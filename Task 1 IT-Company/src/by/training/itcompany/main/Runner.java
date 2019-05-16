package by.training.itcompany.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.PRIVATE_MEMBER;

import by.training.itcompany.repository.EmployeesRepository;

public class Runner {
	
	public static void main(String[] args) {
		final Logger rootLogger = LogManager.getRootLogger();
		
		final String FILENAME = ".\\data\\repositoryITCompany.txt";
		//final String FILENAME = ".\\data\\repositoryITCompanyEmpty.txt";
		//final String FILENAME = ".\\data\\incorrectFileName.txt";
		//final String FILENAME = ".\\data\\repositoryITCompanyWrongData.txt";
		
		//Tests
		//final String FILENAME = ".\\data\\test\\sourceRepository.txt";
		
		EmployeesRepository employeesRepository = EmployeesRepository.getRepository(FILENAME);
		if (employeesRepository!=null) {
			TeamCreator teamCreator = new TeamCreator();
			teamCreator.viewMainMenu();
		}
		rootLogger.info("Everything is fine, program finished correctly");
		
		
				
	}
}
