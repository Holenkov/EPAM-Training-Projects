package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentStatusDAO;
import by.training.edocuments.dao.DocumentTypeDAO;
import by.training.edocuments.exception.DBOperationException;

public class DocumentStatusDAOImpl extends AbstractDAO implements DocumentStatusDAO {
	private static final String ALL_DOCUMENT_STATUSES = "SELECT `docStatusID`, `docStatus` FROM `documentStatus`";
	
			
		/*	docStatusID
docStatus*/

	public DocumentStatusDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public void create(DocumentStatus entity) throws DBOperationException  {
		// TODO Auto-generated method stub
	}

	@Override
	public DocumentStatus find(DocumentStatus entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DocumentStatus entity) throws DBOperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DocumentStatus entity) throws DBOperationException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<DocumentStatus> readAll() throws DBOperationException{
		List<DocumentStatus> docStatuses = new ArrayList<>();
		PreparedStatement statement = null;
		DocumentStatus documentStatus;
		try {
			statement = connection.prepareStatement(ALL_DOCUMENT_STATUSES);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				documentStatus = new DocumentStatus();
				documentStatus.setDocStatusID(rSet.getInt(1));
				documentStatus.setDocStatus(rSet.getString(2));
				docStatuses.add(documentStatus);
			}
			rSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document statuses not read", e);
		} 
		return docStatuses;
	}
	

}
