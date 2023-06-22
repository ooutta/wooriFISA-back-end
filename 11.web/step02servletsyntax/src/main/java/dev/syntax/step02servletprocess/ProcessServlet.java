package dev.syntax.step02servletprocess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 사용자 요청 시 인스턴스가 생성됨(브라우저를 새로고침해도 인스턴스가 재생성되지 않음)
	// 최초 접속 후 브라우저를 리로드 하면 생성자가 다시 실행되지 않고, 
	// 첫 접속 시 생성됐던 인스턴스가 다시 사용된다. => 싱글톤 패턴!
	public ProcessServlet() {
		System.out.println("ProcessServlet() called");
	}

	// 일반 URL 경로(GET 요청)로 요청 시 doGet() 호출됨
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("called");
	}

	// 표준 HTTP Request를 public service()로부터 전달 받아서 doXXX() 호출(ex. doGet())
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("proteced service() called");
		super.service(req, resp);
	}

	// 클라이언트의 외부 request를 protected service()에게 전달
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("public service() called");
		super.service(req, res);
		
	}
	
	

		
}
