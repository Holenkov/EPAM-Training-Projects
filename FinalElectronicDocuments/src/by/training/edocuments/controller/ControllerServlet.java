package by.training.edocuments.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.edocuments.action.Action;
import by.training.edocuments.action.ActionFactory;
import by.training.edocuments.connection.ConnectionPool;
import by.training.edocuments.exception.DBOperationException;
import by.training.edocuments.util.SourceTablesStore;

@WebServlet("/controller")
@MultipartConfig
public class ControllerServlet extends HttpServlet {

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		ActionFactory actionFactory = new ActionFactory();
		Action action = actionFactory.createAction(request);
		if ("POST".equals(request.getMethod())) {
			action.executePost(request, response);
		} else {
			action.executeGet(request, response);
		}
		
		String path = action.getPath();
	//	System.out.println("CS  " + method + path + "   " + action.getIsRedirect());
		if (action.getIsRedirect()) {
			response.sendRedirect(request.getContextPath() + path + ".html" + action.getParameters());
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp" + path + ".jsp");
			dispatcher.forward(request, response);
		}
	
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			ConnectionPool.getConnectionPool().init(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			SourceTablesStore.getStore().init();
		} catch (DBOperationException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
}
