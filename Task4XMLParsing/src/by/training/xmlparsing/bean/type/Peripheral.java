package by.training.xmlparsing.bean.type;

public class Peripheral extends Type{
	boolean isPeripheral;

	public Peripheral(boolean peripheral) {
		super();
		this.isPeripheral = peripheral;
	}
	
	public Peripheral() {
	}

	public boolean isPeripheral() {
		return isPeripheral;
	}

	public void setPeripheral(boolean peripheral) {
		this.isPeripheral = peripheral;
	}

	@Override
	public String toString() {
		//return "Peripheral [isPeripheral=" + isPeripheral + "]";
		return " Device isPeripheral = " + isPeripheral;
	}
	
	
	

}
