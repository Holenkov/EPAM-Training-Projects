package by.training.edocuments.action;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class RequestContainer {
	private HashMap<String, Object> requestAttributes;
	private HashMap<String, String[]> requestParameters;
	private HashMap<String, Object> sessionAttributes;

	
	
	public void extractValues(HttpServletRequest request) {
		Enumeration  attributeNames = request.getAttributeNames();
//		requestAttributes = request.getA
	}

	// метод добавления в запрос данных для передачи в jsp
	public void insertAttributes(HttpServletRequest request) {
		// реализация
	}

	// some methods
}
