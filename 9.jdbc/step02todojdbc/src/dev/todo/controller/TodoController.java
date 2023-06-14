package dev.todo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import dev.todo.model.Todo;

import java.sql.Date;

/*
 * Controller : ����ڷκ��� ���ۿ� ���� ����, �б� ����
 */
public class TodoController {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	// DB�� �����ϴ� �ڵ� �ۼ�
	final String DB_URL = "jdbc:mysql://localhost:3306/";
	final String DATABASE_NAME = "testdb";
	
	final String USER = "root";
	final String PASS = "rmathf96rma.";
	
	// ��ü Todo ��ȸ
	public void findAll() {
		
		List<Todo> todos = new ArrayList<>();
		
		final String selectQuery = "SELECT * FROM todo";
		
		try {
			// DB���� ���� ��ü ����
			connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			
			statement = connection.createStatement();
			
			
			// ��� ������ ���(View)
			resultSet = statement.executeQuery(selectQuery); // ���� ����
			
			while(resultSet.next()) {
//				System.out.print("title = " + resultSet.getString(2)); // �ι�° �÷��� "title" �����Ϳ� �ش��Ѵ�.
			
				
				int id = resultSet.getInt("id");
				
				String title = resultSet.getString("title");
				
				String description = resultSet.getString("description");
				
				Date date = resultSet.getDate("due_date");
				LocalDate dueDate = date.toLocalDate();
				
				Boolean isCompleted = resultSet.getBoolean("is_completed");
				
				todos.add(new Todo(id, title, description, dueDate, isCompleted));
				
			}
		} catch (Exception e) {
			
		} finally {
			// �ڿ� �ݳ�, ����(���� -> ����)
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	// id�� �ش��ϴ� �� ���� Todo ������ ��ȸ
	public Todo findById(int todoId) {
		Todo todo = null;

		final String findByIdQuery = "SELECT * FROM todo WHERE id = ?";
		
		try {
			connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(findByIdQuery);
			
			statement.setInt(1, todoId);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				
				int id = resultSet.getInt("id");
				
				String title = resultSet.getString("title");
				
				String description = resultSet.getString("description");
				
				Date date = resultSet.getDate("due_date");
				LocalDate dueDate = date.toLocalDate();
				
				boolean isCompleted = resultSet.getBoolean("is_completed");
				
				todo = new Todo(id, title, description, dueDate, isCompleted);
			}
			return todo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ڿ� �ݳ�, ����(���� -> ����)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return todo;
		
	}
	
	
	// Todo ����
	
	
	
	// Todo ����
	
	
	
	// Todo ����
	
}
