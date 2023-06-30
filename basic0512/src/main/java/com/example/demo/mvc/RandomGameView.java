package com.example.demo.mvc;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomGameView extends JFrame {
	//선언부
	//화면에서 선언된 JTextFiled와 JTextArea를 사용하려면 
	//RandomGameView 클래스의 주소번지가 필요함
	//인스턴스화 할 때 this를 사용하면 현재 보여지는 클래스를 말함 
	//this는 RandomGameView를 가리킨다 - 생성자도 메소드 오버로딩의 규칙을 따른다
	//같은 이름의 생성자가 있다 하더라도 파라미터 타입이 다르거나 갯수가 다르면 다른 생성자로 인식함 
	RandomGameEvent rgEvent = new RandomGameEvent(this);
	RandomGameLogic rgLogic = new RandomGameLogic(this);
	JTextField jf_input = new JTextField("");
	JTextArea jta_display = new JTextArea(5, 30);
	int dap = -1;//정답을 담을 변수 선언
	
	//생성자
	public RandomGameView() {
		//메인메소드 안에서 인스턴스화를 하자마자 채번하는 메소드 호출하기
		nanSu();//22-23-24
		//현재 내가 ActionListener를 implements하고 있지 않아서 .. 
		jf_input.addActionListener(rgEvent);
	}
	//새게임이 시작될 때마다 다시 호출됨 - 왜냐면 새로운숫자를 채번해야 되니까
	public void nanSu() {
		Random r = new Random();//nextint메소드 제공함
		dap = r.nextInt(10);//0부터 9사이에 채번된 숫자가 dap변수에 담김
	}
	

	//화면그리기
	public void initDisplay(int WIDTH, int HEIGHT, boolean bool, String title) {
		System.out.println("initDisplay 호출");
		this.add("South", jf_input);//배치, add하자
		this.add("Center", jta_display);
		this.setTitle(title);//메소드 호출할 수 있다. 나는
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(bool);//true이면 보여줘, false이면 숨겨줄래
		jta_display.append("새로운 게임이 시작됩니다. ==> "+dap+"\n");
	}
	
	public static void main(String[] args) {
		RandomGameView rgv = new RandomGameView();
		rgv.initDisplay(300,400,true,"숫자맞추기게임");
	}
}
