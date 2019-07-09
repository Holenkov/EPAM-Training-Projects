package by.training.edocuments.service;

import java.util.List;

import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.exception.DBOperationException;

public interface EmployeeStatusService extends Service{
	List<EmployeeStatus> readAll() throws DBOperationException;

}
