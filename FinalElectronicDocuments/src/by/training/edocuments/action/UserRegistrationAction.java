package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.connection.CryptoUtil;

public class UserRegistrationAction extends Action{

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		path = JSPEnum.EMPLOYEE_REGISTRATION_FORM.getPath();
		isRedirect = false;
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		CryptoUtil cryptoUtils = null;
		try {
			cryptoUtils = new CryptoUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Employee employee = new Employee();
		String email = (String) request.getParameter("email");
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String password1 = (String) request.getParameter("password1");
		String password2 = (String) request.getParameter("password2");

		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);

		boolean hasError = false;
		String errorString = null;


	}

}
