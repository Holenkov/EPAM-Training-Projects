package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.edocuments.util.CookieUtil;


public class LogOutAction extends Action {

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.storeLoginedUser(request.getSession(), null);
		CookieUtil.deleteUserCookie(response);
		path = JSPEnum.MAIN.getPath();
		isRedirect = true;
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
