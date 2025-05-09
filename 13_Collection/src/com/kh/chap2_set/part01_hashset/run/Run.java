package com.kh.chap2_set.part01_hashset.run;

import java.util.HashSet;

public class Run {

	public static void main(String[] args) {
		/* 
		 * Set
		 *  - 중복을 허용하지 않는 자료구조
		 *  - 저장된 순서를 보장하지 않는다.
		 * HashSet : 중복을 허용하지 않고, 빠르게 저장이 가능한 자료구조.
		 * LinkedHashSet : 중복을 허용하지 않지만, 저장된 순서는 유지.
		 * TreeSet       : 중복을 허용하지 않지만, 오름차순 정렬을 지원.
		 * */
		HashSet<String> hs1 = new HashSet<>();
		
		// add : 값 추가
		hs1.add("반갑습니다");
		hs1.add("반갑습니다");
		hs1.add("여러분");
		hs1.add("여러분");
		hs1.add("안녕하세요");
		
		System.out.println(hs1); // 중복값 x, 저장순서 x
		
	}
}


















