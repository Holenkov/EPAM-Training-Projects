package test.itcompany.factories;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.training.itcompany.exceptions.IllegalParameterException;
import by.training.itcompany.factories.DeveloperFactory;
import by.training.itcompany.models.Developer;
import by.training.itcompany.models.Employee;

/**
 * JUnit Test for DeveloperFactory class.
*/
@RunWith(Parameterized.class)
public class DeveloperFactoryTest extends Employee{
	
	/** Employee ID */
	private String id;
	/** Department */
	private String department;
	/**Position of Employee */
	private String position;
	/**First name of Employee */
	private String firstName;
	/**Last name of Employee */
	private String lastName;
	/**Working experience of Employee (in full years)*/
	private String experience;
	/**Salary of Employee (in dollars)*/
	private String salary;
	/** Number of finished projects*/
	private String projectExperience;
	Developer expected;
	
	/** Constructor using parameters  
	 * @param id - Unic ID of Employee;
	 * @param position - Position of Developer;
	 * @param firstName - Developer's First name;
	 * @param lastName - Developer's Last name
	 * @param experience - Working experience as Developer (in full years)
	 * @param salary - Salary of Employee (in dollars)
	 * @param projectExperience - Number of Developer's finished projects
	 */
	
	public DeveloperFactoryTest(String id, String department, String position, String firstName, String lastName, String experience, String salary,
			String projectExperience, Developer expected) {
		super();
		this.id = id;
		this.department = department;
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.salary = salary;
		this.projectExperience = projectExperience;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Object[]> paramsForTest() {
		
		return Arrays.asList(new Object[][] {
			{"Development", "Developer", "Anya", "Maksimova", "3", "700", "2", null, null},
			{"100", "Development", "Developer", "Anya", "Maksimova", "3", "700", "2", 
				new Developer(Integer.parseInt("100"), "Developer", "Anya", "Maksimova",
						Integer.parseInt("3"), Integer.parseInt("700"), Integer.parseInt("2"))},
			{"100", "Development", "Developer", "Anya", "Maksimova", "fail", "700", "2", null},
			{"100", "Development", "Developer", "Anya", "Maksimova", "3", "fail", "2", null},
			{"100", "Development", "Developer", "Anya", "Maksimova", "3", "700", "fail", null},
			{"100", "Development", "Developer", "Anya", "Maksimova", "-1", "700", "2", null},
			{"100", "Development", "Developer", "Anya", "Maksimova", "3", "70000", "2", null},
			{"100", "Development", "Developer", "Anya", "Maksimova", "3", "700", "2", 
				new Developer(Integer.parseInt("100"), "Developer", "Anya", "Maksimova",
						Integer.parseInt("3"), Integer.parseInt("700"), Integer.parseInt("2"))}
		});
	}


	@Test
	public void makeEmployeeTest (){
		DeveloperFactory developerFactory = new DeveloperFactory();
		Developer actual = (Developer) developerFactory.makeEmployee(new ArrayList<String>(
				Arrays.asList(id, department, position, firstName, lastName, experience, salary, projectExperience)));
		System.out.println(expected);
		System.out.println(actual);
		System.out.println();
		assertEquals(expected, actual);
	}


	
}
