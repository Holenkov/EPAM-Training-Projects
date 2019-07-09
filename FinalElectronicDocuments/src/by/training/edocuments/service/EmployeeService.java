package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;

public interface EmployeeService extends Service{
	void add(Employee employee) throws DBOperationException;

	void update(Employee employee) throws DBOperationException;
	
	Employee findByID(Employee employee) throws DBOperationException;
	
	Employee findByEmail(Employee employee) throws DBOperationException;

	public List<Employee> readAll() throws DBOperationException;
}
