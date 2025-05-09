package com.kh.chap2_set.part01_hashset.model.vo;

public class Student {
	private String name;
	private int age;
	private int score;
	
	public Student() {
		
	}

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		return (name+age+score).hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) { // 주소값이 동일한 경우 
			return true;
		}
		
		if(o == null) {
			return false;
		}
		
		if(getClass() != o.getClass()) {
			return false;
		}
		
		Student other = (Student) o;
		
		if(age != other.age) {
			return false;
		}
		
		if(score != other.score) {
			return false;
		}
		
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		} else if(!name.equals(other.name)) {
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
}
















