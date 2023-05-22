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
    DBConnectionMgr dbMgr = null;//선언만 되었다. 객체가 생성되지 않았다(사용하면 NullPointerException발생)
    //선언만 했다 - 재정의 , 재생성 해야 되니까(입력, 수정, 삭제, 조회)
    Connection con = null;
    //전령의 역할 - 쿼리문(DML)을 오라클 서버에게 전달하고 처리를 요청(executeQuery():select-조회, executeUpdate():INS|UPD|DEL):int한다
    PreparedStatement pstmt = null;
    //오라클 살고 있는 커서를 움직이는 메소드를 재정의하고 있는 인터페이스 이다 
    ResultSet rs = null;
    //아래는 MemberDao 클래스의 디폴트(파라미터가 한개도 없는) 생성자이다.
    public MemberDao() {
       dbMgr = DBConnectionMgr.getInstance();
    }
    public List<Map<String,Object>> memberList(){
       logger.info("memberList");
       List<Map<String,Object>> mList = new ArrayList<>();
       StringBuilder sql = new StringBuilder();
       sql.append("SELECT mem_id, mem_pw, mem_name FROM member0518");
       try {
          con = dbMgr.getConnection();
          pstmt = con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
          Map<String,Object> rmap = null;
          //rs.next()호출하면 커서가 다음 행으로 가 버림
          //rs.next();
          //rs.next();
          //위(while문앞에서)에서 두 번 rs.next하면 while문은 한 번만 실행됨.
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
    //회원 목록 조회 구현
	public List<Map<String, Object>> memberSelect(HashMap<String, Object> pMap) {
		logger.info("memberSelect");
		//List<Map<String, Object>> mList = null;
		List<Map<String, Object>> mList = new ArrayList<>();//NullPointerException을 피할 수 있다
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_no, mem_id, mem_pw, mem_name, mem_address");
		sql.append(" FROM member0518");
		// member/memberCRUD?method=memberSelect
		//																	&gubun=(mem_id|mem_name|mem_address) - 컬럼명
		//																	&keyword=나|tom|가산동 
		
		//너 분류를 선택했어?
		if(pMap.get("gubun")!=null && !"분류선택".equals(pMap.get("gubun"))) {
			if("mem_id".equals(pMap.get("gubun"))) {//너 뭘 찾고 싶어? 너 아이디로 검색할 거야?
				sql.append(" WHERE mem_id LIKE '%'||?||'%'");
			}else if("mem_name".equals(pMap.get("gubun"))) {
				sql.append(" WHERE mem_name LIKE '%'||?||'%'");
			}else if("mem_address".equals(pMap.get("gubun"))) {
				sql.append(" WHERE mem_address LIKE '%'||?||'%'");
			}
		}else {
			logger.info("조건 검색이 아닐 때 ");
			//이 조건일 때는 그냥 전체 조회를 하면 되는 거야. where절이 필요 없는 거야
		}
		logger.info(sql.toString());
		
		try {
			//물리적으로 떨어져 있는 오라클 서버에 연결하기
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());//선언 된 쿼리문을 읽기 
			//여기서? 자리에 치환될 값을 결정해 줘야해!!! - 왜냐면?
			if(pMap.get("gubun")!=null && !"분류선택".equals(pMap.get("gubun"))) {//너 조건검색을 원해? 그러면 ? 자리에 keyword를 치환해 줘야돼 아니면 500번 에러야 
				pstmt.setString(1,pMap.get("keyword").toString()); //toString-Object에서 String으로 형변환 , ?는 문자열
			}
			rs = pstmt.executeQuery();
			
			
			Map<String, Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("mem_no", rs.getInt("mem_no"));
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				rmap.put("mem_address", rs.getString("mem_address"));
				mList.add(rmap);
			}
			logger.info(mList);//4사람의 정보가 출력됨				
		} catch (Exception e) {
			//try.catch 바디에 문제가 없으면 실행기회는 없다
			logger.info("Exception : "+e.toString());//익셉션의 이름을 출력해줌
		}
		//memberList() 경유하지 않았다
		logger.info(mList.size());//0
		return mList;
		//return null;
	}
	//회원 가입 구현
	public int memberInsert(HashMap<String, Object> pMap) {
		logger.info("memberInsert");
		logger.info("사용자가 입력한 값 : " + pMap);
		return 0;
	}
	public int memberUpdate(HashMap<String, Object> pMap) {
		logger.info("memberUpdate");
		logger.info("사용자가 입력한 값 : " + pMap);
		return 0;
	}
	public int memberDelete(int user_no) {
		logger.info("memberDelete");
		logger.info("사용자가 입력한 값 : " + user_no);//1
		return 0;
	}
}////end of MemberDao
