package dev.syntax.step05querystring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-eng")
public class QueryStringEng extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id"); // id라는 이름으로 전달된 값 추출
		// html 파일에서 name Attribute에 담긴 값을 추출할 때 사용
		// name Attribute : getParameter()에 작성하는 변수 이름

		out.print("<h1>GET방식으로 요청되었음</h1>");

		String password = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] hobbies = request.getParameterValues("hobby");// 쿼리스트링의 변수 형태가 배열타입일 때
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String introduction = request.getParameter("introduction");

		out.print("ID : " + id + " <br/> ");
		out.print("비밀번호 : " + password + " <br/> ");
		out.print("이름 : " + name + " <br/> ");
		out.print("취미 : ");
		for (int i = 0; i < hobbies.length; i++) {
			out.print(hobbies[i] + " ");
		}
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("국가 : " + country + "<br/>");
		out.print("소개 : " + introduction + "<br/>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() called");
	}
	
}
