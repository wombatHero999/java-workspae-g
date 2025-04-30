package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Person;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	private Student[] s = new Student[3];// [new Student(), null, null]
	private Employee[] e = new Employee[10];
	
	private int sIndex = 0;
	private int eIndex = 0;
	
	public int[] personCount() {
		int [] arr = new int[2];// [0 , 0]
		
		// 배열의 인덱스에 들어간 값이 null이라면 저장되지 않은 인덱스 
		for(int i =0; i<s.length; i++) {
			if(s[i] != null) {
				// 초기화가 완료된 인덱스
				arr[0] += 1;
			}
		}
		
		for(Employee emp : e) {
			if(emp != null) {
				arr[1] += 1;
			}
		}
		return arr;		
	}
	
	public void insertStudent(String name, int age, int grade, String major) {
		Student std = new Student(name,age,grade,major);
		
		for(int i =0; i<s.length; i++) {
			if(s[i] == null) { // 비어있는 공간 찾기
				s[i] = std;
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		return s;
	}
	
	public void insertEmployee(String name, int age, int salary, String dept) {
		
	}
	
	public Employee[] printEmployee() {
		
	}
	
}









