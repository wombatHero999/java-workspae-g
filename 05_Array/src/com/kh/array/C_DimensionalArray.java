package com.kh.array;

import java.util.Arrays;

public class C_DimensionalArray {
	
	// 이차원 배열 : 일차원 배열을 묶음으로 관리하는 배열
	public void method1() {
		// 이차원 배열 선언
		int [][] arr1;
		int arr2 [][];
		int [] arr3 [];
		
		// 이차원 배열 할당
		// 배열 = new 자료형[행크기][열크기]
		// 배열 = new 자료형[2차원배열크기][1차원배열크기]
		arr3 = new int[2][3];
		// 3개의 정수값을 관리하는 1차원 배열 2개를 관리하는 2차원배열
		
		// 배열 선언과 동시에 할당
		int[][] arr = new int[3][5];
		/* 
		 * [0,0,0,0,0]
		 * [0,0,0,0,0]
		 * [0,0,0,0,0]
		 * */
		
		System.out.println(arr);// 2차원배열
		System.out.println(arr[0]);//1차원배열
		System.out.println(arr[0][0]); //1차원배열이 관리하는 0번째값
		
		System.out.println(arr.length);// 3
		System.out.println(arr[0].length); // 5
		
		for(int i =0; i<arr.length; i++) {
			for(int j = 0; j <arr[i].length; j++ ) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void method2() {
		// 1행 [1, 2, 3, 4, 5]
		// 2행 [6, 7, 8, 9, 10]
		// 3행 [11, 12, 13, 14, 15]
		int[][] arr = new int[3][5];
		
		int value = 1;
		for(int i = 0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				arr[i][j] = value++;
			}
		}
		for(int i = 0; i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public void method3() {
		
		int [] iArr = {1,2,3,4,5};
		
		int[][] arr = {
				{1,2,3,4,5},
				{6,7,8,10},
				{11,12,13}
		};
		/*
		 * 가변배열 
		 * 행의 크기는 정해져 있으나 각 행별 열의 갯수가 정해지지 않은 배열
		 * 
		 * 이차원배열 == 일차원 배열을 여러개 묶은 형태로, 일차원 배열의 크기가
		 * 꼭 같은 크기일 필요는 없다.
		 *  */
		int[][] arr2 = new int[3][];
		
		System.out.println(arr2);
		System.out.println(arr2[0]);
		
		arr2[0] = new int[2];
		arr2[1] = new int[3];
		arr2[2] = new int[1];
		
		int value = 1;
		for(int i =0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				arr2[i][j] = value++;
			}
		}
		
		for(int i =0; i<arr2.length; i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
	}
	
	public void method4() {
		/* 
		 * char[][] 가변 배열 생성 후
		 * char값을 저장
		 * 
		 * 최종 데이터 예시
		 * 1행 [a, b, c]
		 * 2행 [d, e]
		 * 3행 [f, g, h, i]
		 * */
		char[][] arr = new char[3][];
		
		arr[0] = new char[3];
		arr[1] = new char[2];
		arr[2] = new char[4];
		
		char ch = 'a';
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				arr[i][j] = ch;
				ch++;
			}
		}
		
		// 향상된 반복문 
		// for( 배열의 각 인덱스의 값을 저장할 변수 :  반복을 진행할 배열  )
		for(char[] carr : arr) {
			for( char c  : carr ) {
				System.out.print(c +" ");
			}
			System.out.println();
		}
	
	}
	
	
	
}











