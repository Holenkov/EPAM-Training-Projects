package by.training.edocuments.dao;

import by.training.edocuments.bean.BaseEntity;
import by.training.edocuments.exception.DBOperationException;

public interface DAO <T extends BaseEntity>{
	int create(T entity) throws DBOperationException ;
	T find(T entity) throws DBOperationException ;
	int update(T entity) throws DBOperationException ;
	int delete(T entity) throws DBOperationException ;
	

}
