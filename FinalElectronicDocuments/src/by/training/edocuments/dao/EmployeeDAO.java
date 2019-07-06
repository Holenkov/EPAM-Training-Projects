package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.Employee;


public interface EmployeeDAO extends DAO<Employee>{
	
	List<Employee> readAll();
	Employee findByEmail(Employee employee);

}
