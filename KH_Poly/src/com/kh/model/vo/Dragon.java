package com.kh.model.vo;

public class Dragon extends Monster {
	
	private int count = 0;
	
	public Dragon() {
		super();
	}

	public Dragon(String name, int atk, int hp, int exp) {
		super(name, atk, hp, exp);
	}

	@Override
	public void attack(Characters c) {
		// 드래곤의 공격 : atk ~ atk 사이의 대미지.
		// 드래곤은 매 3번째 공격마다 breath를 발동		
		if(++count % 3 == 0 ){
			breath(c);
			return;
		}
		int dmg = getAtk();
		System.out.println("드래곤이 발톱을 휘두릅니다!");
		c.setHp(c.getHp() - dmg);
		
		System.out.println(c.getName() + " 체력 -" + dmg + ", 남은 체력 : " + c.getHp());
	}
	
	private void breath(Characters c) {
		// breath대미지 : atk * 5
		int dmg = getAtk() * 5;
		System.out.println("드래곤이 막강한 화염을 토해냅니다!!");
		c.setHp(c.getHp() - dmg);
		
		System.out.println(c.getName() + " 체력 -" + dmg + ", 남은 체력 : " + c.getHp());
		
	}
	
	
	
	
	
	
	
	
}
