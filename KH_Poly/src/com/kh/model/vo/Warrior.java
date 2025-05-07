package com.kh.model.vo;

public class Warrior extends Characters implements Skill {

	public Warrior() {
		super();
	}

	public Warrior(String name, int level, int atk, int hp ,int maxHp, int exp) {
		super(name, level, atk, hp, maxHp,exp);
	}

	@Override
	public void levelup() {
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+10);
		setHp(getMaxHp());
		setAtk(getAtk()+2);
	}

	@Override
	public void attack(Monster m) {
		// 전사의 공격 : 1 ~ atk * 3 사이의 랜덤 대미지.
		// atk == 15 ? 1 ~ 45
		int atk = getAtk();
		int dmg = (int) (Math.random() * (atk * 3) + 1);
		System.out.println(getName() + "이 검을 휘둘렀습니다!");
		m.setHp(m.getHp() - dmg);

		System.out.println(m.getName()+" 체력 -" + dmg + ", 남은 체력 : " + m.getHp());
	}

	@Override
	public void useSkill(Monster m) {
		// 스킬 = atk * 2;
		System.out.println(getName() + "이 스킬 강타를 사용했습니다!");
		int dmg = getAtk() * 2;
		m.setHp(m.getHp() - dmg);
		System.out.println(m.getName()+" 체력 -" + dmg + ", 남은 체력 : " + m.getHp());
	}

	@Override
	public String toString() {
		return "직업: 전사 , " + super.toString();
	}

}
