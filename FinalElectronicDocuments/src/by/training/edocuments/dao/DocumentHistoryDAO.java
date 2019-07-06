package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.DocumentHistory;
import by.training.edocuments.bean.Employee;

public interface DocumentHistoryDAO extends DAO<DocumentHistory>{
	List<Document> findByAuthor(Employee employee) throws Exception;
	List<Document> findByExecutor(Employee employee) throws Exception;
	List<Document> readAll() throws Exception;
	
	

}
