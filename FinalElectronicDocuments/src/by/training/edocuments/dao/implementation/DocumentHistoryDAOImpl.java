package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentHistoryDAO;
import by.training.edocuments.exception.DBOperationException;

public class DocumentHistoryDAOImpl extends AbstractDAO implements DocumentHistoryDAO{
	private static final String CREATE_HISTORY = "INSERT INTO `documentHistory` "
			+ "(`docID`, `fromID`, `toID`, `docStatus`) "
			+ "VALUES (?, ?, ?, ?)";
	private static final String HISTORY_BY_SENDER = "SELECT `id`, `docID`, `fromID`, `toID`, `dateExecuted`, `docStatus` "
			+ "FROM `documentHistory` WHERE `fromID` = ?";
	private static final String HISTORY_BY_EXECUTOR = "SELECT `id`, `docID`, `fromID`, `toID`, `dateExecuted`, `docStatus` "
			+ "FROM `documentHistory` WHERE `toID` = ?";
	
	/*id
	docID
	fromID
	toID
	dateExecuted
	docStatus*/

	public DocumentHistoryDAOImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(DocumentHistory history) throws DBOperationException {
		/*private static final String CREATE_HISTORY = "INSERT INTO `documentHistory` "
				+ "(`docID`, `fromID`, `toID`, `dateExecuted`, `docStatus`) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";*/
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(CREATE_HISTORY);
			statement.setInt(1, history.getDocument().getDocID());
			statement.setInt(2, history.getFromEmployee().getEmployeeID());
			statement.setInt(3, history.getToEmployee().getEmployeeID());
			statement.setInt(4, history.getDocStatus().getDocStatusID());
			result = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document History not created. DB error.", e);
		} 
		return result;
	}

	@Override
	public DocumentHistory find(DocumentHistory entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(DocumentHistory entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DocumentHistory entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DocumentHistory> findByAuthor(Employee employee) throws DBOperationException {
		/*private static final String HISTORY_BY_SENDER = "SELECT `id`, `docID`, `fromID`, `toID`, `dateExecuted`, `docStatus` "
				+ "FROM `documentHistory` WHERE `fromID` = ?";*/
		PreparedStatement statement = null;
		List<DocumentHistory> docHistories = new ArrayList<>();
		try {
			statement = connection.prepareStatement(HISTORY_BY_SENDER);
			statement.setInt(1, employee.getEmployeeID());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				DocumentHistory documentHistory = new DocumentHistory();
				initHistory(rSet, documentHistory);
				docHistories.add(documentHistory);
			}  
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document History not found. DB error.", e);
		} 
		return docHistories;
	}

	@Override
	public List<DocumentHistory> findByExecutor(Employee employee) throws DBOperationException {
		PreparedStatement statement = null;
		List<DocumentHistory> docHistories = new ArrayList<>();
		try {
			statement = connection.prepareStatement(HISTORY_BY_EXECUTOR);
			statement.setInt(1, employee.getEmployeeID());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				DocumentHistory documentHistory = new DocumentHistory();
				initHistory(rSet, documentHistory);
				docHistories.add(documentHistory);
			}  
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document History not found. DB error.", e);
		} 
		return docHistories;
	}

	@Override
	public List<DocumentHistory> readAll() throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void initHistory(ResultSet rSet, DocumentHistory docHistory) throws SQLException {
		docHistory.setId(rSet.getInt(1));
		docHistory.setDocument(new Document(rSet.getInt(2)));
		docHistory.setFromEmployee(new Employee(rSet.getInt(3)));
		docHistory.setToEmployee(new Employee(rSet.getInt(4)));
		docHistory.setDateExecuted(rSet.getTimestamp(5));
		docHistory.setDocStatus(new DocumentStatus(rSet.getInt(6)));
	}

}
