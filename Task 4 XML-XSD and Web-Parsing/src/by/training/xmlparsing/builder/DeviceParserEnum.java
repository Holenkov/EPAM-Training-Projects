package by.training.xmlparsing.builder;


public enum DeviceParserEnum {
	MOUSE("mouse"),
	DISPLAY("display"),
	HDD("hdd"),
	SSD("ssd"),
	MOTHERBOARD("motherboard"),
	STORE("store"),
	CPU("cpu"),
	
	
	DEVICES("devices"),

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
	
	PORTS("ports"),
	
	
	RPM("rpm"),
	COOLER("cooler"),
	FREQENCY("frequency"),
	
	CAPACITY("capacity"),
	FREQUENCY("freqency"),
	PORT("port"),
	ISCOOLER("isCooler"),
	ISWIRELESS("isWireless"),
	SPEED("speed");
		
	private String value;    
	private DeviceParserEnum(String value) {     
		this.value = value;    
	}    
	public String getValue() {    
		return value;    
	} 
	
}