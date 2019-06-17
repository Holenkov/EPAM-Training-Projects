package by.training.xmlparsing.bean;

public class HDD extends Store{
	int rpm;
	
	public HDD() {
	}

	public HDD(int rpm) {
		super();
		this.rpm = rpm;
	}

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
	
	
}
