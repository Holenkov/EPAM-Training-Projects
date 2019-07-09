package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageNotFoundAction extends Action{
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = JSPEnum.PAGE_NOT_FOUND.getPath();
		request.setAttribute("path", path);
	}
	
	

}
