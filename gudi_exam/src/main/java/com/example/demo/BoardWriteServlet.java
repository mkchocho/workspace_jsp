package com.example.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class BoardWriteServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardWriteServlet.class);
	//나는 BoardWriteServlet의 단위테스트할 수 있는 URL을 작성할 수 있다. - web.xml
	//Restful API의 get방식과 post방식을 굳이 메소드로 나눌 필요가 없다면 service메소드도 가능함
	//service와 doService는 다름 (부모서블릿-HttpServlet이 가지고 있는 메소드 재정의 가능 → service)
	//서블릿안에서 사용자 정의 메소드를 선언할 수 있지만 파라미터로 톰캣으로부터 요청객체와 응답객체를 주입받지 못한다. - 함정
	//메소드이름을 마음대로 추가할 수 있지만 톰캣서버로 부터 객체주입을 못받으니까 NullPointerException이 발생함
	//doService는 사용자 정의 메소드이지만 그냥 service는 HttpServlet에서 정의된 메소드 이므로
	//파라미터 자리에 req, resp를 사용가능하다
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("service");
		System.out.println("BoardWriteServelet service호출");
		// 사용자가 입력한 제목 읽어오기
		String boardTitle = req.getParameter("boardTitle");
		logger.info(boardTitle);
		// 사용자가 입력한 작성자 읽어오기
		String boardWriter = req.getParameter("boardWriter");
		// 사용자가 입력한 내용 읽어오기
		String boardContent = req.getParameter("boardContent");
		//사용자가 입력한 값 Board.java에 담기
		Board bVO = new Board(); //파라미터를 이를테면 100개를 넘길 수 없기 때문에 담아줌 - 사용자가 입력한 값을  
		bVO.setBoardTitle(boardTitle);
		bVO.setBoardWriter(boardWriter);
		bVO.setBoardContent(boardContent);
		BoardService bService = new BoardService();
		int result = -1;
		result = bService.boardInsert(bVO);//전역변수에 값을 담아 파라미터로 넘김 
		if(result ==1) {
			System.out.println("글쓰기 성공");
		}else {
			System.out.println("글쓰기 실패");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BoardWriteServelet doPost");
	}
	
}