package by.training.xmlparsing.bean;

/**
 * HDD bean, extends of Store. 
 */
public class HDD extends Store{
	/** rpm - raunds per minute.  */
	protected int rpm;
	
	/**
	 * Getter.
	 * @return rpm.
	 */
	public int getRpm() {
		return rpm;
	}

	/**
	 * Setter.
	 * @param rpm
	 */
	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return "HDD [rpm=" + rpm + ", capacity=" + capacity + ", name=" + name + ", origin=" + origin + ", dateOfIssue="
				+ dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}
	
	
}
