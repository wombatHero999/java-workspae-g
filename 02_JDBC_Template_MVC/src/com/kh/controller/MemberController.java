package com.kh.controller;

import java.util.List;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberView;

/* 
 * Controller 
 *  - View(클라이언트페이지)를 통해서 요청한 기능을 처리하는 역할을 수행
 *  - 작업처리는 직접 수행하지 않고, 기능을 처리할 수 있는 Service의 메서드를 호출하여 기능처리를 명령.
 *  - view로부터 전달받은 데이터를 가공처리하여, service에게 전달하고 service가 전달해준 결과데이터(응답
 *    화면)를 View다시 전달해주는 역할을 수행한다.
 * 
 * */
public class MemberController {
	private MemberService ms = new MemberService();
	
	public void insertMember(String memberId, String memberPwd, String memberName, String gender, int age, String email,
			String address, String phone) {
		// 데이터 가공처리
		Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age, null);
		
		// service에 회원가입 요청 지시
		int result = ms.insertMember(m);
		
		// service의 요청결과값에 따라 보여줄 view화면을 지정
		if(result == 1) { // 삽입된 행의 개수 성공
			new MemberView().displaySuccess("회원가입 성공");
		}else { // 실패
			new MemberView().displayFail("회원가입 실패");
		}
	}

	public void selectByUserName(String keyword) {
		// SELECT -> ResultSet -> 알맞은 vo클래스
		List<Member> list = ms.selectByUserName(keyword);
		
		if(list.isEmpty()) {
			// 검색결과 존재하지 않는 경우
			new MemberView().displayNodata(keyword+"에 대한 검색결과가 없습니다.");
		}else {
			// 검색결과 존재하는 경우
			new MemberView().displayListData(list);
		}
		
	}

}










