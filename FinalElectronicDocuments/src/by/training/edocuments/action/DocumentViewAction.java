package by.training.edocuments.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.DocumentHistoryServiceImpl;
import by.training.edocuments.service.implementation.DocumentServiceImpl;
import by.training.edocuments.util.CookieUtil;

public class DocumentViewAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static final  int NEW_DOC = 4;
	private static final  int VIEWED_DOC = 5;

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("backParam", request.getParameter("backParam"));
		String errorString = null;
		String docHistoryID = request.getParameter("docHistoryID");
		DocumentHistoryServiceImpl historyService = new DocumentHistoryServiceImpl();
		DocumentHistory documentHistory = new DocumentHistory(Integer.parseInt(docHistoryID));
		try {
			documentHistory = historyService.find(documentHistory);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString , e);
		}
		Document document = null;
		if (errorString == null) {
			document = documentHistory.getDocument();
			DocumentServiceImpl service = new DocumentServiceImpl();
			try {
				document = service.find(document);
			} catch (DBOperationException e) {
				errorString = e.getMessage();
				LOGGER.error(errorString, e);
			}
		}
		
		if (errorString == null){
			Employee executor = documentHistory.getToEmployee();
			Employee loginedUser = CookieUtil.getLoginedUser(request.getSession());
			if (loginedUser.getEmployeeID() == executor.getEmployeeID()) {
				if (documentHistory.getDocStatus().getDocStatusID() == NEW_DOC) {
					documentHistory.setDocStatus(new DocumentStatus(VIEWED_DOC));
					try {
						historyService.update(documentHistory);
					} catch (DBOperationException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		isRedirect = false;
		if (errorString == null) {
			request.setAttribute("document", document);
			path = JSPEnum.DOCUMENT_VIEW.getPath();
		} else {
			path = JSPEnum.MAIN.getPath();
			request.setAttribute("errorString", errorString);
		}
	}
	
	
}
