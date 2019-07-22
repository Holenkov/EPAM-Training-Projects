package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.DocumentHistoryDAOImpl;
import by.training.edocuments.dao.implementation.SubordinationDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.DocumentHistoryService;
import by.training.edocuments.service.Service;
import by.training.edocuments.util.SourceTablesStore;

public class DocumentHistoryServiceImpl implements DocumentHistoryService{

	@Override
	public int create(DocumentHistory history) throws DBOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocumentHistory find(DocumentHistory docHistory) throws DBOperationException {
		return docHistory;
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
