package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.EmployeePositionDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.EmployeePositionService;

public class EmployeePositionServiceImpl implements EmployeePositionService{

	@Override
	public List<EmployeePosition> readAll() throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new EmployeePositionDAOImpl(connection);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return ((EmployeePositionDAOImpl)dao).readAll();	
	}

}
