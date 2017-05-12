package org.gradle;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dgit.ncs.dto.Title;
import com.dgit.ncs.service.TitleService;

public class TitleServiceTest {

	TitleService service;

	@Before
	public void setUp() throws Exception {
		service = TitleService.getInstance();
	}

	@Test
	public void testSelectAll() {
		// fail("Not yet implemented");
		List<Title> list = service.selectAll();

		for (Title title : list) {
			Assert.assertNotNull(title);
			System.out.println(title.toString());
		}

	}

	/*@Test
	public void testSelectByNo() {
		// fail("Not yet implemented");
		Title title = service.selectByNo(1);
		Assert.assertNotNull(title);

		System.out.println();
		System.out.println(title.toString());
	}

	@Test
	public void testInsertItem() {
		// fail("Not yet implemented");
		Title title = new Title();
		title.setTname("인턴");
		service.insert(title);

		Title lastItem = service.selectLast();
		System.out.println();
		System.out.println(lastItem.toString());
		//Assert.assertEquals("인턴", lastItem.getTname());

	}*/

	@Test
	public void testDeleteItem() {
		// fail("Not yet implemented");
		//service.delete(1);
	}

	/*
	 * @Test public void testUpdateItem() { // fail("Not yet implemented");
	 * Title title = service.selectByNo(1); System.out.println("수전 전 : " +
	 * title.toString()); title.setTname("회장");
	 * 
	 * }
	 */

}
