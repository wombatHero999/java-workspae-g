package com.kh.chap01_file.run;

import java.io.File;
import java.io.IOException;

public class Run {
	
	public static void main(String[] args) {
		// java.io.File클래스
		//  - 파일의 개념을 추상화하여 만들어진 클래스
		//  - 파일의 속성, 경로, 이름, ...등을 얻을 수 있다.
		
		try {
			// 1. 파일명을 제시하여 파일객체 생성하기.
			File file1 = new File("test.txt");
			file1.createNewFile();
			
			// 2. 경로를 지정한 파일명을 제시하여 파일객체 생성
			// -> 해당 경로가 반드시 존재하는지 확인 후 , 객체를 생성해야한다.
			File file2 = new File("C:/aaa/test.txt");
			file2.createNewFile();
			
			// 3. 경로확인 및, 경로(directory)생성 방법
			File bbbFolder = new File("C:/bbb"); // 확인하고자 하는 경로를 가진 File객체 생성
			boolean isExist = bbbFolder.exists();
			System.out.println("isExist : "+isExist);
			
			if(!isExist) {
				bbbFolder.mkdir(); // 단일 디렉토리
				bbbFolder.mkdirs();// 중첩 디렉토리
			}
			
			File file3 = new File("C:/bbb/test.txt");
			file3.createNewFile();
			
			// 4. File에서 제공하는 메서드들.
			System.out.println(bbbFolder.isFile()); // 폴더이므로 false
			System.out.println(file3.isDirectory());
			
			System.out.println("파일명 : "+file3.getName());
			System.out.println("상위폴더 : "+file3.getParent());
			System.out.println("파일용량 : "+file3.length());
			System.out.println("파일이 존재하는 절대 경로 : "+file3.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 프로그램상의 데이터를 외부매체로 "출력" 혹은 입력장치로부터 "입력"받는 과정을 진행하고자 한다면
		 * 반드시 프로그램과 외부매체간의 데이터가 오고갈 수 있는 "통로"를 개설해야 한다.
		 * 이 통로를 Stream이라고 부른다.
		 * 
		 * 스트림의 특징
		 *  - 단방향 : 입력이면 입력, 출력이면 출력으로만 데이터 전송이 가능.
		 *  - 선입선출(FIFO) : 먼저 전달한 값이 먼저 나오게 된다.
		 *  - 시간지연문제가 발생할 수도 있다.
		 * 
		 * 스트림의 구분
		 *  - 데이터의 크기에 따른 분류
		 *    1) 바이트 스트림(InputStream/OutputStream)
		 *     - 모든 바이트 스트림은 InputStream/OuputStream추상클래스를 상속받아 구현.
		 *     - 읽기는(read()) , 쓰기는(write())를 사용.
		 *     - 1byte짜리 데이터가 오고갈 수 있는 스트림.
		 *     
		 *    2) 문자스트림(Reader/Writer)
		 *     - 모든 문자스트림은 Reader/Writer 추상클래스를 상속받아 구현했다.
		 *     - 읽기(read()) 쓰기는 write()함수를 사용
		 *     - 2byte단위로 데이터가 오고가는 스트림.
		 *     
		 *  - 외부매체와의 연결 가능 여부
		 *     기반 스트림 : 외부매체와 직접연결이 가능한 스트림.
		 *     보조 스트림 : 기반스트림의 부족한 기능을 보조하기 위한 스트림.
		 *                (속도 향상, 자료형 변환, 객체단위 입출력...)
		 *                단독으로 사용이 불가능하며, 기반스트림이 필수.
		 *  */
		
	}

}

















