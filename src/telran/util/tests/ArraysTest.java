package telran.util.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static telran.util.Arrays.addObject;
import static telran.util.Arrays.bubbleSort;
import static telran.util.Arrays.insertObject;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.EvenOddComparator;

public class ArraysTest {
	Integer[] numbers = { 10, 5, -5, 100, 200 };
	String[] strings = { "lmn", "a", "ab", "abc", "b", "ba" };

	@Test
	void addObjectTest() {
		Integer[] expectedNumbers = { 10, 5, -5, 100, 200, 50 };
		assertArrayEquals(expectedNumbers, addObject(numbers, 50));
		String[] expectedStrings = { "lmn", "a", "ab", "abc", "b", "ba", "bb" };
		assertArrayEquals(expectedStrings, addObject(strings, "bb"));
	}

	@Test
	void insertObjectTest() {
		Integer[] expectedLast = { 10, 5, -5, 100, 200, 50 };
//		Integer[] expectedFirst = { 50, 10, 5, -5, 100, 200 };
//		Integer[] expectedMiddle = { 10, 5, 50, -5, 100, 200 };
		assertArrayEquals(expectedLast, insertObject(numbers, 5, 50));

	}

	@Test
	void digitsSumComparatorTest() {
		Comparator<Integer> comp = new DigitsSumComparator();
		assertTrue(comp.compare(9, 111) > 0);
		assertTrue(comp.compare(3, 111) == 0);
	}

	@Test
	void standardSortComparatorTest() {
		Integer[] array = { 10, 5, 110, 9, 22, 33 };
		Integer[] expected = { 10, 110, 22, 5, 33, 9 };
		Arrays.sort(array, new DigitsSumComparator());
		assertArrayEquals(expected, array);
	}

	@Test
	void bubbleSortComparatorTest() {
		Integer[] array = { 10, 5, -5, 100, 200 };
		Integer[] expected = { 10, 100, 200, 5, -5 };
		bubbleSort(array,new EvenOddComparator());
		assertArrayEquals(expected, array);
	}
	@Test
	void bubbleSortComparatorTestLambda() {
		Integer[] array = { 10, 5, -5, 100, 200 };
		Integer[] expected = { 10, 100, 200, 5, -5 };
//		bubbleSort(array,(a,b)->compare(a,b)); /* lambda expression */
		
//		bubbleSort(array,(o1,o2)->{
//			int res = 1;
//			if (o1 % 2 == 0 && o2 % 2 != 0) {
//				res = -1;
//			} else if(o1 % 2 != 0 && o2 % 2 != 0) {
//				res = o2 - o1;
//			} else if(o1 % 2 == 0 && o2 % 2 == 0) {
//				res = o1 - o2;
//			}
//			return res;
//			
//		});                                   /* lambda closure*/
		
		bubbleSort(array,ArraysTest::compare); // Method reference (the compare method must be static)
//		bubbleSort(array,this::compare); // Method reference
		
		assertArrayEquals(expected, array);
	}
	private static int compare(Integer o1, Integer o2) {
		int res = 1;
		if (o1 % 2 == 0 && o2 % 2 != 0) {
			res = -1;
		} else if(o1 % 2 != 0 && o2 % 2 != 0) {
			res = o2 - o1;
		} else if(o1 % 2 == 0 && o2 % 2 == 0) {
			res = o1 - o2;
		}
		return res;
	}
}
