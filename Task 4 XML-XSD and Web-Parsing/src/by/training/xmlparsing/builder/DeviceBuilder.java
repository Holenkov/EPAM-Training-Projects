package by.training.xmlparsing.builder;

import java.util.Set;

import by.training.xmlparsing.bean.Device;

public interface DeviceBuilder{
	
	
	public abstract Set<Device> getDevices();  
	public abstract void buildSetDevices(String fileName) throws ParserException;  

}
