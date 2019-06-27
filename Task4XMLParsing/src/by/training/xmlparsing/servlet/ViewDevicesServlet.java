package by.training.xmlparsing.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.builder.DeviceBuilderFactory;
import by.training.xmlparsing.builder.ParserException;
import by.training.xmlparsing.controller.Controller;

/**
 * Servlet implementation class ViewTableServlet
 */
@MultipartConfig
@WebServlet("/viewDevices")
public class ViewDevicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public static final String DEVICES_XML = ".\\data\\devices.xml";
	//public static final String DEVICES_XML = "d:/Epam Training Projects/Task4XMLParsing/data/devices.xml";
	public static final String DEVICES_XML = "/WEB-INF/data/devices.xml";
	public static final String DEVICES_XSD = "/WEB-INF/data/devices.xsd";
	
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part devicesFile = request.getPart("data");
		
		String realPath = request.getServletContext().getRealPath("/");
		String xsdPath = realPath + DEVICES_XSD;
		String parser = request.getParameter("parserType");
		Controller controller = new Controller();
		Set<Device> devices = null;
		try {
			devices = controller.parseDevices(devicesFile.getInputStream(), parser, xsdPath);
		//	devices = controller.parseDevices(realPath + DEVICES_XML, parser);
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
