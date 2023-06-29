package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.util.JDBCTemplate;
//JDBC API를 이용해서 오라클 연동하기 - myBatis배제함
public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	//선언부 - 선언만 했음 - 이른 인스턴스화가 아니다
	JDBCTemplate jt = null;//어디서 객체를 주입받나요?
	Connection con = null;
	PreparedStatement pstmt = null;
	public int boardInsert(Board bVO) {
		System.out.println("BoardDao : "+bVO);
		jt=JDBCTemplate.getInstance();//여기서 주입 받음- 더 이상 jt는 널이 아니다.
		int result = -1;
		StringBuilder sql = new StringBuilder();
		//왜 try..catch 블록에 작성하나? 네트워크, 스레드, IO
		try {
			sql.append("insert into board(boardnum, boardwriter, boardtitle, boardcontent, boarddate)");
			sql.append(" values(seq_board_no.nextval,?,?,?,to_char(sysdate,'YYYY-MM-DD'))");
			//결론:인터페이스는 단독으로 인스턴스화 할 수 없어서 메소드를 통해서 객체주입 받음 
			con = jt.getConnection();//Connection은 인터페이스임 - 메소드로 객체주입됨
			System.out.println(con);//con의 주소번지 출력하기
			pstmt = con.prepareStatement(sql.toString()); //insert문을 스캔함 -?가 몇개인지 알 수 있음 
			pstmt.setString(1, bVO.getBoardWriter());
			pstmt.setString(2, bVO.getBoardTitle());
			pstmt.setString(3, bVO.getBoardContent());
			result = pstmt.executeUpdate();
			logger.info(result);//1이면 등록 성공, 0이면 등록 실패
		} catch (Exception e) {
			e.printStackTrace();//stack영역에 쌓이는 로그메시지 출력해줌 
		}
		return result;
	}
	public static void main(String[] args) {
		BoardDao bd = new BoardDao();
		//글등록을 테스트하는 경우라면 null이 아니라 사용자가 입력한 값을 쥐고 있는 Board넘겨줌 
		bd.boardInsert(null);
	}
}
