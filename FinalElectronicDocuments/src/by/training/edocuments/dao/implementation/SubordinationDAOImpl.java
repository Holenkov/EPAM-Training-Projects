package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.SubordinationDAO;
import by.training.edocuments.exception.DBOperationException;

public class SubordinationDAOImpl extends AbstractDAO implements SubordinationDAO{
	private static final String SUBORDINATION_BY_ID = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
			+ "FROM `subordination` WHERE `id` = ? ORDER BY `id` ";
	private static final String SUBORDINATION_BY_SENDER = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
			+ "FROM `subordination` WHERE `senderID` = ? ORDER BY `id`";
	private static final String SUBORDINATION_BY_RECEIVER = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
			+ "FROM `subordination` WHERE `receiverID` = ? ORDER BY `id`";
	private static final String SUBORDINATION_DELETE_ID = "DELETE FROM `subordination` WHERE `id` = ?";
	private static final String SUBORDINATION_ADD = "INSERT "
			+ "INTO `subordination` (`senderID`, `docTypeID`, `receiverID`) VALUES (?, ? ,?)";
	private static final String SUBORDINATION_BY_SENDER_DOCTYPE = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
			+ "FROM `subordination` WHERE (`senderID` = ?  AND `docTypeID` = ? ) ORDER BY `id` ";
	
	
	/*id
	senderID
	docTypeID
	receiverID*/
	
	public SubordinationDAOImpl(Connection connection) {
		super(connection);
	}

	

	@Override
	public int create(Subordination entity) throws DBOperationException {
		/*private static final String SUBORDINATION_ADD = "INSERT "
				+ "INTO `subordination` (`senderID`, `docTypeID`, `receiverID`) VALUES (?, ? ,?)";*/
		PreparedStatement statement = null;
		int update = 0;
		try {
			statement = connection.prepareStatement(SUBORDINATION_ADD);
			statement.setInt(1, entity.getSender().getEmployeeID());
			statement.setInt(2, entity.getDocType().getDocTypeID());
			statement.setInt(3, entity.getReceiver().getEmployeeID());
			update = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Subordination not created. DB error.", e);
		} 
		return update;
	}


	@Override
	public Subordination find(Subordination entity) throws DBOperationException {
		/*private static final String SUBORDINATION_BY_ID = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
				+ "FROM `subordination` WHERE `id` = ? ORDER BY `id` ";*/
		PreparedStatement statement = null;
		Subordination sub = null;
		try {
			statement = connection.prepareStatement(SUBORDINATION_BY_ID);
			statement.setInt(1, entity.getId());
			ResultSet rSet = statement.executeQuery();
			if (rSet.next()) {
				sub = new Subordination();
				initSubordination(rSet, sub);
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Subordination not found. DB error.", e);
		} 
		return sub;
	}

	@Override
	public int update(Subordination entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Subordination entity) throws DBOperationException {
		/*private static final String SUBORDINATION_DELETE_ID = "DELETE FROM `subordination` WHERE `id` = ?";*/
		PreparedStatement statement = null;
		int result;
		try {
			statement = connection.prepareStatement(SUBORDINATION_DELETE_ID);
			statement.setInt(1, entity.getId());
			result = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Subordination not deleted. DB error.", e);
		} 
		return result;
	}

	@Override
	public List<Subordination> findBySender(Employee employee) throws DBOperationException {
	/*	private static final String SUBORDINATION_BY_SENDER = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
				+ "FROM `subordination` WHERE `senderID` = ? ORDER BY `id`";*/
		PreparedStatement statement = null;
		List<Subordination> subList = new ArrayList<>();
		Subordination sub = null;
		try {
			statement = connection.prepareStatement(SUBORDINATION_BY_SENDER);
			statement.setInt(1, employee.getEmployeeID());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				sub = new Subordination();
				initSubordination(rSet, sub);
				subList.add(sub);
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Subordination not found. DB error.", e);
		} 
		return subList;
	}
	
	@Override
	public List<Subordination> findBySender(Employee employee, DocumentType docType) throws DBOperationException {
	/*	private static final String SUBORDINATION_BY_RECEIVER_DOCTYPE = "SELECT `id`, `senderID`, `docTypeID`, `receiverID` "
				+ "FROM `subordination` WHERE (`senderID` = ?  AND `docTypeID` = ? ) ORDER BY `id` ";*/
		PreparedStatement statement = null;
		List<Subordination> subList = new ArrayList<>();
		Subordination sub = null;
		try {
			statement = connection.prepareStatement(SUBORDINATION_BY_SENDER_DOCTYPE);
			statement.setInt(1, employee.getEmployeeID());
			statement.setInt(2, docType.getDocTypeID());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				sub = new Subordination();
				initSubordination(rSet, sub);
				subList.add(sub);
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Subordination not found. DB error.", e);
		} 
		return subList;
	}


	@Override
	public List<Subordination> readAll() throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void initSubordination(ResultSet rSet, Subordination sub) throws SQLException {
		sub.setId(rSet.getInt(1));
		sub.setSender(new Employee(rSet.getInt(2)));
		sub.setDocType(new DocumentType(rSet.getInt(3)));
		sub.setReceiver(new Employee(rSet.getInt(4)));		
	}

	@Override
	public List<Subordination> findByReceiver(Employee employee) throws DBOperationException {
		PreparedStatement statement = null;
		List<Subordination> subList = new ArrayList<>();
		Subordination sub = null;
		try {
			statement = connection.prepareStatement(SUBORDINATION_BY_RECEIVER);
			statement.setInt(1, employee.getEmployeeID());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				sub = new Subordination();
				initSubordination(rSet, sub);
				subList.add(sub);
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Subordination not found. DB error.", e);
		} 
		return subList;
	}




	
	
}
