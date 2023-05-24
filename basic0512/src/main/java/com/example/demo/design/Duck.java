package com.example.demo.design;
//추상클래스로 설계 하였다.
//추상클래스는 이란 메소드와 추상메소드를 모두 가질 수 있어서
//추상메소드인 경우 일반메소드와 구분하기 위해서 abstract생략하면 안 돼
//어떤 관계일 때 혹은 어떤 기준으로 상속관계를 정하면 되나요?
// A is B 관계가 성립되면 서로 상속관계로 정의한다.

public abstract class Duck {
	FlyBehavior flyBehavior = null;
	//추상메소드 - 결정되지 않았다. 결정할 수 없다. 잘 모르겠다
	public abstract void display();//나는 추상메소드라고 해
	public void swimming() {//일반메소드다 왜냐면 좌줄괄호 우중괄호가 있는 것만으로 구현이다.
		System.out.println("모든 오리는 물 위에 뜬다");
		
	}
	
}