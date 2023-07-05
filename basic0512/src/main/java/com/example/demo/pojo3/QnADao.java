package com.example.demo.pojo3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class QnADao {
	Logger logger = Logger.getLogger(QnADao.class);
	//물리적으로 떨어져 있는 오라클 서버와 연결통로 확보
	SqlSessionFactory sqlSessionFactory = null;
	//쿼리문을 요청하고 커밋 또는 롤백 처리를 지원하는 객체 선언
	SqlSession sqlSession = null;
	//생성자 선언 - 객체 생성 - 객체주입
	public QnADao(){
		//new를 사용해서 객체생성 하는 것 보다 메소드를 통해 객체 생성하는 것이 더 고급이다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public List<Map<String, Object>> qnaList(Map<String, Object> pMap) {
		logger.info("qnaList");
		List<Map<String,Object>> qList =null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			qList = sqlSession.selectList("qnaList",pMap);
			logger.info(qList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qList;
	}

	public int qnaInsert(Map<String, Object> pmap) {
		logger.info("qnaInsert 호출 성공");
		int result = -1;
		sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("qnaInsert",pmap);
		sqlSession.commit();
		if(result==1) {
			logger.info("입력 성공");
		}//0인 경우는 굳이 안적어도 될 거 같아서 코드 작성하지 않음
		return result;
	}
}
