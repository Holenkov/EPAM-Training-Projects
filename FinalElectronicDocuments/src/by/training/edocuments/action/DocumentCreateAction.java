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
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.DocumentServiceImpl;
import by.training.edocuments.service.implementation.SubordinationServiceImpl;
import by.training.edocuments.util.CookieUtil;
import by.training.edocuments.util.SourceTablesStore;

public class DocumentCreateAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String docType = request.getParameter("documentTypeID");
		System.out.println("DocCreate  " + docType);
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

		int docTypeID = Integer.parseInt(request.getParameter("documentTypeID"));
		System.out.println("DocCr  " + request.getParameter("senderID"));
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
		} while (receiverID != null);	
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
			result = documentService.add(document);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString, e);
		}
		
		
		
		
		
		
		
	}	
		
		
		
		
	/*	Employee employee = new Employee();
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Part partAvatar = null;

		InputStream avatarStream = null;
		try {
			partAvatar = request.getPart("avatar");
			if (partAvatar.getSize() > 0) {
			
				avatarStream = partAvatar.getInputStream();
			} else {
				String path = request.getServletContext().getRealPath("/avatar/default.jpg");  
				File file = new File(path);
				try {
					avatarStream = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					errorString = "Default logo not found";
					LOGGER.error(errorString, e);
					hasError = true;
				}
			}
		} catch (IOException | ServletException e1) {
			errorString = "Default logo file not found";
			LOGGER.error(errorString, e1);
			hasError = true;
		}

		employee.setEmail(email);

		EmployeeServiceImpl service = new EmployeeServiceImpl();
		try {
			employee = service.findByEmail(employee);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString, e);
			hasError = true;
		}
		if (employee != null) {
			errorString = "This email already exists";
			hasError = true;
		}

		employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		SourceTablesStore store = SourceTablesStore.getStore();
		employee.setEmployeeStatus(store.returnEmployeeStatus(SourceTablesStore.getNOT_ACTIVE_STATUS()));
		employee.setPosition(store.returnEmployeePosition(SourceTablesStore.getSTART_POSITION()));
		employee.setRole(new UserRole(RoleEnum.NO_PERMISSIONS));
		employee.setAvatar(avatarStream);

		CryptoUtil cryptoUtil = null;
		if (!hasError) {
			try {
				cryptoUtil = new CryptoUtil();
			} catch (Exception e) {
				errorString = "Crypto Util error";
				LOGGER.error(errorString, e);
				hasError = true;
			}
		}

		if (!hasError) {
			employee.setPassword(cryptoUtil.encrypt(password1));
			try {
				service.add(employee);
			} catch (DBOperationException e) {
				errorString = e.getMessage();
				LOGGER.error(errorString, e);
				hasError = true;
			}
		}

		if (!hasError) {
			path = JSPEnum.EMPLOYEE_COMLETE_REGISTRATION.getPath();
			isRedirect = true;
		} else {
			employee.setPassword(password1);
			request.setAttribute("tempEmployee", employee);
			isRedirect = false;
			path = JSPEnum.EMPLOYEE_REGISTRATION_FORM.getPath();
			request.setAttribute("errorString", errorString);
		}

	}*/

}
