package by.training.xmlparsing.bean;

public class HDD extends Store{
	int rpm;
	

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	@Override
	public String toString() {
		return "HDD [rpm=" + rpm + ", capacity=" + capacity + ", name=" + name + ", origin=" + origin + ", dateOfIssue="
				+ dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}
	
	
}
