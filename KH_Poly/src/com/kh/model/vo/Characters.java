package com.kh.model.vo;

public abstract class Characters implements Skill {
	private String name;
	private int level;
	private int atk;
	private int hp;
	private int maxHp;
	private int exp;

	protected Characters() {

	}

	public Characters(String name, int level, int atk, int hp, int maxHp, int exp) {
		super();
		this.name = name;
		this.level = level;
		this.atk = atk;
		this.hp = hp;
		this.maxHp = maxHp;
		this.exp = exp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getExp() {
		return exp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		if (this.exp >= level * 100) {
			System.out.println("레벨업!!");
			levelup();
			System.out.println("현재 정보 : ");
			System.out.println(this.toString());
		}
	}

	public abstract void levelup();

	@Override
	public String toString() {
		return "이름: " + name + ", 레벨: " + level + ", 공격력: " + atk + ", HP: " + hp + ", 경험치: " + exp;
	}

	public abstract void attack(Monster m);
}














