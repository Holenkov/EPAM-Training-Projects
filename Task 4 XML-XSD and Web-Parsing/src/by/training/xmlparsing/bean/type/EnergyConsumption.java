package by.training.xmlparsing.bean.type;

public class EnergyConsumption extends Type{
	int watt;
	
	public EnergyConsumption() {
	}

	public EnergyConsumption(int watt) {
		super();
		this.watt = watt;
	}

	public int getWatt() {
		return watt;
	}

	public void setWatt(int watt) {
		this.watt = watt;
	}
	
	

}
