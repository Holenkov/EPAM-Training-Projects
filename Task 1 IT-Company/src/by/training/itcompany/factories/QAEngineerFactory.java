package by.training.itcompany.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.models.Developer;
import by.training.itcompany.models.Employee;
import by.training.itcompany.models.QAEngineer;

/**
 * Class, extends EmployeeFactory class, implements EmployeeFactoryInterface, 
 * with methods makeEmployee and validate.
 */
public class QAEngineerFactory extends EmployeeFactory implements Factory {

	/**
	 * Method, creating QAEngineer class object.
	 * @param params - List<String>:[id, department, position,firstName, lastName, experience, salary, automatedTesting]
	 * @return Developer object;
	 */
	@Override
	public Employee makeEmployee(List<String> params) {
		List<Object> employeeParams = validate(params);
		if (employeeParams != null) {
			Employee employee = new QAEngineer((int)employeeParams.get(0),
					(String)employeeParams.get(1),
					(String)employeeParams.get(2),
					(String)employeeParams.get(3),
					(int)employeeParams.get(4),
					(int)employeeParams.get(5),
					(boolean)employeeParams.get(6));
			return employee;
		}
		return null;
	}
	
	/**
	 * Method validates values for QAEngineer class fields before creating Developer class object. 
	 * @param params - List<String>:[id, department, position,firstName, lastName, experience, salary, automatedTesting] 
	 * @return List<Object>:[int id, String department, String position, String firstName, 
	 * String lastName, int experience, int salary, boolean automatedTesting]
	 */	
	@Override
	protected List<Object> validate(List<String> params) {
		final Logger rootLogger = LogManager.getRootLogger();
		final int NUMBEROFFIELDS = 8;
		if (params.size() < NUMBEROFFIELDS) {
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
		boolean automatedTesting;
		try {
			automatedTesting = Boolean.parseBoolean(params.get(7));			
		} catch (Exception e) {
			rootLogger.info("Parameter shoul be boolean true/false" + params);
			return null;
		}
		employeeParams.add(automatedTesting);	
		return employeeParams;
	}


}
