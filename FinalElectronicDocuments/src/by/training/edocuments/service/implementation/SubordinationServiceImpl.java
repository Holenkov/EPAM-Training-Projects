package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.EmployeeDAOImpl;
import by.training.edocuments.dao.implementation.SubordinationDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.Service;
import by.training.edocuments.service.SubordinationService;
import by.training.edocuments.util.SourceTablesStore;

public class SubordinationServiceImpl implements SubordinationService{
	

	@Override
	public Subordination find(Subordination sub) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
				
		DAO dao = new SubordinationDAOImpl(connection);
		sub = ((SubordinationDAOImpl)dao).find(sub);
		
		if (sub != null) {
			Service service = new EmployeeServiceImpl();
			Employee sender = sub.getSender(); 
			sender = ((EmployeeServiceImpl)service).findByID(sender);
			sub.setDocType(store.returnDocumentType(sub.getDocType().getDocTypeID()));
			Employee receiver = sub.getReceiver(); 
			receiver = ((EmployeeServiceImpl)service).findByID(receiver);
			sub.setSender(sender);
			sub.setReceiver(receiver);
		}
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return sub;
	}
	
	@Override
	public int create(Subordination sub) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
				
		DAO dao = new SubordinationDAOImpl(connection);
		int result = ((SubordinationDAOImpl)dao).create(sub);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return result;
	}
	
	

	@Override
	public List<Subordination> findBySender(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
	
		Service service = new EmployeeServiceImpl();
		Employee sender = ((EmployeeServiceImpl)service).findByID(employee);
				
		DAO dao = new SubordinationDAOImpl(connection);
		List<Subordination> subList = ((SubordinationDAOImpl)dao).findBySender(employee);
		if (!subList.isEmpty()) {
			for (Subordination sub : subList) {
				sub.setSender(sender);
				
				sub.setDocType(store.returnDocumentType(sub.getDocType().getDocTypeID()));
				
				Employee receiver = sub.getReceiver();
				receiver =  ((EmployeeServiceImpl)service).findByID(receiver);
				sub.setReceiver(receiver);
			}
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return subList;
	}
	
	@Override
	public List<Subordination> findBySender(Employee employee, DocumentType documentType) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
	
		Service service = new EmployeeServiceImpl();
		Employee sender = ((EmployeeServiceImpl)service).findByID(employee);
				
		DAO dao = new SubordinationDAOImpl(connection);
		List<Subordination> subList = ((SubordinationDAOImpl)dao).findBySender(employee, documentType);
		if (!subList.isEmpty()) {
			for (Subordination sub : subList) {
				sub.setSender(sender);
				
				sub.setDocType(store.returnDocumentType(sub.getDocType().getDocTypeID()));
				
				Employee receiver = sub.getReceiver();
				receiver =  ((EmployeeServiceImpl)service).findByID(receiver);
				sub.setReceiver(receiver);
			}
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return subList;
	}

	@Override
	public List<Subordination> findByReceiver(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		SourceTablesStore store = SourceTablesStore.getStore();
	
		Service service = new EmployeeServiceImpl();
		Employee receiver = ((EmployeeServiceImpl)service).findByID(employee);
				
		DAO dao = new SubordinationDAOImpl(connection);
		List<Subordination> subList = ((SubordinationDAOImpl)dao).findByReceiver(employee);
		if (!subList.isEmpty()) {
			for (Subordination sub : subList) {
				Employee sender = sub.getSender();
				sender =  ((EmployeeServiceImpl)service).findByID(sender);
				sub.setSender(sender);
				
				sub.setDocType(store.returnDocumentType(sub.getDocType().getDocTypeID()));
				
				sub.setReceiver(receiver);
			}
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return subList;
	}

	@Override
	public List<Subordination> readAll() throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Subordination sub) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
				
		DAO dao = new SubordinationDAOImpl(connection);
		int result = ((SubordinationDAOImpl)dao).delete(sub);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
		return result;
	}

	

	

}
