package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.base.DocumentType;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentTypeService extends Service{
	List<DocumentType> readAll() throws DBOperationException;
}
