package by.training.itcompany.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.model.Developer;
import by.training.itcompany.model.Employee;

/**
 * Class, extends EmployeeFactjry class, implements EmployeeFactoryInterface,
 * with methods makeEmployee and validate.
 */
public class DeveloperFactory extends EmployeeFactory implements Factory {
	final Logger rootLogger = LogManager.getRootLogger();
	/**
	 * Method, creating Developer class object.
	 *
	 * @param params
	 *            {@code List<String>}:[id, department, position,firstName, lastName,
	 *            experience, salary, projectExperience]
	 * @return Developer object;
	 * @throws IllegalParameterException 
	 */
	@Override
	public Employee makeEmployee(List<String> params) throws IllegalParameterException {
		List<Object> employeeParams = validate(params);
			Developer employee = new Developer();
			try {
				employee.setId((int) employeeParams.get(0));
				employee.setPosition((String) employeeParams.get(1));
				employee.setFirstName((String) employeeParams.get(2));
				employee.setLastName((String) employeeParams.get(3));
				employee.setExperience((int) employeeParams.get(4));
				employee.setSalary((int) employeeParams.get(5));
				employee.setProjectExperience((int) employeeParams.get(6));
			} catch (IllegalParameterException e) {
				throw new IllegalParameterException(e.getMessage() + params.toString(), e);
			}
			
			return employee;
	}

	/**
	 * Method validates values for Developer class fields before creating
	 * Developer class object.
	 *
	 * @param params
	 *            - List<String>:[id, department, position,firstName, lastName,
	 *            experience, salary, projectExperience]
	 * @return List<Object>:[int id, String department, String position, String
	 *         firstName, String lastName, int experience, int salary, int
	 *         projectExperience]
	 * @throws IllegalParameterException 
	 */
	@Override
	protected List<Object> validate(final List<String> params) throws IllegalParameterException {
	
		final int NUMBER_OF_FIELDS = 8;
		if (params.size() < NUMBER_OF_FIELDS) {
			throw new IllegalParameterException("Not enough fields" + params);
		}
		List<Object> employeeParams = new ArrayList<>();
		List<Object> superEmployeeParams;
		
			superEmployeeParams = super.validate(params);
			employeeParams.addAll(superEmployeeParams);
			int projectExperience;
		try {
			projectExperience = Integer.parseInt(params.get(7));
		} catch (NumberFormatException e) {
			throw new IllegalParameterException("Employee ID should be integer.  Current ID is " + params, e);
		}
		employeeParams.add(projectExperience);
		return employeeParams;
	}

}
