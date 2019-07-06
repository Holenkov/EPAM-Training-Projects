package by.training.edocuments.bean.base;

import by.training.edocuments.bean.BaseEntity;

public class DocumentStatus extends BaseEntity{
	
	private int docStatusID;
	private String docStatus;

	public DocumentStatus() {
	}
	
	public DocumentStatus(int docStatusID, String docStatus) {
		super();
		this.docStatusID = docStatusID;
		this.docStatus = docStatus;
	}
	
	public int getDocStatusID() {
		return docStatusID;
	}

	public void setDocStatusID(int docStatusID) {
		this.docStatusID = docStatusID;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	

}
