package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.util.CookieUtil;


public class LogOutAction extends Action {
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		Employee employee = CookieUtil.getLoginedUser(request.getSession());
		CookieUtil.storeLoginedUser(request.getSession(), null);
		CookieUtil.deleteUserCookie(response);
		path = JSPEnum.MAIN.getPath();
		isRedirect = true;
		LOGGER.info("User login  " + employee);
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
