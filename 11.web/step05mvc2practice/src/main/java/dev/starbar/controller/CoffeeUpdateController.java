package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffees/update")
public class CoffeeUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeService coffeeService = new CoffeeService();
		
		String name = (String) request.getParameter("coffeeName");
		String size = request.getParameter("coffeeSize");
		String price = request.getParameter("coffeePrice");
		
		
		Coffee coffee = new Coffee(name, size, Integer.parseInt(price));
		
		coffeeService.update(coffee);
		
//		final String path = "/step05mvc2practice/index.jsp";
		final String path = "/step05mvc2practice/coffees";

		response.sendRedirect(path);
	}

	
}
