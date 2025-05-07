package com.kh.practice.numRange.view;

import java.util.Scanner;

import com.kh.practice.numRange.controller.NumberController;
import com.kh.practice.numRange.exception.NumRangeException;

public class NumberMenu {
	
	public void menu() { 
		Scanner sc = new Scanner(System.in);
		NumberController nc = new NumberController();
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		
		try {
			boolean result = nc.checkDouble(num1, num2);
			System.out.printf("%d는 %d의 배수인가? %s", num1, num2, result);
		}catch(NumRangeException e) {
			e.printStackTrace();
		}
	}
}








