package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.EmployeeStatusDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.EmployeeStatusService;

public class EmployeeStatusServiceImpl implements EmployeeStatusService{

	@Override
	public List<EmployeeStatus> readAll() throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new EmployeeStatusDAOImpl(connection);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return ((EmployeeStatusDAOImpl)dao).readAll();	
	}
	
	

}
