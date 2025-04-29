package com.kh.chap01_poly.part02_electronic.run;

import com.kh.chap01_poly.part02_electronic.controller.ElectronicController;
import com.kh.chap01_poly.part02_electronic.model.vo.*;

public class Run {
	
	public static void main(String[] args) {
//		ElectronicController ec = new ElectronicController();
//		ec.insert(new Desktop("삼성","데탑",1500000,"Geforce"));
//		ec.insert(new NoteBook("엘지","그램",2000000, 4));
//		ec.insert(new Tablet("애플","아이패드",500000));
//		
//		System.out.println(ec.selectDesktop());
//		System.out.println(ec.selectNoteBook());
//		System.out.println(ec.selectTablet());
		
		// 다형성 적용 후 .. 
		ElectronicController ec = new ElectronicController();
		ec.insert(new Desktop("삼성","데탑",1500000,"Geforce"), 0);
		ec.insert(new NoteBook("엘지","그램",2000000, 4), 1);
		ec.insert(new Tablet("애플","아이패드",500000), 2);
		
		System.out.println(ec.select(0));
		System.out.println(ec.select(1));
		System.out.println(ec.select(2));
		
		/*
		 * 다형성을 쓰는 이유
		 * 1. 부모타입 하나만으로 다양한 자식객체들을 다룰 수 있음.
		 * 2. 메소드의 매개변수, 반환형에 다형성이 적용되면 작성해야할 메서드 갯수가 확 줄어든다.  
		 *  */
	}

}


















