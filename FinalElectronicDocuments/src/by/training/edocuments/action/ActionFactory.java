package by.training.edocuments.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private static Map<String, Action> actions = new HashMap<>();

	static {
		actions.put("/", new ViewMainPageAction());
		actions.put("/main", new ViewMainPageAction());
		actions.put("/login", new LoginAction());
		actions.put("/logout", new LogOutAction());
		actions.put("/employee/viewAll", new EmployeeViewAllAction());
		actions.put("/employee/edit", new EmployeeEditAction());
	}

	public Action createAction(HttpServletRequest request) {
		Action action = null;
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		int begin = contextPath.length();
		int end = uri.lastIndexOf('.');
		String actionStr = null;
		if(end >= 0) {
			actionStr = uri.substring(begin, end);
		} else {
			actionStr = uri.substring(begin);
		}
		action = actions.get(actionStr);
		if (action == null) {
			action = new PageNotFoundAction();
		}
		
		return action;
	}
}
