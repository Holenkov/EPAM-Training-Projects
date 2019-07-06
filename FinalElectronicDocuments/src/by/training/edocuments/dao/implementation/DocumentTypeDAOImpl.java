package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentTypeDAO;

public class DocumentTypeDAOImpl extends AbstractDAO implements DocumentTypeDAO {
	private static final String ALL_DOCUMENT_TYPES = "SELECT `docTypeID`, `docType` FROM `documentType`";
	
			
		/*	docTypeID
			docType*/

	public DocumentTypeDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DocumentType find(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, DocumentType> readAll() {
		HashMap<Integer,DocumentType> docTypes = new HashMap<>();
		PreparedStatement statement = null;
		DocumentType documentType;
		try {
			statement = connection.prepareStatement(ALL_DOCUMENT_TYPES);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				documentType = new DocumentType();
				documentType.setDocTypeID(rSet.getInt(1));
				documentType.setDocType(rSet.getString(2));
				docTypes.put(rSet.getInt(1), documentType);
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
		return docTypes;
	}
	

}
