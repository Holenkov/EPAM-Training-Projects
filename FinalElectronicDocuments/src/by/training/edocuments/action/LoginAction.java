package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.CookieUtil;
import by.training.edocuments.util.CryptoUtil;
import by.training.edocuments.util.SourceTablesStore;

public class LoginAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMe);

		Employee employee = new Employee(email);
		boolean hasError = false;
		String errorString = null;
		CryptoUtil cryptoUtil = null;
		
		try {
			cryptoUtil = new CryptoUtil();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hasError = true;
			errorString = e.getMessage();
		}
		
		if (!hasError) {
			try {
				SourceTablesStore store = SourceTablesStore.getStore();
				EmployeeStatus notActive = store.returnEmployeeStatus(4);

				EmployeeServiceImpl service = new EmployeeServiceImpl();
				employee = service.findByEmail(employee);
				password = cryptoUtil.encrypt(request.getParameter("password"));
				if ((employee == null) || (!employee.getPassword().equals(password))) {
					hasError = true;
					errorString = "User Name or password invalid";
				} else if (employee.getEmployeeStatus().equals(notActive)) {
					hasError = true;
					errorString = "User inactive, complete registration, please.";
				}
			} catch (DBOperationException e) {
				LOGGER.error(e.getMessage(), e);
				hasError = true;
				errorString = e.getMessage();
			}
		}
	

		if (hasError) {
			request.setAttribute("errorString", errorString);
		} else {
			isRedirect = true;
			HttpSession session = request.getSession();
			CookieUtil.storeLoginedUser(session, employee);
			LOGGER.info("User login  " + employee.getEmail());
			if (remember) {
				CookieUtil.storeUserCookie(response, employee);
			} else {
				CookieUtil.deleteUserCookie(response);
			}

		}
		path = JSPEnum.MAIN.getPath();
	}
}
