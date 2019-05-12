package by.training.itcompany.main;

import by.training.itcompany.repository.EmployeesRepository;

public class Runner {
	public static void main(String[] args) {
		
		
		//Empty file
		//final String FILENAME = ".\\data\\repositoryITCompanyEmpty.txt";
		final String FILENAME = ".\\data\\repositoryITCompany.txt";
		
		EmployeesRepository employeesRepository = EmployeesRepository.getRepository(FILENAME);
		if (employeesRepository!=null) {
			TeamCreator teamCreator = new TeamCreator();
			teamCreator.createTeam(employeesRepository);
		}
				
				
	}
}
