package com.step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListTest4 {

	public static void main(String[] args) {
		String[][] depts = {
				{"10","개발부","제주"}, //Map<String, String>
				{"20","운영팀","서울"}, //Map<String, String>
				{"30","품질관리팀","세종"} //Map<String, String>
		};
		//앞에는 인터페이스 = 구현체클래스 -> 다형성을 누릴 수 있다.
		//선언부에 오는 타입과 생성부에 오는 타입이 다를 때 다형성을 기대할 수 있다  
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("0","10");
		rmap.put("1","개발부");
		rmap.put("2","제주");
		List<Map<String,Object>> deptList = new ArrayList<>();
		//List 자료구조는 앞ㄹ에서 부터 차례대로 넣어야 한다
		deptList.add(0,rmap);
		//컬럼은 3개이지만 레코드는 1개가 맞다
		System.out.println(deptList.size());//1이다 - 레코드 갯수임
		//insert here 
		Object keys[] = deptList.get(0).keySet().toArray();
		//위 문장을 두 줄로 나누어 작성해 보세요 
		Map map = deptList.get(0); //내 안에 있는 건 Map타입이다.
		//왜냐하면 제네릭은 주소번지를 두 번 접근해야 하니까
		Set set = map.keySet();
		Object[] keys2 = set.toArray();
		System.out.println(keys.length);
		for(Object x:keys) {
			System.out.println(x);
		}
		
		
		
	
		
		
	}

}
