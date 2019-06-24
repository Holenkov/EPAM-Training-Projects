package by.training.xmlparsing.controller;

import java.util.Set;

import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.builder.DeviceBuilder;
import by.training.xmlparsing.builder.DeviceBuilderFactory;
import by.training.xmlparsing.builder.ParserException;

public class Controller {
	
	public Set<Device> parseDevices (String path, String parser) throws ParserException {
			DeviceBuilder deviceBuilder = DeviceBuilderFactory.createDeviceBuilder(parser);
			deviceBuilder.buildSetDevices(path);
			Set<Device> devices = deviceBuilder.getDevices();
			for (Device device : devices) {
				System.out.println(device);
			}
			return devices;
	}

}
