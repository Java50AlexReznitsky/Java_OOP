package telran.people;

import java.util.Arrays;
import java.util.function.Predicate;

public class Company {
	Employee[] employees;

	public Company(Employee[] employees) {
		this.employees = Arrays.copyOf(employees, employees.length);
	}

	public Employee[] sortEmployeesById() {
		Employee[] newArr = Arrays.copyOf(employees, employees.length);
		Arrays.sort(newArr);
		return newArr;
	}

	public Employee[] getEmployeeByAge(int yearFrom, int yearTo) {
		Employee[] res = getEmployeesByPredicate(new BirthYearPredicate(yearFrom, yearTo));
		Arrays.sort(res, new BirthYearComparator());
		return res;
	}

	public Employee[] getEmployeeBySalary(int salaryFrom, int salaryTo) {
		Employee[] res = getEmployeesByPredicate(new SalaryPredicate(salaryFrom, salaryTo));
		Arrays.sort(res, new SalaryComparator());
		return res;
	}

	public Employee[] getEmployeeByDepartment(String department) {
		Employee[] res = getEmployeesByPredicate(new DepartmentPredicate(department));
		Arrays.sort(res);
		return res;
	}

	public boolean addEmployee(Employee empl) {
		boolean fl = true;
		for (int i = 0; i < employees.length; i++) {
			if (empl.id == employees[i].id) {
				fl = false;
			}
		}
		if (fl) {
			Employee[] newArr = Arrays.copyOf(employees, employees.length + 1);
			newArr[newArr.length - 1] = empl;
			 employees = newArr;
		}
		return fl;
	}

	public boolean removeEmployee(Predicate<Employee> predicate) {
		Employee[] res = Arrays.copyOf(employees, employees.length);
		int lenCount = 0;
		boolean fl = false;
		for (Employee empl : employees) {
			if (!predicate.test(empl)) {
				res[lenCount++] = empl;
			} else {
				fl = true;
			}
		}
		employees = Arrays.copyOf(res, lenCount);
		return fl;
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
