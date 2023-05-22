package com.example.demo.member;

import java.io.IOException;
import java.io.PrintWriter;
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



/*
 * 개발자 입장에서 보면 get 방식이든 post방식이든
 * 처리를 해주어야 하는 것은 같다
 * 
 */

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
     * WHERE mem_no=? -> 메소드의 파라미터 자리에 온 값이다. 타입이다. 
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
    //get방식으로 요청을 받든 아니면 post방식으로 요청을 받든 메소드를 하나로 통일하자
    //메소드 오버라이딩을 이용하지 않고 사용자 정의 메소드를 추가하여서 처리를 해 본다
    //파라미터로 주입받는 요청객체와 응답객체를 다른 메소드에 넘길 수 있다
    //@Override doService 앞에는 오버라이드 어노테이션을 쓸 수가 없음
    // 왜냐면 HttpServlet이 제공하는 메소드에만 쓸 수 있으니까...
    //서블릿이 되기 위해서는 반드시 HttpServlet을 상속 받아야 한다 -그래야 자바가 아니라 서블릿이라고 불린다.
    //그럼 왜 서블릿이 되어야 하나요? - 웹 서비스를 제공해야 하니까
    
    public void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	List<Map<String,Object>> mList = null;
        int result = -1;
        String methodName = req.getParameter("method");//memberSelect or memberInsert or memberUpdate or memberDelete
        //리턴타입과 파라미터 결정해 보기 -  대화 - 소스리뷰
        //지워야 한다 - 왜냐하면 입력, 수정, 삭제, 조건 검색일 때 모두 다른 케이스 이므로 조건절로 위치를 옮겼다
        //회원 조회
        if("memberSelect".equals(methodName)) {//조건검색 경우라면 나도 (사용자가 입력한 정보가 )필요해
     	   logger.info("memberSelect");
     	   //여기에서는 mList가 null참조하는 상황-42번
     	   logger.info("before : "+mList);//아무것도 없음 {} []
     	  HashMap<String,Object> pMap = new HashMap<>();
          HashMapBinder hmb = new HashMapBinder(req);
          hmb.bind(pMap);
     	   mList = memberDao.memberSelect(pMap); //이 메소드 안에서 오라클 서버를 경유한 경우라면 더이상 null이 아님
           req.setAttribute("mList", mList);
           RequestDispatcher view = req.getRequestDispatcher("memberList.jsp");
           view.forward(req, resp);
     	   //[] - List -> ArrayList{List인터페이스이고 ArrayList구현체 클래스임}
     	   //{} - Map<String, Object>
     	   logger.info("after : "+mList);//[{},{},{},{}] - 객체배열 형태임
        }//end of 회원조회
        
        //회원 등록
        //사용자가 입력한 값을 파라미터를 통해서 넘겨야 합니다.
        //쿼리문을 작성한 이유는 화면은 없지만 쿼리문을 보고 사용자가 입력한 정보들을 생각(상상, 예측)해 보자
        //insert into member0518(mem_no,mem_id, mem_pw,mem_name) values(3,'banana','345','나초보');
        else if("memberInsert".equals(methodName)) {
        	HashMap<String,Object> pMap = new HashMap<>();
            HashMapBinder hmb = new HashMapBinder(req);
            hmb.bind(pMap);
     	   result = memberDao.memberInsert(pMap);
     	   
        }//end of 회원등록
        //회원 수정
        else if("memberUpdate".equals(methodName)) {
        	HashMap<String,Object> pMap = new HashMap<>();
            HashMapBinder hmb = new HashMapBinder(req);
            hmb.bind(pMap);
     	   result = memberDao.memberUpdate(pMap);
     	   
        }//end of 회원수정
        //회원 삭제
        //DELETE FROM member0518 WHERE mem_no=:x 숫자타입 number(5)
        else if("memberDelete".equals(methodName)) {
     	   //사용자가 선택한 회원일련번호
     	   String mem_no = req.getParameter("mem_no");//문자열
     	   int user_no =0;
     	   user_no = Integer.parseInt(mem_no);//1저장
     	   logger.info("사용자가 삭제를 선택한 회원 일련번호 : "+user_no);
     	   result = memberDao.memberDelete(user_no);
     	   
        }//end of 회원삭제
        //mList = memberDao.memberList(); - CRUD를 조건문으로 분기하면서 memberSelect영역으로 이관했음
        //forward를 연속해서 두 번 요청하게 되면 서버에러(500번을 던짐)가 발생함

    }
    
    //Restful API에서 리소스에 대한 전송하는 방식을 제안하고 있다. - doGet, doPost 선언 해두었다.
    //파라미터를 통해서 톰캣 서버로 부터 주입 받은 요청객체와 응답 객체를 사용자 정의 메소드의 파라미터로 호출하여 넘긴다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doService(req, resp);
    	
    }
    
}