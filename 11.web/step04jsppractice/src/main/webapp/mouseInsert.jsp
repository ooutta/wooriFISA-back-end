<%@page import="dev.mouse.domain.Mouse"%>
<%@page import="dev.mouse.repository.MouseDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// step03servletpractice/MouseInsertServlet에 작성했던 코드를 가져와서 동일하게 적용
	
	// 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	
	// 입력값 파라미터로 가져오기
	// request 객체도 내장 객체로 제공되기 때문에 바로 사용 가능
	String name = request.getParameter("name");
	String country = request.getParameter("country");
	String address = request.getParameter("address");
	
	// DB에 저장
	MouseDAO mouseDAO = new MouseDAO();
	Mouse newMouse = new Mouse(name, country, address);
	mouseDAO.add(newMouse);
	
	// list 화면으로 포워딩
	response.sendRedirect("mouseList.jsp");
	
%>