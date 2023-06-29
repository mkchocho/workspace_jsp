package com.example.pattern;

class Sonata{
	int wheelNum = 4;
	int speed = 0;
	private static Sonata instance = new Sonata();
		
	//생성자 선언시 private이면 외부 클래스에서 인스턴스화를 할 수 없다
	private Sonata() {
		System.out.println("Sonata 디폴트생성자");
	}
	
	public static Sonata getInstance() {
		if(instance==null)
			instance=new Sonata();
		
		return instance;
	}
	
	public void speedUp() {
		speed+=1; //차가 정지된 상태에서는 0임. 엑셀밟으면 1씩 증가함
	}
}

public class SonataApp {

	public static void main(String[] args) {
		//내 안에서 다른 클래스의 변수나 메소드를 누릴 수 있다. (호출할 수 있다. 사용할 수 있다.)
		//단 인스턴스화가 필요하다
		Sonata myCar = null;
		//myCar = new Sonata();
//		System.out.println(myCar.wheelNum);
		
		String num = "10";
		//static은 변수명.메소드명이아니라 타입.메소드명이 옴 
		System.out.println(Integer.parseInt(num)+10);
		//객체주입을 메소드 호출을 통해서 받아온다
		myCar = Sonata.getInstance();
		System.out.println(myCar.wheelNum);
		
		
		
		

	}

}
