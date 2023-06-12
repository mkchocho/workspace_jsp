package com.example.demo.pojo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//카카오 컨트롤러도 서블릿이 아니어도 좋다.
//카카오로그인 버튼 클릭 -> https://kauth.kakao.com/oauth/authorize?client_id=REST ful 키&redirect_uri(콜백부분)=http://localhost:9000/auth/kakao/callback&response_type=code
public class KakaoController { 
	Logger logger = Logger.getLogger(KakaoController.class);

	public String kakaoCallback(HttpServletRequest req, HttpServletResponse res) {
		logger.info("kakaoCallback");
		//카카오 로그인 클릭시 카카오 서버에 요청(응답화면도 카카오서버가 제공함)을 하고 요청에 대한 응답
		//코드를 받아옴
		String code = req.getParameter("code");
		logger.info(code);
		
		String tokenURL ="https://kauth.kakao.com/oauth/token";
//		"grant_type", "authorization_code"
//		"client_id", "e1653c977ff9fd8b703e6844097d7f36"
//		"redirect_uri", "http://localhost:9000/auth/kakao/callback"
//		"code", code
		
		//카카오 서버측에서 응답으로 보내주는 토큰값 읽어오기
		BufferedReader br = null; //filter 스트림 클래스이고 네트워크 요청에 대한 응답을 읽기위해
		try {
			URL url = new URL(tokenURL);
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("grant_type","authorization_code");
			pMap.put("client_id","e1653c977ff9fd8b703e6844097d7f36");
			pMap.put("redirect_uri","http://localhost:9000/auth/kakao/callback");
			pMap.put("code", code);//code는 계속 바뀜, 변수처리
			//위에서 정의한 정보들을 POST방식으로 헤더에 담기 
			StringBuilder postData = new StringBuilder();
			for(Map.Entry<String,Object> params : pMap.entrySet()) {//pMap.entrySet() 키값 받아옴
				if(postData.length()!=0) postData.append("&");
				postData.append(URLEncoder.encode(params.getKey(),"UTF-8"));
				postData.append("=");
				postData.append(URLEncoder.encode(String.valueOf(params.getValue()),"UTF-8"));
			}//end of for
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			//Stream연결
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			System.out.println(conn);//토큰을 발급해 주는 요청에 대해서 연결이 잘 되면... 
			//http 헤더값 넣기
			//POST 방식으로 요청하기
			conn.setRequestMethod("POST");
			//POST 방식으로 사용자가 입력한 값을 넘길 때 추가되는 설정임 - postman
			conn.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			//보내는 데이터 길이 - Tomcat에서 카카오서버측에 보내는 메시지의 길이 계산 
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			//서버측에서 보내온 데이터를 출력할 수 있는 상태인지 체크
			conn.setDoOutput(true);
			//POST방식으로 호출하기
			conn.getOutputStream().write(postDataBytes);
			//여기까지는 카카오 서버측에 요청하기
			//아래부터는 카카오 서버측의 응답 받아오기
			//BufferedReader는 필터스트림 클래스로 단독으로는 읽을 수가 없어서
			//반드시 단독으로 읽을 수 있는 InputStreamReader와 연결해서 읽어올 수 있다.
			//만일 BufferedReader를 사용하지 않으면 read메소드만 사용가능한데 BufferedReader를 사용했기에
			//readLine메소드를 누릴 수 있는 것이다
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String inputLine = null;
			StringBuilder sb = new StringBuilder();
			while((inputLine=br.readLine()) != null) {
				sb.append(inputLine);
			}//end of while - 네트워크 통해서 넘어오는 패킷을 읽어서 StringBuuilder에 담기
			String jsonStr = sb.toString();
			//아래서 출력되는 값은 인증코드를 POST방식으로 카카오 측에 요청하면 응답으로 보내주는 토큰값을 받기 위해서 작성함
			logger.info(jsonStr); //카카오 서버측에서 콜백 URL을 등록한 경우 그 경로로 응답메시지를 전송하고 그 값을 출력함
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "카카오로그인콜백";
	}
}
