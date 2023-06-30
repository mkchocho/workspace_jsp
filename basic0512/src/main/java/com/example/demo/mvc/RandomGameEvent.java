package com.example.demo.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameEvent implements ActionListener {
	RandomGameView rgView = null;
	//생성자 파라미터 자리에 변수는 생성자 영역안에서만 사용가능함 
	public RandomGameEvent(RandomGameView randomGameView) {
		this.rgView = randomGameView;
		System.out.println("RandomGameEvent:"+randomGameView.jf_input);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//randomGameView.jf_input;
		//이벤트가 감지된 클래스의 주소번지를 얻어옴
		Object obj = e.getSource();
		System.out.println(obj);//RandomGameView에 선언된 JTextField의 주소번지
		//너 텍스트 필드에서 엔터친거야?
		if(obj==rgView.jf_input) {
			rgView.jta_display.append(rgView.jf_input.getText()+"\n");
			rgView.jf_input.setText("");
		}
	}

}
