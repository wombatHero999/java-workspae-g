package com.kh.practice.chap02_abstract.controller;

import com.kh.practice.chap02_abstract.model.vo.*;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] arr = new Phone[2];
		arr[0] = new GalaxyNote9();
		arr[1] = new V40();
		
		result[0] = ((GalaxyNote9)arr[0]).printInformation();
		result[1] = ((V40)arr[1]).printInformation();
		
		return result;
	}
}












