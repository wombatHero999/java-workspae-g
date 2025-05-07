package com.kh.model.vo;

public class Archer extends Characters implements Skill {

	public Archer() {
		super();
	}

	public Archer(String name, int level, int atk, int hp ,int maxHp, int exp) {
		super(name, level, atk, hp, maxHp,exp);
	}

	@Override
	public void levelup() {
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+5);
		setHp(getMaxHp());
		setAtk(getAtk()+3);
	}


	@Override
	public void attack(Monster m) {
		// 궁수 공격 : atk + level*2
		int dmg = getAtk() + getLevel() * 2;
		System.out.println(getName() + "이 화살을 쏩니다!");
		m.setHp(m.getHp() - dmg);

		System.out.println(m.getName()+" 체력 -" + dmg + ", 남은 체력 : " + m.getHp());
	}

	@Override
	public void useSkill(Monster m) {
		// 스킬 = atk * 2 + level *3;
		System.out.println(getName() + "이 스킬 멀티샷을 사용했습니다!");
		int dmg = getAtk() * 2 + getLevel() * 3;
		m.setHp(m.getHp() - dmg);
		System.out.println(m.getName()+" 체력 -" + dmg + ", 남은 체력 : " + m.getHp());
	}

	@Override
	public String toString() {
		return "직업: 궁수, " + super.toString();
	}
}
