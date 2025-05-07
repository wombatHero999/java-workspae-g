package com.kh.model.vo;

public class Orc extends Monster {
	
	private int count = 0;
	
	public Orc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orc(String name, int atk, int hp, int exp) {
		super(name, atk, hp, exp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(Characters c) {
		// 오크의 공격 : atk ~ atk 사이의 대미지. 
		// 오크는 3번째 공격마다 체력을 회복
		if(++count % 3 == 0) {
			heal();
		}
		int dmg = getAtk();
		System.out.println("오크가 도끼를 휘두릅니다!");
		c.setHp(c.getHp() - dmg);
		
		System.out.println(c.getName()+" 체력 -"+dmg+", 남은 체력 : "+c.getHp());
	}
	
	private void heal() {
		// 체력 회복량 : 20
		System.out.println("오크가 휴식을 취합니다 ! ");
		setHp(getHp()+20);
		System.out.println("오크의 체력 +"+20+", 남은 체력 : "+getHp());
	}
}








