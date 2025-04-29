package com.kh.chap01_poly.part02_electronic.model.vo;

public class Tablet extends Elecronic{
	
	public Tablet() {
		
	}

	public Tablet(String brand, String name, int price) {
		super(brand, name, price);
	}

	@Override
	public String toString() {
		return "Tablet [toString()=" + super.toString() + "]";
	}
	
}
