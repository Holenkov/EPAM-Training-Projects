package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.bean.base.RoleEnum;
import by.training.edocuments.bean.base.UserRole;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.SourceTablesStore;


public class EmployeeEditAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String employeeID = request.getParameter("employeeID");
	
		String errorString = null;
		Employee employee = new Employee(Integer.parseInt(employeeID));
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		try {
			employee = service.findByID(employee);
		} catch (DBOperationException e) {
			LOGGER.error(e.getMessage(), e);
			errorString = e.getMessage();
		}
		
		List<EmployeePosition> emplPositions = SourceTablesStore.getStore().returnEmployeePositions();
		List<EmployeeStatus> emplStatuses = SourceTablesStore.getStore().returnEmployeeStatuses();
		List<RoleEnum> userRoles = RoleEnum.getRoles();
		
		isRedirect = false;
		if (errorString == null) {
			request.setAttribute("employee", employee);
			request.setAttribute("emplPositions", emplPositions);
			request.setAttribute("emplStatuses", emplStatuses);
			request.setAttribute("userRoles", userRoles);
			path = JSPEnum.EMPLOYEE_EDIT.getPath();
		
		} else {
			request.setAttribute("errorString", errorString);
			path = JSPEnum.EMPLOYEE_VIEW_ALL.getPath();
		}

		
		/*response.sendRedirect(request.getServletPath() + "/employees");*/
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		boolean hasError = false;
		String errorString = null;
		
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		int positionID = Integer.parseInt(request.getParameter("employeePosition"));
		int roleID = Integer.parseInt(request.getParameter("employeeRole"));
		int statusID = Integer.parseInt(request.getParameter("employeeStatus"));
		Employee employee = new Employee(employeeID);
		
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		try {
			employee = service.findByID(employee);
		} catch (DBOperationException e) {
			LOGGER.error(e.getMessage(), e);
			hasError = true;
			errorString = e.getMessage();
		}
		if (employee != null) {
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setPosition(SourceTablesStore.getStore().returnEmployeePosition(positionID));
			employee.setRole(new UserRole(RoleEnum.getRole(roleID)));
			employee.setEmployeeStatus(SourceTablesStore.getStore().returnEmployeeStatus(statusID));
			
			try {
				service.update(employee);
			} catch (DBOperationException e) {
				LOGGER.error(e.getMessage(), e);
				hasError = true;
				errorString = e.getMessage();
			}
			path = JSPEnum.EMPLOYEE_SUCCESS_EDIT.getPath();
			isRedirect = true;
			LOGGER.info("User edited  " + employee.getEmployeeID());
		} else {
			hasError = true;
			isRedirect = false;
			errorString = "Employee null";
			path = JSPEnum.EMPLOYEE_EDIT.getPath();			
		}
		request.setAttribute("errorString", errorString);
		
	}

}
