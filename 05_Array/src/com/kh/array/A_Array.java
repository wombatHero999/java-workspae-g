package com.kh.array;

import java.util.Arrays;

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
	
	public void method3() {
		int [] iArr = new int[5];
		
		// 값 초기화를 위한 for문
		for(int i = 1; i <= iArr.length; i++) {
			iArr[i - 1] = i;
		}
		// [1,2,3,4,5]
		
		System.out.println(iArr[4]);
	}
	
	public void method4() {
		
		int result = 0;
		String str = null; // "";
		int [] arr = null; 
		
		//System.out.println(arr[0]);
		//System.out.println(str.equals(""));
		//System.out.println(arr.length);
	}
	
	public void method5() {
		int[] arr = new int[5];
		
		/*
		 *  arr[0] = 2;
		 *  arr[1] = 4;
		 *  ...
		 *  arr[4] = 10;
		 *  대입을 반복문을 활용하여 작성.
		 *  
		 *  반복문을 활용하여 배열에 저장된 값을 출력
		 *  10 8 6 4 2
		 *  */
		int value = 2;
		for(int i = 0; i<arr.length;i++) {
			arr[i] = value;
			value += 2;
		}
		
		for(int i = arr.length - 1; i > -1; i-- ) {
			System.out.print(arr[i]+" ");
		}
		
		arr[5] = 12;
		/*
		 * 배열은 한번 지정한 크기를 변경 할 수 없음.
		 * => 배열의 크기를 변경하고자 한다면 새로운 배열을 생성 해야 한다.
		 *  */
		arr = new int[6];
		
		arr = null; // 참조형 변수에 null값을 대입하면, 가비지컬렉터
		            //가 해당 메모리를 즉시 삭제시켜준다. 
		//System.out.println(Arrays.toString(arr));
	}
	
	public void method6() {
		// 배열의 선언, 할당, 초기화
		int[] arr = new int[3];
		arr[0] = 1; // 초기화
		
		// 배열 선언 및 할당과 동시에 초기화 하는 방법
		// 1. 
		int[] arr1 = new int[] { 1 , 2 , 3 , 4 };//[1,2,3,4]
		
		// 2. 
		int[] arr2 = {1,2,3,4}; 
		
		// arr1 == arr2
		System.out.println(arr1);
		System.out.println(arr2);
	}
	
	public void method7() {
		
		// 문자열을 char배열로 변경
		String str = "wombat";
		char[] arr = str.toCharArray();//['w','o','m','b','t']
		
		char[] arr2 = new char[str.length()];
		
		for(int i =0; i<arr2.length; i++) {
			arr2[i] = str.charAt(i);
		}
		
		System.out.println( Arrays.toString(arr) );
		System.out.println( Arrays.toString(arr2) );
	}
	
	
	
	
	
	
}











