package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageAction extends Action{

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		isRedirect = false;
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
	}
	
	

}
