package by.training.itcompany.model;

import by.training.itcompany.exception.IllegalParameterException;

/**
 * QAEngineer class with property automatedTesting, extending Employee class with properties
 * id, position, firstName, lastName, experience, salary.
*/
public class QAEngineer extends Employee{
	boolean automatedTesting;
	

	/**Default constructor*/
	public QAEngineer() {
	}

	/** Constructor using parameters  
	 * @param id - Unic ID of Employee;
	 * @param position - Position of Developer;
	 * @param firstName - Developer's First name;
	 * @param lastName - Developer's Last name
	 * @param experience - Working experience as Developer (in full years)
	 * @param salary - Salary of Employee (in dollars)
	 * @param automatedTesting - Is QA Engineer use automated testing, true/false.
	 */
	public QAEngineer(int id, String position, String firstName, String lastName, int experience, int salary, boolean automatedTesting) {
		super(id, position, firstName, lastName, experience, salary);
		this.automatedTesting = automatedTesting;
	}

	public boolean isAutoTesting() {
		return automatedTesting;
	}

	public void setAutoTesting(boolean autoTesting) {
		this.automatedTesting=autoTesting;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (automatedTesting ? 1231 : 1237);
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
		QAEngineer other = (QAEngineer) obj;
		if (automatedTesting != other.automatedTesting)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QAEngineer " + super.toString() + " [automatedTesting=" + automatedTesting + "]";
	}
	
	
	
}
