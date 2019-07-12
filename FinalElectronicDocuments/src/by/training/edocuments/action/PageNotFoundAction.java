package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageNotFoundAction extends Action{
	

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		path = JSPEnum.PAGE_NOT_FOUND.getPath();
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	

}
