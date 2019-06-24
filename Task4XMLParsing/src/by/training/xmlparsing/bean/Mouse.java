package by.training.xmlparsing.bean;

public class Mouse extends Device{
	protected boolean wireless;
	
	public boolean isWireless() {
		return wireless;
	}

	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}




	@Override
	public String toString() {
		return "Mouse [isWireless=" + wireless + ", name=" + name + ", origin=" + origin + ", dateOfIssue="
				+ dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}


	

}
