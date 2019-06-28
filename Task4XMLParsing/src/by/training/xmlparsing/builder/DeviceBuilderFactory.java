package by.training.xmlparsing.builder;

public class DeviceBuilderFactory {
	private enum TypeParser { 
		SAX, 
		STAX, 
		DOM 
		} 
	
	public static DeviceBuilder createDeviceBuilder(String typeParser, String xsdPath) throws ParserException { 
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase()); 
		switch (type) {    
		case DOM: 
			return new DeviceDOMBuilder(xsdPath);    
		case STAX: 
			return new DeviceStAXBuilder(xsdPath);    
		case SAX: 
			return new DeviceSAXBuilder(xsdPath);   
		default: 
			throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
	}
	}
	} 