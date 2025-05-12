package com.kh.chap4_map.part02_clone.run;

import com.kh.chap4_map.part01_hashMap.model.vo.Snack;

public class HashMapRun <K , V> {
	
	private Entry<K, V>[] table;
	private int capacity; // 배열의 크기
	private int size; // 초기화된 수
	
	class Entry <K, V>{
		K key;
		V value;
		Entry<K, V> next;
		
		public Entry(K key, V value, Entry<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public HashMapRun(int capacity) {
		this.capacity = capacity;
	}
	
	public static void main(String[] args) {
		HashMapRun<String, Snack> hm = new HashMapRun<>(10); // 크기 10 
		hm.put("다이제", new Snack("초코맛",800));
		
	}
	
	public int getIndex(K key) {
		// 매개변수로 전달받은 key을 활용하여 table의 저장할 인덱스 위치를 구하는 함수.
		// key값에 hashcode()를 적용
		// hashcode값이 음수일 수 있으므로, 절대값으로 변환
		// 배열의 크기만큼 나머지 연산 수행
		// 113355 % 10 => 5번 인덱스
		// 12345678 % 10 => 8번 인덱스
		// 77777788 % 10 => 8번 인덱스
		return Math.abs(key.hashCode()) % capacity;
	}
	
	public void put(K key, V value) {
		// getIndex함수 호출후 반환값으로 table의 index에 접근  
		int index = getIndex(key);
		
		Entry<K, V> newEntry = new Entry<>(key, value, null);
		
		// table의 index위치에 값이 초기화 되어있는지 확인하기.
		if(table[index] == null) {
			table[index] = newEntry;			
		}else {
			// index위치에 이미 초기화된 데이터가 들어가 있다면? 
			// "다이제" , "다이제" => 중복 키값
			//  - 덮어쓰기
			if(table[index].key.equals(newEntry.key)) {
				table[index].value = newEntry.value;
				return; // size가 추가되지 않도록 종료.
			}else {
				// "다이제" , "칸초" ,"칸초" => 우연히 hashcode중복으로 충돌이 발생한 경우
				//  - 다이제가 저장된 entry의 next에 칸초를 저장.
				
				while(true) {
					if(table[index].key.equals(newEntry.key)) {
						table[index].value = newEntry.value;
						return;
					}
					
					if(table[index].next == null) {
						table[index].next = newEntry;		
						break;
					}			
					//
				}
			}
			
		}
		
		size++;
		// 접근시 내부의 값이 null이라면 Entry매개변수 있는 생성자를 이용하여 
		// 객체생성후 비어있는 저장공간에 Entry객체 추가하기. 
		//  ex) 최초 Entry 객체 생성시 : new Entry(key, value , null) 
		// 값이 null이 아니라면 , entry에 저장된 key값과 새롭게 추가하려는 entry의 
		// key값이 동일한지 검사후 동일하다면 , 중복값이므로 value값만 덮어씌우고 
		// key값이 다르다면 현재 entry의 next요소에 entry객체 저장. 
		// 만약 next에도 이미 값이 존재하는경우, next가 없는 entry를 찾을때까지 반복  
		// 중복값을 제외하고, 값이 새롭게 추가된경우 size 증가
	}
	
	public V get(K key) {
		
	}
	
	public void remove(K key) {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean containsKey(K key) {
		
	}
	
	
}
















