package com.example.demo.pojo2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class OrderDao {
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	Logger logger = Logger.getLogger(OrderDao.class);
	public OrderDao() {//파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public List<Map<String, Object>> orderList(Map<String, Object> pMap) {
		logger.info("orderList");
		List<Map<String, Object>> oList = null;
		try {
			//SqlSession을 생성하려면 먼저 SqlSessionFactory를 생성한다
			//어디서 했니 -> 생성자에서 진행함
			sqlSession = sqlSessionFactory.openSession();
			oList = sqlSession.selectList("orderList",pMap);
			//주의 : 커밋이나 롤백의 대상이 아니다
			logger.info(oList);
		} catch (Exception e) {
			//logger.info(e.toString());
			//logger.info(e.getMessage());
			e.printStackTrace();//에러메시지와 라인번호까지 같이 출력
		}
		return oList;
	}
	public int orderInsert(Map<String, Object> pMap) {
		logger.info("orderInsert");
		int result = -1;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.insert("orderInsert",pMap);
			logger.info("insert문 요청시 오라클 서버에서 처리 후에 반환값: "+result);
			sqlSession.commit();//auto커밋 모드가 꺼져 있어서 반드시 따로 commit()호출해야 반영됨
		} catch (Exception e) {
			logger.info(e.toString());//발생한 익셉션의 이름만 출력해줌-디버깅하는데 그다지 도움이 덜됨
		}
		return result;
	}
	public int orderUpdate(Map<String, Object> pMap) {
		logger.info("orderUpdate");
		int result = -1;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("orderUpdate",pMap);
			logger.info("update문 요청시 오라클 서버에서 처리 후에 반환값: "+result);
			sqlSession.commit();//auto커밋 모드가 꺼져 있어서 반드시 따로 commit()호출해야 반영됨
		} catch (Exception e) {
			logger.info(e.toString());//발생한 익셉션의 이름만 출력해줌-디버깅하는데 그다지 도움이 덜됨
		}
		return result;
	}
	public int orderDelete(Map<String, Object> pMap) {
		logger.info("orderDelete");
		int result = -1;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("orderDelete",pMap);
			logger.info("delete문 요청시 오라클 서버에서 처리 후에 반환값: "+result);
			sqlSession.commit();//auto커밋 모드가 꺼져 있어서 반드시 따로 commit()호출해야 반영됨
		} catch (Exception e) {
			logger.info(e.toString());//발생한 익셉션의 이름만 출력해줌-디버깅하는데 그다지 도움이 덜됨
		}
		return result;
	}

}
