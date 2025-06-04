package com.kh.chap02_crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.kh.model.vo.Member;

public class Crud {
	public static void main(String[] args) {
		Crud c = new Crud();
		//c.update();
		//c.delete("user07");		
		//c.delete("' OR 1 = 1 --");
		//c.selectOne("user01");
		//c.selectAll();
		//c.execPlsql();
		c.execProcedure();
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
	
	// DML(DELETE)
	public void delete(String userId) {
		try {
			// 1) Driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) 연결할 드라이버 선택
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC"
					);
			// + 오토커밋설정
			conn.setAutoCommit(false);
			// 3) Connection객체를 통해 stmt생성
			// PreparedStatement pstmt = conn.prepareStatement(
					//"DELETE FROM MEMBER WHERE MEMBER_ID = ?");
			
			// + 미완성 sql문을 완성형태로 만들기
			// pstmt.setString(1, userId); // sql문 완성
			// DELETE FROM MEMBER WHERE MEMBER_ID = 'user07'
			// ' OR 1=1 --
			// '' OR 1=1 --'
			// ' OR 1 = 1 --
			
			// SQL-Injection공격 예시
			Statement pstmt = conn.createStatement();
						
			// 4) EXECUTE + 5)GET Result
			//int updateCount = pstmt.executeUpdate();
			int updateCount = pstmt.executeUpdate(
					"DELETE FROM MEMBER WHERE MEMBER_ID = '"+userId+"'");
			System.out.println("삭제된 행의 개수 : "+updateCount); // 6
			
			// 6) 트랜잭션 관리
			if(updateCount == 1) {
				//커밋
				conn.commit();
			}else {
				conn.rollback();
			}
			// 7) 자원반납
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectOne(String userId) {
		// 1) Driver등록
		//  생략
		
		try {
			// 2) 연결할 드라이버 선택
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			
			// 3) PreparedStatement생성
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// sql문 완성
			pstmt.setString(1, userId);
			
			// 4,5) sql문 실행 및 결과값 돌려받기
			ResultSet rset = pstmt.executeQuery();
			
			// 6) ResultSet을 알맞은 vo클래스로 변환하기.
			/*
			 * 	ResultSet
			 *   - Select를 호출한 결과 값이 담겨있는 객체
			 *   - 커서(Cursor)를 사용하여 ResultSet의 각 행에 접근할 수 있따
			 *   Cursor ? 
			 *     - ResultSet내부에 특정 행을 가리키는 포인터(배열의 인덱스와비슷)
			 *     Cursor의 위치를 변경하는 메서드들
			 *     1) next() : boolean -> 커서를 다음행으로 이동시키고, 행이 존재
			 *      한다면 true, 없다면 false를 반환하는 메서드.
			 *     2) previous() : boolean -> 커서를 이전행으로 이동시키고, 행이
			 *       존재한다면 true, 아니라면 false
			 *     3) first()/last() : boolean 
			 *        - 커서를 첫번째/마지막 행으로 이동시키고, 해당위치에 행이 존재한
			 *        다면 true, 아니라면 false를 반환
			 *     4) absolute(int row) : boolean 
			 *        - 지정된 행위치로 이동.
			 *     5) relative(int row) : boolean
			 *        - 커서를 현재위치를 기준으로 지정된 행의 개수만큼 이동.  
			 *  */
			if(rset.next()) { // 0 -> 1
				// 조회 결과가 존재하는 경우
				
				// resultSet에서 어떤 "칼럼"을, 어떤 "자료형"으로 뽑을지를 제시.
				// 칼럼을 뽑을 때는 1) 칼럼명(대소문자x) 2) 칼럼 순번 둘중 하나를 사용
				// 자료형을 제시할 때는 1) Int/Double 2) String 3) Date
				
				Member m = new Member(); // rset의 데이터를 옮겨 담을 객체 
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("member_pwd")); // 대소문자 x
				m.setMemberName(rset.getString(3)); // 칼럼의 순번 제시
				m.setEmail(rset.getString("EMAIL"));
				m.setGender(rset.getString("GENDER"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setAge(rset.getInt("AGE"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				
				System.out.println(m);
			}
			
			//7)
			rset.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 한번에 여러행의 데이터를 조회하는 경우
	public void selectAll() {
		// 1) Driver등록
		
		try {
			// 2) DBMS연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			
			// 3) PreparedStatement생성
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MEMBER");
			
			// 4/5) 쿼리 실행 및 결과값 반환
			ResultSet rset = pstmt.executeQuery();
			
			List<Member> list = new ArrayList<>();
			
			// 6) rest을 vo로 변환
			while(rset.next()) {
				// 다음행이 없을 때까지 반복
				Member m = new Member(); // rset의 데이터를 옮겨 담을 객체 
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("member_pwd")); // 대소문자 x
				m.setMemberName(rset.getString(3)); // 칼럼의 순번 제시
				m.setEmail(rset.getString("EMAIL"));
				m.setGender(rset.getString("GENDER"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setAge(rset.getInt("AGE"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				
				list.add(m);
			}
			
			list.stream().forEach(System.out::println);
			
			//7)
			rset.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// PL/SQL문 사용하기
	public void execPlsql() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			
			String sql = "BEGIN UPDATE MEMBER SET MEMBER_NAME = ?"
					+ " WHERE MEMBER_ID = ?;  END;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "경민!");
			pstmt.setString(2, "user01");
			
			// pl/sql문 실행
			// execute -> true(select일시), false(dml일시)
			boolean result = pstmt.execute(); 
			if(result) System.out.println("프로시져 실행 성공");
			else System.out.println("업데이트 성공");
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void execProcedure() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##KH",
					"KH");
			
			// CallableStatement
			//  - java로 프로시저를 호출하기위해 사용하는 객체
			//  - preparedStatement처럼 ? 사용하여 값을 바인딩한다.
			//  - {call 프로시저명(매개변수)}
			String sql = "{call pro_select_emp(?,?,?,?)}";
			// 1번 위치홀더 : 사번(IN) 
			// 2,3,4번 위치홀더 : 이름,보너스,봉급(OUT)
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, 200);
			
			cstmt.registerOutParameter(2, Types.VARCHAR); // OUT매개변수에 사용하는 메서드
			// 결과값을 받아올 자료형 등록
			cstmt.registerOutParameter(3, Types.DOUBLE);
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			// 프로시져 실행
			cstmt.execute();
			
			String name = cstmt.getString(2);
			double bonus = cstmt.getDouble(3);
			int salary = cstmt.getInt(4);
			
			System.out.println(name+" : "+bonus +" : "+salary);
			
			cstmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	


}






