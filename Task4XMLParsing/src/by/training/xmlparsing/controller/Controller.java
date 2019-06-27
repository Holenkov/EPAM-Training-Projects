package by.training.xmlparsing.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.builder.DeviceBuilder;
import by.training.xmlparsing.builder.DeviceBuilderFactory;
import by.training.xmlparsing.builder.ParserException;

public class Controller {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	public Set<Device> parseDevices (InputStream input, String parser, String xsdPath) throws ParserException {
			DeviceBuilder deviceBuilder = DeviceBuilderFactory.createDeviceBuilder(parser, xsdPath);
			deviceBuilder.buildSetDevices(input);
			Set<Device> devices = deviceBuilder.getDevices();
			for (Device device : devices) {
				LOGGER.info(device);
			}
			return devices;
	}

}
