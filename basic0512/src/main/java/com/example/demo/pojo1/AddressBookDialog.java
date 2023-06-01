package com.example.demo.pojo1;

import javax.swing.JDialog;
@SuppressWarnings("serial")
public class AddressBookDialog extends JDialog {
	//선언부
	
	//그럼에도 호출하면 어떻게 되는데? - NullPointerException이 발동할 거야 
	AddressBook aBook = null;//선언만 - 아직 메모리에 로딩이 안되었어 - 누릴 수 없어
	
	//AddressBook aBook = new Address();
	//생성자
	public AddressBookDialog() {
		initDisplay();
	}
	
	//화면 처리부
	public void initDisplay() {
		this.setTitle("나는 다이얼로그창");
		this.setSize(300, 500);
		this.setVisible(false);
	}
	
	//24-25-13-14-18-19-20-15-26
	/*
	public static void main(String[] args) {
		AddressBookDialog aDialog = new AddressBookDialog();//생성자 호출하기
		aDialog.setVisible(true);
	}
	*/
}
