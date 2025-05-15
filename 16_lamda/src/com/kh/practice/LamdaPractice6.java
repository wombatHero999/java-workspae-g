package com.kh.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LamdaPractice6 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Jin", "Suga", "RM", "J-Hope", "V");

		Comparator<String> comp = getComparator("length");
		names.sort(comp);
		System.out.println(names); // 길이순 정렬

		comp = getComparator("reverse");
		names.sort(comp);
		System.out.println(names); // 알파벳 역순 정렬
	}
	public static Comparator<String> getComparator(String mode) { 
	        //코드 구현 
	}
}
