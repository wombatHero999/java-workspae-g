package com.kh.chap02_override.run;

import com.kh.chap02_override.model.vo.Book;

public class Run {
	
	public static void main(String[] args) {
		// 모든 클래스는 Object클래스를 상속 받는다. 즉, 자바의 최상위 클래스는 Object.
		// 즉, Object 정의된 메소드들은 모두 사용 가능하며, 필요하다면 오버라이딩을 통해 재정의 가능.
		Book bk = new Book("수학의 정석","수학학" , 15000);
		
		System.out.println(bk);
		System.out.println(bk.toString());
	}
	
	public void method() {
		
	}
	
	
	
	
}









