package by.training.edocuments.bean;


import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.UserRole;

public class Employee extends BaseEntity{
	
/*	employeeID
pic
email
password
firstName
lastName
position
role
employeeStatus*/
	
	private int employeeID;
	private String email;
	private String password;
	private String firstName;
	private String lastName;	
	private EmployeePosition position;
	private UserRole role;
	private EmployeeStatus employeeStatus;
	
	public Employee() {	
	}

	public Employee(int employeeID, String email, String password, String firstName, String lastName, EmployeePosition position,
			UserRole role, EmployeeStatus employeeStatus) {
		super();
		this.employeeID = employeeID;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.role = role;
		this.employeeStatus = employeeStatus;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public EmployeePosition getPosition() {
		return position;
	}

	public void setPosition(EmployeePosition position) {
		this.position = position;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", position=" + position + ", role=" + role
				+ ", employeeStatus=" + employeeStatus + "]";
	}	
	
	


}
