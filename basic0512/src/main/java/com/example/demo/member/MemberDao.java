package com.example.demo.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.util.DBConnectionMgr;
public class MemberDao {
    Logger logger = Logger.getLogger(MemberDao.class);
    //getConnection메소드를 호출하려고 선언함
    DBConnectionMgr dbMgr = null;//선언만 되었다. 객체가 생성되지 않았다(사용하면 NullPointException 발생)
   //선언만 했다 -재정의, 재생성해야 되니까(입력,  수정, 삭제, 조회)
    Connection con = null;
    //전령의 역할-쿼리문(DML)을 오라클 서버에게 전달하고 처리를 요청(executeQuery(), executeUpdate():INS|UPD|DEL)한다
    PreparedStatement pstmt = null;
    //오라클에 살고 있는 커서를 움직이는 메소드를 재정의하고 있는 인터페이스 이다
    ResultSet rs = null;
    public MemberDao() {
       dbMgr = DBConnectionMgr.getInstance();
    }
    public List<Map<String,Object>> memberList(){
       logger.info("memberList");
       List<Map<String,Object>> mList = new ArrayList<>();
       StringBuilder sql = new StringBuilder();
       sql.append("SELECT mem_id, mem_pw, mem_name FROM member230516");
       try {
          con = dbMgr.getConnection();
          pstmt = con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
          Map<String,Object> rmap = null;
          
          //rs.next()호출하면 커서가 다음 행으로 가 버림
          //rs.next();
          //rs.next();
          //위(while문 앞에서)에서 두 번 rs.next하면 while문은 한 번만 실행됨.
          while(rs.next()) {//2번째 행부터 조회가 된다
             rmap = new HashMap<>();
             rmap.put("mem_id", rs.getString("mem_id"));
             rmap.put("mem_pw", rs.getString("mem_pw"));
             rmap.put("mem_name", rs.getString("mem_name"));
             mList.add(rmap);
          }
          logger.info(mList);
       } catch (SQLException se) {
          logger.info(se.toString());
       } catch (Exception e) {
          logger.info(e.toString());
       }
       return mList;
    }//end of memberList
    public static void main(String[] args) {
		MemberDao mDao = new MemberDao();
		List<Map<String,Object>> mList = mDao.memberList();
		System.out.println(mList);
	}
}////end of MemberDao