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
		//sqlSessionFactory is null -> NullPointerException 
		//오라클서버가 The Network Adapter 어쩌구저쩌구... - 오라클 서버가 정상이 아님
		//체크방법 - 작업관리자 - 서비스 - Oracle Service 실행중인지 체크할 것
		//클래스 컴파일이 제대로 되고 있지 않다 - git에서 내려받는 경우
		//build경로에 파일을 모두 삭제했다가 서버를 재기동해서 현재 시간으로 컴파일된 파일이 생성되는지 체크함 
		//ip address, port number, scott/tiger
		//ClassNotFoundException - ojdbc6.jar /1.배포확인 2.build path 등록  
		sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("qnaInsert",pmap);
		if(result==1) {
			logger.info("입력 성공");
			//물리적인 테이블에 반영하기 - 이걸 안하면 이미지만 가지고 있는 상태임 
			sqlSession.commit();
		}//0인 경우는 굳이 안적어도 될 거 같아서 코드 작성하지 않음
		return result;
	}
}
