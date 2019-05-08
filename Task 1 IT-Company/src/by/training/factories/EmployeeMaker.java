package by.training.factories;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.enums.Departments;
import by.training.models.Employee;

/**
 * 
 * Class with method, that selects Factory for creating Employee. 
 *
 */

public class EmployeeMaker {

	/**
	 * Method selects Factory depends of Parameter department.
	 * @param params  {@code List<String>}:[id, department, position,firstName, lastName,
	 *            experience, salary]
	 * @return Employee object or null, if Employee not created.
	 */

	public Employee createEmployee(final List<String> params) {
		final Logger rootLogger = LogManager.getRootLogger();
		Employee employee = null;
		String department = null;
		try {
			department = params.get(1);
		} catch (Exception e) {
			rootLogger.info("Not enough parameters" + params);
			return null;
		}
		Departments enumDepartment = Departments.getDepartment(department);
		if (enumDepartment == null) {
			rootLogger.info("Wrong Department" + params);
			return null;
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
			
		default:
			return null;
		}
		return employee;
	}
}
