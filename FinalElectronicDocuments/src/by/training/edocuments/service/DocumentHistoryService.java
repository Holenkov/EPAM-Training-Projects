package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentHistoryService extends Service{
	int create(DocumentHistory history) throws DBOperationException;
	DocumentHistory find(DocumentHistory entity) throws DBOperationException;
	List<DocumentHistory> findByAuthor(Employee employee) throws DBOperationException;
	List<DocumentHistory> findByExecutor(Employee employee) throws DBOperationException;
}
