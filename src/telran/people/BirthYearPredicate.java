package telran.people;

import java.util.function.Predicate;

public class BirthYearPredicate implements Predicate<Employee> {
	int yearFrom;
	int yearTo;

	public BirthYearPredicate(int yearFrom, int yearTo) {
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
	}

	@Override
	public boolean test(Employee empl) {
		return empl.birthYear >= yearFrom && empl.birthYear <= yearTo;
	}
}
