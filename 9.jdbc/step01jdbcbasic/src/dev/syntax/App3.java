package dev.syntax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App3 {

	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		
		final String USER = "root";
		final String PASS = "rmathf96rma.";
		
		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(DRIVER_NAME); // ����̹� �ε�

			Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			
			// ������ �������ִ� ����
			Statement statement = connection.createStatement();
			
			final String createTableQuery = 
		            "CREATE TABLE todo (" +
		            "id INT(5) unsigned NOT NULL AUTO_INCREMENT," +
		            "title VARCHAR(255)," +
		            "description VARCHAR(255)," +
		            "due_date DATE," +
		            "is_completed BOOLEAN DEFAULT false," +
		            "PRIMARY KEY (id))";
			
			statement.execute(createTableQuery); // ���� ����
			
		} catch (Exception e) {
			
		}
	}

}
