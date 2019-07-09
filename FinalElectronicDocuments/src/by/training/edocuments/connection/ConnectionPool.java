package by.training.edocuments.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;

import javax.naming.InitialContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.UserRole;
import by.training.edocuments.bean.base.RoleEnum;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.EmployeeDAOImpl;


public class ConnectionPool {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static ArrayBlockingQueue<ProxyConnection> connections;
	private static String userName;
	private static String userPass;
	private static String FULL_URL;
	private static int poolSize;
	
	private static volatile ConnectionPool instance;
	
	private ConnectionPool() {
	}

	public static ConnectionPool getConnectionPool() {
		if (instance == null) {	
			synchronized (ConnectionPool.class) {
			
				if (instance == null) {	
				instance = new ConnectionPool();
				System.out.println("ConnectionPool init");
				//need to find in server prop maximum connections.
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				init(20);
				}
			}
		}
		return instance;
	}
	
	public static void init (final int POOL_SIZE) {
		connections = new ArrayBlockingQueue<>(POOL_SIZE);
		Properties properties = PropertyUtil.getSettings().getProperties();
		userName = properties.getProperty("DB_USER_NAME");
		userPass = properties.getProperty("DB_USER_PASS");
		final String URL = properties.getProperty("DB_URL");
		final String SERVER_PROP = properties.getProperty("SERVER_PROP");
		String fullURL = URL + SERVER_PROP;
		poolSize = POOL_SIZE;
	
		for (int i = 0; i < POOL_SIZE; i++) {
			ProxyConnection connection = null;;
			try {
				connection = new ProxyConnection(DriverManager.getConnection(fullURL, userName, userPass));
				connections.offer(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		}
		LOGGER.info("Connection Pool initialization complete  " + connections.size() + "  " + connections.remainingCapacity());
	}


	public ProxyConnection getConnection(){
		ProxyConnection connection = null;
		try {
			
			connection = connections.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(ProxyConnection connection) {
	
		connections.offer(connection);
	}
	
	
	//MAIN
	public static void main(String[] args) {
		ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
		ProxyConnection connection = connectionPool.getConnection();
		DAO<Employee> employeeDAO = new EmployeeDAOImpl(connection);
		Employee employee = new Employee(1, "email11", "password", "firstName", "lastName", 
				new EmployeePosition(1), new UserRole(RoleEnum.NO_PERMISSIONS), new EmployeeStatus(1));
		/*try {
			employeeDAO.create(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		employee = new Employee(38, "email33", "password47", "firstName", "lastName", 
				new EmployeePosition(1), new UserRole(RoleEnum.NO_PERMISSIONS), new EmployeeStatus(1));
		
		try {
			employeeDAO.update(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		employee = new Employee(38);
		try {
			employee = employeeDAO.find(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		connectionPool.closeConnection(connection);
		
	}


}
