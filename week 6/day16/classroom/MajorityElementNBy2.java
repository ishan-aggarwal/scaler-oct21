package day16.classroom;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MajorityElementNBy2 {

	public static void main(String[] args) {
		Integer a[] = new Integer[] { 1, 3, 3, 1, 2, 1, 1 };

		int size = a.length;
		Optional<Integer> element = getMajorityElement(a, size);

		Integer ele = element.get();
		System.out.println("Element returned is : " + ele);
		if (checkIfMajorityElement(a, size, ele)) {
			System.out.println("Majority elements is " + ele);
		} else {
			System.out.println("Majority element does not exist");
		}

	}

	private static boolean checkIfMajorityElement(Integer[] a, int size, Integer ele) {

		List<Integer> list = Arrays.asList(a);
		long count = list.stream().filter(x -> x == ele).count();
		System.out.println("count of majority element is : " + count);

		if (count >= size / 2 + 1) {
			return true;
		}

		return false;
	}

	private static Optional<Integer> getMajorityElement(Integer[] a, int size) {

		Optional<Integer> majorityElement = Optional.<Integer>empty();
		int freq = 0;

		for (int i = 0; i < size; i++) {
			if (!majorityElement.isPresent()) {
				majorityElement = Optional.ofNullable(a[i]);
				freq = 1;
			} else if (a[i] == majorityElement.get()) {
				freq++;
			} else {
				freq--;
			}

			if (freq == 0) {
				majorityElement = Optional.<Integer>empty();
			}
		}
		return majorityElement;
	}

}
