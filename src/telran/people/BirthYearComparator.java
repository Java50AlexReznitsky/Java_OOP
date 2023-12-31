package telran.people;

import java.util.Comparator;

public class BirthYearComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.birthYear - o1.birthYear;
	}

}
