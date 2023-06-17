package telran.people;

import java.util.function.Predicate;

public class SalaryPredicate implements Predicate<Employee> {
	int salaryFrom;
	int salaryTo;

	public SalaryPredicate(int salaryFrom, int salaryTo) {
		this.salaryFrom = salaryFrom;
		this.salaryTo = salaryTo;
	}

	@Override
	public boolean test(Employee empl) {

		return empl.salary >= salaryFrom && empl.salary <= salaryTo;
	}

}
