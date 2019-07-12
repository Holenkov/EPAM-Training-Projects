package by.training.edocuments.action;

public enum JSPEnum {
	MAIN("/main"),
	LOGIN("/login"),
	LOGOUT("/logout"),
	PAGE_NOT_FOUND("/page_not_found"),
	NOT_AUTH_VIEW("/notAuthView"),
	EMPLOYEE_VIEW_ALL("/employee/viewAll"),
	EMPLOYEE_ADD(""),
	EMPLOYEE_EDIT("/employee/edit"),
	EMPLOYEE_SUCCESS_ADD("/employee/successAdd"),
	EMPLOYEE_SUCCESS_EDIT("/employee/successEdit"),
	EMPLOYEE_REGISTRATION_FORM("/employee/registration"),
	;
	
	private String path;

	private JSPEnum(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
