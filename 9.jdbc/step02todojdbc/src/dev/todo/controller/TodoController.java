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
 * Controller : 사용자로부터 동작에 대한 제어, 분기 역할
 */
public class TodoController {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	// DB에 접근하는 코드 작성
	final String DB_URL = "jdbc:mysql://localhost:3306/";
	final String DATABASE_NAME = "testdb";
	
	final String USER = "root";
	final String PASS = "rmathf96rma.";
	
	// 전체 Todo 조회
	public void findAll() {
		
		List<Todo> todos = new ArrayList<>();
		
		final String selectQuery = "SELECT * FROM todo";
		
		try {
			// DB와의 연결 객체 생성
			connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASS);
			
			statement = connection.createStatement();
			
			
			// 결과 데이터 출력(View)
			resultSet = statement.executeQuery(selectQuery); // 쿼리 수행
			
			while(resultSet.next()) {
//				System.out.print("title = " + resultSet.getString(2)); // 두번째 컬럼인 "title" 데이터에 해당한다.
			
				
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
			// 자원 반납, 해제(순서 -> 역순)
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
	
	// id에 해당하는 한 개의 Todo 데이터 조회
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
			// 자원 반납, 해제(순서 -> 역순)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return todo;
		
	}
	
	
	// Todo 저장
	
	
	
	// Todo 수정
	
	
	
	// Todo 삭제
	
}
