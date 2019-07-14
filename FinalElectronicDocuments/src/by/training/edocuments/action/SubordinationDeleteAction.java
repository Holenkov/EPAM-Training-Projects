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

public class SubordinationDeleteAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String subID = request.getParameter("subID");
		String errorString = null;
		Subordination sub = null;
		if (subID != null) {
			sub = new Subordination(Integer.parseInt(subID));
			SubordinationServiceImpl service = new SubordinationServiceImpl();
			try {
				sub = service.find(sub);
			} catch (DBOperationException e) {
				LOGGER.error(e.getMessage(), e);
				errorString = e.getMessage();
			}
		} else {
			errorString = "Subordination parameter not found.";
		}
		if (sub == null) {
			errorString = "Subordination not found.";
		}
		
		isRedirect = false;
		String employeeID = request.getParameter("employeeID");
		request.setAttribute("employeeID", employeeID);
		if (errorString == null) {
			request.getSession().setAttribute("sub", sub);
			path = JSPEnum.SUBORDINATION_DELETE_CONFIRM.getPath();
			
		} else {
			
			request.setAttribute("errorString", errorString);
			path = JSPEnum.SUBORDINATION_EDIT.getPath();
		}
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		Subordination sub = (Subordination) request.getSession().getAttribute("sub");
		String errorString = null;
	
		SubordinationServiceImpl service = new SubordinationServiceImpl();
		int result = 0;
		try {
			result = service.delete(sub);
		} catch (DBOperationException e) {
			LOGGER.error(e.getMessage(), e);
			errorString = e.getMessage();
		}
		isRedirect = false;
		String employeeID = request.getParameter("employeeID");
		parameters = "?employeeID=" + employeeID;
		if (errorString == null && result > 0) {
			isRedirect = true;
			path = JSPEnum.SUBORDINATION_EDIT.getPath();
		} else {			
			request.setAttribute("errorString", errorString);
			path = JSPEnum.SUBORDINATION_EDIT.getPath();
		}

		
	}

}
