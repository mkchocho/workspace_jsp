package com.example.demo.member;

public class StringTest {

	public static void main(String[] args) {
		String insa = "hello";
		insa = insa.replace('e','o');//새로운 객체 할당됨
		System.out.println(insa);//hello or hollo
		StringBuilder sb = new StringBuilder("hello");
		sb.append(" world!!!");//원본에 추가하기 이다. 덮어쓰기가 아니라
		System.out.println(sb);//hello world!!!
		
	}
}
