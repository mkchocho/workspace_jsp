package com.example.demo.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameEvent implements ActionListener {
	//전역변수는 초기화를 생략할 수 있다 - 생성자가 대신 해주니까
	//전변은 생성자 안에서도 사용할 수 있다. - 왜 전역변수이니까
	//직접 인스턴스화 하는 건 안되고 왜냐면 복사본이 만들어지니까 - 그러면 화면이 두 개 열리니까
	//생성자의 파라미터로 주소번지 원본을 받아와야 한다
	RandomGameView rgView = null;
	//생성자 파라미터 자리에 변수는 생성자 영역안에서만 사용가능함 
	public RandomGameEvent(RandomGameView randomGameView) {
		this.rgView = randomGameView;
		System.out.println("RandomGameEvent");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//randomGameView.jf_input;
		//이벤트가 감지된 클래스의 주소번지를 얻어옴
		Object obj = e.getSource();
		System.out.println(obj);//RandomGameView에 선언된 JTextField의 주소번지'
		String user = rgView.jf_input.getText();
		//너 텍스트 필드에서 엔터친거야?
		if(obj==rgView.jf_input) {
			rgView.jta_display.append(rgView.jf_input.getText()+"\n");
			rgView.jta_display.append(user+":"+rgView.rgLogic.account(user)+"\n");
			rgView.jf_input.setText("");
		}
	}

}
