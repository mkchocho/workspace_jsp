package com.example.demo.pojo1;

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
		//물리적으로 떨어져 있는 오라클 서버와 연결통로 확보함
		//아래 객체를 생성하려면 드라이버 클래스, 계정정보, SID명-orcl11, port번호-대문 - MapperConfig.xml
		//Connection과 PreparedStatement가 필요없어졌다
		SqlSessionFactory sqlSessionFactory = null;//sqlSession.commit(), sqlSession.rollback() 안됨 
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			//ResultSet - 오라클 커서를 조작하는데 필요한 메소드를 정의하고 있어요 
			//ResultSet이 인터페이스인 이유는 업무마다, domain마다 테이블명과 컬럼명이 다 다르다
			//그러니까 결정할 수 없다
			//sqlSession.commit(), sqlSession.rollback();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//메소드이름과 커리문의 id를 upmu[1]="noticeList", upmu[0]="notice"->NoticeController
			nList = sqlSession.selectList("noticeList", pMap);
			//하나. myBatis레이어에서 간섭하여 null이면 객체를 주입해줌
			//둘. 만일 개입이 없다면 null인 상태가 되어야 한다.
			//결론 : selectList의 반환타입이 null인 상태이라면 myBatis가 디폴트 객체를 주입해줌
			//nList = null;
			logger.info(nList.size());//하나 - 0, 만일 하나가 아닌경우라면 NullPointerException 발동 
			System.out.println(nList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return nList;
	}

	public int noticeInsert(Map<String, Object> pMap) {
		logger.info("noticeInsert");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;//sqlSession.commit(), sqlSession.rollback() 안됨 
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//upmu[1] == 메소드이름 == notice.xml의 id값
			result = sqlSession.insert("noticeInsert", pMap);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int noticeUpdate(Map<String, Object> pMap) {
		logger.info("noticeUpdate");
		int result = 0;
		
		//insert here
		SqlSessionFactory sqlSessionFactory = null;//sqlSession.commit(), sqlSession.rollback() 안됨 
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//upmu[1] == 메소드이름 == notice.xml의 id값
			result = sqlSession.update("noticeUpdate", pMap);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int noticeDelete(Map<String, Object> pMap) {
		logger.info("noticeDelete");
		int result = 0;
		
		
		//insert here
		SqlSessionFactory sqlSessionFactory = null;//sqlSession.commit(), sqlSession.rollback() 안됨 
		try {
			sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//upmu[1] == 메소드이름 == notice.xml의 id값
			result = sqlSession.delete("noticeDelete", pMap);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
