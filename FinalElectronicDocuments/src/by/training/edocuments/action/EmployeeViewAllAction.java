package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;

public class EmployeeViewAllAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		List<Employee> employees;
		try {
			employees = service.readAll();
			request.setAttribute("employeeList", employees);
		} catch (DBOperationException e) {
			LOGGER.error(e.getMessage(), e);
			request.setAttribute("errorString", e.getMessage());
		}
		
		path = JSPEnum.EMPLOYEE_VIEW_ALL.getPath();
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
