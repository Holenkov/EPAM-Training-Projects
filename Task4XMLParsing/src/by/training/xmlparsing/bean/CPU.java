package by.training.xmlparsing.bean;

/**
 * CPU bean, extends of Device. 
 */
public class CPU extends Device {
	/** CPU frequency.*/
	protected int frequency;

	/** public int getFrequency().
	 * Getter for CPU frequency.
	 * @return CPU frequency.
	 */
	public int getFrequency() {
		return frequency;
	}

	/** public void setFrequency(int frequency).
	 * Setter for CPU frequency.
	 * @param frequency of CPU.
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + frequency;
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
		CPU other = (CPU) obj;
		if (frequency != other.frequency)
			return false;
		return true;
	}

	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return "CPU [frequency=" + frequency + ", name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue
				+ ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}

}
