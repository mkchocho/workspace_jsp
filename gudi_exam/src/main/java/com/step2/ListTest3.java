package com.step2;

import java.util.ArrayList;
import java.util.List;

public class ListTest3 {

	public static void main(String[] args) {
		String[][] depts = {
				{"10","개발부","제주"}, //Map<String, String>
				{"20","운영팀","서울"}, //Map<String, String>
				{"30","품질관리팀","세종"} //Map<String, String>
		};//이차베열 -> List, Map을 이해시키려고 이용하신다고 함, 사용빈도는 낮음
		System.out.println("befor"+depts[0]);//주소번지
		depts[0] = new String[3];
		System.out.println(depts[0]);//주소번지
		System.out.println(depts[0][1]);//개발부
		System.out.println();
		
		int i[] = new int[3];
		for(int x:i) {
			System.out.println(x); // 0 0 0 - 1차배열이니까
		}
		System.out.println();
		List<Integer> li = new ArrayList<>();
		//배열은 중간에 끼워넣기가 불가한데 List는 가능함 
		System.out.println(li.size()); //0
		li.add(0,10);
		li.add(1,20);
		li.add(1,30);//오버라이드
		for(int x:li) {
			System.out.println(x); //입력 순서대로
		}
	}

}
