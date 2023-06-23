package com.example.demo.pojo3;

public class A {
	void methodA(Object obj) {
		System.out.println("methodA(Object)");
	}
	void methodA(String str) {
		System.out.println("methodA(String)");
	}

	public static void main(String[] args) {
		String name = new String("나신입");
		Integer is = new Integer(10);
		Boolean bool = new Boolean(false);
		//내 안에 있다하더라도 static영역안에서 non-static메소드를 호출하려면
		//반드시 인스턴스화
		A a = new A();
		a.methodA(name);//8
		a.methodA(is);//5
		
		a.methodA("18"+is);
		
	}
}
