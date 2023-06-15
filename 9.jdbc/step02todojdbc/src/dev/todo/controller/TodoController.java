package dev.todo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import dev.todo.dao.TodoDAO;
import dev.todo.model.Todo;
import dev.todo.util.DBUtil;
import dev.todo.view.TodoView;

import java.sql.Date;

/*
 * Controller : ����ڷκ��� ���ۿ� ���� ����, �б� ����
 */
public class TodoController {
	private TodoDAO todoDAO;
	private TodoView todoView;
	
	public TodoController() {
		todoDAO = new TodoDAO();
		todoView = new TodoView();
	}
	// ��ü Todo ��ȸ
	public void findAll() {
		List<Todo> todos = todoDAO.findAll();
		
		if(todos != null && todos.size() != 0) {
			todoView.findAll(todos);
		} else {
			Exception errorObject = new Exception("Todo �����Ͱ� �������� �ʽ��ϴ�.");
			todoView.errorPage(errorObject);
		}
		
	}
	
	// id�� �ش��ϴ� �� ���� Todo ������ ��ȸ
	public void findById(int todoId) {
		Todo todo = todoDAO.findById(todoId);
		
		if(todo != null) {
			todoView.findById(todo);
		} else {
			Exception errorObject = new Exception("Todo �����Ͱ� �������� �ʽ��ϴ�.");
			todoView.errorPage(errorObject);
		}
	}
	
	
	// Todo ����
	public void insert() {
		todoDAO.insert();
		todoView.save();
	}
	
	
	// Todo ����
	public void update() {
		todoDAO.update();
//		todoView.update();
		findAll();
	}
	
	
	// Todo ����
	
}
