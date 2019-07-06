package by.training.edocuments.dao;

import java.util.HashMap;

import by.training.edocuments.bean.base.DocumentStatus;

public interface DocumentStatusDAO extends DAO<DocumentStatus> {
	HashMap<Integer,DocumentStatus> readAll();

}
