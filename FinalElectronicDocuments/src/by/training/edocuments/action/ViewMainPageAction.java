package by.training.edocuments.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewMainPageAction extends Action{


	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		path = JSPEnum.MAIN.getPath();
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	

}
