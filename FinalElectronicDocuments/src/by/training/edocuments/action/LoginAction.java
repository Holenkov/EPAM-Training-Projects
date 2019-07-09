package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.connection.CookieUtil;
import by.training.edocuments.connection.SourceTablesStore;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;

public class LoginAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMe);

		Employee employee = new Employee(email);
		boolean hasError = false;
		String errorString = null;

		if (email == null || email.length() == 0) {
			hasError = true;
			errorString = "Required username!";
		} else if (password == null || password.length() == 0) {
			hasError = true;
			errorString = "Required password!";
		} else {

			try {
				SourceTablesStore store = SourceTablesStore.getStore();
				EmployeeStatus notActive = store.returnEmployeeStatus(4);

				EmployeeServiceImpl service = new EmployeeServiceImpl();
				employee = service.findByEmail(employee);
				// password = cryptoUtils.encrypt(request.getParameter("password"));
				if ((employee == null) || (!employee.getPassword().equals(password))) {
					hasError = true;
					errorString = "User Name or password invalid";
				} else if (employee.getEmployeeStatus().equals(notActive)) {
					hasError = true;
					errorString = "User inactive";
				}
			} catch (DBOperationException e) {
				LOGGER.error(e.getMessage(), e);
				request.setAttribute("errorString", e.getMessage());
				hasError = true;
				errorString = e.getMessage();
			}
		}

		if (hasError) {
			request.setAttribute("errorString", errorString);

		} else {
			HttpSession session = request.getSession();
			CookieUtil.storeLoginedUser(session, employee);
			if (remember) {
				CookieUtil.storeUserCookie(response, employee);
			} else {
				CookieUtil.deleteUserCookie(response);
			}
			
		}
		String path = JSPEnum.MAIN.getPath();
		request.setAttribute("path", path);

	}
}
