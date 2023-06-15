package dev.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DB와 관련된 공통 처리 코드들을 별도의 유틸 클래스로 분리
 */
public class DBUtil {
	// DB에 접근하는 코드 작성
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String DATABASE_NAME = "testdb";

	static final String USER = "root";
	static final String PASS = "1234";
	
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
