package by.training.xmlparsing.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.training.xmlparsing.bean.type.Type;

/**
 * Abstract class of Device. 
 */
public abstract class Device {
	/** Device name. */
	protected String name;
	/** place of origin. */
	protected String origin;
	/** Date of issue. */
	protected Date dateOfIssue;
	/** Price. */
	protected double price;
	/** List of characteristics. */
	protected List<Type> types;
	/** Is device critically needed?. */
	protected boolean critical;
	
	
	/**
	 * Constructor.	
	 */
	public Device() {
		super();
		this.types = new ArrayList<>();
	}
	
	
	/**
	 * Getter.
	 * @return name of Device.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter.
	 * @param name of Device.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for origin.
	 * @return place of origin.
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * Setter for origin. 
	 * @param origin place of origin.
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * Getter for Date.
	 * @return date of issue.
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	
	/**
	 * Setter for Date.
	 * @param dateOfIssue of Device.
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	
	/**
	 * Getter for price.
	 * @return price of device.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for price.
	 * @param price of Device.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Getter for characteristics.
	 * @return List of characteristics.
	 */
	public List<Type> getTypes() {
		return types;
	}
	
	/**
	 * Setter for characteristics.
	 * @param types List of characteristics.
	 */
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
	/**
	 * Getter.
	 * @return true of false.
	 */
	public boolean isCritical() {
		return critical;
	}
	
	/**
	 * Setter.
	 * @param critical true or false.
	 */
	public void setCritical(boolean critical) {
		this.critical = critical;
	}


	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return "Device [name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue + ", price=" + price
				+ ", types=" + types + ", critical=" + critical + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (critical ? 1231 : 1237);
		result = prime * result + ((dateOfIssue == null) ? 0 : dateOfIssue.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		Device other = (Device) obj;
		if (critical != other.critical)
			return false;
		if (dateOfIssue == null) {
			if (other.dateOfIssue != null)
				return false;
		} else if (!dateOfIssue.equals(other.dateOfIssue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	
	
	
	
}
