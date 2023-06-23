package dev.mouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dev.mouse.domain.Mouse;
import dev.mouse.repository.MouseDAO;

/*
 * Mouse 클래스의 정보를 입력하는 폼 만들기
 */

@WebServlet("/add")
public class MouseInsertServlet extends HttpServlet {
	
	private MouseDAO mouseDAO;

	public MouseInsertServlet() {
		super();
		this.mouseDAO = new MouseDAO();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		Mouse newMouse = new Mouse(name, country, address);
		mouseDAO.add(newMouse);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mice");
		dispatcher.forward(request, response);
	}
}
