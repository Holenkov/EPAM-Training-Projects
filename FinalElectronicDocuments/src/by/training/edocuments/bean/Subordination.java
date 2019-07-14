package by.training.edocuments.bean;

import by.training.edocuments.bean.base.DocumentType;

public class Subordination extends BaseEntity{
	
	/*id
	senderID
	docTypeID
	receiverID*/
	
	private int id;
	private Employee sender;
	private DocumentType docType;
	private Employee receiver;
	
	public Subordination() {
	}
	
	public Subordination(int id) {
		super();
		this.id = id;
	}

	public Subordination(int id, Employee sender, DocumentType docType, Employee receiver) {
		super();
		this.id = id;
		this.sender = sender;
		this.docType = docType;
		this.receiver = receiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public DocumentType getDocType() {
		return docType;
	}

	public void setDocType(DocumentType docType) {
		this.docType = docType;
	}

	public Employee getReceiver() {
		return receiver;
	}

	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Subordination [id=" + id + ", sender=" + sender + ", docType=" + docType + ", receiver=" + receiver
				+ "]";
	}


}
