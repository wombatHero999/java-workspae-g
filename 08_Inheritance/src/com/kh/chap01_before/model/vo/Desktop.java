package com.kh.chap01_before.model.vo;

            // 자식            부모
public class Desktop extends Product{
//	private String brand;
//	private String pCode;
//	private String pName;
//	private int price;
	private boolean allInOne;
	
	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
		//super(); // super : 현재 클래스의 부모클래스의 주소값을 담고있는 변수
		         // super() : 부모클래스의 생성자를 호출
		// 부모객체 내부의 필드값들을 초기화 할 수 있는 방법
		// 1. 부모클래스의 매개변수 생성자를 호출하여 필드 초기화
		//super(brand, pCode, pName, price); // 부모생성자는 항상 자식생성자의 첫번째줄에 기술.
		
		// 2. 부모 클래스의 setter함수를 이용하여 초기화.
		super();
		super.setBrand(brand);
		this.setpName(pName);
		setpName(pName);
		setPrice(price);
		
		// 3. 부모클래스의 필드들의 접근제한자를 protected로 변경하여 초기화
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		
		
		this.allInOne = allInOne;
	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	// 오버라이딩 : 부모클래스의 메소드를 자식클래스에서 변경하는 행위
	public String information() {
		return super.information()+", allInOne : "+allInOne;
		// "brand : "+getBrand() +", pCode : "+ pCode+", pName : "+ pName+", allInOne : "+allInOne;
	}
	
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



















