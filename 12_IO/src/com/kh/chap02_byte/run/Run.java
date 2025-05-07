package com.kh.chap02_byte.run;

import com.kh.chap02_byte.model.dao.FileByteDao;

public class Run {
	public static void main(String[] args) {
		/*
		 * 바이트 기반 스트림
		 *  바이트 스트림 : 1byte단위로 데이터를 입출력 하는 스트림
		 *  기반 스트림 : 외부매체와 직접 연결되는 통로를 개설할 수 있는 스트림
		 *  - 외부매체와 직접 연결하고, 연결통로를 통해 1byte단위로 데이터를 송수신 하는 스트림
		 *  
		 *  xxxInputStream : xxx매체로부터 데이터를 입력 받는 스트림
		 *  xxxOutputStream : xxx매체로부터 데이터를 출력 하는 스트림
		 *  */
		FileByteDao dao = new FileByteDao();
		//dao.fileSave();
		dao.fileRead();
	}
}

















