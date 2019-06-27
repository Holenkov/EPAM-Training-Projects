package by.training.xmlparsing.bean;

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
	/**
	 * To String.
	 */
	public String toString() {
		return "CPU [frequency=" + frequency + ", name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue
				+ ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}

}
