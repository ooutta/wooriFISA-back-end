package dev.syntax;

import java.sql.Connection;
import java.sql.SQLException;

public class Step02UsingHikari {

	public static void main(String[] args) {
		try {
			Connection connection = HikariCPDataSource.getConnection();
			System.out.println(connection);
			
			// �������� �����ϰ� ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
