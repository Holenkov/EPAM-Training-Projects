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
import by.training.edocuments.connection.SourceTablesStore;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;


public class EmployeeEditAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String employeeID = request.getParameter("employeeID");
	
		String errorString = null;
		Employee employee = new Employee(Integer.parseInt(employeeID));
		System.out.println(employee);
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
		
		String path;
		if (errorString == null) {
			System.out.println(employee);
			request.setAttribute("employee", employee);
			request.setAttribute("emplPositions", emplPositions);
			request.setAttribute("emplStatuses", emplStatuses);
			request.setAttribute("userRoles", userRoles);
			path = JSPEnum.EMPLOYEE_EDIT.getPath();
		
		} else {
			request.setAttribute("errorString", errorString);
			path = JSPEnum.EMPLOYEE_VIEW_ALL.getPath();
		}
		
		request.setAttribute("path", path);


		
		/*response.sendRedirect(request.getServletPath() + "/employees");*/
	}

}
