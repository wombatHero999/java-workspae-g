package com.kh.practice;

public class LamdaPractice4 {
	public static void main(String[] args) {
		MyFunction2<String, Integer> printer = (name, score) -> 
        System.out.println(name + "님의 점수는 " + score + "점입니다."); 
 
        printer.accept("홍길동", 95); 
        printer.accept("이순신", 88); 
	}
	interface MyFunction2{
		
	}
}
