package by.training.xmlparsing.bean;

/**
 * Display bean, extends of Device. 
 */
public class Display extends Device{
	/** X asix resolution. */
	protected int resolutionX;
	/** Y asix resolution. */
	protected int resolutionY;
	
	/**
	 * Getter.
	 * @return resolution on X axis.
	 */
	public int getResolutionX() {
		return resolutionX;
	}

	/**
	 * Setter.
	 * @param resolutionX on X axis.
	 */
	public void setResolutionX(int resolutionX) {
		this.resolutionX = resolutionX;
	}

	/**
	 * Getter.
	 * @return resolution on Y axis.
	 */
	public int getResolutionY() {
		return resolutionY;
	}

	/**
	 * Setter.
	 * @param resolutionY on Y axis.
	 */
	public void setResolutionY(int resolutionY) {
		this.resolutionY = resolutionY;
	}

	/**
	 * To String.
	 */
	@Override
	public String toString() {
		return "Display [resolutionX=" + resolutionX + ", resolutionY=" + resolutionY + ", name=" + name + ", origin="
				+ origin + ", dateOfIssue=" + dateOfIssue + ", price=" + price + ", types=" + types + ", critical="
				+ critical + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + resolutionX;
		result = prime * result + resolutionY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Display other = (Display) obj;
		if (resolutionX != other.resolutionX)
			return false;
		if (resolutionY != other.resolutionY)
			return false;
		return true;
	}

	

}
