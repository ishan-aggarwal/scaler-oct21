package day16.classroom;

import java.util.Arrays;
import java.util.List;

public class MajorityElementNBy3 {

	public static void main(String[] args) {
//		Integer a[] = new Integer[] { 1, 2, 3, 1, 1 };
//		Integer a[] = new Integer[] { 1 };
		Integer a[] = new Integer[] { 1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254,
				1000106, 1000405, 1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 1000713, 1000727, 1000333,
				1000069, 1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727,
				1000508, 1000475, 1000727, 1000573, 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727,
				1000727, 1000426, 1000547, 1000727, 1000972, 1000575, 1000303, 1000727, 1000533, 1000669, 1000489,
				1000727, 1000329, 1000727, 1000050, 1000209, 1000109 };
		List<Integer> list = Arrays.asList(a);

		System.out.println(repeatedNumber(list));
	}

	public static int repeatedNumber(final List<Integer> a) {

		Integer majorityEle1 = null;
		Integer freq1 = 0;

		Integer majorityEle2 = null;
		Integer freq2 = 0;

		int size = a.size();

		for (Integer ele : a) {

			if (majorityEle1 != null && majorityEle1.compareTo(ele) == 0) {
				freq1++;
			} else if (majorityEle2 != null && majorityEle2.compareTo(ele) == 0) {
				freq2++;
			} else if (freq1 == 0) {
				majorityEle1 = ele;
				freq1++;
			} else if (freq2 == 0) {
				majorityEle2 = ele;
				freq2++;
			} else {
				freq1--;
				freq2--;
			}
		}

		freq1 = 0;
		freq2 = 0;
		for (Integer ele : a) {
			if (majorityEle1 != null && majorityEle1.compareTo(ele) == 0) {
				freq1++;
			}
			if (majorityEle2 != null && majorityEle2.compareTo(ele) == 0) {
				freq2++;
			}
		}

		if (freq1 >= size / 3 + 1) {
			return majorityEle1;
		} else if (freq2 >= size / 3 + 1) {
			return majorityEle2;
		} else {
			return -1;
		}
	}

}
