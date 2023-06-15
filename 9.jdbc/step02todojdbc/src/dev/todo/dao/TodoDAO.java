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

// DAO, Data Access Object�� ���Ӹ�
public class TodoDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public List<Todo> findAll() {
		
		List<Todo> todos = new ArrayList<>();
		
		final String selectQuery = "SELECT * FROM todo";
		
		try {
			// DB���� ���� ��ü ����
			connection = DBUtil.getConnection();
			
			// ���� �������ִ� ��ü
			statement = connection.createStatement();
			
			// ��� ������ ���(View)
			resultSet = statement.executeQuery(selectQuery); // ���� ����
			
			while(resultSet.next()) { // ���� ���� �����ϴ��� Ȯ��
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
			e.printStackTrace();
		} finally {
			// �ڿ� �ݳ�, ����(���� -> ����)
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
	
	
	
	// id�� �ش��ϴ� �� ���� Todo ������ ��ȸ
	public Todo findById(int todoId) {
		Todo todo = null;
		ResultSet rs = null;
	
		// Java7 ���� ��� try-with-resources ����
		// try () �Ұ�ȣ ���ο� �ۼ��� JDBC ��ü���� �ڵ����� �ڿ��� �ݳ���(close()�� ������� �ʾƵ� ��)
		// JDBC ��ü �̿ܿ� �ڿ� �ݳ��� �ʿ��� �ٸ� ��ü�鵵 �����ϰ� ��� ����
		// ����, AutoCloseable �������̽��� ������ Ŭ������ ��� ����
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from todo where id = ?");) {
	
			statement.setInt(1, todoId); // ?�� ����(���ε�)�� ���� ����, �������� ����ǥ ������ŭ �ѹ��� ����
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
			System.out.print("title�� �Է��ϼ��� > ");
			String title = br.readLine();
			
			System.out.print("description�� �Է��ϼ��� > ");
			String description = br.readLine();
			
			System.out.print("dueDate�� yyyy-mm-dd �������� �Է��ϼ��� > ");
			String dateString = br.readLine();
//			LocalDate dueDate = LocalDate.parse(br.readLine(), DateTimeFormatter.ISO_DATE);
	
			// ?�� ����(���ε�)�� ���� ����, �������� ����ǥ ������ŭ �ѹ��� ����
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

			System.out.print("���° �����͸� �����Ͻðڽ��ϱ�? > ");
			int id = Integer.parseInt(br.readLine());
			
			resultSet = statement.executeQuery("select id from todo where id = " + id);
			
			
			if(resultSet.next()) {
				System.out.print("������ title�� �Է��ϼ���. >");
				String title = br.readLine();
				
				System.out.print("������ description�� �Է��ϼ���. >");
				String description = br.readLine();
				
				System.out.print("������ �Ϸ� ���θ� �Է��ϼ���.(�Ϸ�:1, �̿Ϸ�:0)  >");
				boolean isCompleted = Boolean.parseBoolean(br.readLine());

				String updateString = "update todo set title = " + title + ", description = " + description + ", is_completed = " + isCompleted + " where id = " + id;
				boolean rs = statement.execute(updateString);
				
				if(rs) {
					System.out.println("####### ����");
				}
			}
			
			
	
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
