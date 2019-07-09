package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.base.DocumentStatus;
import by.training.edocuments.exception.DBOperationException;

public interface DocumentStatusService extends Service{
	List<DocumentStatus> readAll() throws DBOperationException;
	

}
