package com.di;

public class Sonata {
	//전역변수 값은 생성자를 통해서 초기화 된다.
	//그렇다면 전변은 모두 초기화가 생략된 상태인데 언제 어느 시점에 값이 들어오나요
	
	String carColor;
	int speed;//0
	int wheelNum;//0
	public Sonata() {}
	public Sonata(String carColor) {//해당 차의 시그니쳐 색상을 초기화할 수 있음
		//this는 자기자신을 나타내는 수정자 - 전변에만 가능함 -> 리액트 훅 제안
		//프론트 언어에서는 this는 상황에 따라 바뀐다 - 꺼려지는 수정자
		//생성자가 호출되었다 하더라도 새성자 내부에서 this수정자를 사용한 초기화가 생략되면
		//파라미터로 넘어온 값은 전역변수에 초기화가 되지 못함 
		this.carColor = carColor;
	}
	//sonataBean.xml문서에는 파라미터 두개짜리 생성자가 있는데 Sonata.java에는 두개짜리 생성자가 없을 때
	//BeanCreationExcetion이 발생함 
	public Sonata(String carColor, int speed) {
		this.carColor = carColor;
		this.speed=speed;
	}
	public Sonata(String carColor, int speed, int wheelNum) {
		this.carColor = carColor;
		this.speed=speed;
		this.wheelNum = wheelNum;
	}
	
	public String toString() {
		return "그녀의 자동차는"+this.carColor+"이고, 현재속도는"+this.speed+"km/m이고 바퀴수는"+this.wheelNum+"이다.";
	}
}
