package dev.mouse.controller.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.controller.Controller;
import dev.mouse.controller.MouseInsertController;
import dev.mouse.controller.MouseListController;

// 푸트코트 프론트에서 모든 음식점들의 메뉴를 주문 받는 프론트 컨트롤러
// Web 요청을 받아서 경로에 맞는 하위 컨트롤러(List, InsertController)로 전달하는 역할
@WebServlet(urlPatterns = "/mouse-api/*")
public class MouseFrontController extends HttpServlet {
	
	// controllerMap : 요청된 경로(URL)와 그에 따른 처리를 담당하고 있는 Controller에 대한 정보를 가지고 있는 필드
	/*
	 * localhost:8080/context-path/mouse-api/"mice" -> 전체 Mouse 목록 조회 요청 경로
	 * localhost:8080/context-path/mouse-api/"mice/add" -> 하나의 Mouse 정보 등록 처리 경로
	 */
	private Map<String, Controller> controllerMap = new HashMap<>();
	
	public MouseFrontController() {
//		System.out.println("MouseFrontController 기본 생성자 호출됨");
		controllerMap.put("/mice", new MouseListController());
		controllerMap.put("/mice/add", new MouseInsertController());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		
		String path = request.getPathInfo();
		System.out.println(path);

//		System.out.println(controllerMap.get(path));
		controllerMap.get(path).process(request, response);
	}
	
}
