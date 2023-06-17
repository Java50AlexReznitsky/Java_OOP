package telran.people;

public class Employee implements Comparable<Employee> {
	int id;
	String name;
	int birthYear;
	String department;
	int salary;

	public Employee(int id, String name, int birthYear, String department, int salary) {
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthYear=" + birthYear + ", department=" + department
				+ ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object emplObj) {
		Employee e = (Employee) emplObj;
		return e.id == id;

	}

	@Override
	public int compareTo(Employee empl) {
		return id - empl.id;
	}

}
