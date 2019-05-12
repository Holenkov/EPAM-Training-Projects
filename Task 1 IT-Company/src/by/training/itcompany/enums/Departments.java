package by.training.itcompany.enums;
/**
 *
 * Enumeration for Departments.
 *
 */

public enum Departments {
	DEVELOPMENT ("Development"),
	MANAGEMENT ("Management"),
	QA ("QA Department");

	/**
	 * Name of Department.
	 */
	private String department;

	/**
	 * Private Constructor.
	 * @param department : "Development", "Management", "QA Department".
	 */
	Departments(final String department) {
		this.department = department;
	}

	/**
	 * Getter for Enum values.
	 * @return Enum value
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Getter for Enums.
	 * @param department value of Enum.
	 * @return first Enum by its Value.
	 */
	public static Departments getDepartment(final String department) {
		for (Departments dep : Departments.values()) {
			if (department.equals(dep.getDepartment())) {
				return dep;
			}
		}
		return null;
	}

}
