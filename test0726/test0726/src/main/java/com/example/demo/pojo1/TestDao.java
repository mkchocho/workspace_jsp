package com.example.demo.pojo1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.example.demo.model.Test;
import com.util.MyBatisCommonFactory;

public class TestDao {
	public List<Test> selectList(Map<String, Object> pMap){
		List<Map<String, Object>> list = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("selectList", pMap);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
