package com.kh.chap02_abstract.part01.model.vo;

public class Basketball extends Sports{
	
	@Override
	public void rule() {
		System.out.println("손으로 공을 넣어 링에 넣어야 한다.");
	}
}
