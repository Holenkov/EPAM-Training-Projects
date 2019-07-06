package by.training.edocuments.bean;

import java.sql.Timestamp;

import by.training.edocuments.bean.base.DocumentStatus;


public class DocumentHistory extends BaseEntity {
	
	/*id
docID
fromID
toID
dateExecuted
docStatus*/
	
	private int id;
	private Document document;
	private Employee fromEmployee;
	private Employee toEmployee;
	private Timestamp dateExecuted;
	private DocumentStatus docStatus;
	
	public DocumentHistory() {
	}

	public DocumentHistory(int id, Document document, Employee fromEmployee, Employee toEmployee,
			Timestamp dateExecuted, DocumentStatus docStatus) {
		super();
		this.id = id;
		this.document = document;
		this.fromEmployee = fromEmployee;
		this.toEmployee = toEmployee;
		this.dateExecuted = dateExecuted;
		this.docStatus = docStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Employee getFromEmployee() {
		return fromEmployee;
	}

	public void setFromEmployee(Employee fromEmployee) {
		this.fromEmployee = fromEmployee;
	}

	public Employee getToEmployee() {
		return toEmployee;
	}

	public void setToEmployee(Employee toEmployee) {
		this.toEmployee = toEmployee;
	}

	public Timestamp getDateExecuted() {
		return dateExecuted;
	}

	public void setDateExecuted(Timestamp dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

	public DocumentStatus getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(DocumentStatus docStatus) {
		this.docStatus = docStatus;
	}
	
	


}
