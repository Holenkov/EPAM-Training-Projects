package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.DocumentHistoryDAOImpl;
import by.training.edocuments.dao.implementation.EmployeeDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.DocumentHistoryService;
import by.training.edocuments.service.Service;
import by.training.edocuments.util.SourceTablesStore;

public class DocumentHistoryServiceImpl implements DocumentHistoryService{

	@Override
	public int create(DocumentHistory history) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DocumentHistoryDAOImpl dao = new DocumentHistoryDAOImpl(connection);
		int result = dao.create(history);
		if (result == 0) throw new DBOperationException("History not added");
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);	
		return result;
	}

	@Override
	public DocumentHistory find(DocumentHistory docHistory) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
	
		Service serviceEmployee = new EmployeeServiceImpl();
		Service serviceDocument = new DocumentServiceImpl();
		
				
		DAO dao = new DocumentHistoryDAOImpl(connection);
		DocumentHistory history = ((DocumentHistoryDAOImpl)dao).find(docHistory);
		if (history != null) {
				Employee sender = history.getFromEmployee();
				sender = ((EmployeeServiceImpl)serviceEmployee).findByID(sender);
				history.setFromEmployee(sender);
				
				Document document = history.getDocument();
				document = ((DocumentServiceImpl)serviceDocument).find(document);
				history.setDocument(document);
				
				Employee receiver = history.getToEmployee();
				receiver =  ((EmployeeServiceImpl)serviceEmployee).findByID(receiver);
				history.setToEmployee(receiver);
				
				history.setDocStatus(store.returnDocumentStatus(history.getDocStatus().getDocStatusID()));
				
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return history;
		
	}

	@Override
	public List<DocumentHistory> findByAuthor(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
	
		Service serviceEmployee = new EmployeeServiceImpl();
		Service serviceDocument = new DocumentServiceImpl();
		Employee sender = ((EmployeeServiceImpl)serviceEmployee).findByID(employee);
				
		DAO dao = new DocumentHistoryDAOImpl(connection);
		List<DocumentHistory> histories = ((DocumentHistoryDAOImpl)dao).findByAuthor(employee);
		if (!histories.isEmpty()) {
			for (DocumentHistory history : histories) {
				history.setFromEmployee(sender);
				
				Document document = history.getDocument();
				document = ((DocumentServiceImpl)serviceDocument).find(document);
				history.setDocument(document);
				
				Employee receiver = history.getToEmployee();
				receiver =  ((EmployeeServiceImpl)serviceEmployee).findByID(receiver);
				history.setToEmployee(receiver);
				
				history.setDocStatus(store.returnDocumentStatus(history.getDocStatus().getDocStatusID()));
				
			}
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return histories;
	}

	@Override
	public List<DocumentHistory> findByExecutor(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
	
		Service serviceEmployee = new EmployeeServiceImpl();
		Service serviceDocument = new DocumentServiceImpl();
		Employee executor = ((EmployeeServiceImpl)serviceEmployee).findByID(employee);
				
		DAO dao = new DocumentHistoryDAOImpl(connection);
		List<DocumentHistory> histories = ((DocumentHistoryDAOImpl)dao).findByExecutor(executor);
		if (!histories.isEmpty()) {
			for (DocumentHistory history : histories) {
				Employee sender = history.getFromEmployee();
				sender =  ((EmployeeServiceImpl)serviceEmployee).findByID(sender);
				history.setFromEmployee(sender);
				
				Document document = history.getDocument();
				document = ((DocumentServiceImpl)serviceDocument).find(document);
				history.setDocument(document);
				
				history.setToEmployee(executor);
				history.setDocStatus(store.returnDocumentStatus(history.getDocStatus().getDocStatusID()));
			}
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return histories;
	}

	@Override
	public int update(DocumentHistory history) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DocumentHistoryDAOImpl dao = new DocumentHistoryDAOImpl(connection);
		int result = dao.update(history);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return result;		
	}

}
