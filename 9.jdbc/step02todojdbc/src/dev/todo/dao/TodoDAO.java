package dev.todo.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.todo.model.Todo;
import dev.todo.util.DBUtil;

// DAO, Data Access Object의 줄임말
public class TodoDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public List<Todo> findAll() {
		
		List<Todo> todos = new ArrayList<>();
		
		final String selectQuery = "SELECT * FROM todo";
		
		try {
			// DB와의 연결 객체 생성
			connection = DBUtil.getConnection();
			
			// 쿼리 전달해주는 객체
			statement = connection.createStatement();
			
			// 결과 데이터 출력(View)
			resultSet = statement.executeQuery(selectQuery); // 쿼리 수행
			
			while(resultSet.next()) { // 다음 행이 존재하는지 확인
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
			e.printStackTrace();
		} finally {
			// 자원 반납, 해제(순서 -> 역순)
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return todos;
	}
	
	
	
	// id에 해당하는 한 개의 Todo 데이터 조회
	public Todo findById(int todoId) {
		Todo todo = null;
		ResultSet rs = null;
	
		// Java7 이후 방식 try-with-resources 문법
		// try () 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 사용하지 않아도 됨)
		// JDBC 객체 이외에 자원 반납이 필요한 다른 객체들도 동일하게 사용 가능
		// 조건, AutoCloseable 인터페이스를 구현한 클래스만 사용 가능
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from todo where id = ?");) {
	
			statement.setInt(1, todoId); // ?에 맵핑(바인딩)할 값을 지정, 좌측부터 물음표 개수만큼 넘버링 지정
			rs = statement.executeQuery();
	
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			Date dueDate = rs.getDate("due_date");
			int isCompleted = rs.getInt("is_completed");
	
			todo = new Todo(id, title, description, dueDate.toLocalDate(), isCompleted == 1);
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
	
			}
		}
	
		return todo;
	}
	
	public void insert() {
		boolean rs = false;
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into todo (title, description, due_date) values (?, ?, ?)");) {
			System.out.print("title을 입력하세요 > ");
			String title = br.readLine();
			
			System.out.print("description을 입력하세요 > ");
			String description = br.readLine();
			
			System.out.print("dueDate을 yyyy-mm-dd 형식으로 입력하세요 > ");
			String dateString = br.readLine();
//			LocalDate dueDate = LocalDate.parse(br.readLine(), DateTimeFormatter.ISO_DATE);
	
			// ?에 맵핑(바인딩)할 값을 지정, 좌측부터 물음표 개수만큼 넘버링 지정
			statement.setString(1, title); 
			statement.setString(2, description); 
			statement.setDate(3, Date.valueOf(dateString)); 
			rs = statement.execute();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void update() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();

			System.out.print("몇번째 데이터를 수정하시겠습니까? > ");
			int id = Integer.parseInt(br.readLine());
			
			resultSet = statement.executeQuery("select id from todo where id = " + id);
			
			
			if(resultSet.next()) {
				System.out.print("수정할 title을 입력하세요. >");
				String title = br.readLine();
				
				System.out.print("수정할 description을 입력하세요. >");
				String description = br.readLine();
				
				System.out.print("수정할 완료 여부를 입력하세요.(완료:1, 미완료:0)  >");
				boolean isCompleted = Boolean.parseBoolean(br.readLine());

				String updateString = "update todo set title = " + title + ", description = " + description + ", is_completed = " + isCompleted + " where id = " + id;
				boolean rs = statement.execute(updateString);
				
				if(rs) {
					System.out.println("####### 성공");
				}
			}
			
			
	
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
