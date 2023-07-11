package com.example.demo.design;

public class DuckSimulation {
	//파라미터의 갯수가 다르거나 타입이 다르면 메소드 오버로딩 조건을 만족하니까 중복선언이 가능하다
	//메소드 이름이 같은데 둘은 서로 다른 메소드이다-메소드 오버로딩이다
	void methodA(WoodDuck wd) {
		System.out.println("methodA(WoodDuck)호출");
	}
	void methodA(Duck duck) {
		System.out.println("methodA(Duck)호출");
	}
	public static void main(String[] args) {
		//날고 날지 못하고는 해당 객체의 생성자에서 결정되었다.
		//다형성이란 같은 이름의 메소드를 호출했는데 그 기능이 다르게 동작하는 것을 말한다.
		//선언부의 타입과 생성부의 타입이 다를 때 기대할 수 있다.
		//하드코딩이라 부른다 - 왜냐면 제어권을 개발자가 책임짐
		//개발자 만일 신입개발자라면?...
		//신입 개발자는 직접 인스턴스화를 하지 않는게 좋겠다.
		//신입개발자에게서 빼앗아 오자
		//빼앗은 인스턴스화에 대한 책임을 스프링에 쥔다 - 라이프사이클 관리 받음 
		Duck myDuck = new MallardDuck();//6번에 myDuck과 8번에 myDuck은 이름은 같지만 주소번지가 다르다.
		myDuck.flyBehavior.fly();//나는 날고 있어요
		myDuck = new WoodDuck();
		myDuck.flyBehavior.fly();//나는 날지 못합니다 출력
		//static영역에서는 non-static 변수나 메소드를 호출할 수 없다
		//내 안에 있는 메소드 이더라도 인스턴스화를 하면 호출할 수 있다. - 문제해결능력
		DuckSimulation ds = new DuckSimulation();
		ds.methodA(myDuck);
		WoodDuck himDuck = new WoodDuck();
		ds.methodA(himDuck);
	}
}
