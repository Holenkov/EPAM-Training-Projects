package by.training.xmlparsing.handler;

public enum DeviceParserEnum {
	DEVICES("devices"),
	MOUSE("mouse"),
	ORIGIN("origin"),
	PRICE("price"),
	TYPES("types"),
	ENERGY("energy"),
	WATT("watt"),
	PERIPHERAL("peripheral"),
	ISPERIPHERAL("isPeripheral"),
	ISCRITICAL("isCritical"),
	ISWIRELES("isWireless"),
	DISPLAY("display"),
	RESOLUTIONX("resolutionX"),
	RESOLUTIONY("resolutionY"),
	MOTHERBOARD("motherboard"),
	PORTS("ports"),
	SSD("ssd"),
	HDD("hdd"),
	RPM("rpm"),
	FREQENCY("frequency"),
	SPEED("speed");
		
	private String value;    
	private DeviceParserEnum(String value) {     
		this.value = value;    
	}    
	public String getValue() {    
		return value;    
	} 
	
}
