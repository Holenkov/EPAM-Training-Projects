package by.training.xmlparsing.bean;

public class CPU extends Device {
	int frequency;

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "CPU [frequency=" + frequency + ", name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue
				+ ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}
	
	
	
	

}
