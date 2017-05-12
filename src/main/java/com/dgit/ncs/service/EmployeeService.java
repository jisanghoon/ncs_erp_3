package com.dgit.ncs.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.ncs.dto.Employee;
import com.dgit.ncs.dto.Title;
import com.dgit.ncs.mappers.EmployeeMapper;
import com.dgit.ncs.mappers.TitleMapper;
import com.dgit.ncs.setting.MybatisSessionFactory;

public class EmployeeService implements EmployeeMapper<Employee> {
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	private static EmployeeService instance;

	public static EmployeeService getInstance() {
		if (instance == null) {
			instance = new EmployeeService();
		}
		return instance;
	}

	private EmployeeService() {
	}

	@Override
	public void insert(Employee item) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
		try {
			employeeDao.insert(item);
			sqlSession.commit();
		} finally {
			
			sqlSession.close();
		}
	}

	@Override
	public void delete(int idx) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
		try {
			employeeDao.delete(idx);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void update(Employee item) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
		try {
			employeeDao.update(item);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public List<Employee> selectAll() {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
		try {
			List<Employee> returnList = employeeDao.selectAll();
			return returnList;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Employee selectByNo(int idx) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
		try {
			Employee employee = (Employee) employeeDao.selectByNo(idx);
			return employee;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Employee selectLast() {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
		try {
			Employee employee = (Employee) employeeDao.selectLast();
			return employee;
		} finally {
			sqlSession.close();
		}
	}
}
