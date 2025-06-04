package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	/* 
	 * JDBC내부의 중복코드들
	 * 1. 커넥션 객체 생성 & 드라이버 클래스 등록
	 * 2. close(), rollback(), commit() 
	 *     - 예외처리
	 * */
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			// prop로드
			prop.load(new FileInputStream("resources/driver.properties"));
			
			// 1. 드라이버 클래스 등록
			Class.forName(prop.getProperty("driver"));
			// 2. 커넥션 객체 생성
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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













