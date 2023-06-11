package telran.util.tests;

import java.util.Comparator;

public class DigitsSumComparator implements Comparator<Integer> {

//	@Override
	public int compare(Integer num1, Integer num2) {
		return getDigitsSum(num1) - getDigitsSum(num2);
	}

	private int getDigitsSum(Integer number) {
		int sum = 0, digit = 0;
		do {
			digit = Math.abs(number % 10);
			sum += digit;
			number /= 10;
		} while (number != 0);
		return sum;
	}
}
