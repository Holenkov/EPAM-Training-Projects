package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.Subordination;
import by.training.edocuments.exception.DBOperationException;

public interface SubordinationService extends Service {
	Subordination find(Subordination sub) throws DBOperationException;
	List<Subordination> findBySender(Employee employee) throws DBOperationException;
	List<Subordination> findByReceiver(Employee employee) throws DBOperationException;
	List<Subordination> readAll() throws DBOperationException;
	int delete(Subordination sub) throws DBOperationException;
	int create(Subordination sub) throws DBOperationException;

}
