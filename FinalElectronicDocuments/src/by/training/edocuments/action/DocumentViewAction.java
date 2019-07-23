package by.training.edocuments.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.DocumentHistoryServiceImpl;
import by.training.edocuments.service.implementation.DocumentServiceImpl;

public class DocumentViewAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();
	private final static int NEW_DOC = 4;
	private final static int VIEWED_DOC = 5;

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String docID = request.getParameter("docID");
		String docHistoryID = request.getParameter("docHistoryID");
		Document document = new Document(Integer.parseInt(docID));
		
		DocumentServiceImpl service = new DocumentServiceImpl();
		try {
			document = service.find(document);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString , e);
		}
		if (errorString == null){
			if (docHistoryID != null) {
				errorString = changeViewed(docHistoryID);
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
	
	private String changeViewed(String docHistoryID) {
		String errorString = null;
		DocumentHistoryServiceImpl historyService = new DocumentHistoryServiceImpl();
		DocumentHistory documentHistory = new DocumentHistory(Integer.parseInt(docHistoryID));
		
		try {
			documentHistory = historyService.find(documentHistory);
			if (documentHistory.getDocStatus().getDocStatusID() == NEW_DOC) {
				documentHistory.setDocStatus(new DocumentStatus(VIEWED_DOC));
				historyService.update(documentHistory);
			}
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString , e);
		}
		return errorString;
	}
	
}
