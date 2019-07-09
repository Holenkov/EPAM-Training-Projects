package by.training.edocuments.action;

public enum JSPEnum {
	MAIN("/WEB-INF/jsp/main.jsp"),
	LOGIN(""),
	PAGE_NOT_FOUND("/WEB-INF/jsp/page_not_found.jsp"),
	EMPLOYEE_VIEW_ALL("/WEB-INF/jsp/employee/viewAll.jsp"),
	EMPLOYEE_ADD(""),
	EMPLOYEE_EDIT("/WEB-INF/jsp/employee/edit.jsp");
	
	private String path;

	private JSPEnum(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
