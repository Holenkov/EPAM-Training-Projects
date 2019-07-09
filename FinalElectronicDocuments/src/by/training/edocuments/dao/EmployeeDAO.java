package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;


public interface EmployeeDAO extends DAO<Employee>{
	
	List<Employee> readAll () throws DBOperationException ;
	Employee findByEmail(Employee employee) throws DBOperationException ;

}
