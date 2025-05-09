package com.kh.chap2_set.part01_hashset.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.kh.chap2_set.part01_hashset.model.vo.Student;

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
		System.out.println(hs1.size());
		
		hs1.remove("여러분"); // 삭제할 값을 제시.
		System.out.println(hs1);
		
		System.out.println("-------------------------------");
		
		// 반복처리
		for(String s : hs1) {
			System.out.println(s);
		}
		
		// set계열을 list계열로 옮겨 담는 방법들
		ArrayList<String> list = new ArrayList<>(hs1); // 컬렉션의 데이터를 배열에 모두 담은상태로 컬렉션 생성
		list.addAll(hs1);
		System.out.println(list);
		
		// Iterator사용
		Iterator<String> it = hs1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("=====================================");
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("공유",40,100));
		hs2.add(new Student("홍길동",20,10));
		hs2.add(new Student("김유신",20,30));
		hs2.add(new Student("공유",40,100));
		
		System.out.println(hs2); 
		
		/*
		 * HashSet에 객체를 저장할 때는
		 *  1. 객체의 hashCode()함수로 저장할 위치를 찾아가고
		 *  2. 저장한 위치에 이미 저장된 값이 있다면 eqauls()를 통해 저장된 값과 새로 추가할 값이
		 *     같은지 검사한다.
		 *  3. 두 값이 같다면 , 데이터를 중복으로 저장하지 않고, 두 값이 다르다면 저장된값의 다음위치에
		 *     새로운 값을 저장한다.
		 *  */
		
		// LinkedHashSet : 저장순서 유지
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(34); //  current 34 , next : 4545
		set1.add(4545); // current 4545, next : 111
		set1.add(111); // current 111, next : null
		set1.add(1);
		System.out.println(set1);
		// Linked는 왜 head랑 tail을 같이 보관하나?
		
		// TreeSet -> 정렬
		// set내부에 데이터가 추가될때 compare,compareTo메서드를 자동 실행.
		Set<Integer> set2 = new TreeSet<>(set1);
		// ArrayList, set을 매개변수로 추가시 안에 담긴 데이터의 기본정렬방식대로 정렬
		// Comparator객체를 추가하면, 이후 set에 데이터를 추가할때 Comparator에 정의한
		// 정렬조건대로 정렬이 이루어 진다.		
		System.out.println(set2);
	}
}


















