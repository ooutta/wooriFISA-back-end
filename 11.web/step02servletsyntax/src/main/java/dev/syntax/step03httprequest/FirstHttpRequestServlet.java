package dev.syntax.step03httprequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "fistHttpRequestServlet", urlPatterns = "/fist-request-servlet")
public class FirstHttpRequestServlet extends HttpServlet {

	/*
	 * service() -> doGet(), doPost() 등 호출
	 * service()의 파라미터 2가지
	 * HttpServletRequest 객체 -HTTP 요청을 처리하는 객체
	 * HttpServletResponse 객체 - HTTP 응답을 처리하는 객체
	 */
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request: " + request);
		System.out.println("response: " + response);
		
		response.setContentType("text/html"); // 응답 객체에 이 문서의 타입은 HTML이라고 지정
		response.setCharacterEncoding("UTF-8"); // 응답 객체에 이 문서의 문자셋 인코딩은 UTF-8이라고 명시

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Request Information Example</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h3>요청 메시지에 담긴 정보 확인</h3>");
		
		// Header 메시지에 담긴 정보 추출
		out.println("Context Path : " + request.getContextPath() + "<br/>");
		out.println("Request URL : " + request.getRequestURL() + "<br/>");
		out.println("Request URI : " + request.getRequestURI() + "<br/>");
		out.println("Server Port : " + request.getServerPort() + "<br/>");
		out.println("Request Protocol : " + request.getProtocol() + "<br/>");
		out.println("Request METHOD: " + request.getMethod() + "<br/>");
		out.println("Query String : " + request.getQueryString() + "<br/>");// http://localhost:8080/step02servletsyntax/first-request-servlet?name=jerry&age=15
		out.println("Parameter(name) : " + request.getParameter("name") + "<br/>");
		out.println("Parameter(age) : " + request.getParameter("age") + "<br/>");
		
		out.println("</body>");
        out.println("</html>");
        
        // 
		out.close();
	}
	
}
