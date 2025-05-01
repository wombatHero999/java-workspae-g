package com.kh.chapr04_date.run;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Run {	
	
	public static void main(String[] args) {
		Run r = new Run();
		r.test5();
	}
	
	/*
	 * Calendar : 날짜와 시간에 관한 데이터를 처리하는 추상클래스. 
	 *  */
	public void test1() {
		
		// 현재 날짜 , 시간정보 조회
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = Calendar.getInstance();
		
		// 현재시간 조회
		System.out.println(cal2);
		
		System.out.println(cal2.get(Calendar.YEAR));
		System.out.println(cal2.get(Calendar.MONTH) + 1); // 0월 부터 시작. 
		System.out.println(cal2.get(Calendar.DATE));
		
		System.out.println(cal2.get(Calendar.HOUR));
		System.out.println(cal2.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal2.get(Calendar.MINUTE));
		System.out.println(cal2.get(Calendar.SECOND));
	}
	
	// 특정일, 특정시간을 Calendar객체로 생성
	public void test2() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2026, 0 , 1 , 0, 0, 0);
		
		Calendar cal2 = new GregorianCalendar(2026,1,1,0,0,0);
		printCalendar(cal1);
		printCalendar(cal2);
		
		// 날짜 차이 계산
		Calendar now = Calendar.getInstance();
		
		// 각 시간각체가 보관중인 밀리초값을 통해 시간을 계산
		// 1970년 1월 1일 자정기준 흐른 밀리초
		long num1 = now.getTimeInMillis(); // 1970년1월1일 ~ 2025년5월1일 까지의 밀리초
		long num2 = cal1.getTimeInMillis();// 1970년1월1일 ~ 2025년12월31일 까지의 밀리초
		
		// 1000mills == 1s 
		long diff = (num2 - num1) / 1000 / 60 / 60 / 24;
		
		System.out.println(diff);
		System.out.println("새해까지 D-"+ (diff + 1) +"일 남았습니다.");
	}
	
	// Date클래스
	//  - 날짜와 시간에 대한 정보를 담을 수 있는 클래스
	//  - java.text.SimpleDateFormat과 연계하여 내가 원하는 시간문자열을 얻을 수 있다.
	//  - 자바개발 초창기에 급하게 만들어진 클래스가 완성도가 높지 않다.(다국적으로 쓰기에 부적합)
	public void test3() { 
		
		// 현재시간 정보를 가진 Date객체
		Date today = new Date();
		System.out.println("기본생성자 : "+today);
		
		// 내가 원하는 날짜를 가진 Date객체를 생성할 때
		// 2025년 5월 2일로 객체 생성
		// 년도 설정시에는 생성하고자하는 년도 - 1900
		Date date1 = new Date(2025 - 1900, 4, 2 , 0, 0 ,0);
		System.out.println("매개변수 생성자 : "+date1);
		
		// 년월일시분초 말고, 내가원하는 날짜의 mills를 넣어서 초기화
		Calendar cal2 = new GregorianCalendar(2025,4,2,0,0,0);
		long mills = cal2.getTimeInMillis();
		
		Date date2 = new Date(mills); // 이거랑 기본생성자만 사용한느걸 권장
		System.out.println("long타입 매개변수 생성자 : "+date2);
	}
	
	// SimpleDateFormat
	//  내가 원하는 포맷의 문자열로 시간객체를 변경해주는 기능을 가진 클래스
	public void test4() {
		// xxxx년 xx월 xx일 xx시 xx분 xx초
		
		// 1. 매개변수 생성자로 문자열 포맷 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		
		Date d = new Date();
		String result = sdf.format(d);
		System.out.println(result);
	}
	
	/* 
	 * 숫자값 형식 지정
	 *  - DecimalFormat
	 * */
	public void test5() {
		double num = 1234567890.123;
		// # 해당 자리에 데이터가 없는 경우 생략시키는 기호
		// 0 해당 자리에 데이터가 없는 경우 0으로 채우는 기호
		DecimalFormat df = new DecimalFormat("$#,###.00000");
		System.out.println(df.format(num));
	}
	
	public void printCalendar(Calendar c) {
		System.out.printf("%d/%02d/%02d %02d:%02d:%02d\n", 
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH)+1,
				c.get(Calendar.DATE),
				c.get(Calendar.HOUR_OF_DAY),
				c.get(Calendar.MINUTE),
				c.get(Calendar.SECOND));
	}
	
	
	
	
	
	
	
	
}















