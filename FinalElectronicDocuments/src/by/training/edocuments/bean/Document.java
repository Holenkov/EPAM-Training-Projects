package by.training.edocuments.bean;

import java.sql.Timestamp;

import by.training.edocuments.bean.base.DocumentType;

public class Document extends BaseEntity {
	
	private int docID;
	private Employee author;
	private DocumentType docType;
	private String description;
	private String textBody;
	private Timestamp dateUpdated;
	private Timestamp dateToExecute;
	private String signUpdater;
	
	
	public Document() {
	}	

	public Document(int docID) {
		super();
		this.docID = docID;
	}

	public Document(int docID, Employee author, DocumentType docType, String description, String textBody,
			Timestamp dateUpdated, Timestamp dateToExecute, String signUpdater) {
		super();
		this.docID = docID;
		this.author = author;
		this.docType = docType;
		this.description = description;
		this.textBody = textBody;
		this.dateUpdated = dateUpdated;
		this.dateToExecute = dateToExecute;
		this.signUpdater = signUpdater;
	}


	public int getDocID() {
		return docID;
	}


	public void setDocID(int docID) {
		this.docID = docID;
	}


	public Employee getAuthor() {
		return author;
	}


	public void setAuthor(Employee author) {
		this.author = author;
	}


	public DocumentType getDocType() {
		return docType;
	}


	public void setDocType(DocumentType docType) {
		this.docType = docType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTextBody() {
		return textBody;
	}


	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}


	public Timestamp getDateUpdated() {
		return dateUpdated;
	}


	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}


	public Timestamp getDateToExecute() {
		return dateToExecute;
	}


	public void setDateToExecute(Timestamp dateToExecute) {
		this.dateToExecute = dateToExecute;
	}


	public String getSignUpdater() {
		return signUpdater;
	}


	public void setSignUpdater(String signUpdater) {
		this.signUpdater = signUpdater;
	}


	@Override
	public String toString() {
		return "Document [docID=" + docID + ", author=" + author + ", docType=" + docType + ", description="
				+ description + ", textBody=" + textBody + ", dateUpdated=" + dateUpdated + ", dateToExecute="
				+ dateToExecute + ", signUpdater=" + signUpdater + "]";
	}
	
	

	

}
