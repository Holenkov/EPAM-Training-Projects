package by.training.itcompany.factory;

import java.util.List;

import by.training.itcompany.exception.IllegalParameterException;
import by.training.itcompany.model.Employee;

/**
Interface with method makeEmployee.
*/
public interface Factory {

	Employee makeEmployee(List<String> params) throws IllegalParameterException;


}
