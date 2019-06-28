package by.training.xmlparsing.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * MotherBoard bean, extends of Device. 
 */
public class MotherBoard extends Device{
	/** List of ports on Motherboard. */
	protected List<Port> ports;
	
	/**
	 * Constructor.
	 */
	public MotherBoard() {
		super();
		this.ports = new ArrayList<>();
	}

	/**
	 * Getter.
	 * @return List of ports.
	 */
	public List<Port> getPorts() {
		return ports;
	}

	/**
	 * Setter.
	 * @param ports List.
	 */
	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	@Override
	/**
	 * To String.
	 */
	public String toString() {
		return "MotherBoard [ports=" + ports + ", name=" + name + ", origin=" + origin + ", dateOfIssue=" + dateOfIssue
				+ ", price=" + price + ", types=" + types + ", critical=" + critical + "]";
	}
	
	

}
