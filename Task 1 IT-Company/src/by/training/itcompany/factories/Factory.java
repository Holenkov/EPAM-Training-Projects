package by.training.itcompany.factories;

import java.util.List;

import by.training.itcompany.models.Employee;

/**
Interface with method makeEmployee.
*/
public interface Factory {

	Employee makeEmployee(List<String> params);


}
