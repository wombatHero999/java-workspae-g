package com.kh.chap03_char.run;

import com.kh.chap03_char.model.dao.FileCharDao;

public class Run {
	
	public static void main(String[] args) {
		// 문자 기반 스트림
		//  - 외부매체와 직접 연결 후, 2byte단위로 데이터를 주고 받는 통로를 개설하는 스트림
		// xxxReader / xxxWriter
		FileCharDao dao = new FileCharDao();
		//dao.fileSave();
		dao.fileRead();		
	}
	
}















