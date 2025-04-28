package com.kh.practice.snack.model.vo;

public class Snack {
	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	public Snack() {
		
	}
	
	public Snack(String kind , String name, String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}
	
	public String information() {
		// 빵(케이크 - 블루베리) 1개 15000원
		return kind+"("+name+" - "+flavor +") "+numOf+"개 "+price+"원";		
	}
	
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	// 나머지 필드들도 get/set만들기
	
}












