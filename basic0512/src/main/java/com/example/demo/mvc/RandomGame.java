package com.example.demo.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//클래스 쪼개기
//문제: 0~9사이의 임의의 숫자를 채번하고 그 숫자를 맞추는 게임
//힌트:낮춰라, 높여라, 정답입니다. 축하합니다.

public class RandomGame extends JFrame implements ActionListener {
	//선언부 - 전역변수 - 초기화를 생략할 수 있다
	JTextField jf_input = new JTextField("");
	JTextArea jta_display = new JTextArea(5, 30);
	//정답을 담을 변수 선언
	int dap = -1;
	//생성자
	public RandomGame() {//디폴트 생성자
		System.out.println("디폴트 생성자 호출");
		nanSu();
		//이벤트소스와 이벤트 처리 클래스를 매칭해줌
		// 내안에 actionPerformed메소드가 있다는 건 내가 ActionLisener의 구현체 클래스다
		jf_input.addActionListener(this);//this->  RandomGame
		jta_display.setEditable(false);
	}
	//새게임이 시작될 때 마다 다시 호출됨 - 왜냐면 새로운숫자를 채번해야 되니까
	public void nanSu() {
		Random r = new Random();
		dap = r.nextInt(10);
	}
	//판정 - 힌트문{낮춰라, 높여라}
	//파라미터 input은 사용자가 화면에 입력한 숫자를 담음
	public String account(String input) {
		int user = 0;
		String msg = "";
		if(input !=null) {
			user = Integer.parseInt(input);
		}
		if(dap == user) {
			msg="축하합니다. 정답입니다. \n";
			//System.exit(0);//가상머신과  연결고리를 끊어줌
		}else if(dap > user) {
			msg="높여라\n";
		}else if(dap < user) {
			msg="낮춰라\n";
		}
		return msg;
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
	//35-38{인스턴스화:생성자호출}-14-15{생성자안에 실행문[if문,for문,산술식]}-39{메소드호출}
	//21-22[출력]
	//메인메소드 - entry point다 , 메인스레드이다,  가장먼저 실행된다
	public static void main(String[] args) {
		//내 안에 있는 메소드라 하더라도 static영역에서 non-static메소드를 호출하려면
		//인스턴스화.- 클래스가 heap메모리{클래스}영역에 상주
		RandomGame rdg = new RandomGame();
		rdg.initDisplay(300,400, true,"숫자맞추기게임 Ver1.0");//사용자가 입력하는 자리가 파라미터 자리이다. - 메소드오버로딩
		
		
	}/////////////////   end of main  ///////////////
	//콜백메소드-개발자가 호출하는 메소드가 아니다-버튼이 눌려지면 그걸 JVM이 느끼면 그때 호출해줌
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트 소스가 누구지? 버튼이요-저장버튼
		Object obj = e.getSource();
		String user = jf_input.getText();
		//너 저장버튼 누른거야?
		if(jf_input == obj) {
			//System.out.println("저장버튼 누름");
			jta_display.append(user+ " : " +account(user) +"\n");
			jf_input.setText("");
		}
		
	}

}////////////////////  end of RandomGame ///////////////////