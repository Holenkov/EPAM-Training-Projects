package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentDAO;
import by.training.edocuments.exception.DBOperationException;

public class DocumentDAOImpl extends AbstractDAO implements DocumentDAO{
	private final Logger rootLogger = LogManager.getRootLogger(); 
	private static final String CREATE_DOCUMENT = "INSERT INTO `document` "
			+ "(`authorID`, `docType`, `description`, `textBody`, `dateUpdated`, `dateToExecute`) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DOCUMENT_BY_ID = "SELECT `docID`, `authorID`, `docType`, `description`, "
			+ "`textBody`, `dateUpdated`, `dateToExecute` FROM `document` WHERE `docID` = ?";  
	
	/*docID
	authorID
	docType
	description
	textBody
	dateUpdated
	dateToExecute*/

	public DocumentDAOImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Document document) throws DBOperationException {
	/*	private static final String CREATE_DOCUMENT = "INSERT INTO `document` "
				+ "(`authorID`, `docType`, `description`, `textBody`, `dateUpdated`, `dateToExecute`) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";*/
		PreparedStatement statement = null;
		int update = 0;
		try {
			statement = connection.prepareStatement(CREATE_DOCUMENT);
			statement.setInt(1, document.getAuthor().getEmployeeID());
			statement.setInt(2, document.getDocType().getDocTypeID());
			statement.setString(3, document.getDescription());
			statement.setString(4, document.getTextBody());
			statement.setTimestamp(5, document.getDateUpdated());
			statement.setTimestamp(6, document.getDateToExecute());
			update = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document not created. DB error.", e);
		} 
		return update;
	}

	@Override
	public Document find(Document document) throws DBOperationException {
		/*private static final String DOCUMENT_BY_ID = "SELECT `docID`, `authorID`, `docType`, `description`, "
				+ "`textBody`, `dateUpdated`, `dateToExecute` FROM `document` WHERE `docID` = ?";  */
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DOCUMENT_BY_ID);
			statement.setInt(1, document.getDocID());
			ResultSet rSet = statement.executeQuery();
			if (rSet.next()) {
				initDocument(rSet, document);
			}  else {
				document = null;
			}
			statement.close();
			rSet.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document not found. DB error.", e);
		} 
		return document;
	}

	@Override
	public int update(Document entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Document entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void initDocument (ResultSet rSet, Document document) throws SQLException {
		document.setDocID(rSet.getInt(1));
		document.setAuthor(new Employee(rSet.getInt(2)));
		document.setDocType(new DocumentType(rSet.getInt(3)));
		document.setDescription(rSet.getString(4));
		document.setDateUpdated(rSet.getTimestamp(5));
		document.setDateToExecute(rSet.getTimestamp(5));
	}



}
