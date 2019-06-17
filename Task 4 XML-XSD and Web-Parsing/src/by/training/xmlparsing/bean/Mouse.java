package by.training.xmlparsing.bean;

public class Mouse extends Device{
	boolean isWireless;
	
	public Mouse() {
	}

	public Mouse(boolean isWireless) {
		super();
		this.isWireless = isWireless;
	}

	public boolean isWireless() {
		return isWireless;
	}

	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}

	

}
