package dev.syntax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		// Java ���α׷��� DB ������ �����ϴ� �۾�
		
		// 1. DB�� ���� �� �ʿ��� ���� �ۼ�
		final String DB_URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		
		 // CREATE DATABASE testdb; ���� �� DATABASE �̸�
		final String USER = "root";
		final String PASS = "rmathf96rma.";
		
		
		// 2. DB ���� �ڵ� �ۼ�
		try {
			Connection  connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			
			// DB���� Ŀ�ؼ�(����) ��ü
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. ���� ���� Ȯ��
		
	}

}
