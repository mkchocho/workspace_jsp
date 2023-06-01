package com.example.demo.pojo1;

import java.util.ArrayList;

class Pride{
	int speed;
}
public class PrideSimulation {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		System.out.println(list);
		list=null;
		System.out.println(list.size());
		
		Pride myCar = new Pride();
		System.out.println(myCar);//@abcd1234 주소번지를 갖고 있고 또 실체도 존재함 
		int speed = myCar.speed;//0
		System.out.println(speed);//0
		
		myCar = null;//다시 초기화를 함 -null --> 모른다. 아직 미정이다. 결정되지 않았다.
		myCar = new Pride();//새로운 차가 생성 됨 - 주소번지가 새로 부여됨 
		System.out.println(myCar);//주소번지는 설사 새로 부여되었다 하더라도 실체가 없다
		speed = myCar.speed;//0 null인 상태에서 변수를 호출할 수 없다.
		System.out.println(speed);//0
	}

}
