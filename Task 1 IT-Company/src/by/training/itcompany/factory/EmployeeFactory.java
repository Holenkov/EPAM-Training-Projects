package by.training.itcompany.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.model.Employee;

/**
 * Abstract class with implemented from EmployeeFactoryInterface method
 * makeEmployee and method validate.
 */

public abstract class EmployeeFactory implements Factory {

	/**
	 * Method, creating Employee class object.
	 *
	 * @param params
	 *            - List<String> contains values of Employee class fields.
	 * @return Employee object;
	 */
	@Override
	public abstract Employee makeEmployee(List<String> params) throws IllegalParameterException;

	/**
	 * Method validates values for Employee class fields before creating
	 * Employee class object.
	 *
	 * @param params
	 *            {@code List<String>}:[id, department, position,firstName, lastName,
	 *            experience, salary]
	 * @return {@code List<Object>}:[int id, String department, String position, String
	 *         firstName, String lastName, int experience, int salary]
	 */
	protected List<Object> validate(final List<String> params) throws IllegalParameterException{
		final int NUMBER_OF_FIELDS = 7;
		if (params.size() < NUMBER_OF_FIELDS) {
			throw new IllegalParameterException("Not enough fields" + params);
		}
		int id;
		List<Object> employeeParams = new ArrayList<>();
		try {
			id = Integer.parseInt(params.get(0));
		} catch (NumberFormatException e) {
			throw new IllegalParameterException("Employee ID should be integer.  Current ID is " + params, e);
		}
		employeeParams.add(id);

		String position = params.get(2);
		employeeParams.add(position); // Position validation??
		String firstName = params.get(3);
		employeeParams.add(firstName);
		String lastName = params.get(4);
		employeeParams.add(lastName);
		int experience;
		try {
			experience = Integer.parseInt(params.get(5));
		} catch (NumberFormatException e) {
			throw new IllegalParameterException("Employee experience should be integer.  Current experience is " + params, e);
		}
		employeeParams.add(experience);
		int salary;
		try {
			salary = Integer.parseInt(params.get(6));
		} catch (NumberFormatException e) {
			throw new IllegalParameterException("Employee salary should be integer.  Current salary is " + params, e);
		}
		employeeParams.add(salary);

		return employeeParams;
	}
}
