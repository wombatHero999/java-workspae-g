package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

/*
 * DAO(Data Access Object)
 *  - Controller - Service를 통해서 호출되는 클래스
 *  - DBMS서버와 직접 통신하여, SQL문을 실행하고 , 실행결과를 반환하는 클래스.
 *  */
public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			prop.load( new FileInputStream("resources/query.properties") );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection conn, Member m) {
		int updateCount = 0;
		String sql = prop.getProperty("insertMember");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddress());
			pstmt.setInt(8, m.getAge());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}

	public List<Member> selectByUserName(Connection conn, String keyword) {
		List<Member> list = new ArrayList<>();
		String sql = prop.getProperty("selectUserByName");
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberName(rset.getString("member_name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

}










