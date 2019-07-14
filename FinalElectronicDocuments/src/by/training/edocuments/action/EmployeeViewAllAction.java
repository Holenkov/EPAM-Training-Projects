package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.CryptoUtil;

public class EmployeeViewAllAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		List<Employee> employees = null;
		try {
			employees = service.readAll();
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString , e);
			request.setAttribute("errorString", errorString);
		}
		isRedirect = false;
		if (errorString == null) {
			request.setAttribute("employeeList", employees);
			path = JSPEnum.EMPLOYEE_VIEW_ALL.getPath();
		} else {
			path = JSPEnum.MAIN.getPath();
		}
		
		
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
