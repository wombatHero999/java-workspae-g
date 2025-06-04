package com.kh.board.model.vo;

/** 
 * Member 테이블의 한행의 정보를 보관할 클래스
 * */
public class Member {
	private String memberId;
	private String memberPwd;
	
	public Member() {
		
	}

	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + "]";
	}
	
}















