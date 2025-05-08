package com.kh.chap_list.arrayList.run;

import java.util.ArrayList;

import com.kh.chap_list.arrayList.model.vo.Music;

public class Run {
	/*
	 * 컬렉션(Collection)
	 *  - 자료구조가 내장되어 있는 클래스로, 자바에서 제공하는 "자료구조"담당 프레임워크.
	 *  
	 * 자료구조
	 *  - 메모리상에서 데이터들을 효율적으로 다루기 위해 필요한 개념
	 * 
	 * 프레임워크
	 *  - 효율적인 기능들이 정의되어 있는 틀
	 *  
	 * 배열과 컬렉션(List)의 차이점 
	 * 
	 * 배열의 특징
	 *  1. 동일한 자료형의 데이터를 관리
	 *  2. 한번 선언한 후 크기가 고정
	 *  3. 데이터저장 외 기능이 존재하지 않는다.
	 *  
	 * 컬렉션(List)의 특징
	 *  1. 여러타입의 데이터를 동시에 보관할 수 있다.
	 *  2. 크기에 제약이 없다.
	 *  3. 다양한 기능들이 정의되어 있다. 
	 *  
	 * 컬렉션의 3가지 분류
	 * 
	 * 1. List계열 
	 *      - 담고자하는 값만을 관리하는 클래스
	 *      - 값을 저장할 때 인덱스를 활용하여 저장 순서를 유지
	 *      - 중복된 값이 들어와도 문제 없다.
	 *      - 대표클래스 : "ArrayList", Vector, LinkedList 등이 존재.
	 * 2. Set계열
	 *      - 담고자하는 값만을 관리하는 클래스
	 *      - 값을 저장할 때 인덱스를 사용하지 않기 때문에 저장순서가 유지되지 않는다.
	 *      - 중복값을 허용하지 않는다.(Set)
	 *      - 저장된 값이 곧 저장위치가 된다.
	 * 		- 대표클래스 : HashSet, TreeSet
	 * 3. Map계열  
	 *      - 담고자하는 값과 그 "값"을 꺼낼수 있는 "키"를 함께 저장하는 클래스
	 *      - 값을 저장할 때 인덱스를 사용하지 않기 때문에 저장순서가 유지되지 않는다.
	 *  	- key값은 중복을 허용하지 않으나, value값을 중복을 허용한다.
	 *      - 대표클래스 : HashMap, Properties
	 *  */
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		ArrayList list2 = new ArrayList<String>(3);
		
		// 제네릭<E>
		// 컬렉션에 저장할 객체의 타입을 고정하기 위해 사용하는 타입변수
		ArrayList<Music> list3 = new ArrayList<Music>(3);
		
		System.out.println(list3);		
		
		// 1. add(E e) : 리스트의 size에 e를 저장하는 메서드
		list3.add(new Music("someone like you","Adel"));
		list3.add(new Music("너의번호를누르고","박명수"));
		list3.add(new Music("벛꽃엔딩","장범준"));
		
		System.out.println(list3);
		
		// 2. add(int index, E e) : 인덱스 위치에 e값을 추가하는 메서드.
		list3.add(1 , new Music("바다의 왕자","박명수"));
		// 배열의 용량(capacity)보다 더 많은 데이터를 저장하는 경우 기존배열보다 크기가 1 더큰 배열을 생성한 후 깊은 복사를 한다.
		
		System.out.println(list3);
		
		// 3. set(int index, E e) : 리스트의 인덱스위치의 값을 e로 "변경"시켜주는 메서드
		list3.set(0, new Music("불장난","에스파"));
		
		System.out.println(list3);
		
		// 4. remove(int index) : 인덱스위치에 저장된 데이터를 삭제시켜주는 메서드.
		list3.remove(0);
		System.out.println(list3);
		
		// 5. size() : 리스트에 초기화된 데이터의 수를 반환해주는 메서드.
		System.out.println("리스트에담긴 데이터의 수 : "+list3.size());
		
		// 6. get(int index) : 인덱스 위치의 데이터를 반환해주는 메서드
		
		
	}

}













