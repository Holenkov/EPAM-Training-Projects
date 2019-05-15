package by.training.itcompany.model;

import by.training.itcompany.exception.IllegalParameterException;

/**
 * Manager class with property someTextField, extending Employee class with properties
 * id, position, firstName, lastName, experience, salary.
*/

public class Manager extends Employee{
	String someTextField;

	/**Default constructor*/
	public Manager() {
	}

	/** Constructor using parameters  
	 * @param id - Unic ID of Employee;
	 * @param position - Position of Developer;
	 * @param firstName - Developer's First name;
	 * @param lastName - Developer's Last name
	 * @param experience - Working experience as Developer (in full years)
	 * @param salary - Salary of Employee (in dollars)
	 * @param someTextField - Enter some text here
	 */
	public Manager(Integer id, String position, String firstName, String lastName, int experience, int salary,
			String someTextField) {
		super(id, position, firstName, lastName, experience, salary);
		this.someTextField = someTextField;
	}

	public String getSomeTextField() {
		return someTextField;
		
	}

	public void setSomeTextField(String someTextField) {
		this.someTextField = someTextField;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((someTextField == null) ? 0 : someTextField.hashCode());
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
		Manager other = (Manager) obj;
		if (someTextField == null) {
			if (other.someTextField != null)
				return false;
		} else if (!someTextField.equals(other.someTextField))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager " + super.toString() + " [someTextField=" + someTextField + "]";
	};
	

	
	
}
