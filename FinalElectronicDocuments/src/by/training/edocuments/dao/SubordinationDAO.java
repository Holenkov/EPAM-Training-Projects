package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Document;
import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;

public interface SubordinationDAO extends DAO<Subordination>{
	List<Subordination> findBySender(Employee employee) throws DBOperationException;
	List<Subordination> findByReceiver(Employee employee) throws DBOperationException;
	List<Subordination> findBySender(Employee employee, DocumentType docType) throws DBOperationException;
	List<Subordination> readAll() throws DBOperationException ;

}
