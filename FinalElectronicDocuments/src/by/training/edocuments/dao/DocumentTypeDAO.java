package by.training.edocuments.dao;

import java.util.HashMap;
import by.training.edocuments.bean.base.DocumentType;

public interface DocumentTypeDAO extends DAO<DocumentType> {
	HashMap<Integer,DocumentType> readAll();

}
