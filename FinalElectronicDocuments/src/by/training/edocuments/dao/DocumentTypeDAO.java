package by.training.edocuments.dao;

import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentTypeDAO extends DAO<DocumentType> {
	List<DocumentType> readAll() throws DBOperationException;

}
