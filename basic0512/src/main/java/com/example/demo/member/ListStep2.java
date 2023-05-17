package com.example.demo.member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//인터페이스는 단독으로 인스턴스화를 할 수 없다.
//반드시 구현체 클래스가 있어야 메모리에 올릴 수 있다.(변수호출, 메소드 호출 - 누린다)
import java.util.Map;

public class ListStep2 {
	
	public static void main(String[] args) {
		List<Map<String,Object>> fruitList= new ArrayList<>();//싱글스레드에서 안전
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("first","토마토");
		rMap.put("second","키위");
		fruitList.add(rMap); //fruitList.get(0) = new HashMap<>(); 들어있음
		//System.out.println(rMap.get("first"));//토마토
		//System.out.println(rMap);

		rMap = new HashMap<>();
		rMap.put("first","수박");
		rMap.put("second","딸기");
		fruitList.add(rMap);
		//System.out.println(rMap.get("first"));//수박
		
		for(int i=0; i<fruitList.size(); i++) {
			Map<String, Object> rMap2 = fruitList.get(i);
			System.out.println(rMap2.get("first")+","+rMap2.get("second"));
		}
	}

}
