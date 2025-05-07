package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	
	public CharacterController() {
		
	}
	
	public int countAlpha(String s) throws CharCheckException{
		
		char[] arr = s.toLowerCase().toCharArray();
		
		int count = 0;
		for(char ch : arr) {
			if(ch >= 'a' && ch <= 'z') {
				count++;
			}
			if(ch == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
		}
		
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}













