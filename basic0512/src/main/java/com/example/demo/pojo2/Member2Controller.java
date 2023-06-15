package com.example.demo.pojo2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
//1-2레벨에서는 Controller 인터페이스 추가하였다
//인퍼테이스에는 추상메소드 execute가 선언되어 있다
//추상메소드는 선언시 세미콜론으로 끝남 - 반드시 구현체 클래스가 있어야 한다.
//Member2Controller가 Controller 인터페이스의 구현체 클래스이다.
public class Member2Controller implements Controller {
	Logger logger = Logger.getLogger(Member2Controller.class);
	//다음 단계는 업무에 대한 결정과 선택을 할 수 있는 서비스 계층을 연결해 본다
	//객체주입 코드이다(인스턴스화를 말함-이른 인스턴스화로 처리함)
	//게으른 인스턴스화를 하면 시점의 문제를 해결할 수 있어야 함
	//이 문제를 해결하지 못하면 NullPointerException을 얻어 맞게 됨
	Member2Logic memberLogic = new Member2Logic();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		//컨트롤계층에서 리턴타입은 무엇으로 해야 하고 무엇을 담아야 하는지 고민해 본다 
		String[] upmu = (String[])req.getAttribute("upmu");
		String page = null;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+","+upmu[1]);
		//회원목록 조회
		//SELECT*FROM member0518
		if("memberList".equals(upmu[1])) {
			logger.info("회원목록조회");
			List<Map<String,Object>> mList = null;
			mList = memberLogic.memberList();
			page="forward:memberList"; //응답페이지 이름, select결과가 유지되어야 하니까 forward로 한다
 		}
		
		//회원정보 보기
		//SELECT*FROM member0518 WHERE mem_no=2
		else if("memberDetail".equals(upmu[1])) {
			logger.info("회원정보 보기");
			//pMap.get("mem_no")=>2
			hmb.bind(pMap);
			List<Map<String,Object>> mList = null;
			mList = memberLogic.memberList();
			page="forward:memberDetail"; //응답페이지 이름, select결과가 유지되어야 하니까 forward로 한다
		}
		//회원가입
		//INSERT INTO member0518 VALUES(?,?,?,......)
		//insert문의 반환값은 뭐지? -int-> 1 row inserted
		else if("memberInsert".equals(upmu[1])) {
			logger.info("회원가입");
			int result = 0;
			hmb.bind(pMap);
			result = memberLogic.memberInsert(pMap);
			if(result == 1) {
				page="redirect:memberList.pj2";
			}else {
				page="redirect:memberError";
			}
		}
		//회원정보수정
		//UPDATE member0518 SET mem_zipcode=?, mem_address=? WHERE mem_no=2
		else if("memberUpdate".equals(upmu[1])) {
			logger.info("회원정보수정");
			int result = 0;
			hmb.bind(pMap);
			result = memberLogic.memberUpdate(pMap);
			if(result == 1) {
				page="redirect:memberList.pj2";
			}else {
				page="redirect:memberError";
			}
		}
		//회원탈퇴
		//DELETE FROM member0518 WHERE mem_no=2
		//쿼리문을 보면 리턴타입과 파라미터 갯수나 타입을 정할 수가 있다. - 그래서 적어볼까
		else if("memberDelete".equals(upmu[1])) {
			logger.info("회원탈퇴");
			int result = 0;
			hmb.bind(pMap);
			result = memberLogic.memberDelete(pMap);
			if(result == 1) {
				page="redirect:memberList.pj2";
			}else {
				page="redirect:memberError";
			}
		}
		
		
		return null;
	}

}
