package dev.syntax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		// Java 프로그램과 DB 서버와 연결하는 작업
		
		// 1. DB와 연결 시 필요한 정보 작성
		final String DB_URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		
		 // CREATE DATABASE testdb; 했을 때 DATABASE 이름
		final String USER = "root";
		final String PASS = "rmathf96rma.";
		
		
		// 2. DB 연결 코드 작성
		try {
			Connection  connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			
			// DB와의 커넥션(연결) 객체
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. 연결 성공 확인
		
	}

}
