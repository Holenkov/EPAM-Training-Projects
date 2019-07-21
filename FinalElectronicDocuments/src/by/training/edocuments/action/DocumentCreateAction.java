package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.SourceTablesStore;

public class DocumentCreateAction extends Action {

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String docType = request.getParameter("documentTypeID");
		if (docType != null){
			int docTypeID = Integer.parseInt(docType);
			SourceTablesStore store  = SourceTablesStore.getStore();
			DocumentType documentType = store.returnDocumentType(docTypeID);
			path = JSPEnum.DOCUMENT_CREATE.getPath();
			isRedirect = false;
			request.setAttribute("documentType", documentType);
		} else {
			SourceTablesStore store = SourceTablesStore.getStore();
			List<DocumentType> docTypes = store.returnDocumentTypes();
			request.setAttribute("docTypes", docTypes);
			
			path = JSPEnum.DOCUMENT_CHOOSE_TYPE.getPath();
			isRedirect = false;
		}
		
		

	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
