package day16.assignments;

import java.util.Arrays;
import java.util.List;

public class NBy3RepeatedNumber {
	// DO NOT MODIFY THE LIST
	public static int repeatedNumber(final List<Integer> a) {

		Integer me1 = null, freq1 = 0;
		Integer me2 = null, freq2 = 0;

		for (int i = 0; i < a.size(); i++) {

			if (me1 != null && me1.compareTo(a.get(i)) == 0) {
				freq1++;
			} else if (me2 != null && me2.compareTo(a.get(i)) == 0) {
				freq2++;
			} else if (freq1 == 0) {
				me1 = a.get(i);
				freq1 = 1;
			} else if (freq2 == 0) {
				me2 = a.get(i);
				freq2 = 1;
			} else {
				freq1--;
				freq2--;
			}
		}

		freq1 = 0;
		freq2 = 0;
		for (int i = 0; i < a.size(); i++) {
			if (me1.compareTo(a.get(i)) == 0) {
				freq1++;
			} else if (me2.compareTo(a.get(i)) == 0) {
				freq2++;
			}
		}

		if (freq1 > freq2 && freq1 >= a.size() / 3 + 1) {
			return me1;
		} else if (freq2 > freq1 && freq2 >= a.size() / 3 + 1) {
			return me2;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Integer[] arr = { 1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254, 1000106,
				1000405, 1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 1000713, 1000727, 1000333, 1000069,
				1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727, 1000508,
				1000475, 1000727, 1000573, 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727, 1000727,
				1000426, 1000547, 1000727, 1000972, 1000575, 1000303, 1000727, 1000533, 1000669, 1000489, 1000727,
				1000329, 1000727, 1000050, 1000209, 1000109 };
		List<Integer> a = Arrays.asList(arr);
		System.out.println(repeatedNumber(a));
	}
}
