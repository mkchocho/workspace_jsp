package com.example.demo.member;

import java.util.ArrayList;
import java.util.List;

import com.vo.Member0518;

public class ListStep3 {
	List<Member0518> mList = new ArrayList<>();
	public void initList() {
		Member0518 mVO = new Member0518();
		mVO.setMem_id("tomato");
		mList.add(mVO);
		
	}
	
	public static void main(String[] args) {
		//non-static 타입은 static 영역에서 사용이 불가하다.
		//단 인스턴스화를 하면 사용 가능하다 
		ListStep3 ls3 = new ListStep3();
		System.out.println(ls3.mList.size()); //0
	}

}
