package by.training.xmlparsing.bean.type;

public class Cooller extends Type{
	boolean isCooller;
	
	public Cooller() {
	}

	public Cooller(boolean isCooller) {
		super();
		this.isCooller = isCooller;
	}

	public boolean isCooller() {
		return isCooller;
	}

	public void setCooller(boolean isCooller) {
		this.isCooller = isCooller;
	}

	@Override
	public String toString() {
		return " Is cooller present = " + isCooller + " ";
	}
	
	
	

}
