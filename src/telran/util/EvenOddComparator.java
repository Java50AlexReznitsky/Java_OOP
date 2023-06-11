package telran.util;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer num1, Integer num2) {
		boolean num1IsEven = num1 % 2 == 0;
		boolean num2IsEven = num2 % 2 == 0;
		
		if (num1IsEven && num2IsEven) {
			return num1.compareTo(num2);
		} else if (!num1IsEven && !num2IsEven) {
			return num2.compareTo(num1);
		} else if (num1IsEven && !num2IsEven) {
			return -1;
		} else {
			return 1;
		}
	}
}
