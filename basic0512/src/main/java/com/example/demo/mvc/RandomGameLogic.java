package com.example.demo.mvc;

public class RandomGameLogic {
	RandomGameView rdGame = null;
	
	//변수 dap은 RandomGameView에 있는데 사용은 RandomGameLogic에서 해야 한다.
	//어떡하지?
	//해결방법은 RandomGameView의 주소번지가 필요하다
	//그럼 여기에서 RandomGameView rdGame = new RandomGameView(); 해도 되나?
	//아니 -> 카피본이 생김, 원본을 사용해야 한다 
	public RandomGameLogic(RandomGameView rgv) {
		this.rdGame = rgv;
	}
	//판정 - 힌트문{낮춰라, 높여라}
	//파라미터 input은 사용자가 화면에 입력한 숫자를 담음
	public String account(String input) {
		int user = 0;
		String msg = "";
		if(input !=null) {
			user = Integer.parseInt(input);
		}
		if(rdGame.dap == user) {
			msg="축하합니다. 정답입니다. \n";
			//System.exit(0);//가상머신과  연결고리를 끊어줌
		}else if(rdGame.dap > user) {
			msg="높여라\n";
		}else if(rdGame.dap < user) {
			msg="낮춰라\n";
		}
		return msg;
	}
}
