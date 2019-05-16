package by.training.itcompany.repository;

	/**
	 * Non-singletone class for creating test Repository.
	 */

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.apache.logging.log4j.core.util.Throwables;

	import by.training.itcompany.exception.NullResultException;
	import by.training.itcompany.model.Departments;
	import by.training.itcompany.model.Developer;
	import by.training.itcompany.model.Employee;
	import by.training.itcompany.model.Manager;
	import by.training.itcompany.model.QAEngineer;
	import by.training.itcompany.reader.RepositoryReader;

	public class EmployeesRepositoryForTest implements Repository{
		private List<Employee> employees;
		final Logger rootLogger = LogManager.getRootLogger();

		/** 
		 * Public constructor.
		 * @param fileName - path to txt file, storing Repository data.
		 */	
		public EmployeesRepositoryForTest(String fileName) throws NullResultException {
		
			RepositoryReader repositoryReader = new RepositoryReader();
			List<Employee> employees = repositoryReader.readFromFile(fileName);
			if (employees!=null) {
				this.employees = employees;
			} else {
				throw new NullResultException("Error of creating Repository");
			}	
		}
			
				
		/**
		 * View Repository.
		 */
		@Override
		public void viewRepository() {
			if (employees.size() != 0) {
				System.out.println("Employees in Repository.");
				for (Employee employee : employees) {
					System.out.println(employee);			
				}
			} else {
				System.out.println("Repositoty is Empty");
			}
			System.out.println();
		}
		
		public List<Employee> returnAll() {
			List<Employee> retEmployees = new ArrayList<>();
			for (Employee employee : employees) {
				retEmployees.add(employee);
			}
			return retEmployees;
		}
		
		

		@Override
		public void deleteByParam(String param, List<String> params) {
		}
		
		@Override
		public void add(Employee employee) {
		}

		@Override
		public List<Employee> findByParam (String param, List<String> params){
				return null; 
		}
		
		@Override
		public void sortByParam(List<String> params) {
		}	


	}
