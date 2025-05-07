package com.kh.model.vo;

public class Goblin extends Monster {
	
	
	public Goblin() {
		super();
	}

	public Goblin(String name, int atk, int hp, int exp) {
		super(name, atk, hp, exp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(Characters c) {
		// 고블린의 공격 : atk ~ atk 사이의 대미지. 
		int dmg = getAtk();
		System.out.println("고블린이 몽둥이를 휘두릅니다!");
		c.setHp(c.getHp() - dmg);
		
		System.out.println(c.getName()+" 체력 -"+dmg+", 남은 체력 : "+c.getHp());
	}
}
