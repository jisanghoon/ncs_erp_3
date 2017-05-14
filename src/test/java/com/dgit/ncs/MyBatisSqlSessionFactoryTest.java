package com.dgit.ncs;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dgit.ncs.setting.MybatisSessionFactory;

public class MyBatisSqlSessionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyBatisSqlSessionFactory() {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
	}

}
