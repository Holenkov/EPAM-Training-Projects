package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.SubordinationServiceImpl;

public class SubordinationEditAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String employeeID = request.getParameter("employeeID");
		
		List<Subordination> subBySender = null;
		List<Subordination> subByReceiver = null;
		if (employeeID != null) {
			Employee employee = new Employee(Integer.parseInt(employeeID));
			SubordinationServiceImpl service = new SubordinationServiceImpl();
			try {
				subByReceiver = service.findByReceiver(employee);
				subBySender = service.findBySender(employee);
			} catch (DBOperationException e) {
				LOGGER.error(e.getMessage(), e);
				errorString = e.getMessage();
				request.setAttribute("errorString", errorString);
			}
		} else {
			isRedirect = true;
			request.setAttribute("errorString", errorString);
			path = JSPEnum.MAIN.getPath();
		}
		
		
		isRedirect = false;
		if (errorString == null) {
			request.setAttribute("subBySender", subBySender);
			request.setAttribute("subByReceiver", subByReceiver);
			path = JSPEnum.SUBORDINATION_EDIT.getPath();
			request.setAttribute("employeeID", employeeID);
		} else {
			request.setAttribute("errorString", errorString);
			path = JSPEnum.EMPLOYEE_EDIT.getPath();
		}
		
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	

}
