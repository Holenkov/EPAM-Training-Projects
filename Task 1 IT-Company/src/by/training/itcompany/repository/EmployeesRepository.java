/**
 * Repository for Employee class objects 
 * with private field List<Employee> employees.
 */

package by.training.itcompany.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Throwables;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.exception.NullResultException;
import by.training.itcompany.model.Departments;
import by.training.itcompany.model.Developer;
import by.training.itcompany.model.Employee;
import by.training.itcompany.model.Manager;
import by.training.itcompany.model.QAEngineer;
import by.training.itcompany.reader.RepositoryReader;

public class EmployeesRepository implements Repository{
	private static EmployeesRepository instance = null;
	private List<Employee> employees;
	private int maxID;
	private final Logger rootLogger = LogManager.getRootLogger();
	private final Logger logger = LogManager.getLogger(EmployeesRepository.class);

	/** 
	 * Private constructor.
	 * @param fileName - path to txt file, storing Repository data.
	 */	
	private EmployeesRepository(String fileName) throws NullResultException {
	
		RepositoryReader repositoryReader = new RepositoryReader();
		List<Employee> employees = repositoryReader.readFromFile(fileName);
			this.employees = employees;
			setMaxId();
	}
		
	/**Singleton for Repository.
	 *  * @param fileName - path to txt file, storing Repository data.
	 * Data format: int id;String department;String position;String firstName;String lastName;
	 * int experience;int salary; 
	 * @return Repository object if Repository created or null if Repository can not be created;
	 */
	public static EmployeesRepository getRepository(String fileName) {
		if (instance == null) {
			try {
				instance = new EmployeesRepository(fileName);
			} catch (NullResultException e) {
				e.printStackTrace();
				instance = null;
			}
		}
	return instance;
	}
	
	public static EmployeesRepository getRepository() {
		return instance;
	}
	
	private void setMaxId() {
		int id = 1;
		for (Employee employee : employees) {
			int temtID = employee.getId();
			if (temtID > id) {
				id = temtID;
			}
		}
		maxID = id;
	}
	
	
	/**
	 * View Repository.
	 */
	@Override
	public void viewRepository() {
		if (employees.size() != 0) {
			logger.info("Employees in Repository.");
			for (Employee employee : employees) {
				System.out.println(employee);			
			}
		} else {
			logger.info("Repositoty is Empty");
		}
		logger.info("");
	}
	
	
	/**
	 * Method for testing only.
	 * @return
	 */
	public List<Employee> returnAll() {
		List<Employee> retEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			retEmployees.add(employee);
		}
		return retEmployees;
	}
	

	@Override
	public void deleteByParam(String param, List<String> params) {
		findByParam(param, params);
		
	}
	
	public void deleteByID(int id) {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId()==id) {
				employees.remove(i);
			}
		}
		
	}
	

	
	
	/**
	 * Add Employee to Repository. 
	 */
	@Override
	public void add(Employee employee) {
		try {
			employee.setId(maxID+1);
			employees.add(employee);
			maxID++;
		} catch (IllegalParameterException e) {			
			e.printStackTrace();
		}
	
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
	public List<Employee> findByParam (String param, List<String> params){
		List<Employee> employees = new ArrayList<>();
		if (params.size()<1) {
			rootLogger.info("Employees not found, illegal parameter");
			return employees;
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
				return employees;
			}
			if (max<min) {
				rootLogger.info("max should be higher than min.  Current min/max is " + min + "/" + max);
				rootLogger.info("Employees not found, illegal parameter");
				return employees;
			}
			employees = findBySalary(min, max);
			break;			
			
		case "id":
			int id;
			try {
				id = Integer.parseInt((String) params.get(0));			
			} catch (Exception e) {
				rootLogger.info("Employee ID should be integer.  Current ID is " + params);
				rootLogger.info("Employees not found, illegal parameter");
				return employees;
			}
			employees = findByID(id);
			break;
			
		case "department":
			String department = params.get(0);
			Departments dpt;
			try {
				 dpt = Departments.getDepartment(department);
			} catch (Exception e) {
				rootLogger.info("Incorrect department.  Current department is " + params);
				rootLogger.info("Employees not found, illegal parameter");
				return employees;
			}		
			employees = findByDepartment(dpt);
			break;
		}	
		if (employees.size()==0) {
			rootLogger.info("Employees not found");
		}
		return employees;
	}
	
	private List<Employee> findByID(int id) {
		List<Employee> getEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getId()==id) {
				getEmployees.add(employee);
			}
		}
		return getEmployees;
	}
	
	private List<Employee> findByDepartment(Departments department) {
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
		return getEmployees;
	}
	
	private List<Employee> findBySalary(int min, int max) {
		List<Employee> getEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			int salary = employee.getSalary();
			if ((salary>min)&&(salary<max)) {
				getEmployees.add(employee);
			}
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
		int size = params.size();
		if ((params==null)||(size==0)) {
			return;
		}
		Comparator<Employee> comparator;
		comparator = returnComparator(params.get(0));
		if (size > 1) {
			for (int i=1; i<=size-1; i++) {
				comparator = comparator.thenComparing(returnComparator(params.get(i)));
			}
		}		
		if (comparator!=null) {
			employees.sort(comparator);
		}			
	}	

	private Comparator<Employee> returnComparator (String param) {
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
		return comparator;
	}
	

}
