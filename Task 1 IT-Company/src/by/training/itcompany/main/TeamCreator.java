package by.training.itcompany.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import by.training.itcompany.models.Employee;
import by.training.itcompany.repository.Repository;

public class TeamCreator {
	private List<Employee> team;

	public void createTeam(Repository repository) {
		Scanner scanner;
		team = new ArrayList<>();		
		int menu = -1;
		do {
			System.out.println("1: View Repository   2: View Team   0: Exit");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
			case 1:
				viewRepository(repository);
				break;
			case 2:
				viewTeam();
				break;
			case 0:
				System.out.println("Good bye!!!");
			default:
				System.out.println("Incorrect number.");
				break;
			}
			
			
		} while (menu != 0);
		scanner.close();
	}
	
	private void viewRepository(Repository repository) {
		Scanner scanner;
		int menu = -1;
		do {
			System.out.println(
					"1: View Repository   2: Sort by ID   3: Sort by Salary   4: Sort by Department   5: Add to Team   0: Back");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
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
				System.out.println("Enter ID");
				String id = scanner.next();
				//int id = scanner.nextInt();
				List<Employee> employees = repository.getByParam("id", new ArrayList<String>(Arrays.asList(id)));
				if (employees!=null) {
					team.add(employees.get(0));		
				}
				break;
			default:
				break;
			}
		} while (menu != 0);
	}
	
	private void viewTeam() {
		if (team.size()>0) {
			System.out.println("Your team cost is " + teamCost());
			for (Employee employee : team) {
				System.out.println(employee);
			}
		} else {
			System.out.println("Your team is empty");
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
