package com.kh.chap02_lamda.part03_FuntionalInterface;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuntionalInterface {
	
	public static void main(String[] args) {
		/*
		 * 함수형 인터페이스
		 *  - 람다식을 통해 구현되는 추상메소드를 가지고 있는 인터페이스.
		 *  - 오직 1개의 추상메서드만 가지고 있다
		 *  - 람다식을 사용하기 위해서는 함수형 인터페이스가 필요하다.
		 * 
		 *  자바 대표 함수형 인터페이스
		 *   - 제네릭을 사용하여 확장성을 높였다
		 *  
		 *    인터페이스       |    추상메서드
		 *  =======================
		 *  1. Runnable     |   run() : void 
		 *  2. Supplier<R>  |   get() : R 
		 *  3. Consumer<T>  |   accept(T) : void
		 *  4. Function<T,R>|   apply(T) : R
		 *  5. Predicate<T> |   test(T) : boolean
		 *  */
		Runnable r = () -> {
			for(int i =0; i< 10; i++) {
				System.out.println(new Date());
			}			
		};
		r.run();
		
		// 2. Supplier : 공급역할의 함수 : 매개변수는 없고, 반환값이 있는 함수
		Supplier<Long> supplier = () -> new Date().getTime();
		System.out.println(supplier.get());
		
		// 3. Consumer : 매개변수 있고, 리턴값이 없는 형식의 람다식 구현
		Consumer<String> con = name -> System.out.println("이름 : "+name);
		con.accept("홍길동");
		
		// 4. Function : 매개변수와 리턴값 모두 존재
		Function<String, Integer> function = (str) -> str.length(); 
		function.apply("안녕하세요"); // 5
		
		// 5. Predicate : 매개변수 있고, 반환값은 boolean
		Predicate<Integer> predicate = n -> n % 2 == 0 && n % 5 == 0;
		boolean result = predicate.test(11);
		System.out.println(result);
		
		
	}

}











