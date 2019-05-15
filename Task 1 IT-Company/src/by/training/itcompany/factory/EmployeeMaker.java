package by.training.itcompany.factory;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.exception.NullResultException;
import by.training.itcompany.model.Departments;
import by.training.itcompany.model.Employee;

/**
 * 
 * Class with method, that selects Factory for creating Employee. 
 *
 */

public class EmployeeMaker {
	final Logger rootLogger = LogManager.getRootLogger();

	/**
	 * Method selects Factory depends of Parameter department.
	 * @param params  {@code List<String>}:[id, department, position,firstName, lastName,
	 *            experience, salary]
	 * @return Employee object or null, if Employee not created.
	 */

	public Employee createEmployee (final List<String> params) throws IllegalParameterException {
	
		Employee employee = null;
		String department = null;
		try {
			department = params.get(1);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalParameterException("Not enough parameters"  + params, e);
		}
		Departments enumDepartment = Departments.getDepartment(department);
		if (enumDepartment == null) {
			throw new IllegalParameterException("Wrong Department" + params);			
		}
		switch (enumDepartment) {
		case MANAGEMENT:
			ManagerFactory managerFactory = new ManagerFactory();
			employee = managerFactory.makeEmployee(params);
			break;
		case DEVELOPMENT:
			DeveloperFactory developerFactory = new DeveloperFactory();
			employee = developerFactory.makeEmployee(params);
			break;
		case QA:
			QAEngineerFactory qaEngineerFactory = new QAEngineerFactory();
			employee = qaEngineerFactory.makeEmployee(params);
			break;
		}
		return employee;
	}
}
