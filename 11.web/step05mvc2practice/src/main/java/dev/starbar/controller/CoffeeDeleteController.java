package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.service.CoffeeService;

@WebServlet("/coffees/delete")
public class CoffeeDeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeService coffeeService = new CoffeeService();
		
		int delId = Integer.parseInt(request.getParameter("delId"));
		
		coffeeService.delete(delId);
		
		final String path = "/step05mvc2practice/coffees";

		response.sendRedirect(path);
	}
	
	
}
