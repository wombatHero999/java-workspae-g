package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class TriangleController {
	
	private Shape s = new Shape();
	
	
	public double calcArea(double height, double width) {
		// 문제에서 요구한 방법
		s = new Shape(3 , height, width);
		
		s.setHeight(height);
		s.setWidth(width);
		s.setType(3);
		
		return width * height / 2;
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print() {
		return "삼각형" + s.information();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
