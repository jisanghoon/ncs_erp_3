package org.gradle;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dgit.ncs.dto.Department;
import com.dgit.ncs.dto.Employee;
import com.dgit.ncs.dto.Title;
import com.dgit.ncs.service.EmployeeService;

public class EmployServiceTest {
	EmployeeService service;

	@Before
	public void setUp() throws Exception {
		service = EmployeeService.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertItem() {
		// fail("Not yet implemented");

		Department dno = new Department();
		dno.setDcode(1);

		Title tno = new Title();
		tno.setTcode(1);

		Employee employee = new Employee();
		employee.setTitle(tno);
		employee.setDepartment(dno);
		employee.setEname("홍길동");
		employee.setSalary(2000000);
		employee.setGender(0);
		employee.setJoindate(new Date());
		
		service.insert(employee);
		
		

	}

	@Test
	public void testDeleteItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		// fail("Not yet implemented");
		List<Employee> list = service.selectAll();

		for (Employee employee : list) {
			Assert.assertNotNull(employee);
			System.out.println(employee.toString());
		}
	}

	@Test
	public void testSelectByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectLast() {
		fail("Not yet implemented");
	}

}
