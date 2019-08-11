package by.training.edocuments.action;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.util.UTF8Control;

public class ChangeLanguageAction extends Action{
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	
	
	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String currentLanguage = request.getParameter("language");
		if (currentLanguage != null){
			String country = "";
			String language = "";
			switch (currentLanguage) {
			case "EN":
				country = "US";
				language = "EN";
				break;
			case "RU":
				country = "RU";
				language = "RU";
				break;
			case "SP":
				country = "ME";
				language = "SP";
				break;
			}
			Locale current = new Locale(language, country);
			ResourceBundle rb = ResourceBundle.getBundle("text", current, new UTF8Control());
			HttpSession session = request.getSession();
			session.setAttribute("langBundle", rb);
		} else {
			errorString = "Language not choosen";
		}
		path = JSPEnum.MAIN.getPath();
		isRedirect = false;
		request.setAttribute("errorString", errorString);		
	}
	
	
	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	

}
