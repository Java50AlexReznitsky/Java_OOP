package telran.people;

import java.util.Arrays;
import java.util.function.Predicate;

public class Company {
	Employee[] employees;

	public Company(Employee[] employees) {
		this.employees = Arrays.copyOf(employees, employees.length);
	}

	public Employee[] sortEmployeesById(Employee[] emplObjs) {
		Employee[] newArr = Arrays.copyOf(emplObjs, emplObjs.length);
		Arrays.sort(newArr);
		return newArr;
	}

	public Employee[] getEmployeeByAge(int yearFrom, int yearTo) {
		Employee[] res = getEmployeesByPredicate(new BirthYearPredicate(yearFrom, yearTo));
		Arrays.sort(res, new BirthYearComparator());
		return res;
	}

	private Employee[] getEmployeesByPredicate(Predicate<Employee> predicate) {
		Employee[] res = Arrays.copyOf(employees, employees.length);
		int lenCount = 0;
		for (Employee empl : employees) {
			if (predicate.test(empl)) {
				res[lenCount++] = empl;
			}
		}
		return Arrays.copyOf(res, lenCount);
	}
}
