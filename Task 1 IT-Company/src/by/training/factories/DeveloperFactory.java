package by.training.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.models.Developer;
import by.training.models.Employee;

/**
 * Class, extends EmployeeFactjry class, implements EmployeeFactoryInterface,
 * with methods makeEmployee and validate.
 */
public class DeveloperFactory extends EmployeeFactory implements Factory {

	/**
	 * Method, creating Developer class object.
	 *
	 * @param params
	 *            {@code List<String>}:[id, department, position,firstName, lastName,
	 *            experience, salary, projectExperience]
	 * @return Developer object;
	 */
	@Override
	public Employee makeEmployee(final List<String> params) {
		List<Object> employeeParams = validate(params);
		if (employeeParams != null) {
			Employee employee = new Developer((int) employeeParams.get(0),
					(String) employeeParams.get(1),
					(String) employeeParams.get(2),
					(String) employeeParams.get(3),
					(int) employeeParams.get(4),
					(int) employeeParams.get(5),
					(int) employeeParams.get(6));
			return employee;
		}
		return null;
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
	 */
	@Override
	protected List<Object> validate(final List<String> params) {
		final Logger rootLogger = LogManager.getRootLogger();
		final int NUMBER_OF_FIELDS = 8;
		if (params.size() < NUMBER_OF_FIELDS) {
			rootLogger.info("Not enough fields" + params);
			return null;
		}
		List<Object> employeeParams = new ArrayList<>();
		List<Object> superEmployeeParams = super.validate(params);
		if (superEmployeeParams != null) {
			employeeParams.addAll(superEmployeeParams);
		} else {
			return null;
		}
		int projectExperience;
		try {
			projectExperience = Integer.parseInt(params.get(7));
		} catch (Exception e) {
			rootLogger.info("Number of finished projects should be integer" + params);
			return null;
		}
		employeeParams.add(projectExperience);
		return employeeParams;
	}

}
