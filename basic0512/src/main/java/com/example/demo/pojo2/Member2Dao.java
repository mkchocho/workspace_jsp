package com.example.demo.pojo2;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

// 오라클 서버와 연동하기
// 입력|수정|삭제|조회 담당함
// XXXDao도 넓은 의미에서는 모델 계층에 해당함
// XXXDao클래스가 있고 없고는 MVC패턴을 결정짓는 인자가 아니다.
// 여기서는 왜 굳이 사용하나요? - myBatis를 사용하니까 그래서 사용하자 - 제안
public class Member2Dao {
	Logger logger = Logger.getLogger(Member2Dao.class);	
	//myBatis Layer 설정 바탕으로 객체 주입이 필요하다
	SqlSessionFactory sqlSsSessionFactory = null; // 오라클 서버 접속
	SqlSession sqlSession = null; //커밋과 롤백 담당 
}
