package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c = new Circle(x, y, radius);
		
		double result = Math.PI * radius * radius;
		
		return "면적 : " + c + " / " + result;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x); // 초기화 완료
		c.setY(y);
		c.setRadius(radius);
		
		double result = Math.PI * radius * 2;
		
		return "둘레 : "+ c + " / "+result;
	}
	
}



















