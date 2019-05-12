package by.training.itcompany.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.factories.EmployeeMaker;
import by.training.itcompany.models.Employee;
import by.training.itcompany.repository.EmployeesRepository;

/**
 *Public Util class for working with text file.
 */

public class RepositoryFileIO {
	/**
	 *  Constructor for Util class.
	 */
	public RepositoryFileIO() {
		
	}
	
	
	/**
	 *Static method read information from file
	 *and returns ArrayList of Employees.
	 *@param fileName - path to file;
	 *@return ArrayList<Employee>
	 */
	public List<Employee> readFromFile(final String fileName) {
		final Logger rootLogger = LogManager.getRootLogger();
		
		File file = new File(fileName);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			rootLogger.info("Repository file not found");	
			return null;
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<List<String>> stringEmployees = new ArrayList<>();
		List<String> employee = null;
		try {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				employee = new ArrayList<>(Arrays.asList(line.split(";")));
				stringEmployees.add(employee);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Employee> objEmployees = new ArrayList<>();
		EmployeeMaker employeeFactory = new EmployeeMaker();
		if (stringEmployees.size()>0) {
			for (List<String> empl : stringEmployees) {
				if (empl.size()>0) {
					Employee objEmployee = employeeFactory.createEmployee(empl);
					if (objEmployee != null) {
						objEmployees.add(objEmployee);
					}
			
				}
			}
		}/* else {
			System.out.println("Repository null");
			return null;
		}*/
		
		return objEmployees;
	}
	
	

	/**
	 *Static method write information to file.
	 *@param fileName - path to file;
	 *@return ArrayList<Employee>
	 */
	public void saveToFile(List<Employee> employees, String fileName) {
		final Logger rootLogger = LogManager.getRootLogger();
		File file = new File(fileName);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Employee empl: employees) {
			rootLogger.info(empl);
		}
		
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
}
