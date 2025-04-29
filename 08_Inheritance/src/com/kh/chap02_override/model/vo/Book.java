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
	 * 오버라이드(재정의)
	 *  - 상속받고 있는 부모클래스의 메서드를 자식클래스에서 재정의 하는 행위
	 *  - 부모가 제공하고 있던 메소드를 자식클래스에서 고쳐서 사용하는 것으로, 실행우선권은 자식 메서드에게 있다.
	 *  
	 * 오버라이드 성립조건
	 *  - 부모 메서드의 메서드명과 100%일치해야 한다.
	 *  - 매개변수의 자료형, 갯수, 순서가 100% 동일해야 한다.
	 *  - 반환형도 동일해야한다.
	 *  - 접근제한자는 부모메서드의 접근제한자와 같거나, 공유범위가 더 커야한다.
	 *  - 예외처리범위는 부모메서드의 예외처리와 같거나 , 범위가 더 작아야 한다.
	 *  => 재정의를 위해서는 위 작성규칙을 반드시 준수해야한다.
	 *  
	 *  toString() : Object 클래스의 메소드.
	 *               클래스명@주소값를 반환하는 메소드로, println과 같은 출력문에서 참조변수가 출력되는 경우
	 *               항상 toString()를 호출한 값을 출력한다.
	 *               
	 *  @Override 어노테이션
	 *   - 오버리이딩 성립조건을 준수했는지 검사하는 역할의 어노테이션
	 *   - 잘못된 조건으로 오버라이딩 한 경우 에러를 발생시켜 코드를 수정할 수 있도록 유도한다.
	 *  */	
	
	@Override
	public String toString() {
		return "title : "+title+", author : "+author+", price : "+price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
