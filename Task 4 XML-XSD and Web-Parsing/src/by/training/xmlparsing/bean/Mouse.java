package by.training.xmlparsing.bean;

public class Mouse extends Device{
	boolean isWireless;
	
	public boolean isWireless() {
		return isWireless;
	}

	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}

	@Override
	public String toString() {
		return "Mouse [isWireless=" + isWireless + ", name=" + name + ", origin=" + origin + ", dateOfIssue="
				+ dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}


	

}
