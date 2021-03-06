/**
 * Abstract class Employee with properties
 * id, position, firstName, lastName, experience, salary.
*/

package by.training.itcompany.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.itcompany.exception.IllegalParameterException;


public abstract class Employee {
	final int MIN_EXPERIENCE = 0;
	final int MAX_EXPERIENCE = 50;
	final int MIN_SALARY = 0;
	final int MAX_SALARY = 5000;
	
	
	/** Employee ID */
	private int id;
	/**Position of Employee */
	private String position;
	/**First name of Employee */
	private String firstName;
	/**Last name of Employee */
	private String lastName;
	/**Working experience of Employee (in full years)*/
	private int experience;
	/**Salary of Employee (in dollars)*/
	private int salary;
	
	public Employee() {
	}

	public Employee(int id, String position, String firstName, String lastName, int experience, int salary) {
		super();
		this.id = id;
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.salary = salary;
	}



	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public void setExperience(int experience) throws IllegalParameterException {
		if ((experience < MIN_EXPERIENCE)||(experience > MAX_EXPERIENCE)){ 
			throw new IllegalParameterException("Something wrong with experience value. Current experience is " + experience);
		}
		this.experience = experience;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) throws IllegalParameterException {
		if ((salary < MIN_SALARY)||(salary > MAX_SALARY)){
			throw new IllegalParameterException("Something wrong with salary value. Current salary is " + salary);
		}
		this.salary = salary;
	}

	public int getId() {
		return id;
	}


	public void setId (int id) throws IllegalParameterException {
		if (id < 0) {
			throw new IllegalParameterException("Employee ID should be positive integer. Current ID is " + id);
		}
		this.id = id;	
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + experience;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (experience != other.experience)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", position=" + position + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", experience=" + experience + ", salary=" + salary + "]";
	}



	
	

}
