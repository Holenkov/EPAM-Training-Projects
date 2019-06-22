package by.training.xmlparsing.bean;

import java.util.ArrayList;
import java.util.List;

public class MotherBoard extends Device{
	List<Port> ports;
	
	public MotherBoard() {
		super();
		this.ports = new ArrayList<>();
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	@Override
	public String toString() {
		return "MotherBoard [ports=" + ports + ", name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue
				+ ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}
	
	

}
