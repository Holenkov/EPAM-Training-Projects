package by.training.edocuments.bean.base;

import by.training.edocuments.bean.BaseEntity;

public class EmployeePosition extends BaseEntity{
	
	private int positionID;
	private String position;
	
	public EmployeePosition() {
	}
	
	public EmployeePosition(int positionID) {
		super();
		this.positionID = positionID;
	}

	public EmployeePosition(int positionID, String position) {
		super();
		this.positionID = positionID;
		this.position = position;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "EmployeePosition [positionID=" + positionID + ", position=" + position + "]";
	}

	

}
