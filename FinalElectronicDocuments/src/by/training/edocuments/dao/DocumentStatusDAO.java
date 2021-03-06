package by.training.edocuments.dao;

import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentStatusDAO extends DAO<DocumentStatus> {
	List<DocumentStatus> readAll() throws DBOperationException;

}
