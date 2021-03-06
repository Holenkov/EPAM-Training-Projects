package by.training.edocuments.dao;

import java.util.HashMap;
import java.util.List;

import by.training.edocuments.bean.base.EmployeePosition;
import by.training.edocuments.exception.DBOperationException;

public interface EmployeePositionDAO extends DAO<EmployeePosition> {
	List<EmployeePosition> readAll() throws DBOperationException;

}
