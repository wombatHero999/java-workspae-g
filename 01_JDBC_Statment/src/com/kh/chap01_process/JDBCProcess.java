package com.kh.chap01_process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProcess {
	/* 
	 * JDBC(Java DataBase Connectivity)
	 *  - Java애플리케이션과 데이터베이스간의 연동시 필요한 연결방법, SQL문을 전달하고 결과값을 돌려받는
	 *    방법들의 표준을 정의해둔 자바 API 인터페이스
	 *  - JDBC는 연결하고자 하는 DB가 무엇이던 간에 일관된 방법으로 통신이 가능하게끔 표준화 시켰다.
	 *     => JDBC는 표준 인터페이스만 정의해 두었고, 각 RDBMS제조 회사에서 직접 JDBC를 구현하였음.
	 *  - Spring, MyBatis, JPA 등에서 JDBC를 내부적으로 활용하였기 때문에 작동방식에 대한 이해를 위하여
	 *    JDBC에 대한 공부가 필요.   
	 *    
	 *  JDBC 주요 객체들
	 *   - DATABASE와 연결하기위한 객체, SQL문을 DBMS에 전달하기 위해 저장하는 객체, 결과값을 반환받는
	 *     객체등으로 나뉘어져 있다.
	 *   1) XXXDriver : db와의 연결을 담당하는 핵심 클래스로, 각 회사에서 JDBC의 Driver인터페이스를
	 *      구현한 클래스.
	 *   2) DriverManager : Driver들을 관리하는 클래스. 여러개의 Driver들 중 어떤 Driver를 사용할지
	 *     선택한다. 
	 *   3) Connection : DB와 연결된 상태임을 나타내는 객체. DB와 연결 설정 및 해제, 트랜잭션 관리
	 *      등을 할 수 있다.
	 *   4) XXXStatement : sql문장(statement)을 저장하는 객체. 저장한 sql문장을 DB서버에 보낸 후,
	 *      실행결과를 돌려받는 객체.
	 *   5) ResultSet : select수행결과를 저장하는 객체.
	 * */
	
	public static void main(String[] args) {
		/* 
		 * JDBC API의 코딩 흐름
		 * 1. Driver등록
		 * 2. DBMS와 연결
		 * 3. Connection객체를 통해 Statement생성
		 * 4. sql문장을 Statement에 저장 후, sql문 실행
		 * 5. db서버로 부터 실행결과값 반환 -> DQL문을 실행 했다면 ResultSet, DML문을 실행했다면 int반환
		 * 6. 트랜잭션 처리 / ResultSet을 알맞은 데이터로 변환
		 * 7. 사용한 자원 반납
		 * */
		try {
			DriverManager.drivers().forEach(System.out::println);
			
			// 1) 오라클 드라이버 등록(클래스정보를 load)
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) DBMS와 연결 -> Connection객체 생성
			/* 연결을 위해 필요한 정보
			 * 1) 오라클서버 주소
			 * 2) 접속계정
			 * 3) 접속비밀번호
			 *  */ 
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"C##JDBC",
					"JDBC");
			
			// 3) SQL문 저장을 위한 Statement객체 생성
			Statement stmt = conn.createStatement();
			
			// 4) Statement를 통해 sql문 전달 후 , 실행
			boolean result = stmt.execute("SELECT 'HELLO JDBC' AS TEST FROM DUAL");
			
			// 5) 결과값 받기(ResultSet)
			if(result) {
				// 결과값은 stmt내부의 resultSet필드 혹은 DML문 실행시 updateCount필드에 저장되어 있음.
				ResultSet rset= stmt.getResultSet();
				
				// 6) ResultSet을 알맞은 vo클래스로 변환
				if(rset.next()) {// 커서의 위치를 +1 한 후, 해당위치에 값이 존재한다면 true/false반환
					String result2 = rset.getString("TEST");
					System.out.println(result2);
				}
				
			}
			
			// 4번+5번 합치기 가능.
			// execute(쿼리문 실행) + getResultSet(실행결과 반환) -> executeQuery
			stmt.executeQuery("SELECT 'HELLO' AS TEST FROM DUAL");
			// execute(DML류실행) + getUpdateCount() -> executeUpdate
			
			
			// 7) 자원반납 -> 생성된 자원의 역순으로.
			// ResultSet -> Statement -> Connection
			//rset.close();
			stmt.close();
			conn.close();
			
		} 
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}










