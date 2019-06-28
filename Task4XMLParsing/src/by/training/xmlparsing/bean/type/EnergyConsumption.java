package by.training.xmlparsing.bean.type;

/**
 * EnergyConsumption bean, extends of Type. 
 */
public class EnergyConsumption extends Type{
	/** Energy consumption of Device. */
	private double watt;
	
	/**
	 * Constructor.
	 */
	public EnergyConsumption() {
	}

	/**
	 * Constructor using field.
	 * @param watt - consumption in watts.
	 */
	public EnergyConsumption(double watt) {
		super();
		this.watt = watt;
	}

	/**
	 * Getter.
	 * @return consumption in watts.
	 */
	public double getWatt() {
		return watt;
	}

	/**
	 * Setter.
	 * @param watt -  consumption in watts.
	 */
	public void setWatt(double watt) {
		this.watt = watt;
	}

	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return " EnergyConsumption " + watt +  " watt. ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(watt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EnergyConsumption other = (EnergyConsumption) obj;
		if (Double.doubleToLongBits(watt) != Double.doubleToLongBits(other.watt))
			return false;
		return true;
	}
	
	
	
	

}
