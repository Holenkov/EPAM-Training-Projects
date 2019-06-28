package by.training.xmlparsing.bean;

/**
 * Mouse bean, extends of Device. 
 */
public class Mouse extends Device{
	/** Parameter is mouse wireless. */
	protected boolean wireless;
	
	/**
	 * Getter.
	 * @return true if wireless.
	 */
	public boolean isWireless() {
		return wireless;
	}

	/**
	 * Setter.
	 * @param wireless - true if wireless.
	 */
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}




	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return "Mouse [isWireless=" + wireless + ", name=" + name + ", origin=" + origin + ", dateOfIssue="
				+ dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}


	

}
