package com.kh.practice.score.view;

import java.util.Scanner;

import com.kh.practice.score.controller.ScoreController;

public class ScoreMenu {

	private Scanner sc = new Scanner(System.in);
	private ScoreController scr = new ScoreController();

	public void mainMenu() {
		1.  성적  저장 ➔ saveScore() 
		2.  성적  출력 ➔ readScore() 
	    9.  끝내기   ➔ “프로그램을  종료합니다.” 출력  후  종료 
		 //  잘못  입력했을  경우  “잘못  입력하셨습니다.  다시  입력해주세요.” 출력  후  반복
	}

	public void saveScore() {
		int num = 0; //  학생  숫자를  나타낼  변수 
		  N번  째  학생  정보  기록 
		  이름  : 
		  국어  점수  : 
		  영어  점수  : 
		  수학  점수  : 
		  // ScoreController(scr)의  saveScore()  매개변수로  모두  넘겨  주고 
		  //  그  학생  점수의  합계와  평균도  함께  매개변수로  넣어줌 
		  그만  입력하시려면  N  또는  n  입력,  계속  하시려면  아무  키나  입력하세요  :   
		  // N이나  n을  입력하지  않으면  이름  및  점수를  받는  것을  반복함 
		  // N이나  n을  입력하면  사용자에게  받는  반복문을  나감 
	}

	public void readScore() {
		int count = 0; // 몇 명의 학생인지(반복문이 몇 번 실행됐는지) 담을 변수
		int sumAll = 0;
		double avgAll = 0.0; // 모든 학생들의 합과 평균을 담을 변수

		// scr의  readScore()의  반환  값을  DataInputStream에  담고  반복문을  이용하여 
		//안에  들어가있는  데이터를  가지고  와서  출력 
		//모든  파일이  읽어졌을  때  나오는  EOFException을  이용하여 
		//EOFException가  일어났을  때  읽은  회수,  전체  합계,  전체  평균  출력
	}
}
