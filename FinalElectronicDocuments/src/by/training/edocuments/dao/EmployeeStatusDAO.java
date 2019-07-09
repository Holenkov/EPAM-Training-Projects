package by.training.edocuments.dao;

import java.util.List;

import by.training.edocuments.bean.base.EmployeeStatus;
import by.training.edocuments.exception.DBOperationException;

public interface EmployeeStatusDAO extends DAO<EmployeeStatus> {
	List<EmployeeStatus> readAll() throws DBOperationException;

}
