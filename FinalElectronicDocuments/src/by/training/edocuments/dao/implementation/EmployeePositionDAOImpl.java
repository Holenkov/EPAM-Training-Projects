package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.EmployeePositionDAO;
import by.training.edocuments.exception.DBOperationException;

public class EmployeePositionDAOImpl extends AbstractDAO implements EmployeePositionDAO {
	private static final String ALL_EMPLOYEE_POSITIONS = "SELECT `positionID`, `position` FROM `employeePosition`";
	
	/*positionID
	position*/		

	public EmployeePositionDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public int create(EmployeePosition entity) throws DBOperationException {
		return 0;
		// TODO Auto-generated method stub
		
	}


	@Override
	public EmployeePosition find(EmployeePosition entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int update(EmployeePosition entity) throws DBOperationException {
		return 0;
		// TODO Auto-generated method stub
		
	}


	@Override
	public int delete(EmployeePosition entity) throws DBOperationException {
		return 0;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<EmployeePosition> readAll() throws DBOperationException {
		List<EmployeePosition> emplPositions = new ArrayList<>();
		PreparedStatement statement = null;
		EmployeePosition employeePosition;
		try {
			statement = connection.prepareStatement(ALL_EMPLOYEE_POSITIONS);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				employeePosition = new EmployeePosition();
				employeePosition.setPositionID(rSet.getInt(1));
				employeePosition.setPosition(rSet.getString(2));
				emplPositions.add(employeePosition);
			}
			rSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Employee positions not read", e);
		} 
		return emplPositions;
	}


	
	

}
