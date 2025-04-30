package com.kh.practice.chap02_abstract.run;

import com.kh.practice.chap02_abstract.controller.PhoneController;

public class Run {
	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] result = pc.method();
		for(String s : result) {
			System.out.println(s);
		}
	}
}










