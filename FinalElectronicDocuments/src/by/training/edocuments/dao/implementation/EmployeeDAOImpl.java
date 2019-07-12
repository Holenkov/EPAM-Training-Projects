package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.bean.base.RoleEnum;
import by.training.edocuments.bean.base.UserRole;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.EmployeeDAO;
import by.training.edocuments.exception.DBOperationException;



public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO{
	private final Logger rootLogger = LogManager.getRootLogger(); 
	private static final String UPDATE_EMPLOYEE = "UPDATE `employee` "
			+ "SET `email` = ?, `pic` = ?, `password` = ?, `firstName` = ?, "
			+ "`lastName` = ?, `position` = ?, `role` = ?, `employeeStatus` = ? "
			+ "WHERE `employeeID` = ?";
	private static final String CREATE_EMPLOYEE = "INSERT INTO `employee` "
			+ "(`email`, `pic`, `password`, `firstName`, `lastName`, `position`, `role`, `employeeStatus`) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String EMPLOYEE_BY_ID = "SELECT `employeeID`, `email`, `pic`, `password`, "
			+ "`firstName`, `lastName`, `position`, `role`, `employeeStatus` "
			+ "FROM `employee` WHERE `employeeID` = ?";  
	private static final String EMPLOYEE_BY_EMAIL = "SELECT `employeeID`, `email`, `pic`, `password`, "
			+ "`firstName`, `lastName`, `position`, `role`, `employeeStatus` "
			+ "FROM `employee` WHERE `email` = ?"; 
	private static final String EMPLOYEE_ALL = "SELECT `employeeID`, `email`, `pic`, `password`, "
			+ "`firstName`, `lastName`, `position`, `role`, `employeeStatus` "
			+ "FROM `employee` ORDER BY `employeeID`"; 
		
	
//	String sql = "SELECT `login`, `password`, `role` FROM `users` WHERE `identity` = ?";
	
	
	public EmployeeDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	
/*	employeeID
	pic
	email
	password
	firstName
	lastName
	position
	role
	employeeStatus
	*/


	@Override
	public int create(Employee employee) throws DBOperationException {
		/*String sql = "INSERT INTO `employee` "
				+ "(`email`, `pic`, `password`, `firstName`, `lastName`, `position`, `role`, `employeeStatus`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";*/
		PreparedStatement statement = null;
		int update = 0;
		try {
			statement = connection.prepareStatement(CREATE_EMPLOYEE);
			statement.setString(1, employee.getEmail());
			statement.setString(2, "vcdgfsd");
			statement.setString(3, employee.getPassword());
			statement.setString(4, employee.getFirstName());
			statement.setString(5, employee.getLastName());
			statement.setInt(6, employee.getPosition().getPositionID());
			statement.setInt(7, employee.getRole().getRoleID());
			statement.setInt(8, employee.getEmployeeStatus().getEmplStatusID());
			update = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return update;
	}
	
	
	
	@Override
	public Employee find(Employee employee) throws DBOperationException {
		/*private final static String EMPLOYEE_BY_ID = "SELECT `employeeID`, `email`, `pic`, `password`, "
				+ "`firstName`, `lastName`, `position`, `role`, `employeeStatus` "
				+ "FROM `employee` WHERE `employeeID` = ?";     */
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(EMPLOYEE_BY_ID);
			statement.setInt(1, employee.getEmployeeID());
			ResultSet rSet = statement.executeQuery();
			if (rSet.next()) {
				initEmployee(rSet, employee);
			}  else {
				employee = null;
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Employee not found. DB error.", e);
		} 
		return employee;
	}
	
	
	@Override
	public int update(Employee employee) throws DBOperationException {
		/*private final static String INSERT_EMPLOYEE = "UPDATE `employee` "
				+ "SET `email` = ?, `pic` = ?, `password` = ?, `firstName` = ?, "
				+ "`lastName` = ?, `position` = ?, `role` = ?, `employeeStatus` = ? " + "WHERE employeeID = ?";*/
		PreparedStatement statement = null;
		System.out.println(connection + "   " + employee.getEmail());
		int update;
		try {
			statement = connection.prepareStatement(UPDATE_EMPLOYEE);
			statement.setString(1, employee.getEmail());
			statement.setString(2, "vcdgfsd");
			statement.setString(3, employee.getPassword());
			statement.setString(4, employee.getFirstName());
			statement.setString(5, employee.getLastName());
			statement.setInt(6, employee.getPosition().getPositionID());
			statement.setInt(7, employee.getRole().getRoleID());
			statement.setInt(8, employee.getEmployeeStatus().getEmplStatusID());
			statement.setInt(9, employee.getEmployeeID());
			update = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Employee not updated", e);
		} 
		return update;
	}

	@Override
	public int delete(Employee employee){
		return 0;
	}	
	

	
	@Override
	public List<Employee> readAll() throws DBOperationException {
		List<Employee> employees = new ArrayList<>();
		PreparedStatement statement = null;
		Employee employee;
		try {
			statement = connection.prepareStatement(EMPLOYEE_ALL);
			ResultSet rSet = statement.executeQuery();
			
			while (rSet.next()) {
				employee = new Employee();
				initEmployee(rSet, employee);
				employees.add(employee);
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Employees not read", e);
		} 

		return employees;
	}

	@Override
	public Employee findByEmail(Employee employee) throws DBOperationException {
		/*private final static String EMPLOYEE_BY_ID = "SELECT `employeeID`, `email`, `pic`, `password`, "
		+ "`firstName`, `lastName`, `position`, `role`, `employeeStatus` "
		+ "FROM `employee` WHERE `email` = ?";     */
		ResultSet rSet = null;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(EMPLOYEE_BY_EMAIL);
			statement.setString(1, employee.getEmail());
			rSet = statement.executeQuery();
			if (rSet.next()) {
				initEmployee(rSet, employee);
			} else {
				employee = null;
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Employee not read", e);
		} 

		return employee;
	}
	
	private void initEmployee (ResultSet rSet, Employee employee) throws SQLException {
		employee.setEmployeeID(rSet.getInt(1));
		employee.setEmail(rSet.getString(2));
		//enter image
		employee.setPassword(rSet.getString(4));
		employee.setFirstName(rSet.getString(5));
		employee.setLastName(rSet.getString(6));
		employee.setPosition(new EmployeePosition(rSet.getInt(7)));
		employee.setRole(new UserRole(rSet.getInt(8), RoleEnum.getRole(rSet.getInt(8))));
		employee.setEmployeeStatus(new EmployeeStatus(rSet.getInt(9)));
	}

}
