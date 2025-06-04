package com.kh.board.model.vo;

import java.sql.Date;

/**
 * Board 테이블의 한행의 정보를 보관할 클래스
 *  */
public class Board {
	private int bno;
	private String title;
	private String content;
	private Date createDate;
	private String writer;
	private String deleteYn;
	
	public Board() {
		
	}

	public Board(int bno, String title, String content, Date createDate, String writer, String deleteYn) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.writer = writer;
		this.deleteYn = deleteYn;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", createDate=" + createDate
				+ ", writer=" + writer + ", deleteYn=" + deleteYn + "]";
	}
	
}











