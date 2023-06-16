package telran.people.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.people.Company;
import telran.people.Employee;

class EmployeeTest {
	private static final int ID1 = 1;
	private static final int ID2 = 2;
	private static final int ID3 = 3;
	private static final int ID4 = 4;
	private static final int SALARY1 = 50000;
	private static final int SALARY2 = 6000;
	private static final int SALARY3 = 4000;
	private static final int SALARY4 = 8000;
	private static final String NAME1 = "Sasha";
	private static final String NAME2 = "Roma";
	private static final String NAME3 = "Daniel";
	private static final String NAME4 = "Yura";
	private static final int birthYear1 = 1980;
	private static final int birthYear2 = 1985;
	private static final int birthYear3 = 1990;
	private static final int birthYear4 = 1995;
	private static final String DEPARTMENT1 = "Development";
	private static final String DEPARTMENT2 = "Razdolbayee";

	Employee empl1 = new Employee(ID1, NAME1, birthYear1, DEPARTMENT1, SALARY1);
	Employee empl2 = new Employee(ID3, NAME3, birthYear3, DEPARTMENT2, SALARY3);
	Employee empl3 = new Employee(ID2, NAME2, birthYear2, DEPARTMENT1, SALARY2);
	Employee empl4 = new Employee(ID4, NAME4, birthYear4, DEPARTMENT2, SALARY4);

	Employee[] employees = { empl1, empl2, empl3, empl4 };
	Company company;

	@BeforeEach
	void setUp() {
		company = new Company(employees);
	}

	@Test
	void sortEmployeesByIdTest() {
		Employee[] expected = {
				new Employee(ID1, NAME1, birthYear1, DEPARTMENT1, SALARY1),
				new Employee(ID2, NAME2, birthYear2, DEPARTMENT1, SALARY2),
				new Employee(ID3, NAME3, birthYear3, DEPARTMENT2, SALARY3),
				new Employee(ID4, NAME4, birthYear4, DEPARTMENT2, SALARY4),
		};
		assertArrayEquals(expected,company.sortEmployeesById(employees));
	}
	@Test
	void getEmployeeByAgeTest() {
		Employee[] expected = {
				new Employee(ID3, NAME3, birthYear3, DEPARTMENT2, SALARY3),
				new Employee(ID2, NAME2, birthYear2, DEPARTMENT1, SALARY2),
				new Employee(ID1, NAME1, birthYear1, DEPARTMENT1, SALARY1),
		};
		assertArrayEquals(expected,company.getEmployeeByAge(1979,1991));
	}

}
