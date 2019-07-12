package by.training.edocuments.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private static Map<String, Action> actions = new HashMap<>();

	static {
		actions.put("/", new ViewMainPageAction());
		actions.put(JSPEnum.MAIN.getPath(), new ViewMainPageAction());
		actions.put(JSPEnum.LOGIN.getPath(), new LoginAction());
		actions.put(JSPEnum.LOGOUT.getPath(), new LogOutAction());
		actions.put(JSPEnum.EMPLOYEE_VIEW_ALL.getPath(), new EmployeeViewAllAction());
		actions.put(JSPEnum.EMPLOYEE_EDIT.getPath(), new EmployeeEditAction());
		actions.put(JSPEnum.EMPLOYEE_SUCCESS_EDIT.getPath(), new MessageAction());
		actions.put(JSPEnum.EMPLOYEE_REGISTRATION_FORM.getPath(), new UserRegistrationAction());
		actions.put(JSPEnum.NOT_AUTH_VIEW.getPath(), new MessageAction());
		
		
		
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
		} else {
			action.setPath(actionStr);
		}
		
		return action;
	}
}
