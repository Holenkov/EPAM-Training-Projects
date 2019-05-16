package by.training.itcompany.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.model.Employee;
import by.training.itcompany.repository.EmployeesRepository;
import by.training.itcompany.repository.Repository;

/**
 * 
 * Simple Console-based application with methods for view and sort Repository and create Team.
 * Just for test project.  
 *
 */

public class TeamCreator {
	private List<Employee> team;
	private final Logger logger = LogManager.getLogger(TeamCreator.class);

	public void viewMainMenu() {
		Scanner scanner;
		team = new ArrayList<>();		
		int menu = -1;
		do {
			logger.info("1: View Repository   2: View Team  0: Exit");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				logger.info("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
			case -1:
				break;
			case 1:
				viewRepositoryMenu();
				break;
			case 2:
				viewTeam();
				break;
			case 0:
				logger.info("Good bye!!!");
				break;
			default:
				logger.info("Incorrect number.");
				break;
			}
			
			
		} while (menu != 0);
		scanner.close();
	}
	
	private void viewRepositoryMenu() {
		Repository repository = EmployeesRepository.getRepository();
		Scanner scanner;
		int menu = -1;
		do {
			logger.info(
					"1: View Repository  2: Sort by ID   3: Sort by Salary   4: Sort by Department  5: Sort by Department and salary 6: Add to Team   0: Back");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				logger.info("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
			case -1:
				break;
			case 1:
				repository.viewRepository();
				break;
			case 2:
				repository.sortByParam(new ArrayList<>(Arrays.asList("id")));
				repository.viewRepository();
				break;
			case 3:
				repository.sortByParam(new ArrayList<>(Arrays.asList("salary")));
				repository.viewRepository();
				break;
			case 4:
				repository.sortByParam(new ArrayList<>(Arrays.asList("department")));
				repository.viewRepository();
				break;
			case 5:
				repository.sortByParam(new ArrayList<>(Arrays.asList("department", "salary")));
				repository.viewRepository();
				break;
			case 6:
				logger.info("Enter ID");
				String id = scanner.next();
				List<Employee> employees = repository.findByParam("id", new ArrayList<String>(Arrays.asList(id)));
				if (employees.size()!=0) {
					team.add(employees.get(0));		
				}
				break;
			default:
				logger.info("Incorrect number.");
				break;
			}
		} while (menu != 0);
	}
	
	private void viewTeam() {
		if (team.size()>0) {
			logger.info("Your team cost is " + teamCost());
			for (Employee employee : team) {
				logger.info(employee);
			}
		} else {
			logger.info("Your team is empty");
		}
	}
	
	private int teamCost() {
		int cost = 0;
		for (Employee employee : team) {
			cost = cost + employee.getSalary();
		}
		return cost;
	}
 	
	

}
