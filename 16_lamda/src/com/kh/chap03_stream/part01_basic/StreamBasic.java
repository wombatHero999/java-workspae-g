package com.kh.chap03_stream.part01_basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasic {
	/* 
	 * 스트림(Stream API)
	 *  - 데이터의 흐름, 스트림 내부의 데이터를 다른 스트림으로 보내고, 다시 보내는 식으로 무한한 흐름
	 *    을 만들어 낼 수 있는 클래스
	 *  - 주로 컬렉션의 요소들에 대한 데이터 처리시 많이 사용된다.
	 *  - 컬렉션의 데이터를 "함수형 스타일"로 처리할수 있도록 지원하는 클래스.
	 *  - 기존 반복문, 조건문을 사용하여 처리했던 다양한 작업들을 람다식을 통해 제어가 가능하도록 
	 *    다양한 메서드들을 정의해 두었다.
	 *  - 각종 자료구조(컬렉션, 배열, 기본자료형, FILE,..)들을 스트림을 통해 일관성있게 제어할 수
	 *    있도록 정의해 두었다.
	 * 
	 * 스트림의 연산메서드
	 *  - 데이터를 처리하기위한 "중간연산"메서드들과 "최종연산"메서드가 존재
	 *  - 스트림의 데이터 처리 과정
	 *    1) 스트림 생성 및 초기화
	 *    2) 중간연산 N회 수행
	 *    3) 최종연산 1회 수행
	 * 
	 * 스트림의 특징
	 *  - 스트림은 재사용이 불가능.  
	 *  - 스트림은 최종연산 메서드가 호출되기 전까지 실제 연산이 수행되지 않는다.(지연연산)
	 *  - 컬렉션을 통해 스트림으로 변환한 경우, 기존 컬렉션 데이터의 값을 변경하지 않는다.
	 * =============================================================
	 * 
	 * 스트림 객체 생성 방법
	 * 1) 배열을 통한 스트림 생성
	 *  - 배열을 선언 및 할당 , 초기화 후 Arrays.stream()호출
	 *  - 자료형[] 배열 = new 자료형[n]; 초기화;
	 *  - 기본자료형Stream or Stream<자료형>  = Arrays.stream(배열명);
	 * 
	 * 2) 컬렉션을 통한 스트림 생성
	 *  - 컬렉션<자료형> 컬렉션명 = new 컬렉션();
	 *  - Stream<자료형> 스트림 = 컬렉션명.stream();
	 * */
	
	public static void main(String[] args) {
		//1. 배열
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = Arrays.stream(arr);
		
		String[] sArr = {"java","is","fun"};
		Stream<String> stream = Arrays.<String>stream(sArr);
		
		//2. collection을 통한 스트림생성
		ArrayList<Integer> list = new ArrayList<>();
		Stream<Integer> arrayStream = list.stream();
		
		Stream<Integer> setStream = new HashSet<Integer>().stream();
		
		HashMap<String, Integer> map = new HashMap<>();
		Stream<String> mapStream = map.keySet().stream();
		
		// 3. Stream클래스를 통한 스트림 생성
		Stream<String> empty = Stream.<String>empty();
		
		Stream<String> sStream =  Stream.<String>builder()
			.add("A")
			.add("B")
			.build();
		
		Stream<String> oStream = Stream.<String>of("a","b","c","d");
		
		Stream<Integer> iStream =
				Stream.<Integer>generate(() -> 1).limit(100); // 100개의 1데이터
		
		Stream<Integer> iStream2 = 
				Stream.<Integer>iterate(1 , i -> i+1).limit(100);
		
		// 기본자료형스트림을 통한 스트림 생성
		IntStream iStream3 = IntStream.range(1, 5); // [1,2,3,4]
		IntStream iStream4 = IntStream.rangeClosed(1, 5); // [1,2,3,4,5]
		
		// 4. 파일스트림을 통한 스트림 생성
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))  ){
			Stream<String> lines = br.lines();
			lines.forEach((String str) -> System.out.println(str));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Stream의 반복문.
		// 1) 배열의 반복문 -> 출력문
		for(String str : sArr) {
			System.out.println(str);
		}
		
		// 2) 스트림을 통한 반복 출력문
		//     forEach : 스트림을 단순반복시 사용하는 최종연산 메서드
		stream.forEach((String value) -> System.out.println(value));
		
		// 3) 배열을 통해 반복문으로, 배열내부의 값들중 2,4의 배수인 값 들의 합구하기
		int sum = 0;
		for(int i : arr) {
			if(i % 2 == 0 && i % 4 == 0) {
				sum += i;
			}
		}
		
		// 4) 스트림을 통해 위 코드 구현
		// filter -> 조건식의 결과가 true/false가 나오는 람다식을 작성하는 "중간연산" 메서드
		IntStream iStream5 = intStream
			.filter( (int i) -> i % 2 == 0)
			.peek( (int i) -> System.out.println(i))
			.filter( i -> i % 4 == 0);
		
//		try {
//			Thread.sleep(10000); // 지연연산
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
			
		int sum2 = iStream5.sum();// 내부의 값을 모두 더해주는 "최종연산" 메서드
		
		System.out.println(sum+" ::: "+sum2);
		
		iStream5.sum(); // 재사용 불가.
	}
	
	
}















