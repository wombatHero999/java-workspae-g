package com.kh.chap01_before.model.vo;

public class Product {
	// 다양한 제품클래스에서 공통으로 사용하는 필드, 기능을 정의해둘 클래스 : 부모클래스
	
//	private String brand;
//	private String pCode;
//	private String pName;
//	private int price;
	
	protected String brand;
	protected String pCode;
	protected String pName;
	protected int price;
	
	public Product() {
		
	}
	
	public Product(String brand, String pCode, String pName, int price) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String information() {
		return "brand : "+ brand+", pCode : "+ pCode +", pName : "+pName+", price : "+ price;
	}
	
}



















