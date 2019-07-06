package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.Employee;

public interface DocumentDAO extends DAO<Document>{
	List<Document> findByAuthor(Employee employee) throws Exception;
	List<Document> readAll() throws Exception;

}
