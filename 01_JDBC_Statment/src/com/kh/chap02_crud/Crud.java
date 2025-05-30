package com.kh.chap02_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {
	public static void main(String[] args) {
		Crud c = new Crud();
		c.update();
	}
	
	public void insert() {
		try {
			// 1) Driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) DBMS와 연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC" , "JDBC");
			// 3) autocommit설정하기 : true(기본값) / false
			conn.setAutoCommit(false);
			
			// 4) Statement객체 생성
			// Statement ? 실행할 sql문을 완전한 문장형태로 만든 후 실행하는 클래스.
			Statement stmt = conn.createStatement();
			
			String name = "민경민";
			
			// 5+6) 쿼리문 전달 후 실행결과값 돌려받기
			int updateCount = stmt.executeUpdate(
					"INSERT INTO MEMBER VALUES ("
					+ "'"+name+"','"+name+"','"+name+"','"+name+"','rudals@naver.com',"
					+ "'010-4121-3393','경기도 김포시 하성면',25,SYSDATE)");
			
			// 7) 트랜잭션 처리
			if(updateCount == 1) {
				//1행의 데이터가 정상적으로 삽입되었다면
				conn.commit();
			}else {
				conn.rollback();
			}
			
			// 8) 자원반납
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			// 1) 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) 
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC","JDBC");
			
			// 3) 
			conn.setAutoCommit(false);
			
			// 4) PreparedStatement
			/*     - 쿼리문을 미리 준비해두는 문장 클래스
			 *     - Statment의 단점을 보완한 클래스
			 *     1) 데이터 바인딩이 어렵고 가독성이 좋지 못함.
			 *     2) 재사용성이 좋지 못함. (Statement는 실행할 쿼리문을 매번 새롭게 파싱하여 호출)
			 *     3) SQL-Injection공격을 방어할 수 없다.
			 *     4) 동적 쿼리문을 만들기가 어렵다.
			 *     
			 *     - 객체 생성시 실행하고자 하는 쿼리문을 "미완성된"상태로 객체에 전달하여, 미리 
			 *       쿼리문을 파싱시키고 쿼리문을 실행하기 직전 "완성된"쿼리문형태로 변환시켜서 실행한다.      
			*/     
			String sql = "UPDATE MEMBER SET EMAIL = ? WHERE MEMBER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 5) 미완성 쿼리문을 완성형태로 변경
			// pstmt.setXXX(?의 위치값, 대입값);
			// XXX는 대입값의 자료형
			pstmt.setString(1, "ㅋㅋㅋ@naver.com");
			pstmt.setString(2, "user01");
			
			//6,7)
			int updateCount = pstmt.executeUpdate();
			
			//8)
			if(updateCount == 1) conn.commit();
			else conn.rollback();
			
			//9)
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}






