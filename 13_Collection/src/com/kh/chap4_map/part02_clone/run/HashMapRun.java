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
		table = new Entry[capacity];
	}
	
	public static void main(String[] args) {
		HashMapRun<String, Snack> hm = new HashMapRun<>(10); // 크기 10 
		hm.put("다이제", new Snack("초코맛", 1500)); 
		hm.put("칸초", new Snack("단맛", 600)); 
		hm.put("새우깡", new Snack("짠맛", 500)); 
		hm.put("포테이토칩", new Snack("짠맛", 500)); 
		
		System.out.println(hm.get("새우깡"));
		hm.put("새우깡", new Snack("메운맛",700));
		System.out.println(hm.get("새우깡"));
		
		hm.remove("포테이토칩");
		System.out.println(hm.get("포테이토칩"));
		System.out.println(hm);
		
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
				
				// "다이제" , "칸초", "새우깡" 모두 같은 인덱스를 공유하는 경우
				Entry<K, V> next = table[index];
				while(true) {
					if(next.key.equals(newEntry.key)) {
						next.value = newEntry.value;
						return;
					}
					
					if(next.next == null) {
						next.next = newEntry;		
						break;
					}			
					//
					next = table[index].next;
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
		// getIndex함수 호출후 반환값으로 table의 index에 접근  
		int index = getIndex(key);
		Entry<K, V> e = table[index];
		
		// 접근시 내부의 값이 null이라면 null값 반환
		if(e == null) {
			return null;
		}else {
			// 객체가 있다면 저장된 객체의 key값과 매개변수로 전달받은 key값 확인 
			do {
				if(e.key.equals(key)) {
					return e.value;
				}
				e = e.next;
			}while(e != null);
		}
		return null;
		// 동일하다면 객체에 저장된 value값 반환. 
		// 동일하지 않다면 노드드의 next 값을 찾아 다시한번 검사 (next가 존재하지  
		// 않을때까지 반복). 다음 노드들 중에서 key값이 일치하는 값이 존재한다면  
		// 노드 내부의 value값 반환. 일치하는 key값이 없었다면 null값 반환
	}
	
	public void remove(K key) {
		int index = getIndex(key);
		Entry<K, V> e = table[index];
		
		if(e == null) {
			return;
		}		
		Entry<K, V> prev = null;
		do {
			if(e.key.equals(key)) {
				// 첫번째 entry인지 확인
				if(e == table[index]) {
					// e.next값이 null이 아니라면 e.next값을 대입
					table[index] = (e.next != null ? e.next : null);
				}else {
					prev.next = e.next;
				}
				size--;
				return;
			}
			prev = e;
			e = e.next;
		}while(e != null);
		// 객체가 있다면 저장된 객체의 key값과 매개변수로 전달받은 key값 확인 
		// 동일하다면 현재 Node삭제.  
	}
	
	public int size() {
		return size;
	}
	
	public boolean containsKey(K key) {
		// getIndex함수 호출후 반환값으로 table의 index에 접근  
		// 접근시 내부의 값이 null이라면 null값 반환  
		// 객체가 있다면 저장된 객체의 key값과 매개변수로 전달받은 key값 확인 
		// 동일하다면 true반환, 일치하지 않는다면 node의 next값을 찾아 일치하는 것을 
		// 찾을때까지 검사. 일치하는 값을 찾았다면 true/ 찾지 못했다다면 false 반환
		int index = getIndex(key);
		Entry<K, V> e = table[index];
		
		if( e == null) {
			return false;
		}
		do {
			if(e.key.equals(key)) {
				return true;
			}
			e = e.next;
		}while(e != null);
		
		return false;		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for(Entry e : table) {
			if(e == null) continue;
			// {key : value}
			sb.append("{").append(e.key).append(" : ").append(e.value).append("}").append(",");	
			
			Entry next = e.next;
			do {
				if(next != null) {
					sb.append("{").append(next.key).append(" : ").append(next.value).append("}").append(",");	
					next = next.next;
				}
			}while(next != null); // 
		}
		//sb.append(Arrays.toString(table));
		
		sb.append('}');
		
		return sb.toString();
	}
	
}
















