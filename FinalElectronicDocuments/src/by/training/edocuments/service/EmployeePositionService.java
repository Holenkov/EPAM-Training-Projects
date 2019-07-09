package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.exception.DBOperationException;

public interface EmployeePositionService extends Service{
	List<EmployeePosition> readAll() throws DBOperationException;

}
