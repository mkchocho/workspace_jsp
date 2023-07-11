package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SonataTest {

	public static void main(String[] args) {
		// 사용자가 직접 인스턴스화 하기
		// 자원관리에 대한 책임이 개발자에게 있다.
		Sonata yourCar = new Sonata(); // 하드코딩 - 제어역전은 없다
		System.out.println(yourCar);
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\di\\sonataBean.xml"); // xml로부터 Sonata의 정보를 얻어올 수 있음
		Sonata myCar = (Sonata)context.getBean("herCar");
		System.out.println(myCar); //스프링에서 대신 생성해준 객체의 주소번지 입력
		System.out.println(myCar.getClass());
		//파라미터가 2개인 생성자가 정의되어 있지 않아서 문제 발생함
		
	}

}
