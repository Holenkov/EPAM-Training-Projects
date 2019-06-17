package by.training.xmlparsing.bean;

import java.util.List;

public class MotherBoard extends Device{
	List<Port> ports;
	
	public MotherBoard() {
	}

	public MotherBoard(List<Port> ports) {
		super();
		this.ports = ports;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}
	
	

}
