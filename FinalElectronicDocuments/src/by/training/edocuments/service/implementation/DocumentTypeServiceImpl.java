package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.DocumentTypeDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.DocumentTypeService;

public class DocumentTypeServiceImpl implements DocumentTypeService{

	@Override
	public List<DocumentType> readAll() throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new DocumentTypeDAOImpl(connection);
		List<DocumentType> list = ((DocumentTypeDAOImpl)dao).readAll();
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return list;	
	}

}
