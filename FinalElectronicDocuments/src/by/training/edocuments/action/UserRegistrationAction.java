package by.training.edocuments.action;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.RoleEnum;
import by.training.edocuments.bean.base.UserRole;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.CryptoUtil;
import by.training.edocuments.util.SourceTablesStore;

public class UserRegistrationAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static final String DEFAULT_AVATAR = "/avatar/default.jpg";

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		path = JSPEnum.EMPLOYEE_REGISTRATION_FORM.getPath();
		isRedirect = false;
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		boolean hasError = false;
		String errorString = null;

		Employee employee = new Employee();
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Part partAvatar = null;

		InputStream avatarStream = null;
		try {
			partAvatar = request.getPart("avatar");
	//		if (partAvatar.getSize() > 0) {
			if (partAvatar != null) {
			
				avatarStream = partAvatar.getInputStream();
			} else {
				String path = request.getServletContext().getRealPath(DEFAULT_AVATAR);  
				File file = new File(path);
				try {
					avatarStream = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					errorString = "Default logo not found";
					LOGGER.error(errorString, e);
					hasError = true;
				}
			}
		} catch (IOException | ServletException e1) {
			errorString = "Default logo file not found";
			LOGGER.error(errorString, e1);
			hasError = true;
		}

		employee.setEmail(email);

		EmployeeServiceImpl service = new EmployeeServiceImpl();
		try {
			employee = service.findByEmail(employee);
		} catch (DBOperationException e) {
			errorString = e.getMessage();
			LOGGER.error(errorString, e);
			hasError = true;
		}
		if (employee != null) {
			errorString = "This email already exists";
			hasError = true;
		}

		employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		SourceTablesStore store = SourceTablesStore.getStore();
		employee.setEmployeeStatus(store.returnEmployeeStatus(SourceTablesStore.getNOT_ACTIVE_STATUS()));
		employee.setPosition(store.returnEmployeePosition(SourceTablesStore.getSTART_POSITION()));
		employee.setRole(new UserRole(RoleEnum.NO_PERMISSIONS));
		employee.setAvatar(avatarStream);

		CryptoUtil cryptoUtil = null;
		if (!hasError) {
			try {
				cryptoUtil = new CryptoUtil();
			} catch (Exception e) {
				errorString = "Crypto Util error";
				LOGGER.error(errorString, e);
				hasError = true;
			}
		}

		if (!hasError) {
			employee.setPassword(cryptoUtil.encrypt(password1));
			try {
				service.add(employee);
			} catch (DBOperationException e) {
				errorString = e.getMessage();
				LOGGER.error(errorString, e);
				hasError = true;
			}
		}

		if (!hasError) {
			path = JSPEnum.EMPLOYEE_COMLETE_REGISTRATION.getPath();
			isRedirect = true;
			LOGGER.info("Employee registered  " + employee);
		} else {
			employee.setPassword(password1);
			request.setAttribute("tempEmployee", employee);
			isRedirect = false;
			path = JSPEnum.EMPLOYEE_REGISTRATION_FORM.getPath();
			request.setAttribute("errorString", errorString);
		}

	}


}
