package org.gradle;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dgit.ncs.setting.MybatisSessionFactory;

public class MybatisSessionFactoryTest {
	SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testOpenSession() {
		// fail("Not yet implemented");
		sqlSession = MybatisSessionFactory.openSession();
	}

}
