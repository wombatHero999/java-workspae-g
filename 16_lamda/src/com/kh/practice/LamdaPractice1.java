package com.kh.practice;

public class LamdaPractice1 {
	public static void main(String[] args) {
		String[] arr = { "java", "lambda", "hi", "functional", "wow" };
		printStrings(arr, s -> s.length() >= 5);
	}

	public static void printStrings(String[] arr, StringChecker checker) {
		for (String str : arr) {
			if (checker.check(str)) {
				System.out.println(str);
			}
		}
	}
	
	@FunctionalInterface
	interface StringChecker {
		boolean check(String str);
	}

}







