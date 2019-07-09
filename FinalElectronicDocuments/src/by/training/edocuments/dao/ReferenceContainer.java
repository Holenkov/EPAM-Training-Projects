package by.training.edocuments.dao;

import java.util.HashMap;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.service.Service;

public class ReferenceContainer {
	private static HashMap<Integer,EmployeeStatus> employeeStatuses;
	private static HashMap<Integer,EmployeePosition> employeePositions;
	private static HashMap<Integer,DocumentType> docTypes;
	private static HashMap<Integer,DocumentStatus> docStatuses;
	
	private static ReferenceContainer container = null;
	
	private ReferenceContainer() {
	}
	
	public static synchronized ReferenceContainer getContainer() {
		if (container == null) {	
			synchronized (ReferenceContainer.class) {
				if (container == null) {	
					container = new ReferenceContainer();
					init();
				}
			}
		}
		return container;
	}
	
	private static void init() {
	}
	

}
