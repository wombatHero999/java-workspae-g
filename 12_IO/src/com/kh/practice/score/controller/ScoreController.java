package com.kh.practice.score.controller;

import java.io.DataInputStream;
import java.io.FileNotFoundException;

import com.kh.practice.score.model.dao.ScoreDAO;

public class ScoreController {

	private ScoreDAO sd = new ScoreDAO();
	
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		//매개변수를 DAO에 전달
		sd.saveScore(name, kor, eng, math, sum, avg);
	}
	
	public DataInputStream readScore() throws FileNotFoundException {
		return sd.readScore();
	}
	
}















