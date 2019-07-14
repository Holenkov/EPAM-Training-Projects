package by.training.edocuments.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.dao.AbstractDAO;
import by.training.edocuments.dao.DocumentTypeDAO;
import by.training.edocuments.exception.DBOperationException;

public class DocumentTypeDAOImpl extends AbstractDAO implements DocumentTypeDAO {
	private static final String ALL_DOCUMENT_TYPES = "SELECT `docTypeID`, `docType` FROM `documentType`";
	
			
		/*	docTypeID
			docType*/
	
	public DocumentTypeDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public int create(DocumentType entity) throws DBOperationException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public DocumentType find(DocumentType entity) throws DBOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(DocumentType entity) throws DBOperationException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(DocumentType entity) throws DBOperationException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DocumentType> readAll() throws DBOperationException{
		 List<DocumentType>  docTypes = new ArrayList<>();
		PreparedStatement statement = null;
		DocumentType documentType;
		try {
			statement = connection.prepareStatement(ALL_DOCUMENT_TYPES);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				documentType = new DocumentType();
				documentType.setDocTypeID(rSet.getInt(1));
				documentType.setDocType(rSet.getString(2));
				docTypes.add(documentType);
			}
			rSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new DBOperationException("Document types not read. DB error.", e);
		} 
		return docTypes;
	}
	

}
