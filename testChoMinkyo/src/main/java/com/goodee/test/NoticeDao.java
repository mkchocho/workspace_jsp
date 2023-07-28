package com.goodee.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
//NoticeDao와 오라클 서버 사이에는 myBatis강이 흐른다
public class NoticeDao {
	Logger logger = Logger.getLogger(NoticeDao.class);

	public List<Map<String, Object>> noticeList(Map<String, Object> pMap) {
		logger.info("noticeList");
		List<Map<String, Object>> nList = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			nList = sqlSession.selectList("noticeList", pMap);
			logger.info(nList.size());
			System.out.println(nList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nList;
	}

	public int noticeInsert(Map<String, Object> pMap) {
		logger.info("noticeInsert");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.insert("noticeInsert", pMap);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
