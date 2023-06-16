package telran.people;

import java.util.Comparator;

public class BirthYearComparator implements Comparator<Employee> {

	@Override //          1990        1980
	public int compare(Employee o1, Employee o2) {
		//          1980          1990
		return o2.birthYear - o1.birthYear;
	}

}
