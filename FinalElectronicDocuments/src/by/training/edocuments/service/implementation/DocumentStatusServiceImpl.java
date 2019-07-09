package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.DocumentStatusDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.DocumentStatusService;

public class DocumentStatusServiceImpl implements DocumentStatusService{

	
	
	@Override
	public List<DocumentStatus> readAll() throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new DocumentStatusDAOImpl(connection);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return ((DocumentStatusDAOImpl)dao).readAll();	
	}

}
