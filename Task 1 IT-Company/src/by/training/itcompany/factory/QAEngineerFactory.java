package by.training.itcompany.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.model.Developer;
import by.training.itcompany.model.Employee;
import by.training.itcompany.model.QAEngineer;

/**
 * Class, extends EmployeeFactory class, implements EmployeeFactoryInterface,
 * with methods makeEmployee and validate.
 */
public class QAEngineerFactory extends EmployeeFactory implements Factory {
	final Logger rootLogger = LogManager.getRootLogger();
	/**
	 * Method, creating QAEngineer class object.
	 * 
	 * @param params
	 *            - List<String>:[id, department, position,firstName, lastName,
	 *            experience, salary, automatedTesting]
	 * @return Developer object;
	 * @throws IllegalParameterException
	 */
	@Override
	public Employee makeEmployee(List<String> params) throws IllegalParameterException {
		List<Object> employeeParams = validate(params);
		QAEngineer employee = new QAEngineer();
		try {
			employee.setId((int) employeeParams.get(0));
			employee.setPosition((String) employeeParams.get(1));
			employee.setFirstName((String) employeeParams.get(2));
			employee.setLastName((String) employeeParams.get(3));
			employee.setExperience((int) employeeParams.get(4));
			employee.setSalary((int) employeeParams.get(5));
			employee.setAutoTesting((boolean) employeeParams.get(6));
		} catch (IllegalParameterException e) {
			throw new IllegalParameterException(e.getMessage() + params.toString(), e);
		}
		return employee;
	}

	/**
	 * Method validates values for QAEngineer class fields before creating
	 * Developer class object.
	 * 
	 * @param params
	 *            - List<String>:[id, department, position,firstName, lastName,
	 *            experience, salary, automatedTesting]
	 * @return List<Object>:[int id, String department, String position, String
	 *         firstName, String lastName, int experience, int salary, boolean
	 *         automatedTesting]
	 * @throws IllegalParameterException
	 */
	@Override
	protected List<Object> validate(List<String> params) throws IllegalParameterException {
	
		final int NUMBEROFFIELDS = 8;
		if (params.size() < NUMBEROFFIELDS) {
			throw new IllegalParameterException("Not enough fields" + params);
		}
		List<Object> employeeParams = new ArrayList<>();
		List<Object> superEmployeeParams = super.validate(params);
		employeeParams.addAll(superEmployeeParams);
		boolean automatedTesting = Boolean.parseBoolean(params.get(7));
		employeeParams.add(automatedTesting);
		return employeeParams;
	}

}
