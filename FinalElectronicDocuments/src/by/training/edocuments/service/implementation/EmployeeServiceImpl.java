package by.training.edocuments.service.implementation;

import java.sql.Connection;
import java.util.List;

import javax.swing.text.Position;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.connection.ProxyConnection;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.EmployeeDAOImpl;
import by.training.edocuments.dao.implementation.EmployeePositionDAOImpl;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.EmployeeService;
import by.training.edocuments.util.SourceTablesStore;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void add(Employee employee)  throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		EmployeeDAOImpl dao = new EmployeeDAOImpl(connection);
		int result = dao.create(employee);
		if (result == 0) throw new DBOperationException("Employee not added");
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
	}
	
	@Override
	public Employee findByID(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new EmployeeDAOImpl(connection);
		employee = ((EmployeeDAOImpl)dao).find(employee);
		if (employee != null) {
			setStatusPosition(employee);
		} else {
			throw new DBOperationException("Employee not found");
		}
//		setStatusPosition(employee);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return employee;
	}
	
	@Override
	public Employee findByEmail(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new EmployeeDAOImpl(connection);
		employee = ((EmployeeDAOImpl)dao).findByEmail(employee);
		if (employee != null) {
			setStatusPosition(employee);
		}	
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return employee;
	}

	@Override
	public void update(Employee employee) throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		EmployeeDAOImpl dao = new EmployeeDAOImpl(connection);
		dao.update(employee);
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);		
	}
	
	@Override
	public List<Employee> readAll() throws DBOperationException {
		Connection connection = ConnectionPool.getConnectionPool().getConnection();
		DAO dao = new EmployeeDAOImpl(connection);
		List<Employee> employees;
		employees = ((EmployeeDAOImpl)dao).readAll();
		for (Employee employee : employees) {
			setStatusPosition(employee);
		}
		ConnectionPool.getConnectionPool().closeConnection((ProxyConnection)connection);
		return employees;
	}
	
	private void setStatusPosition (Employee employee) {
		SourceTablesStore store = SourceTablesStore.getStore();
		EmployeePosition position = store.returnEmployeePosition(employee.getPosition().getPositionID());
		EmployeeStatus status = store.returnEmployeeStatus(employee.getEmployeeStatus().getEmplStatusID());
		employee.setEmployeeStatus(status);
		employee.setPosition(position);
		
	}


	

	

}
