package com.kh.chap02_override.model.vo;

public class Book /* extends Object */ {
	
	private String title;
	private String author;
	private int price;
	
	public Book() {
		super();
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * 
	 *  
	 *  
	 *  toString() : Object 클래스의 메소드.
	 *               클래스명@주소값를 반환하는 메소드로, println과 같은 출력문에서 참조변수가 출력되는 경우
	 *               항상 toString()를 호출한 값을 출력한다.
	 *  */	
	public String toString() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
