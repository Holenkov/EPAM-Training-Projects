package by.training.edocuments.dao;

import by.training.edocuments.bean.BaseEntity;
import by.training.edocuments.exception.DBOperationException;

public interface DAO <T extends BaseEntity>{
	void create(T entity) throws DBOperationException ;
	T find(T entity) throws DBOperationException ;
	void update(T entity) throws DBOperationException ;
	void delete(T entity) throws DBOperationException ;
	

}
