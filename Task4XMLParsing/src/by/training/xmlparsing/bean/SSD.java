package by.training.xmlparsing.bean;

/**
 * Mouse bean, extends of Store. 
 */
public class SSD extends Store{
	/** Reading speed. */
	protected int speed;
	
	/**
	 * Getter.
	 * @return speed.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Setter.
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return "SSD [speed=" + speed + ", capacity=" + capacity + ", name=" + name + ", origin=" + origin
				+ ", dateOfIssue=" + dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical
				+ "]";
	}

	
}
