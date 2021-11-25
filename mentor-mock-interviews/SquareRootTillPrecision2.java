package mentor;

/*
 * Given a number either float, double or int and an int precision like 
 *  num = 3.0 and precision = 3
 *  return 1.732 as the answer
 */

public class SquareRootTillPrecision2 {

	public static double squareRoot(double number, int precision) {
		double result = 0.0;
		double startValue = 0.0;
		double endValue = number;
		double midValue = 0.0;

		double power = Math.pow(10, precision + 1);
		double increment = 1 / power;

		while (startValue <= endValue) {
			midValue = startValue + (endValue - startValue) / 2;

			if (midValue * midValue == number) {
				return midValue;
			}

			if ((midValue * midValue < number) && ((midValue + increment) * (midValue + increment) > number)) {
//				return midValue;
				return Math.round(midValue * power * 1f) / power * 1f;

			}

			if (midValue * midValue < number) {
				startValue = midValue;
			}

			if (midValue * midValue > number) {
				endValue = midValue;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(squareRoot(3.0, 3));
	}

}
