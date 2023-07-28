package com.example.demo.model;

public class Test {

	private int tNo; // t_no NUMBER
    private String tWriter; // t_writer VARCHAR2(30)
    private String tTitle; // t_title VARCHAR2(100)
    private String tContent; // t_content VARCHAR2(200)
    private String tDate; // t_date VARCHAR2(30)

    // 생성자
	public Test() {}

	public Test(int tNo, String tWriter, String tTitle, String tContent, String tDate) {
		super();
		this.tNo = tNo;
		this.tWriter = tWriter;
		this.tTitle = tTitle;
		this.tContent = tContent;
		this.tDate = tDate;
	}

	//getter setter 시작 
	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettWriter() {
		return tWriter;
	}

	public void settWriter(String tWriter) {
		this.tWriter = tWriter;
	}

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public String gettContent() {
		return tContent;
	}

	public void settContent(String tContent) {
		this.tContent = tContent;
	}

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}
	
	
	
	
	
	
	
	
}
