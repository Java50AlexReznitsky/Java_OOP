package telran.numbers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer>{
	int minInclusive;
	int maxExclusive;
	Predicate<Integer> predicate;
	public RangePredicate(int minInclusive, int maxExclusive) {
		if(minInclusive >= maxExclusive) {
			throw new IllegalArgumentException("min must be less than max");
		}
		this.minInclusive = minInclusive;
		this.maxExclusive = maxExclusive;
	}
	public Predicate<Integer> getPredicate() {
		return predicate;
	}
	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}
	public int[] toArray() {
		int res[] = new int[maxExclusive - minInclusive];
		int index = 0;
		for(int num: this) {
			res[index++] = num;
		}
		return Arrays.copyOf(res, index);
	}
	
	private class RangePredicateIterator implements Iterator<Integer> {
		int current;
		Predicate<Integer> innerPredicate;
		RangePredicateIterator(Predicate<Integer> predicate) {
			
			innerPredicate = predicate;
			if (innerPredicate == null) {
				innerPredicate = e -> true;
			}
			current = innerPredicate.test(minInclusive) ? minInclusive : getCurrent(minInclusive);
		}
		@Override
		public boolean hasNext() {
			
			return current < maxExclusive;
		}

		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			int res = current;
			current = getCurrent(current);
			return res;
		}
		private int getCurrent(int current) {
			current++;
			while(current < maxExclusive && !innerPredicate.test(current)) {
				current++;
			}
			return current;
		}
		
	}
	@Override
	public Iterator<Integer> iterator() {
		
		return new RangePredicateIterator(predicate);
	}

}
//package telran.numbers;
//
//import java.util.Iterator;
//import java.util.function.Predicate;
//
//public class RangePredicate implements Iterable<Integer> {
//
//	int minInclusive;
//	int maxExclusive;
//	Predicate<Integer> predicate;
//
//	public RangePredicate(int minInclusive, int maxExclusive) {
//		this.minInclusive = minInclusive;
//		this.maxExclusive = maxExclusive;
//	}
//	public Predicate<Integer> getPredicate() {
//		return predicate;
//	}
//
//	public void setPredicate(Predicate<Integer> predicate) {
//		this.predicate = predicate;
//	}
//	public int[] toArray() {
//		//TODO
//		return null;
//	}
//
//	private class RangePredicateIterator implements Iterator<Integer> {
//		int current; // TODO
//		Predicate<Integer> innerPredicate = getPredicate();
//
//		public RangePredicateIterator(Predicate<Integer> predicate) {
//			innerPredicate = predicate;
//		}
//
//		@Override
//		public boolean hasNext() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public Integer next() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//	}
//
//	@Override
//	public Iterator<Integer> iterator() {
//		return new RangePredicateIterator(predicate);
//	}
//
//}
