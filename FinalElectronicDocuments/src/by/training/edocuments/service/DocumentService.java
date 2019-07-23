package by.training.edocuments.service;

import by.training.edocuments.bean.Document;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentService extends Service{
	int create(Document document) throws DBOperationException;
	Document find(Document document) throws DBOperationException;
	
}
