package com.kh.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

/* Service
 *  - 컨트롤러에서 서비스 호출 후 , dbms와 연결하여 수행해야하는 작업이 존재하는 경우, 
 *    컨트롤러에게서 전달받은 요청내용을 dao에게 넘기는 클래스.
 *  - dao의 요청처리 결과에 따라 트랜잭션처리를 수행한다.
 *  - 그 밖에 복잡한 비지니스로직을 처리하는 클래스
 * */
public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		// dao를 호출하여 회원가입처리(Member테이블에 데이터 추가)
		// 트랜잭션 처리를 위한 처리한 행의 갯수 반환
		
		// 회원테이블에 insert
		int updateCount = dao.insertMember(conn, m);
		// 쿠폰테이블에 insert
		// 코인테이블에 insert
		
		if (updateCount == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);		
		
		return updateCount;
	}

	public List<Member> selectByUserName(String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Member> list = dao.selectByUserName(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
		

}











