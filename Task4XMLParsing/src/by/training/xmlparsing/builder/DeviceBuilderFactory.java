package by.training.xmlparsing.builder;

public class DeviceBuilderFactory {
	private enum TypeParser { 
		SAX, 
		STAX, 
		DOM 
		} 
	
	public static DeviceBuilder createDeviceBuilder(String typeParser) throws ParserException { 
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase()); 
		switch (type) {    
		case DOM: 
			return new DeviceDOMBuilder();    
		case STAX: 
			return new DeviceStAXBuilder();    
		case SAX: 
			return new DeviceSAXBuilder();    
		default: 
			throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
	}
	}
	} 