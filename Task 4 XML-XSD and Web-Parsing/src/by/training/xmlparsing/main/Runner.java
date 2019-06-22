package by.training.xmlparsing.main;

import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.builder.DeviceDOMBuilder;
import by.training.xmlparsing.builder.DeviceSAXBuilder;
import by.training.xmlparsing.builder.ParserException;

public class Runner {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	public static final String DEVICES_XSD = ".\\data\\devices.xsd";
	public static final String DEVICES_XML = ".\\data\\devices.xml";

	public static void main(String[] args) {
		DeviceSAXBuilder deviceSaxBuilder;
		try {
			deviceSaxBuilder = new DeviceSAXBuilder();
			deviceSaxBuilder.buildSetDevices(DEVICES_XML);
			Set<Device> devices = deviceSaxBuilder.getDevices();
			for (Device device : devices) {
				LOGGER.info(device);

			}
		} catch (ParserException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		LOGGER.info("");
		LOGGER.info("DOM builder");
		DeviceDOMBuilder deviceDOMBuilder;
		try {
			deviceDOMBuilder = new DeviceDOMBuilder();
			deviceDOMBuilder.buildSetDevices(DEVICES_XML);
			Set<Device> devices = deviceDOMBuilder.getDevices();
			for (Device device : devices) {
				LOGGER.info(device);

			}
		} catch (ParserException e) {
			LOGGER.error(e.getMessage(), e);
		}
	
		
	}
}
