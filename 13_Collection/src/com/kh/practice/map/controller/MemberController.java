package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String,Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m) {
		// 전달 받은 id가 없다면 id와 m을 map에 추가 후 true 반환 
		// 있다면 false 값 반환
		if(map.containsKey(id)) {
			return false;
		}
		
		map.put(id, m);
		return true;
	}
	
	public String logIn(String id, String password) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(password) ) {
			return map.get(id).getName();
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(oldPw) ) {
			map.get(id).setPassword(newPw);
			return true;
		}
		return false;		
	}
	
	public void changeName(String id, String newName) {
		if(map.containsKey(id)) {
			map.get(id).setName(newName);
		}
	}
	
	public TreeMap sameName(String name) {
		// 전달 받은 name이 저장된 데이터의 이름과 같으면 
		// key로 오름차순 해주는 객체(TreeMap)에 해당 id와 이름 저장 후 객체 반환 
		// 단, 엘리먼트 하나씩 뽑아내는 과정에서 keySet()을 쓸 것 
		
		Set<String> keySet = map.keySet();
		TreeMap<String , Member> tm = new TreeMap<>();
		for(String key : keySet) {
			if(map.get(key).getName().equals(name)) {
				tm.put(key, map.get(key));
			}
		}
		
		return tm;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}















