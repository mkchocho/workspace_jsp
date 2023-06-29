package com.example.demo;
//Service 계층의 클래스 설계시 이 안에 DB연동 코드를 담지 않아야 한다.
//왜냐면 오라클 서버에서 mySQL서버로 이관하였다고 가정해볼 때

public class BoardService {
	BoardDao boardDao = new BoardDao();
public int boardInsert(Board bVO) {
	System.out.println("BoardService:" + bVO);
	int result = -1; //1:성공, 0:실패
	result = boardDao.boardInsert(bVO);
	return result;
}
}
