package org.gradle;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dgit.ncs.dto.Department;
import com.dgit.ncs.dto.Employee;
import com.dgit.ncs.service.DepartmentService;
import com.dgit.ncs.service.TitleService;

public class DepartmentServiceTest {

	DepartmentService service;

	@Before
	public void setUp() throws Exception {
		service = DepartmentService.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertItem() {
		//fail("Not yet implemented");
		
		
		
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

		List<Department> list = service.selectAll();

		for (Department department : list) {
			Assert.assertNotNull(department);
			System.out.println(department.toString());
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
