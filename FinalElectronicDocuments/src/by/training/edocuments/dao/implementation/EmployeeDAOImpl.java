package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.EmployeeDAO;



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
	public void create(Employee employee){
		/*String sql = "INSERT INTO `employee` "
				+ "(`email`, `pic`, `password`, `firstName`, `lastName`, `position`, `role`, `employeeStatus`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";*/
		PreparedStatement statement = null;
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
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	/*	if (result == 1) {
			rootLogger.info("Employee was created");
		} else if (result == 0) {
			rootLogger.info("Employee was not created");
		}*/
		
	}
	
	
	
	@Override
	public Employee find(Employee employee) {
		/*private final static String EMPLOYEE_BY_ID = "SELECT `employeeID`, `email`, `pic`, `password`, "
				+ "`firstName`, `lastName`, `position`, `role`, `employeeStatus` "
				+ "FROM `employee` WHERE `employeeID` = ?";     */
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_EMPLOYEE);
			statement.setInt(1, employee.getEmployeeID());
			ResultSet rSet = statement.executeQuery();
			if (rSet.next()) {
			//	employee.setEmployeeID(employee.getEmployeeID());
				employee.setEmail(rSet.getString(2));
				employee.setPassword(rSet.getString(4));
				employee.setFirstName(rSet.getString(5));
				employee.setLastName(rSet.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return employee;
	}
	
	
	@Override
	public void update(Employee employee) {
		/*private final static String INSERT_EMPLOYEE = "UPDATE `employee` "
				+ "SET `email` = ?, `pic` = ?, `password` = ?, `firstName` = ?, "
				+ "`lastName` = ?, `position` = ?, `role` = ?, `employeeStatus` = ? " + "WHERE employeeID = ?";*/
		PreparedStatement statement = null;
		System.out.println(connection + "   " + employee.getEmail());

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
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Employee employee){
	}	
	

	
	@Override
	public List<Employee> readAll() {
			List<Employee> employeeList = null;
	        return employeeList;
	}

	@Override
	public Employee findByEmail(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
