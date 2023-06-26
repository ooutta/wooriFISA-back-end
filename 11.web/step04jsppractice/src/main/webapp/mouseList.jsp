<%@page import="dev.mouse.domain.Mouse"%>
<%@page import="java.util.List"%>
<%@page import="dev.mouse.repository.MouseDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jsp 문법  
	page 지시자, 이 파일의 언어는 java, 문서 타입은 text/html, UTF-8 등
	이 지시자가 있어야 java 코드 작성 가능
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>국적</th>
				<th>주소</th>
			</tr>
			<!-- tbody에 해당하는 부분에 전체 mouse 리스트 데이터 출력 -->
		</thead>
		<tbody>
			<% 
				MouseDAO mouseDAO = new MouseDAO();
				List<Mouse> mice = mouseDAO.findAll();
			
				for (Mouse mouse: mice) {
					out.write("<tr>");
					out.write(String.format("<td>%s</td>", mouse.getName()));
					out.write(String.format("<td>%s</td>", mouse.getName()));
					out.write(String.format("<td>%s</td>", mouse.getCountry()));
					out.write(String.format("<td>%s</td>", mouse.getAddress()));
					out.write("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>