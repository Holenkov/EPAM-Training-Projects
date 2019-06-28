package by.training.xmlparsing.bean.type;

/**
 * Peripheral bean, extends of Type. 
 */
public class Peripheral extends Type{
	/** Parameter is device peripheral. */
	private boolean isPeripheral;

	/**
	 * Constructor using field.
	 * @param peripheral - is device peripheral, true if yes.
	 */
	public Peripheral(boolean peripheral) {
		super();
		this.isPeripheral = peripheral;
	}
	
	/**
	 * Constructor.
	 */
	public Peripheral() {
	}

	/**
	 * Getter.
	 * @return true or false.
	 */
	public boolean isPeripheral() {
		return isPeripheral;
	}

	/**
	 * Setter.
	 * @param peripheral - true or false.
	 */
	public void setPeripheral(boolean peripheral) {
		this.isPeripheral = peripheral;
	}

	@Override
	public String toString() {
		//return "Peripheral [isPeripheral=" + isPeripheral + "]";
		return " Device isPeripheral = " + isPeripheral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isPeripheral ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peripheral other = (Peripheral) obj;
		if (isPeripheral != other.isPeripheral)
			return false;
		return true;
	}
	
	
	

}
