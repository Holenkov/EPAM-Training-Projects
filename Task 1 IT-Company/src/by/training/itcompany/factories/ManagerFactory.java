package by.training.itcompany.factories;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exceptions.IllegalParameterException;
import by.training.itcompany.models.Developer;
import by.training.itcompany.models.Employee;
import by.training.itcompany.models.Manager;

/**
 * Class, extends EmployeeFactjry class, implements EmployeeFactoryInterface,
 * with methods makeEmployee and validate.
 */
public class ManagerFactory extends EmployeeFactory implements Factory {

	/**
	 * Method, creating Manager class object.
	 * @param params - {@code List<String>}:[id, department, position,firstName, lastName, experience, salary, someTextField] 
	 * @return Manager object;
	 */
	@Override
	public Employee makeEmployee(final List<String> params) {
		List<Object> employeeParams = validate(params);
		if (employeeParams != null) {
			Manager employee = new Manager();
			try {
				employee.setId((int) employeeParams.get(0));
				employee.setPosition((String) employeeParams.get(1));
				employee.setFirstName((String) employeeParams.get(2));
				employee.setLastName((String) employeeParams.get(3));
				employee.setExperience((int) employeeParams.get(4));
				employee.setSalary((int) employeeParams.get(5));
				employee.setSomeTextField((String)employeeParams.get(6));
			} catch (IllegalParameterException e) {
				e.printStackTrace();
				return null;
			}
			return employee;
		}
		return null;
	}

	/**
	 * Method validates values for Manager class fields before creating Manager class object. 
	 * @param params - {@code List<String>}:[id, department, position,firstName, lastName, experience, salary, someTextField] 
	 * @return {@code List<Object>}:[int id, String department, String position, String firstName, 
	 * String lastName, int experience, int salary, String someTextField]
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
		String someTextField = params.get(7);
		employeeParams.add(someTextField); //Position validation??

		return employeeParams;
	}


}
