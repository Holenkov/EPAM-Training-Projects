package by.training.xmlparsing.bean.type;

public class EnergyConsumption extends Type{
	double watt;
	
	public EnergyConsumption() {
	}

	public EnergyConsumption(double watt) {
		super();
		this.watt = watt;
	}

	public double getWatt() {
		return watt;
	}

	public void setWatt(double watt) {
		this.watt = watt;
	}

	@Override
	public String toString() {
		return "EnergyConsumption [watt=" + watt + "]";
	}
	
	
	
	

}
