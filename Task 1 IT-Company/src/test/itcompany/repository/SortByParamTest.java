package test.itcompany.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.training.itcompany.exception.NullResultException;
import by.training.itcompany.model.Employee;
import by.training.itcompany.repository.EmployeesRepository;
import by.training.itcompany.repository.EmployeesRepositoryForTest;

@RunWith(Parameterized.class)
public class SortByParamTest {
	private List<String> params;
	private List<Employee> expected;
	
	
	public SortByParamTest(List<String> params, List<Employee> expected) {
		super();
		this.params = params;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Object[]> paramsForTest() throws NullResultException {
		List<Object[]> forTest = new ArrayList<>();
		//ID
		String FILENAME = ".\\data\\test\\sortByIDExpected.txt";
		EmployeesRepositoryForTest tr = new EmployeesRepositoryForTest(FILENAME);
		forTest.add(new Object[]{new ArrayList<>(Arrays.asList("id")), tr.returnAll()});
		
		//Department
		FILENAME = ".\\data\\test\\sortByDepartmentExpected.txt";
		tr = new EmployeesRepositoryForTest(FILENAME);
		forTest.add(new Object[]{new ArrayList<>(Arrays.asList("department")), tr.returnAll()});
		
		return forTest;
	}
	
	@Test
	public void sortByParam (){
		final String FILENAME = ".\\data\\test\\sourceRepository.txt";
		EmployeesRepository employeesRepository = EmployeesRepository.getRepository(FILENAME);
		employeesRepository.sortByParam(params);
		List<Employee> actual = employeesRepository.returnAll();
		
		assertEquals(expected, actual);
	}	
	
	

}
