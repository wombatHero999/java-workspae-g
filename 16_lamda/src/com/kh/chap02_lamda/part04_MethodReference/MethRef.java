package com.kh.chap02_lamda.part04_MethodReference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethRef {
	/* 
	 * 람다식 메서드 참조(Method Reference)
	 *  - 기존 람다식 구문 중 이미 존재하는 메서드와 코드가 일치하는 경우, 이미 존재하는 메서드를
	 *    참조하는 방식으로 코드를 더욱 간결하게 바꿀 수 있다.
	 *    EX) (String str) -> {return str.length();};  
	 *        String::length;
	 *  - 람다식을 통해 구현한 기능이 이미 정의되어있는 다른 메소드의 기능을 그대로 사용하는 경우,
	 *    다른 메서드의 이름을 통해 호출할 메서드를 정의하는 것
	 *  
	 *   메서드 참조의 종류
	 *   1. static메서드 참조
	 *   2. 일반 메서드 참조
	 *   3. 객체 메서드 참조
	 *   4. 생성자 참조
	 *  
	 *  - 메소드 참조문은 컴파일 과정에서 다시한번 람다식으로 변환됨.
	 *  - 메소드 참조문 사용시 메모리를 좀더 효율적으로 사용 가능하므로 사용하는걸 권장.
	 * */
	public static void main(String[] args) {
		
		Consumer<String> print; // <S> -> void;
		print = (str) -> System.out.println(str);
		print.accept("lambda");
		
		print = System.out::println;
		print.accept("is fun");
		
		// 1. static메서드 참조
		Function<String, Integer> parser;
		parser = (str) -> Integer.parseInt(str);
		parser = Integer::parseInt;
		
		// 2. 일반 메서드 참조
		// 1) String.length() : 
		Function<String, Integer> strLength;
		strLength = (s) -> s.length();
		strLength = String::length;
		
		// 2) s1.equals(s2) : boolean
		BiFunction<String, String, Boolean> strEquals;
		strEquals = (s1 , s2) -> s1.equals(s2);
		strEquals = String::equals;
		
		// 3) 객체 메서드 참조
		String title = "소나기";
		Predicate<String> equalsToTitle;
		equalsToTitle = (str) -> title.equals(str);
		equalsToTitle = title::equals;
		
		// 4) 생성자 참조
		class Person {
			private String name;
			private int age;
			
			public Person() {
				
			}
			
			public Person(String name) {
				
			}
			
			public Person(String name, int age) {
				
			}
		}
		
		Supplier<Person> personSupplier;
		personSupplier = () -> new Person();
		personSupplier = Person::new;
		
		Function<String, Person> personFunction;
		personFunction = (name) -> new Person(name);
		personFunction = Person::new;
		
		
		
	}
}

















