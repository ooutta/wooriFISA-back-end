package dev.film.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DATABASE_NAME = "sakila";

    static final String USER = "root";
    static final String PASS = "1234";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
