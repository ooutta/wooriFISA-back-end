package dev.starbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

/*
 * Servlet
 * 사용자로부터 GET 요청을 받을 경우 전체 Coffe 목록 데이터를 coffeeList.jsp로 전달
 * 
 */
@WebServlet("/coffees")
// 1. Servlet으로 동작하도록 HttpServlet 상속
public class CoffeListController extends HttpServlet {

	// 2. GET 요청을 처리하기 위해 호출되는 메서드 오버라이딩
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. DB에서 전체 Coffee 목록 조회하는 요청을 service 클래스에 전달
		// Controller가 직접 DB에 조회하는 DAO를 호출하지 않음
		CoffeeService coffeeService = new CoffeeService();
		List<Coffee> coffeeList = coffeeService.findAll();
		
		for(Coffee coffee : coffeeList) {
			System.out.println(coffee);
		}
		
		// 4. 커피 목록 결과 데이터를 jsp 페이지로 포워딩
		request.setAttribute("list", coffeeList);

//		final String path = "coffeeList.jsp";
		final String path = "/WEB-INF/coffeeList.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	
	
	
}
