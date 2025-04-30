package com.kh.hw.person.model.vo;

public class Employee extends Person {

	private int salary;
	private String dept;

	public Employee() {
		super();
	}

	public Employee(String name, int age) {
		super(name, age);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", dept=" + dept + "]";
	}

}
