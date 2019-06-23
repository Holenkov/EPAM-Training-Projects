package by.training.xmlparsing.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.training.xmlparsing.bean.type.Type;

public abstract class Device {
	String name;
	String origin;
	Date dateOfIssue;
	double price;
	List<Type> types;
	boolean critical;
	
	
	
	
	public Device() {
		super();
		this.types = new ArrayList<>();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
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
