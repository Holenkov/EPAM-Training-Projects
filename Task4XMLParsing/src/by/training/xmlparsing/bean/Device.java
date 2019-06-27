package by.training.xmlparsing.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.training.xmlparsing.bean.type.Type;

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
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public boolean isCritical() {
		return critical;
	}
	public void setCritical(boolean critical) {
		this.critical = critical;
	}


	@Override
	public String toString() {
		return "Device [name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue + ", price=" + price
				+ ", types=" + types + ", critical=" + critical + "]";
	}
	
	
	
	
}
