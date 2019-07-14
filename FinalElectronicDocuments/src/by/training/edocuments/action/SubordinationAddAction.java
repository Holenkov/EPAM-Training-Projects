package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.service.implementation.SubordinationServiceImpl;
import by.training.edocuments.util.SourceTablesStore;

public class SubordinationAddAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		List<Employee> employees = null;
		try {
			employees = service.readAll();
			request.setAttribute("employeeList", employees);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(e.getMessage(), e);
		}
		String employeeID = request.getParameter("employeeID");
		request.setAttribute("employeeID", employeeID);
		
		if (errorString == null) {
			SourceTablesStore store = SourceTablesStore.getStore();
			List<DocumentType> docTypes = store.returnDocumentTypes();
			request.setAttribute("employees", employees);
			request.setAttribute("docTypes", docTypes);
			path = JSPEnum.SUBORDINATION_ADD_FORM.getPath();
			isRedirect = false;
		} else {
			request.setAttribute("errorString", errorString);
			path = JSPEnum.SUBORDINATION_EDIT.getPath();
		}

	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		
		String sender = request.getParameter("sender");
		String docType = request.getParameter("docType");
		String receiver = request.getParameter("receiver");
		Employee senderObj = new Employee(Integer.parseInt(sender));
		DocumentType docTypeObj = new DocumentType(Integer.parseInt(docType));
		Employee receiverObj = new Employee(Integer.parseInt(receiver));
		
		
		Subordination sub = new Subordination();
		sub.setSender(senderObj);
		sub.setDocType(docTypeObj);
		sub.setReceiver(receiverObj);
		
		SubordinationServiceImpl service = new SubordinationServiceImpl();
		int result = 0;
		try {
			result = service.create(sub);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(e.getMessage(), e);
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
