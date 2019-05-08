package by.training.factories;

import java.util.List;

import by.training.models.Employee;

/**
Interface with method makeEmployee.
*/
public interface Factory {

	Employee makeEmployee(List<String> params);


}
