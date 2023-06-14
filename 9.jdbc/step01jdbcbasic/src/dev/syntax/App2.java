package dev.syntax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App2 {

	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		
		final String USER = "root";
		final String PASS = "rmathf96rma.";
		
		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(DRIVER_NAME); // 드라이버 로딩

			Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			
			// 쿼리문 전달해주는 역할
			Statement statement = connection.createStatement();
			
			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS todo";
			
			statement.execute(dropTableQueryIfExists); // 쿼리 수행
			
		} catch (Exception e) {
			
		}
	}

}
