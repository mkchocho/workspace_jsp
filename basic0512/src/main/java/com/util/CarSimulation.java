package com.util;
abstract class Car{
	int speed =0;
	public abstract void go();//추상 메소드
	public void stop() {
		System.out.println("5번라인 - stop");
		speed = speed-1;
		if(speed>0) {
			speed = speed -1;
		}
		else {
			speed = 0;
		}
	}
}
//A is a B 소나타는 자동차이다
//Sonata is a Car
//520! is a Car

class Sonata extends Car{

	@Override
	public void go() {
		// TODO Auto-generated method stub
	}
	@Override
	public void stop() {
		System.out.println("26번라인(Sonata클래스의) - stop");
		if(speed>0) {
			speed = speed -2;
		}
		else {
			speed = 0;
		}
	}
	
}

public class CarSimulation {

	public static void main(String[] args) {
		//추상 클래스와 인터페이스는 반드시 구현체 클래스가 있어야함 - 스프링 프레임워크가 추구하는 코딩 방향
		//단독으로 인스턴스화 할 수 없다
		//Car meCar = new Car();
		Car myCar = new Sonata();
		myCar.stop();
		//meCar.stop();
		Sonata herCar = new Sonata();
		Car himCar = null;
		Sonata yourCar = null;
		//형전환 연산자(캐스팅연산자)을 통해서 강제로 형전환을 해도 런타임시에는 결국 망한다 -Exception이 
		yourCar = (Sonata)myCar;
		yourCar = herCar;
		

	}

}
