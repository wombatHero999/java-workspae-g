package com.kh.chap04_assist.part01_buffered.run;

import com.kh.chap04_assist.part01_buffered.model.dao.BufferedDao;

public class Run {
	public static void main(String[] args) {
		BufferedDao dao = new BufferedDao();
		//dao.fileSave();
		dao.fileRead();
	}
}
