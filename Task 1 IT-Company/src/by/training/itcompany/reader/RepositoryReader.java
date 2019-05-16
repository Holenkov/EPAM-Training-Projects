package by.training.itcompany.reader;
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

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.exception.NullResultException;
import by.training.itcompany.factory.EmployeeMaker;
import by.training.itcompany.model.Employee;
import by.training.itcompany.repository.EmployeesRepository;

/**
 *Public Util class for working with text file.
 */

public class RepositoryReader {
	private final Logger rootLogger = LogManager.getRootLogger();
	/**
	 *  Constructor for Util class.
	 */
	public RepositoryReader() {
		
	}
	
	
	/**
	 *Static method read information from file
	 *and returns ArrayList of Employees.
	 *@param fileName - path to file;
	 *@return ArrayList<Employee>
	 */
	public List<Employee> readFromFile (final String fileName) throws NullResultException {
		File file = new File(fileName);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			rootLogger.error("Repository file not found", e);	
			throw new NullResultException("Repository file not found", e);
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
			rootLogger.error("Error reading from Repository file", e);	
		}
		List<Employee> objEmployees = new ArrayList<>();
		EmployeeMaker employeeMaker = new EmployeeMaker();
		if (stringEmployees.size()>0) {
			for (List<String> empl : stringEmployees) {
					Employee objEmployee;
					try {
						objEmployee = employeeMaker.createEmployee(empl);
						objEmployees.add(objEmployee);
					} catch (IllegalParameterException e) {
						rootLogger.error(e);	
					}
			}
		} else {
			throw new NullResultException("Repository file is empty");
		}
		if (objEmployees.size()>0) {
			return objEmployees;			
		} else {
			throw new NullResultException("Repository file contains incorrect data");
		}
		
		
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
