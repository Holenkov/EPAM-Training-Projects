package by.training.edocuments.connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.Service;
import by.training.edocuments.service.implementation.DocumentStatusServiceImpl;
import by.training.edocuments.service.implementation.DocumentTypeServiceImpl;
import by.training.edocuments.service.implementation.EmployeePositionServiceImpl;
import by.training.edocuments.service.implementation.EmployeeStatusServiceImpl;

public class SourceTablesStore {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static Map<Integer, DocumentStatus> documentStatusMap = new HashMap<>();
	private static Map<Integer, DocumentType> documentTypeMap = new HashMap<>();
	private static Map<Integer, EmployeeStatus> employeeStatusMap = new HashMap<>();
	private static Map<Integer, EmployeePosition> employeePositionMap = new HashMap<>();
	
	private static volatile SourceTablesStore store;
	
	private SourceTablesStore() {
	}

	public static SourceTablesStore getStore() {
		if (store == null) {
			synchronized(SourceTablesStore.class) {
				if (store == null) {
					store = new SourceTablesStore();
					init();
				}
			}
		}
		return store;
	}
	
	public DocumentStatus returnDocumentStatus(int index) {
		return documentStatusMap.get(index);
	}
	
	public List<DocumentStatus> returnDocumentStatuses() {
		List<DocumentStatus> list = new ArrayList<>();
		for (Map.Entry<Integer, DocumentStatus> entry: documentStatusMap.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	
	public DocumentType returnDocumentType(int index) {
		return documentTypeMap.get(index);
	}
	
	public List<DocumentType> returnDocumentTypes() {
		List<DocumentType> list = new ArrayList<>();
		for (Map.Entry<Integer, DocumentType> entry: documentTypeMap.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	public EmployeeStatus returnEmployeeStatus(int index) {
		return employeeStatusMap.get(index);
	}
	
	public List<EmployeeStatus> returnEmployeeStatuses() {
		List<EmployeeStatus> list = new ArrayList<>();
		for (Map.Entry<Integer, EmployeeStatus> entry: employeeStatusMap.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	public EmployeePosition returnEmployeePosition(int index) {
		return employeePositionMap.get(index);
	}
	
	public List<EmployeePosition> returnEmployeePositions() {
		List<EmployeePosition> list = new ArrayList<>();
		for (Map.Entry<Integer, EmployeePosition> entry: employeePositionMap.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	public static void init() {
		Service service = new DocumentStatusServiceImpl();
		List<DocumentStatus> docStatuses = null;
		try {
			docStatuses = ((DocumentStatusServiceImpl)service).readAll();
		} catch (DBOperationException e) {
			e.printStackTrace();
			return;
		}	
		documentStatusMap.clear();
		for (DocumentStatus element : docStatuses) {
			documentStatusMap.put(element.getDocStatusID(), element);
		}
		
		service = new DocumentTypeServiceImpl();
		List<DocumentType> docTypes = null;
		try {
			docTypes = ((DocumentTypeServiceImpl)service).readAll();
		} catch (DBOperationException e) {
			e.printStackTrace();
			return;
		}	
		documentTypeMap.clear();
		for (DocumentType element : docTypes) {
			documentTypeMap.put(element.getDocTypeID(), element);
		}
		
		service = new EmployeePositionServiceImpl();
		List<EmployeePosition> emplPositions = null;
		try {
			emplPositions = ((EmployeePositionServiceImpl)service).readAll();
		} catch (DBOperationException e) {
			e.printStackTrace();
			return;
		}	
		employeePositionMap.clear();
		for (EmployeePosition element : emplPositions) {
			employeePositionMap.put(element.getPositionID(), element);
		}
		
		service = new EmployeeStatusServiceImpl();
		List<EmployeeStatus> emplStatuses = null;
		try {
			emplStatuses = ((EmployeeStatusServiceImpl)service).readAll();
		} catch (DBOperationException e) {
			e.printStackTrace();
			return;
		}	
		employeeStatusMap.clear();
		for (EmployeeStatus element : emplStatuses) {
			employeeStatusMap.put(element.getEmplStatusID(), element);
		}
		LOGGER.info("SourceTablesStore initialization success");
		
	}
	
	
	

	
	
	
	
	
}
