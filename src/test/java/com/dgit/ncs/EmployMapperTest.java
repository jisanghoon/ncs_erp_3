package com.dgit.ncs;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dgit.ncs.dto.Employee;
import com.dgit.ncs.service.EmployeeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployMapperTest {
	EmployeeService service;

	@Before
	public void setUp() throws Exception {
		service = EmployeeService.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAInsertItem() {

		Employee employee;

		employee = new Employee();
		employee.setEno(17100);
		employee.setEname("홍길동");

		service.insert(employee);

		employee = new Employee();
		employee.setEno(17101);
		employee.setEname("갑순이");

		service.insert(employee);

	}

	@Test
	public void testBDelete() {
		service.delete(17101);
	}

	@Test
	public void testCUpdate() {
		Employee employee;

		employee = service.selectByNo(17100);
		employee.setEname("갑돌이");
		service.update(employee);

	}

	@Test
	public void testDSelect() {
		List<Employee> list = service.selectAll();

		for (Employee employee : list) {
			Assert.assertNotNull(employee);
			System.out.println(employee.toString());
		}
	}

	@Test
	public void testESelectOne() {
		Employee employee = service.selectByNo(17100);
		System.out.println();
		System.out.println(employee.toString());
		Assert.assertNotNull(employee);
	}

}
