package by.training.edocuments.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.edocuments.exception.PoolInitException;


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
				}
			}
		}
		return instance;
	}
	
	public void init (final int POOL_SIZE) throws Exception{
		connections = new ArrayBlockingQueue<>(POOL_SIZE);
		Properties properties = new Properties();
	    try {
	    	properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("app.properties"));	
	    } catch (Exception e) {
	    	throw new PoolInitException("Connection properties not read.", e);
	    }
		userName = properties.getProperty("DB_USER_NAME");
		userPass = properties.getProperty("DB_USER_PASS");
		final String URL = properties.getProperty("DB_URL");
		final String SERVER_PROP = properties.getProperty("SERVER_PROP");
		FULL_URL = URL + SERVER_PROP;
		poolSize = POOL_SIZE;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			for (int i = 0; i < POOL_SIZE; i++) {
				ProxyConnection connection = null;
					connection = new ProxyConnection(DriverManager.getConnection(FULL_URL, userName, userPass));
					connections.offer(connection);
			}
		} catch (SQLException e) {	
			throw new PoolInitException("Connection pool not initialized.", e);
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
		try {
			connection.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection = new ProxyConnection(DriverManager.getConnection(FULL_URL, userName, userPass));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		connections.offer(connection);
	}
	
	



}
