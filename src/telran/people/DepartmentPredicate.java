package telran.people;

import java.util.function.Predicate;

public class DepartmentPredicate implements Predicate<Employee> {
String department;

public DepartmentPredicate(String department) {
	this.department= department;
}
@Override
public boolean test(Employee empl) {
	return empl.department.equals(department);
}

}

