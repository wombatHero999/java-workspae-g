package com.kh.chap02_abstract.part02.run;

import com.kh.chap02_abstract.part02.model.vo.Baby;
import com.kh.chap02_abstract.part02.model.vo.Basic;
import com.kh.chap02_abstract.part02.model.vo.Mother;
import com.kh.chap02_abstract.part02.model.vo.Person;

public class Run {
	public static void main(String[] args) {
		
		Basic b; // = new Basic();
		b = new Mother("정선이", 50, 50);
		Basic b2 = new Baby("민경민",80,50);
		
		b.eat();
		((Mother)b).sleep();
		b2.eat();
		((Person)b2).sleep();
		
		System.out.println(b);
		System.out.println(b2);
	}
}








