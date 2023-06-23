package telran.numbers;

import java.util.Iterator;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer> {

	int minInclusive;
	int maxExclusive;
	Predicate<Integer> predicate;

	public Predicate<Integer> getPredicate() {
		return predicate;
	}
	public RangePredicate(int minInclusive, int maxExclusive) {
		super();
		this.minInclusive = minInclusive;
		this.maxExclusive = maxExclusive;
	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}
	public int[] toArray() {
		//TODO
		return null;
	}

	private class RangePredicateIterator implements Iterator<Integer> {
		int current; // TODO
		Predicate<Integer> innerPredicate; // TODO

		public RangePredicateIterator(Predicate<Integer> predicate) {
			innerPredicate = predicate;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Override
	public Iterator<Integer> iterator() {
		return new RangePredicateIterator(predicate);
	}

}
