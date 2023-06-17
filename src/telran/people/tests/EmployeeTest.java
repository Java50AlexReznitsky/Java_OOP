package telran.people.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.people.Company;
import telran.people.DepartmentPredicate;
import telran.people.Employee;

class EmployeeTest {
	private static final int ID1 = 1;
	private static final int ID2 = 2;
	private static final int ID3 = 3;
	private static final int ID4 = 4;
	private static final int ID5 = 5;
	private static final int SALARY1 = 10000;
	private static final int SALARY2 = 15000;
	private static final int SALARY3 = 17000;
	private static final int SALARY4 = 20000;
	private static final String NAME1 = "Sasha";
	private static final String NAME2 = "Roma";
	private static final String NAME3 = "Daniel";
	private static final String NAME4 = "Yura";
	private static final String NAME5 = "Moshe";
	private static final int birthYear1 = 1980;
	private static final int birthYear2 = 1985;
	private static final int birthYear3 = 1990;
	private static final int birthYear4 = 1995;
	private static final String DEPARTMENT1 = "Development";
	private static final String DEPARTMENT2 = "Razdolbayee";
	private static final String DEPARTMENT3 = "GameDev";

	Employee empl1 = new Employee(ID1, NAME1, birthYear1, DEPARTMENT1, SALARY1);
	Employee empl2 = new Employee(ID2, NAME2, birthYear2, DEPARTMENT1, SALARY2);
	Employee empl3 = new Employee(ID3, NAME3, birthYear3, DEPARTMENT2, SALARY3);
	Employee empl4 = new Employee(ID4, NAME4, birthYear4, DEPARTMENT2, SALARY4);
	Employee empl5 = new Employee(ID5, NAME5, birthYear4, DEPARTMENT3, SALARY4);

	Employee[] employees = { empl1, empl2, empl3, empl4 };
	Company company;

	@BeforeEach
	void setUp() {
		company = new Company(employees);
	}

	@Test
	void sortEmployeesByIdTest() {
		Employee[] expected = { empl1, empl2, empl3, empl4 };

		assertArrayEquals(expected, company.sortEmployeesById());
	}

	@Test
	void getEmployeeByAgeTest() {
		Employee[] expected = { empl4, empl3, empl2, empl1 };
		Employee[] expected2 = { empl2, empl1 };
		assertArrayEquals(expected, company.getEmployeeByAge(1980, 1995));
		assertArrayEquals(expected2, company.getEmployeeByAge(1980, 1985));
	}

	@Test
	void getEmployeeBySalaryTest() {
		Employee[] expected = {empl1, empl2, empl3,};
		Employee[] expected2 = {empl1};
		assertArrayEquals(expected,company.getEmployeeBySalary(10000,17000));
		assertArrayEquals(expected2,company.getEmployeeBySalary(10000,10000));
	}
	@Test
	void getEmployeeByDepartmentTest() {
		Employee[]expected = { empl1, empl2,};
		Employee[]expected2 = { empl3, empl4,};
		assertArrayEquals(expected,company.getEmployeeByDepartment(DEPARTMENT1));
		assertArrayEquals(expected2,company.getEmployeeByDepartment("Razdolbayee"));
	}
	@Test
	void addEmployeeTest() {
		assertTrue(company.addEmployee(empl5));
		Employee[] expected = {empl1, empl2, empl3, empl4, empl5};
		assertArrayEquals(expected, company.sortEmployeesById());
	}
	@Test
	void removeEmployeeTest() {
		Employee[]expected = { empl1, empl2};
		assertTrue(company.removeEmployee(new DepartmentPredicate(DEPARTMENT2)));
		assertArrayEquals(expected, company.sortEmployeesById());
		
	}

}