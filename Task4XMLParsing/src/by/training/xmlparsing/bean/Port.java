package by.training.xmlparsing.bean;

public enum Port {
	COM("COM"),
	USB("USB"),
	LPT("LPT"),
	HDMI("HDMI"),
	SATA("SATA"),
	PCI("PCI");
	
	private String value;
	
	private Port(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
