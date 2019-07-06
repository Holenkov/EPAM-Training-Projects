package by.training.edocuments.dao;

import java.util.HashMap;
import by.training.edocuments.bean.base.EmployeePosition;

public interface EmployeePositionDAO extends DAO<EmployeePosition> {
	HashMap<Integer,EmployeePosition> readAll();

}
