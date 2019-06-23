package by.training.xmlparsing.builder;


public enum DeviceParserEnum {
	//classes
	MOUSE("mouse"),
	DISPLAY("display"),
	HDD("hdd"),
	SSD("ssd"),
	MOTHERBOARD("motherboard"),
	STORE("store"),
	CPU("cpu"),
	
	//attributes
	NAME("name"),
	DATE("date"),
	
	
	DEVICES("devices"),

	//fields
	ORIGIN("origin"),
	PRICE("price"),
	TYPES("types"),
	ENERGY("energy"),
	WATT("watt"),
	PERIPHERAL("peripheral"),
	ISPERIPHERAL("isPeripheral"),
	ISCRITICAL("isCritical"),
	ISWIRELES("isWireless"),
	RESOLUTIONX("resolutionX"),
	RESOLUTIONY("resolutionY"),
	CAPACITY("capacity"),
	PORT("port"),
	ISCOOLER("isCooler"),
	ISWIRELESS("isWireless"),
	SPEED("speed"),
	RPM("rpm"),
	COOLER("cooler"),
	PORTS("ports"),
	FREQUENCY("freqency");
		
	private String value;    
	private DeviceParserEnum(String value) {     
		this.value = value;    
	}    
	public String getValue() {    
		return value;    
	} 
	
}