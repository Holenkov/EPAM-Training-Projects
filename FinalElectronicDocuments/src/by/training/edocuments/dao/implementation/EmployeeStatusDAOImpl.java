package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.EmployeePositionDAO;
import by.training.edocuments.dao.EmployeeStatusDAO;
import by.training.edocuments.exception.DBOperationException;

public class EmployeeStatusDAOImpl extends AbstractDAO implements EmployeeStatusDAO {
	private static final String ALL_EMPLOYEE_POSITIONS = "SELECT `emplStatusID`, `emplStatus` FROM `employeeStatus`";
	
	/*emplStatusID
emplStatus*/		

	public EmployeeStatusDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public void create(EmployeeStatus entity) throws DBOperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeStatus find(EmployeeStatus entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(EmployeeStatus entity) throws DBOperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployeeStatus entity) throws DBOperationException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmployeeStatus> readAll() throws DBOperationException {
		List<EmployeeStatus> emplStatuses = new ArrayList<>();
		PreparedStatement statement = null;
		EmployeeStatus employeeStatus;
		try {
			statement = connection.prepareStatement(ALL_EMPLOYEE_POSITIONS);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				employeeStatus = new EmployeeStatus();
				employeeStatus.setEmplStatusID(rSet.getInt(1));
				employeeStatus.setEmplStatus(rSet.getString(2));
				emplStatuses.add(employeeStatus);
			}
			rSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Employee statuses not read. DB error.", e);
		} 
		return emplStatuses;
	}




	
	

}
