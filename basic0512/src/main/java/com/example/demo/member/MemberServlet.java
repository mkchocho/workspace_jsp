package com.example.demo.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
@SuppressWarnings("serial")
@WebServlet("/member/memberCRUD")
public class MemberServlet extends HttpServlet {
    Logger logger = Logger.getLogger(MemberServlet.class);
    MemberDao memberDao = new MemberDao();
    /* ************************************************************************************
     * 회원(CRUD)관리 구현
     * URL 패턴 : 	업무명(폴더명) - member 
     * 					호출이름 - memberCRUD
     * 쿼리스트링 - 조회 : ?method=memberSelect
     * SELECT mem_no, mem_id, mem_pw, mem_name FROM member0518;
     * 쿼리스트링 - 등록 : ?method=memberInsert
     * insert into member0518(mem_no,mem_id, mem_pw, mem_name) values(3,'banana','345', '나초보');
     * 쿼리스트링 - 수정 : ?method=memberUpdate															┗파라미터?
     * UPDATE member0518 
        		SET mem_name = '토마토'
  		WHERE mem_no = 1;
     * 쿼리스트링 - 삭제 : ?method=memberDelete
     * DELETE FROM member0518 WHERE mem_no=:x;
     * 
     	단위 테스트 해보고 작성하기 좋은습관
     *************************************************************************************/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Map<String,Object>> mList = null;
       int result = -1;
       String methodName = req.getParameter("method");//memberSelect or memberInsert or memberUpdate or memberDelete
       //리턴타입과 파라미터 결정해 보기 -  대화 - 소스리뷰
       HashMap<String,Object> pMap = new HashMap<>();
       HashMapBinder hmb = new HashMapBinder(req);
       hmb.bind(pMap);
       //회원 조회
       if("memberSelect".equals(methodName)) {//조건검색 경우라면 나도 (사용자가 입력한 정보가 )필요해
    	   logger.info("memberSelect");
    	   //여기에서는 mList가 null참조하는 상황-42번
    	   logger.info("before : "+mList);//아무것도 없음 {} []
    	   mList = memberDao.memberSelect(); //이 메소드 안에서 오라클 서버를 경유한 경우라면 더이상 null이 아님
    	   //[] - List -> ArrayList{List인터페이스이고 ArrayList구현체 클래스임}
    	   //{} - Map<String, Object>
    	   logger.info("after : "+mList);//[{},{},{},{}] - 객체배열 형태임
       }
       //회원 등록
       //사용자가 입력한 값을 파라미터를 통해서 넘겨야 합니다.
       //쿼리문을 작성한 이유는 화면은 없지만 쿼리문을 보고 사용자가 입력한 정보들을 생각(상상, 예측)해 보자
       //insert into member0518(mem_no,mem_id, mem_pw,mem_name) values(3,'banana','345','나초보');
       else if("memberInsert".equals(methodName)) {
    	   result = memberDao.memberInsert(pMap);
    	   
       }
       //회원 수정
       else if("memberUpdate".equals(methodName)) {
    	   result = memberDao.memberUpdate(pMap);
    	   
       }
       //회원 삭제
       //DELETE FROM member0518 WHERE mem_no=:x 숫자타입 number(5)
       else if("memberDelete".equals(methodName)) {
    	   //사용자가 선택한 회원일련번호
    	   String mem_no = req.getParameter("mem_no");//문자열
    	   int user_no =0;
    	   user_no = Integer.parseInt(mem_no);//1저장
    	   logger.info("사용자가 삭제를 선택한 회원 일련번호 : "+user_no);
    	   result = memberDao.memberDelete(user_no);
    	   
       }
       mList = memberDao.memberList();
       req.setAttribute("mList", mList);
       RequestDispatcher view = req.getRequestDispatcher("memberList.jsp");
       view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
    
}