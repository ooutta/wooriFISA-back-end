package dev.todo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * DB와 관련된 공통 처리 코드들을 별도의 유틸 클래스로 분리
 */
public class DBUtil {

	public static Connection getConnection() {
		
		Properties prop = new Properties();
		
		
		try {
			
			FileInputStream fs = new FileInputStream("resources/jdbc.properties");
			
			prop.load(fs);
			
			final String DB_URL = prop.getProperty("url");
			final String DATABASE_NAME = prop.getProperty("database");
			
			final String USER =  prop.getProperty("username");
			final String PASS =  prop.getProperty("password");

			Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			return conn;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
