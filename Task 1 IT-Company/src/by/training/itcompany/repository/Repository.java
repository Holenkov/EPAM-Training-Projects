package by.training.itcompany.repository;

import java.util.List;

import by.training.itcompany.model.Employee;

public interface Repository {
	void viewRepository();
	//List<Employee> getAll();
	//void setAll(List<Employee> employees);
	void deleteByParam(String param, List<String> params);
	/**
	 * Add Employee to Repository. 
	 */
	void add(Employee employee);
	/**
	 * Get Employees from Repository by parameter.
	 * @param param name of parameter.
	 * @param params list of parameter values.
	 * Parameters: 
	 * "salary",[min, max] - integer numbers;
	 * "id",[id] - integer number;
	 * "department", ["Development"], ["Management"] or ["QA Department"],
	 * @return List<Employee>  or null if Employees not found. 
	 */
	List<Employee> getByParam(String param, List<String> params);
	/**
	 * Method sorts Repository by parameters.
	 * @param params - ArrayList<String> of Parameters, one or two parameters. Sort by: "id", "salary", "department", "experience".
	 */
	void sortByParam(List<String> params);
	
	
	

}
