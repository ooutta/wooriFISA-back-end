package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.starbar.model.Coffee;
import dev.starbar.util.DBUtil;

/*
 * DAO : Data Access Object
 * DB에 접근할 때 사용하는 코드만 작성하는 부분
 */
public class CoffeeDAO {
	
	public List<Coffee> findAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset;
		Coffee coffee;
		List<Coffee> coffeeList = new ArrayList<>();

		String query = "SELECT * FROM coffee";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				int id = rset.getInt("id");
				String name = rset.getString("name");
				String size = rset.getString("size");
				int price = rset.getInt("price");
				coffee = new Coffee(id, name, size, price);

				coffeeList.add(coffee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}

		return coffeeList;
	}
	
	
	public void add(Coffee coffee) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset;

		String query = "INSERT INTO coffee(name, size, price) VALUES (?, ?, ?)";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, coffee.getName());
			pstmt.setString(2, coffee.getSize());
			pstmt.setInt(3, coffee.getPrice());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public void delete(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset;

		String query = "DELETE FROM coffee WHERE id = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public void update(Coffee coffee) {
		
	}
}
