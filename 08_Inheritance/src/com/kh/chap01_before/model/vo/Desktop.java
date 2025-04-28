package com.kh.chap01_before.model.vo;

public class Desktop {
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	private boolean allInOne;
	
	/* 
	 * TV, Desktop, SmartPhone, ... 가전제품 클래스들을 만들때 마다
	 * 각 클래스에 필요한 필드들을 작성시 "중복으로 들어가는 코드가 많은 경우" 유지보수 과정에서
	 * 수정이 필요한 경우 모든 필드들을 일일이 수정해야하는 번거로움이나, 새로운 공통 필드 추가시의 
	 * 번거로움등, 생산성 측면에서 안좋은 영향을 끼치게 된다.
	 * 
	 * 이럴 때는 상속이라는 개념을 적용시켜서 
	 * 매 클래스마다 중복된 필드 및 메서드들을 하나의 클래스에 정의해둔 후 , 해당 클래스를 "상속"받는 식으로
	 * 작업하는게 좋다.
	 * */

}



















