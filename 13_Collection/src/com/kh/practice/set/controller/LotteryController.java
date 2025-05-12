package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<>();
	private HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		  // 전달 받은 l을 lottery에서 삭제 
		  // 당첨자 목록(win) 중에 삭제된 추첨 대상자가 존재할 수 있으니 
		  // 삭제 결과인 boolean 값과 win객체가 null이 아닐 때에만  
		  // win에도 해당 추첨 대상자 삭제
		boolean result = lottery.remove(l);
		
		if(result && win != null && !win.isEmpty()) {
			win.remove(l);
		}
		
		return result;
	}
	
	public HashSet winObject() {
	  // 랜덤으로 뽑기 위해 lottery를 ArrayList에 담고,
	  ArrayList<Lottery> list = new ArrayList<>(lottery);
	  // 인덱스를 이용해 win에 당첨자 저장 
	  
	  if(list.size() < 4) {
		  return null;
	  }
	  
	  while(win.size() < 4) {
		  // 랜덤인덱스의 범위 0 - size()-1	  
		  int random = new Random().nextInt(list.size());  // (int)(Math.random() * list.size());
		  win.add(list.get(random));		  
	  }
	  
	  return win;
	}
	
	public TreeSet sortedWinObject() {
		// 이름으로 오름차순 정렬하되, 이름이 같으면 번호로 오름차순 하는 
		// 정렬기준을 가지고 정렬된 결과를 반환
		// 이 때, 미리 만들어진 win을 가지고 정렬하기 때문에 
		// 당첨 대상 확인을 꼭 먼저 해야함
		winObject();
		
		TreeSet<Lottery> ts = new TreeSet<>(new SortedLottery()); 
		ts.addAll(win);
		
		return ts;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);		
	}
}
















