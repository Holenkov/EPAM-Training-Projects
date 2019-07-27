package by.training.edocuments.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;

public class EmployeeViewAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String employeeID = request.getParameter("employeeID");
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		Employee employee = new Employee(Integer.parseInt(employeeID));
		
		try {
			employee = service.findByID(employee);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString , e);
		}
		isRedirect = false;
		if (errorString == null) {
			InputStream avatarStream = employee.getAvatar();
			byte[] imageData = null;
			try {
				imageData = new byte[avatarStream.available()];
				avatarStream.read(imageData);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String encode = Base64.getEncoder().encodeToString(imageData);
		    request.setAttribute("avatar", encode);
		
			request.setAttribute("employee", employee);
			path = JSPEnum.EMPLOYEE_VIEW.getPath();
		} else {
			path = JSPEnum.MAIN.getPath();
			request.setAttribute("errorString", errorString);
		}
	}
	
	/*  byte[] imgData = rs.getBytes("img"); // blob field 
      request.setAttribute("rvi", "Ravinath");
      rs.getString("teatitle");

      String encode = Base64.getEncoder().encodeToString(imgData);
      request.setAttribute("imgBase", encode);*/

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
