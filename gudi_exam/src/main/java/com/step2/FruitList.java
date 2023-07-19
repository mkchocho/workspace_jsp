package com.step2;

import java.util.ArrayList;
import java.util.List;
//Collection Framework API - 자바가상머신 - s/w로 만든 CPU
//대괄호 - List, Array-javascript -> JSON -> 서로다른 언어를 형전환
public class FruitList {
	
	public static void main(String[] args) {
		String apple = "사과";
		String tomato = "토마토";
		String kiwi = "키위";
		//DB서버 - 옵티마이저 
		//브라우저 - DOM Tree장치, Render Tree장치
		//객체가 생성되긴 했지만 아직 아무것도 담지 않았다 - ClassLoader 살고 있고 - 실행 
		List<String> list = new ArrayList<>(); // 인스턴스화 - 빈방
		System.out.println(list.size());
		list.add(0,apple);
		System.out.println(list.size());
		//list.remove(0); 이 코드가 아래가 더 직관적임 
		list.remove("사과");
		System.out.println(list.size());
		
		
		
		
		
	}

}
