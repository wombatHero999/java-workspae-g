package com.kh.practice;

import java.util.function.BiFunction;


public class LamdaPractice5 {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> op = getOperator("+"); 
        System.out.println(op.apply(10, 5));  // 15 
 
        op = getOperator("*"); 
        System.out.println(op.apply(10, 5));  // 50 
	}
	
	public static BiFunction<Integer, Integer, Integer> getOperator(String type) { 
	    //코드 구현
		switch(type) {
		case "+" : 
			return (a1, a2) -> a1+a2;
		case "*" : 
			return (a1, a2) -> a1*a2;
		case "-" : 
			return (a1, a2) -> a1-a2;
		case "/" : 
			return (a1,a2) -> a1/a2;
		case "%" : 
			return (a1,a2) -> a1 % a2;
		default  : 
			throw new RuntimeException("잘못된 연산자입니다.");
		}
	} 
}










