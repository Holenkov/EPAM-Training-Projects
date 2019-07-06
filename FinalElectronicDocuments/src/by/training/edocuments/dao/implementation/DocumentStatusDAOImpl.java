package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentStatusDAO;
import by.training.edocuments.dao.DocumentTypeDAO;

public class DocumentStatusDAOImpl extends AbstractDAO implements DocumentStatusDAO {
	private static final String ALL_DOCUMENT_STATUSES = "SELECT `docStatusID`, `docStatus` FROM `documentStatus`";
	
			
		/*	docStatusID
docStatus*/

	public DocumentStatusDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public void create(DocumentStatus entity) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public DocumentStatus find(DocumentStatus entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DocumentStatus entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DocumentStatus entity) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public HashMap<Integer, DocumentStatus> readAll() {
		HashMap<Integer,DocumentStatus> docStatuses = new HashMap<>();
		PreparedStatement statement = null;
		DocumentStatus documentStatus;
		try {
			statement = connection.prepareStatement(ALL_DOCUMENT_STATUSES);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				documentStatus = new DocumentStatus();
				documentStatus.setDocStatusID(rSet.getInt(1));
				documentStatus.setDocStatus(rSet.getString(2));
				docStatuses.put(rSet.getInt(1), documentStatus);
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
		return docStatuses;
	}
	

}
