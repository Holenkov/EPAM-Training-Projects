package by.training.xmlparsing.bean;

/**
 * Enum of ports of motherboard. 
 */
public enum Port {
	COM("COM"),
	USB("USB"),
	LPT("LPT"),
	HDMI("HDMI"),
	SATA("SATA"),
	PCI("PCI");
	
	/** Name of port. */
	private String value;
	
	/**
	 * Constructor.
	 * @param value name of Port.
	 */
	private Port(String value) {
		this.value = value;
	}

	/**
	 * Getter.
	 * @return value of enum.
	 */
	public String getValue() {
		return value;
	}

}
