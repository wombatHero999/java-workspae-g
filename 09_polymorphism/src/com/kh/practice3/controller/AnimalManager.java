package com.kh.practice3.controller;

import com.kh.practice3.model.vo.Animal;
import com.kh.practice3.model.vo.Cat;
import com.kh.practice3.model.vo.Dog;

public class AnimalManager {
	
	public static void main(String[] args) {
		// Animal 타입의 객체배열 크기 5로 생성 
		Animal [] arr = new Animal[5];
		
		arr[0] = new Dog("뽀삐","말티즈",3);
		arr[1] = new Cat("코코","브숏","고양이카페","회색");
		arr[2] = new Dog("호두","허스키", 15);
		arr[3] = new Cat("후추","코숏","길거리","치즈");
		arr[4] = new Dog("초코","토이푸들",1);
		
		// 각 인덱스에 무작위로 Dog객체 또는 Cat객체로 생성 
		// (이때, 매개변수 생성자를 이용하여 생성) 
		for(int i =0; i<arr.length; i++) {
			arr[i].speak();
		}
		 
		// 반복문을 통해서 해당 배열의 0번 인덱스부터 마지막 인덱스까지의  
		// 객체의 speak() 메소드 호출
	}
}















