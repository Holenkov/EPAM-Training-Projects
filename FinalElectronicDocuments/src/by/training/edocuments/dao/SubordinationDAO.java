package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;

public interface SubordinationDAO extends DAO<Subordination>{
	List<Document> findBySender(Employee employee) throws Exception;
	List<Document> readAll() throws Exception;

}
