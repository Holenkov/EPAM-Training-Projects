package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewMainPageAction extends Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = JSPEnum.MAIN.getPath();
		request.setAttribute("path", path);
	}
	
	

}
