package by.training.edocuments.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.UserRole;
import by.training.edocuments.bean.base.RoleEnum;
import by.training.edocuments.dao.DAO;
import by.training.edocuments.dao.implementation.EmployeeDAOImpl;


public class ConnectionPool {
	private ArrayBlockingQueue<ProxyConnection> connections;
	private String userName;
	private String userPass;
	private String URL;
	private int poolSize;
	
	private static volatile ConnectionPool instance;
	
	private ConnectionPool() {
	}

	public static synchronized ConnectionPool getConnectionPool() {
		if (instance == null) {	
			synchronized (ConnectionPool.class) {
				if (instance == null) {	
				instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}
	
	public void init (final String USER_NAME, final String USER_PASS, final int POOL_SIZE) {
		connections = new ArrayBlockingQueue<>(POOL_SIZE);
		Properties properties = AppProperties.getSettings().getProperties();
		userName = properties.getProperty("DB_USER_NAME");
		userPass = properties.getProperty("DB_USER_PASS");
		URL = properties.getProperty("DB_URL");
		String fullURL = URL + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
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
	
	
	public static void main(String[] args) {
		ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
		connectionPool.init("root", "", 20);
		ProxyConnection connection = connectionPool.getConnection();
		DAO<Employee> employeeDAO = new EmployeeDAOImpl(connection);
		Employee employee = new Employee(1, "email11", "password", "firstName", "lastName", 
				new EmployeePosition(1), new UserRole(RoleEnum.NO_PERMISSIONS), new EmployeeStatus(1));
		/*try {
			employeeDAO.create(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		employee = new Employee(38, "email33", "password", "firstName", "lastName", 
				new EmployeePosition(1), new UserRole(RoleEnum.NO_PERMISSIONS), new EmployeeStatus(1));
		
		try {
			employeeDAO.update(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connectionPool.closeConnection(connection);
		
	}


}
