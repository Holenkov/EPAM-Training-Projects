package by.training.xmlparsing.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.bean.Display;
import by.training.xmlparsing.builder.DeviceBuilder;
import by.training.xmlparsing.builder.DeviceBuilderFactory;
import by.training.xmlparsing.builder.DeviceDOMBuilder;
import by.training.xmlparsing.builder.DeviceSAXBuilder;
import by.training.xmlparsing.builder.DeviceStAXBuilder;
import by.training.xmlparsing.builder.ParserException;

public class Runner {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	public static final String DEVICES_XSD = ".\\data\\devices.xsd";
	public static final String DEVICES_XML = ".\\data\\devices.xml";

	public static void main(String[] args) {
		
		try {
			DeviceBuilder deviceBuilder = DeviceBuilderFactory.createDeviceBuilder("SAX", DEVICES_XSD);
			File file = new File(DEVICES_XML);
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deviceBuilder.buildSetDevices(inputStream);
			Set<Device> devices = deviceBuilder.getDevices();
			LOGGER.info("");
			LOGGER.info("SAX builder");
			for (Device device : devices) {
				LOGGER.info(device);
			}
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
		try {
			DeviceBuilder deviceBuilder = DeviceBuilderFactory.createDeviceBuilder("StAX", DEVICES_XSD);
			File file = new File(DEVICES_XML);
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deviceBuilder.buildSetDevices(inputStream);
			Set<Device> devices = deviceBuilder.getDevices();
			LOGGER.info("");
			LOGGER.info("StAX builder");
			for (Device device : devices) {
				LOGGER.info(device);
			}
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
		try {
			DeviceBuilder deviceBuilder = DeviceBuilderFactory.createDeviceBuilder("DOM", DEVICES_XSD);
			File file = new File(DEVICES_XML);
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deviceBuilder.buildSetDevices(inputStream);
			Set<Device> devices = deviceBuilder.getDevices();
			LOGGER.info("");
			LOGGER.info("DOM builder");
			for (Device device : devices) {
				LOGGER.info(device);
			}
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
	}
}
