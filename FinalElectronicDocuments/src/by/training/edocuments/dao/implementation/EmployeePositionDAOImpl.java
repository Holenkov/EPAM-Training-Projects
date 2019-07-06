package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentTypeDAO;
import by.training.edocuments.dao.EmployeePositionDAO;

public class EmployeePositionDAOImpl extends AbstractDAO implements EmployeePositionDAO {
	private static final String ALL_EMPLOYEE_POSITIONS = "SELECT `positionID`, `position` FROM `employeePosition`";
	
	/*positionID
	position*/		

	public EmployeePositionDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(EmployeePosition entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public EmployeePosition find(EmployeePosition entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(EmployeePosition entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(EmployeePosition entity) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public HashMap<Integer, EmployeePosition> readAll() {
		HashMap<Integer, EmployeePosition> emplPositions = new HashMap<>();
		PreparedStatement statement = null;
		EmployeePosition employeePosition;
		try {
			statement = connection.prepareStatement(ALL_EMPLOYEE_POSITIONS);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				employeePosition = new EmployeePosition();
				employeePosition.setPositionID(rSet.getInt(1));
				employeePosition.setPosition(rSet.getString(2));
				emplPositions.put(rSet.getInt(1), employeePosition);
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
		return emplPositions;
	}


	
	

}
