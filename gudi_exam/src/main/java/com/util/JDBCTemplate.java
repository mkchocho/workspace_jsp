package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTemplate {
	//변수앞에 final이면 상수이다.
	//변수앞에 static이면 하나다. 클래스급이다.
	private final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String _URL = "jdbc:oracle:thin:@172.16.2.8:1521:orcl11";
    private final static String _USER = "tomato";
    private final static String _PW = "tiger";
    private static JDBCTemplate instance = new JDBCTemplate();
    Connection con = null;
    PreparedStatement pstmt = null;//자바에서 오라클 서버로 DML을 전달함 - 그리고 처리해줘
    ResultSet rs = null;//커서를 움직임 - 다음, 이전으로 rs.next(), rs.previous(), rs.isFirst(), rs.isLast()
	private JDBCTemplate() {} //인스턴스화를 여러번하지 못하도록 private로 잠굼 - 싱글패턴으로 하기
	public static JDBCTemplate getInstance() { //싱글톤 패턴을 적용한 코드임
		if(instance==null)
			instance = new JDBCTemplate();
		return instance;
	}
	//오라클서버와 연결통로
	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL,_USER,_PW);
		} catch (Exception e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			return null;
		}
		return con;
	}
	//사용한 자원 반납하기 - 스프링을 사용하면 이런 걸 안해도 됨 - 자동으로 해줌
	//반납하지 않으면 어떻게 되나요? 자바가상머신이 해줌 - 명시적으로 해주는 걸 원함 - 시스템 엔지니어
	//생성된 역순으로 반납합니다.
	//select일 때만
	//왜 인터페이스로 정의한 걸까요? 정할 수 가 없음 - 케이스마다 달라지니까,
	//한가지로 정할 수 없다면 인터페이스로 설계가능함
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//insert|update|delete
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

/*
 Java JDBC 사용하지 않음-반복 -> myBatis[쿼리문을 xml문에 작성함] -> JPA[쿼리문이 없다-hibernate]
 쿼리문 대신 클래스 설계를 해야 함 - 롬복
	 1. 드라이버 클래스를 로딩한다.
	 2. 물리적으로 떨어져 있는 서버와 연결통로를 만든다
	 	계정 : scott/tiger, ip address, 포트번호, service name (SID)
	 3. 쿼리문을 요청하기(Statement, PreparedStatement - 전령)
	 	DML처리해줘 (데이터 조작어 - SELECT : commit이나 rollback 대상이 아님 but INSERT|UPDATE|DELETE 대상임)
	 4. 커서를 이동하면서 데이터를 한 로우씩 꺼내오기(select 문일때만 필요함)
 */
