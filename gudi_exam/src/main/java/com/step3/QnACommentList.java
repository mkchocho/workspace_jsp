package com.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QnACommentList {
	static int q_no = 0;
	public static void main(String[] args) {
		List<Map<String,Object>> qList = new ArrayList<>();
		Map<String,Object> qmap = new HashMap<>();
		qmap.put("q_no", 1);
		qmap.put("q_title", "8월 휴관일은 언제인가요?");
		qmap.put("q_writer", "치타");//회원집합에서 로그인을 했을 때 세션에 저장된 이름을 가져와서 넣어준다
		qList.add(qmap);
		qmap = new HashMap<>();
		qmap.put("q_no", 2);
		qmap.put("q_title", "썸머이벤트 기간은 언제까지인가요?");
		qmap.put("q_writer", "고양이");//m_name or  m_nickname
		qList.add(qmap);		
		List<Map<String,Object>> cList = new ArrayList<>();
		Map<String,Object> cmap = new HashMap<>();
		cmap.put("q_no", 2);
		cmap.put("c_no", 1);
		cmap.put("c_comment", "8월15일까지 입니다. 감사합니다.");
		cmap.put("c_writer", "관리자");
		cList.add(cmap);
		cmap = new HashMap<>();
		cmap.put("q_no", 1);
		cmap.put("c_no", 2);
		cmap.put("c_comment", "둘째주 일요일만 휴관입니다.");
		cmap.put("c_writer", "관리자");
		cList.add(cmap);
		//여기부터 집중 - 복습
		Map<String,Object> qcmap = new HashMap<>();
		qcmap.put("commentList", cList);
		qList.add(qcmap);
		System.out.println(qList);//[{},{},.....] - JSON포맷, ChartJS와 연계
		System.out.println(cList);//[{},{},.....] - JSON포맷, ChartJS와 연계
		
		//insert here -  두번째 답변을 읽어서 출력해보기
		int size = 0;
		size = qList.size();//3 or 4
		System.out.println(size);
		for(int i=0;i<size;i++) {
			Map<String,Object> rmap = qList.get(i);
			if(rmap.containsKey("commentList")) {
				System.out.println(rmap.get("q_no"));//2번출력된다. 아니다 1번만 출력된다.
				q_no = 2;
				System.out.println(rmap);
				//insert here - q_no=2라는 것을 알고 있다고 가정한다
				List<Map<String,Object>> rcList = null;
				//아래 코드 분석 되나요???
				rcList = (List)rmap.get("commentList");
				System.out.println(rcList.size());//2
				//어 for문이 또 필요하겠네!!!
				for(int j=0;j<rcList.size();j++) {//2
					//q_no가 2하고 같니? - qList가져와야 되나? 아니면 cList에서 가져오나요?
					Map map = rcList.get(j);
					if(q_no == Integer.parseInt(map.get("q_no").toString())) {
						System.out.println(map.get("c_comment"));
					}
					if(1 == 1) {
						System.out.println("q_no가 1번인 글에 대한 댓글이다 -> " + map.get("c_comment"));
					}
				}
				
			}//qList에서 댓글 내용만 꺼내기
		}//end of outter for
		
		
	}//end of main

}