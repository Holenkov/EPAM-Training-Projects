package test.itcompany.factory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.factory.DeveloperFactory;
import by.training.itcompany.model.Developer;
import by.training.itcompany.model.Employee;

/**
 * JUnit Test for DeveloperFactory class.
*/
@RunWith(Parameterized.class)
public class DeveloperFactoryTest{
	private final Logger rootLogger = LogManager.getRootLogger();
	
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
		Developer actual = new Developer();
		try {
			actual = (Developer) developerFactory.makeEmployee(new ArrayList<String>(
					Arrays.asList(id, department, position, firstName, lastName, experience, salary, projectExperience)));
		} catch (IllegalParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			actual = null;
		}
	/*	System.out.println(expected);
		System.out.println(actual);
		System.out.println();*/
		assertEquals(expected, actual);
	}


	
}
