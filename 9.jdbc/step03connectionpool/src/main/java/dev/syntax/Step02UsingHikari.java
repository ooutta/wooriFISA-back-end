package dev.syntax;

import java.sql.Connection;
import java.sql.SQLException;

public class Step02UsingHikari {

	public static void main(String[] args) {
		try {
			Connection connection = HikariCPDataSource.getConnection();
			System.out.println(connection);
			
			// 나머지는 동일하게 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
