package com.example.demo.pojo3;
//추상클래스는 결정되지 않았다
abstract class Car{
	
}

class Pride extends Car {

}
class Sonata extends Car{
	
}

public class CarSimulation {

	public static void main(String[] args) {

		Car myCar = new Pride();
		Pride herCar = new Pride();
		Sonata himCar = new Sonata();
		Car yourCar = herCar;
		yourCar = himCar;
		//herCar = himCar;
		Object obj = null;
		obj = herCar;
		obj = himCar;
	}

}
