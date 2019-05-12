package by.training.itcompany.models;

import by.training.itcompany.exceptions.IllegalParameterException;

/**
 * Developer class with property projectExperience, extending Employee class with properties
 * id, position, firstName, lastName, experience, salary.
*/

public class Developer extends Employee{
	
	
	/** Number of finished projects*/
	private int projectExperience;

	/**Default constructor*/
	public Developer() {
		// TODO Auto-generated constructor stub
	}
	
	/** Constructor using parameters  
	 * @param id - Unic ID of Employee;
	 * @param position - Position of Developer;
	 * @param firstName - Developer's First name;
	 * @param lastName - Developer's Last name
	 * @param experience - Working experience as Developer (in full years)
	 * @param salary - Salary of Employee (in dollars)
	 * @param projectExperience - Number of Developer's finished projects
	 */
		
	public Developer(Integer id, String position, String firstName, String lastName, int experience, int salary,
			int projectExperience) {
		super(id, position, firstName, lastName, experience, salary);
		this.projectExperience = projectExperience;
	}
	
	

	public int getProjectExperience() {
		return projectExperience;
	}	

	public void setProjectExperience(int projectExperience) throws IllegalParameterException {
	if ((projectExperience < 0)&&(projectExperience > 50))  
		throw new IllegalParameterException("Something wrong with number of projects. Current number of projects is " + projectExperience);
		this.projectExperience = projectExperience;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + projectExperience;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developer other = (Developer) obj;
		if (projectExperience != other.projectExperience)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Developer " + super.toString() + " [projectExperience=" + projectExperience + "]";
	}	
	

}
