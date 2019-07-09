package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.training.edocuments.connection.CookieUtil;

public class LogOutAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.storeLoginedUser(request.getSession(), null);
		String path = JSPEnum.MAIN.getPath();
		request.setAttribute("path", path);
	}

}
