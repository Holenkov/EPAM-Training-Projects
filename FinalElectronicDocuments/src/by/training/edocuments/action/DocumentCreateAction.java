package by.training.edocuments.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.DocumentHistoryServiceImpl;
import by.training.edocuments.service.implementation.DocumentServiceImpl;
import by.training.edocuments.service.implementation.SubordinationServiceImpl;
import by.training.edocuments.util.CookieUtil;
import by.training.edocuments.util.SourceTablesStore;

public class DocumentCreateAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private final static int NEW_DOC = 4;

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String docType = request.getParameter("documentTypeID");
		if (docType != null){
			int docTypeID = Integer.parseInt(docType);
			SourceTablesStore store  = SourceTablesStore.getStore();
			DocumentType documentType = store.returnDocumentType(docTypeID);
			SubordinationServiceImpl service = new SubordinationServiceImpl();
			Employee sender = CookieUtil.getLoginedUser(request.getSession());
			List<Subordination> subordinations = null;
			try {
				subordinations = service.findBySender(sender, documentType);
			} catch (DBOperationException e) {
				errorString = "Default logo file not found";
				LOGGER.error(errorString, e);
			}
			if (errorString == null) {
				if (subordinations.isEmpty()) {
					errorString = "No receivers for this type of document";
					path = JSPEnum.DOCUMENT_CHOOSE_TYPE.getPath();
					isRedirect = false;
					List<DocumentType> docTypes = store.returnDocumentTypes();
					request.setAttribute("docTypes", docTypes);
				} else {
					path = JSPEnum.DOCUMENT_CREATE.getPath();
					isRedirect = false;
					request.setAttribute("documentType", documentType);
					request.setAttribute("subordinations", subordinations);
				}
			} else {
				path = JSPEnum.MAIN.getPath();
				isRedirect = true;
			}
		} else {
			SourceTablesStore store = SourceTablesStore.getStore();
			List<DocumentType> docTypes = store.returnDocumentTypes();
			request.setAttribute("docTypes", docTypes);
			
			path = JSPEnum.DOCUMENT_CHOOSE_TYPE.getPath();
			isRedirect = false;
		}
		request.setAttribute("errorString", errorString);
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		int subNumber = Integer.parseInt(request.getParameter("subNumber"));
		System.out.println(subNumber);
		int docTypeID = Integer.parseInt(request.getParameter("documentTypeID"));
		int senderID = Integer.parseInt(request.getParameter("senderID"));
		String description = request.getParameter("docDescription");
		String text = request.getParameter("docText");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(request.getParameter("executeDate"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Timestamp executeDate = new Timestamp(date.getTime());
		Timestamp currentDate = Timestamp.valueOf(LocalDateTime.now());
		List<Employee> receivers = new ArrayList<>();
		String receiverID;
		int i = 0;
		do {
			receiverID = request.getParameter("receiver" + i);				
			if (receiverID != null) {
				receivers.add(new Employee(Integer.parseInt(receiverID)));
			}	
			i++;
		} while (i < subNumber);	
		Document document = new Document();
		document.setAuthor(new Employee(senderID));
		document.setDocType(new DocumentType(docTypeID));
		document.setDescription(description);
		document.setTextBody(text);
		document.setDateUpdated(currentDate);
		document.setDateToExecute(executeDate);
		DocumentServiceImpl documentService = new DocumentServiceImpl();
		int result = 0;
		try {
			result = documentService.create(document);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString, e);
		}
		
		DocumentHistoryServiceImpl historyServiceImpl = new DocumentHistoryServiceImpl();
		if (!receivers.isEmpty() && errorString == null) {
			for (Employee receiver : receivers) {
				DocumentHistory docHistory = new DocumentHistory();
				docHistory.setDocument(new Document(result));
				docHistory.setFromEmployee(new Employee(senderID));
				docHistory.setToEmployee(receiver);
				docHistory.setDocStatus(new DocumentStatus(NEW_DOC));
				try {
					historyServiceImpl.create(docHistory);
				} catch (DBOperationException e) {
					errorString = e.getMessage();
					LOGGER.error(errorString, e);
				}
			}
		}
		if (errorString == null) {
			path = JSPEnum.DOCUMENT_CREATE_COMPLETE.getPath();
			isRedirect = true;
		} else {
			SourceTablesStore store = SourceTablesStore.getStore();
			List<DocumentType> docTypes = store.returnDocumentTypes();
			request.setAttribute("docTypes", docTypes);
			
			path = JSPEnum.DOCUMENT_CHOOSE_TYPE.getPath();
			isRedirect = false;
		}
		request.setAttribute("errorString", errorString);
	}	

}
