package com.example.demo.pojo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepleExam {

	public static void main(String[] args) {
		//List선언하기
		//List안에 제네릭 타입으로 Map설정함
		List<Map<String,Object>> list = new ArrayList<>();
		//Map을 인스턴스화 했음
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("mem_id", "tomato");//키값으로 아이디
		rmap.put("mem_email", "tomato@hot.com");//두번째 키값으로는 이메일
		rmap.put("mem_age", 30);
		list.add(rmap);//위에서 정의된 Map을 다시 List에 추가함 - List는 레코드이다, Map은 컬럼값을 담았다
		rmap = new HashMap<>();//두번째 로우에 레코드에 들어갈 맵을 정의함
		rmap.put("mem_id", "kiwi");//아이디
		rmap.put("mem_email", "kiwi@hot.com");//이메일 주소 
		list.add(rmap);//레코드 추가했죠 list.size() = 2이다.
		rmap = new HashMap<>();//두번째 로우에 레코드에 들어갈 맵을 정의함
		rmap.put("mem_id", "apple");//아이디
		rmap.put("mem_email", "apple@hot.com");//이메일 주소 
		list.add(rmap);//레코드 추가했죠 list.size() = 2이다.
		//돌연변이
		Map<String,Object> rmap2 = new HashMap<>();//세번째 맵은 구조가 다르다
		rmap2.put("total", 300);//두개가 아니라 하나만 담음 - 정사각형 혹은 직사각형이 되어야 되는데 모양이 틀어짐
		list.add(rmap2);
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			Map<String,Object> rm = list.get(i);
			System.out.println(rm);//0번째{}, 1번째{}, 2번째{}
			Object key[] = null;
			key = rm.keySet().toArray();
			//한번더? - 키값이 다름 
			for(int j=0;j<key.length;j++) {
				String temp = (String)key[j];
				if("total".equals(temp)) {
					System.out.println(rm.get(temp));
				}
				if("mem_age".equals(temp)) {
					System.out.println(rm.get(temp));
				}
				
			}
		}
	}

}