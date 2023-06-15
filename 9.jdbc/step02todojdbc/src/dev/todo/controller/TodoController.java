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
 * Controller : 사용자로부터 동작에 대한 제어, 분기 역할
 */
public class TodoController {
	private TodoDAO todoDAO;
	private TodoView todoView;
	
	public TodoController() {
		todoDAO = new TodoDAO();
		todoView = new TodoView();
	}
	// 전체 Todo 조회
	public void findAll() {
		List<Todo> todos = todoDAO.findAll();
		
		if(todos != null && todos.size() != 0) {
			todoView.findAll(todos);
		} else {
			Exception errorObject = new Exception("Todo 데이터가 존재하지 않습니다.");
			todoView.errorPage(errorObject);
		}
		
	}
	
	// id에 해당하는 한 개의 Todo 데이터 조회
	public void findById(int todoId) {
		Todo todo = todoDAO.findById(todoId);
		
		if(todo != null) {
			todoView.findById(todo);
		} else {
			Exception errorObject = new Exception("Todo 데이터가 존재하지 않습니다.");
			todoView.errorPage(errorObject);
		}
	}
	
	
	// Todo 저장
	public void insert() {
		todoDAO.insert();
		todoView.save();
	}
	
	
	// Todo 수정
	public void update() {
		todoDAO.update();
//		todoView.update();
		findAll();
	}
	
	
	// Todo 삭제
	
}
