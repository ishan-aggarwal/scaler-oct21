package week28.day72.classwork;

import java.util.Arrays;
import java.util.Comparator;

//Q1. Fractional Knapsack Problem

//Case Study:
//Given weights and values of n items and the flexibility that you are allowed to break items or choose fraction of the items. Your task is to put these items in a knapsack of capacity W to get the maximum total value of the items in the knapsack.
//
//Input: 
//Number of items, n = 3
//int[] weights = { 10, 20, 30 }; 
//int[] values = { 60, 100, 120 }; 
//int capacity = 50; 
//
//Output: 
//Maximum Value Attainable - 240 
//Considering items of weight 10 kg and 20 kg and 2/3 fraction of 30 kg. 
//Hence total price will be 60+100+(2/3)(120) = 240

public class FractionalKnapsackProblem {

	// function to get maximum value attainable
	private static double getMaxValue(int[] weights, int[] val, int capacity) {
		WeightValue[] weightValue = new WeightValue[weights.length];
		// Populate with the values
		for (int i = 0; i < weights.length; i++) {
			weightValue[i] = new WeightValue(weights[i], val[i]);
		}

		// sorting items by value/weight ratio;
		Arrays.sort(weightValue, (WeightValue o1, WeightValue o2) -> {
			return o2.ratio.compareTo(o1.ratio);
		});

		double totalValue = 0d;
		for (WeightValue i : weightValue) {
			int curWeight = (int) i.weight;
			int curValue = (int) i.value;
			if (capacity - curWeight >= 0) {
				// this weight can be picked while
				capacity = capacity - curWeight;
				totalValue += curValue;
			} else {
				// item cant be picked whole
				double fraction = ((double) capacity / (double) curWeight);
				totalValue += (curValue * fraction);
				capacity = (int) (capacity - (curWeight * fraction));
				break;
			}
		}
		return totalValue;
	}

	// Weight value class
	static class WeightValue {
		Double ratio;
		double weight, value;

		// item value function
		public WeightValue(int weight, int value) {
			this.weight = weight;
			this.value = value;
			ratio = new Double((double) value / (double) weight);
		}
	}

	// Driver code
	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 50;
		double maxValue = getMaxValue(weights, values, capacity);
		System.out.println("Maximum Value Attainable - " + maxValue);
	}

}
