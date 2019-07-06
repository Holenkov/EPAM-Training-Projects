package by.training.edocuments.dao;

import by.training.edocuments.bean.BaseEntity;

public interface DAO <T extends BaseEntity>{
	void create(T entity) throws Exception;
	T find(T entity) throws Exception;
	void update(T entity) throws Exception;
	void delete(T entity) throws Exception;
	

}
