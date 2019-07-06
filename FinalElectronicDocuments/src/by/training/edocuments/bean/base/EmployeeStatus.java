package by.training.edocuments.bean.base;

import by.training.edocuments.bean.BaseEntity;

public class EmployeeStatus extends BaseEntity{
	
	private int emplStatusID;
	private String emplStatus;
	
	
	public EmployeeStatus() {
	}	

	public EmployeeStatus(int emplStatusID) {
		super();
		this.emplStatusID = emplStatusID;
	}

	public EmployeeStatus(int emplStatusID, String emplStatus) {
		super();
		this.emplStatusID = emplStatusID;
		this.emplStatus = emplStatus;
	}

	public int getEmplStatusID() {
		return emplStatusID;
	}

	public void setEmplStatusID(int emplStatusID) {
		this.emplStatusID = emplStatusID;
	}

	public String getEmplStatus() {
		return emplStatus;
	}

	public void setEmplStatus(String emplStatus) {
		this.emplStatus = emplStatus;
	}

}
