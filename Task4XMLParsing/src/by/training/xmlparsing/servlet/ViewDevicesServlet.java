package by.training.xmlparsing.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.builder.DeviceBuilderFactory;
import by.training.xmlparsing.builder.ParserException;
import by.training.xmlparsing.controller.Controller;

/**
 * Servlet implementation class ViewTableServlet
 */
@WebServlet("/viewDevices")
public class ViewDevicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public static final String DEVICES_XML = ".\\data\\devices.xml";
	public static final String DEVICES_XML = "d:/Epam Training Projects/Task4XMLParsing/data/devices.xml"   ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDevicesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parser = request.getParameter("parserType");
		Controller controller = new Controller();
		Set<Device> devices = null;
		try {
			devices = controller.parseDevices(DEVICES_XML, parser);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		request.setAttribute("devices", devices);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/devicesList.jsp");
        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
