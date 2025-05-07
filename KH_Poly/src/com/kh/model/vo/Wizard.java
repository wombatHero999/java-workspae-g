package com.kh.model.vo;

public class Wizard extends Characters implements Skill {
	public Wizard() {
		super();
	}

	public Wizard(String name, int level, int atk, int hp ,int maxHp, int exp) {
		super(name, level, atk, hp, maxHp,exp);
	}

	@Override
	public void levelup() {
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+4);
		setHp(getMaxHp());
		setAtk(getAtk()+4);
	}

	@Override
	public void attack(Monster m) {
		// 마법사의 공격 : atk ~ atk 사이의 대미지.
		// atk == 15 -> 15 ~ 15
		int dmg = getAtk();
		System.out.println(getName() + "이 지팡이를 휘둘렀습니다!");
		m.setHp(m.getHp() - dmg);

		System.out.println(m.getName()+" 체력 -" + dmg + ", 남은 체력 : " + m.getHp());
	}

	@Override
	public void useSkill(Monster m) {
		// 스킬 = atk * 3;
		System.out.println(getName() + "이 스킬 지건을 사용했습니다!");
		int dmg = getAtk() * 3;
		m.setHp(m.getHp() - dmg);
		System.out.println(m.getName()+" 체력 -" + dmg + ", 남은 체력 : " + m.getHp());
	}

	@Override
	public String toString() {
		return "직업: 마법사, " + super.toString();
	}
}
