package com.kh.board.model.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

// JDBC의 주요 메서드들을 정의한 클래스
// getConnection, close, commit, rollback 메서드를 정의
// 단, db와의 연결정보는 resources/driver.properties에서 관리한다.
public class JDBCTemplate {
	/* 
	 * Connection의 생성 방법
	 * 1) 어플리케이션에서 연결할 driver를 조회
	 * 2) db driver는 db서버와 TCP방식으로 커넥션을 생성한다(3Way-HandShake)
	 * 3) db drvier는 전달받은 아이디와 비밀번호로 db에 연결을 요청한다
	 * 4) 인증 완료시 db서버는 생성완료 메세지를 어플리케이션에게 전달 후, 어플리케이션이
	 *    수신완료 메세지를 전송하면 연결이 완료된 커넥션객체를 어플리케이션에게 전달한다.
	 *    
	 * - 요약하자면 커넥션 객체 생성 작업은 리소스가 굉장히 많이 드는 작업. 따라서, 자주 생성
	 *   및 종료하는 것은 효율적이지 못하다.
	 * - 객체를 생성하는 것이 가장 큰 문제이므로 커넥션 객체를 "미리" 생성해두고, 필요할 때 마다
	 *   꺼내 쓸 수 있도록 Connection Pool을 만들었다. 
	 * 
	 * Connection Pool
	 *  - 커넥션 객체를 미리 생성하여 보관해두고, 필요할 때마다 꺼내쓰도록 지원하는 객체
	 *  - 커넥션풀 구현 라이브러리 : DBCP, HikariCP, Tomcat DataSource 등 존재.
	 * */
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			// prop로드
			prop.load(new FileInputStream("resources/driver.properties"));
			
			// 커넥션 풀 생성
			// BasicDataSource
			//  - 자바의 DataSource를 구현한 구현클래스. 데이터베이스 연결 및 커넥션풀 생성과
			//    관련 다양한 기능을 제공한다.
			BasicDataSource dataSource = new BasicDataSource();
			
			// 생성할 커넥션에 대한 정보 기술
			dataSource.setDriverClassName(prop.getProperty("driver"));
			dataSource.setUrl(prop.getProperty("url"));
			dataSource.setUsername(prop.getProperty("username"));
			dataSource.setPassword(prop.getProperty("password"));
			dataSource.setInitialSize(10); // 커넥션풀의 초기 사이즈 지정.기본값(0)
			dataSource.setMaxTotal(50); // 커넥션풀의 최대 사이즈 지정. 기본값(8)
			dataSource.setDefaultAutoCommit(false); // 자동커밋설정 false. 기본값(true)
			dataSource.setMaxWaitMillis(10000); //커넥션풀에 커넥션이 없는 경우 대기할 시간 지정.(10초).  
			dataSource.setRemoveAbandonedTimeout(300);
			// 반출되었으나 사용되지 않고 있는 커넥션 자동 삭제 옵션
			
			conn = dataSource.getConnection();
			// 위 메서드가 처음 호출될 때 커넥션 풀이 생성된다.
			
			/*
			 *  커넥션풀의 장점
			 *   - 성능향상 : 커넥션풀은 데이터베이스 연결(Connection)을 미리 생성하고, 풀에 유지시켜둠으로써 
			 *     자바 어플리케이션의 성능을 향상시킬 수 있다.
			 *   - 메모리 누수 방지 : 사용하고 닫아두지 않은 커넥션들을 자동으로 삭제시켜주는 등 자동메모리관리
			 *     기능이 존재 한다.
			 *   - 커넥션풀의 다양한 옵션들을 통해 원하는 커넥션풀을 커스터마이징 할 수 있다.  
			 *  커넥션풀의 단점
			 *   - 메모리 소비
			 *   - 커넥션을 생성해둔다는 것은 커넥션의 개수만큼의 데이터베이스 서버와 연결이 유지된 상태임을 의미하고,
			 *     연결상태에 있으면 항상 일정량의 메모리를 할당받게 된다. 커넥션풀이 너무 많으면 오히려 시스템 성능이
			 *     더 나빠질 수 있다.(적절한 개수 유지가 필요)
			 *  */
			
			
			// 1. 드라이버 클래스 등록
			// Class.forName(prop.getProperty("driver"));
			// 2. 커넥션 객체 생성
//			conn = DriverManager.getConnection(
//					prop.getProperty("url"),
//					prop.getProperty("username"),
//					prop.getProperty("password"));
//			conn.setAutoCommit(false);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// close메서드 류
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) { // 다형성으로 자식클래스를 모두 받음
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
