package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {
	/* 
	 * 보조스트림
	 *  - 기반스트림의 부족한 기능들을 "확장"시킬 수 있는 스트림들
	 *  - 보조스트림은 단독으로는 사용이 불가능.
	 *  
	 * [표현법]
	 * 보조스트림 변수명 = new 보조스트림(기반스트림객체); 
	 * 
	 * 보조스트림 여러개 추가
	 * 보조스트림1 변수명 = new 보조스트림1(new 보조스트림2(기반스트림객체)); 
	 * 데코레이터패턴
	 * 
	 * BufferedXXX : "속도 성능 향상" 목적의 보조스트림
	 *  => 데이터를 바로 출력/입력 하는것이 아니라 
	 *     크기가 큰 버퍼공간을 만들어서 데이터를 모아두었다가 한번에 입출력을 진행
	 * */
	
	// BufferedReader / BufferedWriter
	public void fileSave() {
		//BufferedWriter bw = null;
		// 만약 보조스트림이 Writer면 기반스트림도 Writer
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"));){
			bw.write("안녕하세요");
			bw.newLine(); // 개행문자추가
			bw.write("저리가세요\n");
			
			bw.flush();// 버퍼공간 비워주는 메서드.
			// flush메서드는 close()실행시 자동으로 호출되는 메서드
			// 버퍼공간이 다 채워지지않은 상태에서 메서드가 종료될때, 버퍼에 담겨있는 데이터가 누락될수 있으므로
			// flush함수를 통해 버퍼를 비워줘야 한다.
			
			// 출력 후 10초 대기
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
			
			String value = null;
			while( (value = br.readLine()) != null) {
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}







