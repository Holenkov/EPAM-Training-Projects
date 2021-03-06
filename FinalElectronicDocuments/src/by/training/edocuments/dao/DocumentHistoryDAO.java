package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentHistoryDAO extends DAO<DocumentHistory>{
	List<DocumentHistory> findByAuthor(Employee employee) throws DBOperationException;
	List<DocumentHistory> findByExecutor(Employee employee) throws DBOperationException;
	List<DocumentHistory> readAll() throws DBOperationException;
	
	

}
