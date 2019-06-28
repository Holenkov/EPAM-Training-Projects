package by.training.xmlparsing.bean.type;

/**
 * Cooler bean, extends of Type. 
 */
public class Cooler extends Type{
	/** Parameter is cooler present on device. */
	private boolean isCooler;
	
	/**
	 * Constructor.
	 */
	public Cooler() {
	}

	/**
	 * Constructor using field.
	 */
	public Cooler(boolean isCooler) {
		super();
		this.isCooler = isCooler;
	}

	/**
	 * Getter.
	 * @return true or false.
	 */
	public boolean isCooler() {
		return isCooler;
	}

	/**
	 * Setter.
	 * @param isCooler - true or false.
	 */
	public void setCooler(boolean isCooler) {
		this.isCooler = isCooler;
	}

	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return " Is cooler present = " + isCooler + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isCooler ? 1231 : 1237);
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
		Cooler other = (Cooler) obj;
		if (isCooler != other.isCooler)
			return false;
		return true;
	}
	
	
	

}
