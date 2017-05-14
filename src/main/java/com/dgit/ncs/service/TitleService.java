package com.dgit.ncs.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.ncs.dto.Title;
import com.dgit.ncs.mappers.TitleMapper;
import com.dgit.ncs.setting.MybatisSessionFactory;

public class TitleService implements TitleMapper<Title> {
	private static final Logger logger = Logger.getLogger(TitleService.class);
	private static TitleService instance;

	public static TitleService getInstance() {
		if (instance == null) {
			instance = new TitleService();
		}
		return instance;
	}

	private TitleService() {
	}

	@Override
	public void insert(Title item) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		TitleMapper titleDao = sqlSession.getMapper(TitleMapper.class);
		try {
			titleDao.insert(item);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		TitleMapper titleDao = sqlSession.getMapper(TitleMapper.class);
		try {
			titleDao.delete(idx);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void update(Title item) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		TitleMapper titleDao = sqlSession.getMapper(TitleMapper.class);
		try {
			titleDao.update(item);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public List<Title> selectAll() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		TitleMapper titleDao = sqlSession.getMapper(TitleMapper.class);
		try {
			List<Title> returnList = titleDao.selectAll();
			return returnList;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Title selectByNo(int idx) {
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		TitleMapper titleDao = sqlSession.getMapper(TitleMapper.class);
		try {
			Title title = (Title) titleDao.selectByNo(idx);
			return title;
		} finally {
			sqlSession.close();
		}
	}

}
