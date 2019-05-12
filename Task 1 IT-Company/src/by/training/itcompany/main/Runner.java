package by.training.itcompany.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exceptions.NullResultException;
import by.training.itcompany.models.Employee;
import by.training.itcompany.repository.EmployeesRepository;

public class Runner {
	public static void main(String[] args) {
		final Logger rootLogger = LogManager.getRootLogger();
		
		
		final String FILENAME = ".\\data\\repositoryITCompany.txt";		
		EmployeesRepository employeesRepository = EmployeesRepository.getRepository(FILENAME);
		if (employeesRepository!=null) {
			TeamCreator teamCreator = new TeamCreator();
			teamCreator.createTeam(employeesRepository);
		}
		
		
		/*employeesRepository.viewRepository();
		employeesRepository.sortByParam(new ArrayList<>(Arrays.asList("experience", "department")));
		System.out.println();
		employeesRepository.viewRepository();
		List<Employee> employees = null;
		employees = employeesRepository.getByParam("departments", new ArrayList<String>(Arrays.asList("Development")));
		
		if (employees!=null) {
			System.out.println("------------Employees--------------");
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	*/
		
				
				
	}
}
