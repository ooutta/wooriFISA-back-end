package dev.syntax.step02servletprocess;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * [로그 출력 순서]
 * LifeCycleServlet() called
 * init(ServletConfig) called, 서블릿 인스턴스 초기화
 * init() called, 서블릿 인스턴스 초기화
 * service() called, 사용자 요청에 따라 서비스 제공
 * doGet() called
 */


@WebServlet("/LifecycleServlet")
public class LifeCycleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet() called");
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() called, 사용자 요청에 따라 서비스 제공");
		super.service(req, resp);
	}
	
	// 서블릿의 코드가 수정되어 새롭게 컴파일되었을 때 기존의 서블릿 인스턴스가 제거됨
	// 코드를 수정하고 리로드 하면, destroy()가 실행된 후 다시 기본 생성자가 실행된다.
	@Override
	public void destroy() {
		System.out.println("destroy() called, 서블릿 인스턴스 제거");
		super.destroy();
	}

	// 서블릿 초기화 호출, 인스턴스 생성 후 초기화 로직이 필요할 때 오버라이딩해서 구현 가능
	@Override
	public void init() throws ServletException {
		System.out.println("init() called, 서블릿 인스턴스 초기화");
		super.init();
	}
	
    // Servlet Container가 Servlet을 서비스에 배치하고 있다는 것을 알리기 위해 호출되는 메서드
    // 사용할 필요 없음 -> 초기화 로직은 init() 메서드에 작성하는 것이 좋다고함
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig) called, 서블릿 인스턴스 초기화");
		super.init(config);
	}
	
}
