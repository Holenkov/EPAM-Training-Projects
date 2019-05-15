package by.training.itcompany.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.model.Developer;
import by.training.itcompany.model.Employee;
import by.training.itcompany.model.Manager;

/**
 * Class, extends EmployeeFactjry class, implements EmployeeFactoryInterface,
 * with methods makeEmployee and validate.
 */
public class ManagerFactory extends EmployeeFactory implements Factory {
	final Logger rootLogger = LogManager.getRootLogger();

	/**
	 * Method, creating Manager class object.
	 * 
	 * @param params
	 *            - {@code List<String>}:[id, department, position,firstName,
	 *            lastName, experience, salary, someTextField]
	 * @return Manager object;
	 * @throws IllegalParameterException
	 */
	@Override
	public Employee makeEmployee(final List<String> params) throws IllegalParameterException {
		List<Object> employeeParams = validate(params);
		Manager employee = new Manager();
		try {
			employee.setId((int) employeeParams.get(0));
			employee.setPosition((String) employeeParams.get(1));
			employee.setFirstName((String) employeeParams.get(2));
			employee.setLastName((String) employeeParams.get(3));
			employee.setExperience((int) employeeParams.get(4));
			employee.setSalary((int) employeeParams.get(5));
			employee.setSomeTextField((String) employeeParams.get(6));
		} catch (IllegalParameterException e) {
			throw new IllegalParameterException(e.getMessage() + params.toString(), e);
		}
		return employee;
	}

	/**
	 * Method validates values for Manager class fields before creating Manager
	 * class object.
	 * 
	 * @param params
	 *            - {@code List<String>}:[id, department, position,firstName,
	 *            lastName, experience, salary, someTextField]
	 * @return {@code List<Object>}:[int id, String department, String position,
	 *         String firstName, String lastName, int experience, int salary,
	 *         String someTextField]
	 * @throws IllegalParameterException
	 */
	@Override
	protected List<Object> validate(final List<String> params) throws IllegalParameterException {
		
		final int NUMBER_OF_FIELDS = 8;
		if (params.size() < NUMBER_OF_FIELDS) {
			throw new IllegalParameterException("Not enough fields" + params);
		}
		List<Object> employeeParams = new ArrayList<>();
		List<Object> superEmployeeParams = super.validate(params);
		employeeParams.addAll(superEmployeeParams);
		String someTextField = params.get(7);
		employeeParams.add(someTextField); // Position validation??

		return employeeParams;
	}

}
