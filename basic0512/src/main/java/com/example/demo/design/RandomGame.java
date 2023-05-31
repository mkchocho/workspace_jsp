package com.example.demo.design;

import javax.swing.JFrame;

public class RandomGame {
	
	//선언부
	//아래처럼 게으른 인스턴스화를 할 땐 사용전에 반드시 생성(생성자 호출)할것
	//이른인스턴스화와 게으른 인스턴스화의 차이점. 뭐가 다르지, 어떻게 다르지?, 왜 다르지
//	JFrame jf = null;;//나중에 생성할게 - 선언만 했다.
	JFrame jf = new JFrame();
	//생성자 선언
	public RandomGame() {
		System.out.println("RandomGame 디폴트 생성자");
		//생성자 안에서 메소드 호출이 가능하다
		//non-static영역이라서 내 안에 있는 메소드를 자유롭게 호출 가능 함 
		initDisplay();
	}
	
	//화면 처리부
	public void initDisplay() {
		//jf = new JFrame();
		jf.setTitle("처음 만들어 보는 게임111111");
		jf.setSize(400, 300);
		jf.setVisible(true);//false이면 비활성화 됨
		jf.setTitle("처음 만들어 보는 게임5555555555555555555");
	}

	
	
	//메인 메소드
	public static void main(String[] args) {
		new RandomGame();
		//내 안에 있는 메소드라 하더라도 static 안에서는 non-static은 접근이 불가함
		//내 안에 있는 메소드라 하더라도 1) 인스턴스화를 하고 호출하거나
		//생성자 안에서 호출은 가능하다.
		//initDisplay();
	}
	

}
