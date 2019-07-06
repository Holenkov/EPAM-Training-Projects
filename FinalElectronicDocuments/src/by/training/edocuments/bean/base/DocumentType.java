package by.training.edocuments.bean.base;

import by.training.edocuments.bean.BaseEntity;

public class DocumentType extends BaseEntity{
	
	private int docTypeID;
	private String docType;
	
	public DocumentType() {
	}
	
	public DocumentType(String docType) {
		super();
		this.docType = docType;
	}

	public DocumentType(int docTypeID) {
		super();
		this.docTypeID = docTypeID;
	}

	public DocumentType(int docTypeID, String docType) {
		super();
		this.docTypeID = docTypeID;
		this.docType = docType;
	}

	public int getDocTypeID() {
		return docTypeID;
	}

	public void setDocTypeID(int docTypeID) {
		this.docTypeID = docTypeID;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}


	
	

	
	
	

}
