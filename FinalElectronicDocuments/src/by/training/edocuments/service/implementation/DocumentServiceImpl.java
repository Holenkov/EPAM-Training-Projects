package by.training.edocuments.service.implementation;

import java.sql.Connection;

import by.training.edocuments.bean.Document;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.implementation.DocumentDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.DocumentService;

public class DocumentServiceImpl implements DocumentService{

	@Override
	public int add(Document document) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DocumentDAOImpl dao = new DocumentDAOImpl(connection);
		int result = dao.create(document);
		if (result == 0) throw new DBOperationException("Document not added");
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);	
		return result;
	}

	@Override
	public Document find(Document document) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DocumentDAOImpl dao = new DocumentDAOImpl(connection);
		document = dao.find(document);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);	
		return document;
	}
	
	

}
