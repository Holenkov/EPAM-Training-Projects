package by.training.edocuments.dao;

import java.sql.Connection;


public abstract class AbstractDAO {
	protected Connection connection;

	public AbstractDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	

	
	
/*	public Connection getConnection() {
		return connection;
	}*/

}
