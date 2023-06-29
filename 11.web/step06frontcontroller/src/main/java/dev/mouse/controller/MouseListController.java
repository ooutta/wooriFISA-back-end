package dev.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MouseListController implements Controller {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("list called");
	}

	// 기존 방식
	// 1. HttpServlet 상속
	// 2. 
	
	
	
	
}
