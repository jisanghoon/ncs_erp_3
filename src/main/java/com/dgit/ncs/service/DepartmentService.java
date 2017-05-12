package com.dgit.ncs.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.ncs.dto.Department;
import com.dgit.ncs.dto.Title;
import com.dgit.ncs.mappers.DepartmentMapper;
import com.dgit.ncs.mappers.TitleMapper;
import com.dgit.ncs.setting.MybatisSessionFactory;

public class DepartmentService implements DepartmentMapper<Department> {

	private static final Logger logger = Logger.getLogger(DepartmentService.class);
	private static DepartmentService instance;

	public static DepartmentService getInstance() {
		if (instance == null) {
			instance = new DepartmentService();
		}
		return instance;
	}

	private DepartmentService() {
	}

	@Override
	public void insert(Department item) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		DepartmentMapper dDao = sqlSession.getMapper(DepartmentMapper.class);
		try {
			dDao.insert(item);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void delete(int idx) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		DepartmentMapper dDao = sqlSession.getMapper(DepartmentMapper.class);
		try {
			dDao.delete(idx);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void update(Department item) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		DepartmentMapper dDao = sqlSession.getMapper(DepartmentMapper.class);
		try {
			dDao.update(item);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Department> selectAll() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		DepartmentMapper dDao = sqlSession.getMapper(DepartmentMapper.class);
		try {
			List<Department> returnList = dDao.selectAll();
			return returnList;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Department selectByNo(int idx) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		DepartmentMapper dDao = sqlSession.getMapper(DepartmentMapper.class);
		try {
			Department deparment = (Department) dDao.selectByNo(idx);
			return deparment;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Department selectLast() {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		DepartmentMapper dDao = sqlSession.getMapper(DepartmentMapper.class);
		try {
			Department deparment = (Department) dDao.selectLast();
			return deparment;
		} finally {
			sqlSession.close();
		}
	}

}
