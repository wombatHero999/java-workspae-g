package com.kh.array;

public class A_Array {
	/*
	 * 변수 : 하나의 공간에 하나의 값을 담을 수 있다.
	 * 
	 * 배열 : 하나의 공간에 여러개의 값을 담을 수 있음
	 *       단, "같은 자료형"의 값들만 담을 수 있다.
	 *       int [] arr = new int[3];
	 *       int자료형값을 저장할 수 있는 메모리 영역이 3칸 할당 된다.
	 *       [0,0,0]
	 *       배열에 저장된 데이터를 꺼낼 때는 인덱스를 활용하며 인덱스는 0부터 시작.
	 *       arr[0] , arr[1], arr[2]
	 *       배열의 크기가 5, 마지막 인덱스 4
	 *       배열의 크기가 n이라면 그 배열의 마지막 인덱스는 n-1
	 *  */
	
	public void method1() {
		// 배열 선언
		// 자료형 [] 배열명;
		// 자료형 배열명 [];
		
		int a;
		int [] arr;
		int arr2 [];
		
		/*
		 * 배열 할당
		 * 이 배열에 몇 개의 값들을 보관할건지 그 배열의 크기를 지정해주는 과정.
		 * 크기를 지정해주면, 지정한 갯수만큼의 인덱스(저장공간)를 가진 배열이 생성
		 * [표현법]
		 * 배열명 = new 자료형[배열크기]; 
		 *  */
		arr = new int[5];
		
		// 선언과 동시에 할당
		int [] arr3 = new int[5];// [ 0, 0, 0, 0, 0 ]
		
		// 배열의 각 인덱스에 값을 대입하고, 추출하는 방법
		arr3[0] = 0;
		arr3[1] = 1;
		arr3[2] = 2;
		// [0 , 1 , 2 , 0 , 0 ]
		
		System.out.println(arr3[0]); // 0
		System.out.println(arr3[1]); // 1
		System.out.println(arr3[3]); // 0 -> 초기화 시키지 않았음에도
		//System.out.println(a);
		// 0이 출력
		// String str = "11";
		System.out.println(arr3); // [I@626b2d4a
		// System.identityHashCode(str);
	}
	
	public void method2() {
		
		int num = 10;
		
		int [] iArr = new int[5];// [0,0,0,0,0]
		
		System.out.println("num : "+num); // 10
		System.out.println("iArr : "+iArr); // 주소값
		System.out.println("iArr의 해시코드값 : "+iArr.hashCode());
		// 주소값을 10진수로 변경
		
		int [] iArr2 = new int[5];
		System.out.println("iArr2의 해시코드값 : "+iArr2.hashCode());
		
		int [] iArr3 = iArr2;
		System.out.println(iArr3 == iArr2); // true
	}
	
}











