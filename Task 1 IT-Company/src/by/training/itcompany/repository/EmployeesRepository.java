/**
 * Repository for Employee class objects 
 * with private field List<Employee> employees.
 */

package by.training.itcompany.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Throwables;

import by.training.itcompany.enums.Departments;
import by.training.itcompany.exceptions.NullResultException;
import by.training.itcompany.models.Developer;
import by.training.itcompany.models.Employee;
import by.training.itcompany.models.Manager;
import by.training.itcompany.models.QAEngineer;
import by.training.itcompany.utils.RepositoryFileIO;

public class EmployeesRepository implements Repository{
	private static EmployeesRepository instance = null;
	private List<Employee> employees;

	/** 
	 * Private constructor.
	 * @param fileName - path to txt file, storing Repository data.
	 */	
	private EmployeesRepository(String fileName) throws NullResultException {
		final Logger rootLogger = LogManager.getRootLogger();
		RepositoryFileIO repositoryFileIO = new RepositoryFileIO();
		List<Employee> employees = repositoryFileIO.readFromFile(fileName);
		if (employees!=null) {
			this.employees = employees;
		} else {
			//rootLogger.info("Error of creating Repository");	
			throw new NullResultException("Error of creating Repository");
		}	
	}
		
	/**Singleton for Repository.
	 *  * @param fileName - path to txt file, storing Repository data.
	 * Data format: int id;String department;String position;String firstName;String lastName;
	 * int experience;int salary; 
	 * @return Repository object if Repository created or null if Repository can not be created;
	 */
	public static EmployeesRepository getRepository(String fileName) {
		EmployeesRepository tempInstance = instance;
		if (tempInstance==null) {
			synchronized (EmployeesRepository.class) {
				tempInstance = instance;
				if (tempInstance==null) {
					try {
						tempInstance = new EmployeesRepository(fileName);
					} catch (NullResultException e) {
						tempInstance = null;
					}
				}
			}
		}
		return tempInstance;
	}
	
	/**
	 * View Repository.
	 */
	@Override
	public void viewRepository() {
		System.out.println("EmployeesRepository in Repository.");
		for (Employee employee : employees) {
			System.out.println(employee);			
		}
		System.out.println();
	}
	/**
	 * Return list of all Employees in Repository. 
	 * @return List<Employee>
	 */
	@Override
	public List<Employee> getAll() {
		return employees;
	}

	@Override
	public void setAll(List<Employee> employees) {
		this.employees = employees;		
	}

	@Override
	public void deleteByParam(String param, List<String> params) {
		
		
	}
	
	/**
	 * Add Employee to Repository. 
	 */
	@Override
	public void add(Employee employee) {
		employees.add(employee);		
	}

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
	@Override
	public List<Employee> getByParam (String param, List<String> params){
		Logger rootLogger = LogManager.getRootLogger();
		if (params.size()<1) {
			rootLogger.info("Employees not found, illegal parameter");
			return null;
		}
		switch (param) {
		case "salary":
			int min;
			int max;
			try {
				min = Integer.parseInt((String) params.get(0));
				max = Integer.parseInt((String) params.get(1));
			} catch (Exception e) {
				rootLogger.info("min, max parameters  should be integer.  Current min/max is " + params);
				rootLogger.info("Employees not found, illegal parameter");
				return null;
			}
			if (max<min) {
				rootLogger.info("max should be higher than min.  Current min/max is " + min + "/" + max);
				rootLogger.info("Employees not found, illegal parameter");
				return null;
			}
			return getBySalary(min, max);
			
		case "id":
			int id;
			try {
				id = Integer.parseInt((String) params.get(0));			
			} catch (Exception e) {
				rootLogger.info("Employee ID should be integer.  Current ID is " + params);
				rootLogger.info("Employees not found, illegal parameter");
				return null;
			}
			return getByID(id);
			
		case "department":
			String department = params.get(0);
			Departments dpt;
			try {
				 dpt = Departments.getDepartment(department);
			} catch (Exception e) {
				rootLogger.info("Incorrect department.  Current department is " + params);
				rootLogger.info("Employees not found, illegal parameter");
				return null;
			}		
			return getByDepartment(dpt);
			
		default:
			rootLogger.info("Employees not found, illegal parameter");
			return null;
		}		
	}
	
	private List<Employee> getByID(int id) {
		Logger rootLogger = LogManager.getRootLogger();
		List<Employee> getEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getId()==id) {
				getEmployees.add(employee);
			}
		}
		if (getEmployees.size()<1) {
			rootLogger.info("Employees not found. ID not found");
			return null;
		}
		return getEmployees;
	}
	
	private List<Employee> getByDepartment(Departments department) {
		Logger rootLogger = LogManager.getRootLogger();
		List<Employee> getEmployees = new ArrayList<>();
		Class<?> myClass = null; 
		switch (department) {
		case DEVELOPMENT:
			myClass = Developer.class;
			break;
		case MANAGEMENT:
			myClass = Manager.class;
			break;
		case QA:
			myClass = QAEngineer.class;
		break;
		}		
		for (Employee employee : employees) {
			if(employee.getClass().equals(myClass)) {
				getEmployees.add(employee);
			}
		}
		if (getEmployees.size()<1) {
			rootLogger.info("Employees not found. ID not found");
			return null;
		}
		return getEmployees;
	}
	
	private List<Employee> getBySalary(int min, int max) {
		Logger rootLogger = LogManager.getRootLogger();
		List<Employee> getEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			int salary = employee.getSalary();
			if ((salary>min)&&(salary<max)) {
				getEmployees.add(employee);
			}
		}
		if (getEmployees.size()<1) {
			rootLogger.info("Employees not found. ID not found");
			return null;
		}
		return getEmployees;
	}
	
	/**
	 * Method sorts Repository by parameters.
	 * @param params - ArrayList<String> of Parameters, one or two parameters. Sort by: "id", "salary", "department", "experience".
	 */
	//Make parameters ENUM?
	@Override
	public void sortByParam(List<String> params) {
		if (params==null) {
			return;
		}
		switch (params.size()) {
		case 1:
			sortByOneParam(params.get(0));
			break;
		case 2:
			sortByTwoParams(params.get(0), params.get(1));
			break;
		default:
			break;
		}

		
	}

	/**
	 * Method sorts Repository one parameter.
	 * @param param - Sort by: "id", "salary", "department", "experience".
	 */
	private void sortByOneParam(String param) {
		Comparator<Employee> comparator = null;
		switch (param) {
		case "id":
			comparator = Comparator.comparing(Employee::getId);
			break;
		case "salary":
			comparator = Comparator.comparing(Employee::getSalary);
			break;
		case "department":
			comparator = (o1, o2) -> (o1.getClass().getName()).compareTo(o2.getClass().getName());
			break;
		case "experience":
			comparator = Comparator.comparing(Employee::getExperience);
			break;
		default:
			break;
		}
		if (comparator!=null) {
			employees.sort(comparator);
		}		
	}

	/**
	 * Method sorts Repository by two parameters.
	 * @param param1 "salary", "department", "experience".
	 * @param param2 "salary", "department", "experience".
	 */
	private void sortByTwoParams(String param1, String param2) {
		Comparator<Employee> comparator = null;
		switch (param1) {	
		
		case "department":
			comparator = (o1, o2) -> (o1.getClass().getName()).compareTo(o2.getClass().getName());
			switch (param2) {		
			case "salary":
				comparator = comparator.thenComparing(Employee::getSalary);
				break;				
			case "experience":
				comparator = comparator.thenComparing(Employee::getExperience);
				break;	
			default:
				break;
				
			}	
			break;
			
		case "salary":
			comparator = Comparator.comparing(Employee::getSalary);
			switch (param2) {		
			case "experience":	
				comparator = comparator.thenComparing(Employee::getExperience);
				break;
			case "department":		
				Comparator<Employee> comparator1 = (o1, o2) -> (o1.getClass().getName()).compareTo(o2.getClass().getName());
				comparator = comparator.thenComparing(comparator1);
				break;
			default:
				break;
			}	
			break;
			
		case "experience":
			comparator = Comparator.comparing(Employee::getExperience);
			switch (param2) {		
			case "salary":	
				comparator = comparator.thenComparing(Employee::getSalary);
				break;
			case "department":	
				Comparator<Employee> comparator1 = (o1, o2) -> (o1.getClass().getName()).compareTo(o2.getClass().getName());
				comparator = comparator.thenComparing(comparator1);
				break;	
			default:
				break;
			}	
			break;
		}		
		if (comparator!=null) {
			employees.sort(comparator);
		}		
	}






	

}
