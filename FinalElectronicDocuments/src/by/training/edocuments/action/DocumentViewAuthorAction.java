package by.training.edocuments.action;

import java.util.List;

import javax.mail.internet.NewsAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.DocumentHistoryServiceImpl;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.CookieUtil;

public class DocumentViewAuthorAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	
	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		DocumentHistoryServiceImpl service = new DocumentHistoryServiceImpl();
		List<DocumentHistory> historyList = null;
		Employee employee = CookieUtil.getLoginedUser(request.getSession());
		try {
			historyList = service.findByAuthor(employee);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString , e);
		}
		isRedirect = false;
		if (errorString == null) {
			request.setAttribute("historyList", historyList);
			path = JSPEnum.DOCUMENT_VIEW_AUTHOR.getPath();
		} else {
			path = JSPEnum.MAIN.getPath();
			request.setAttribute("errorString", errorString);
		}
	}
	
	
	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
