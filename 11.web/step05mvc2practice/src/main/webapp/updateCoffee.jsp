<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Coffee 정보 수정</h2>
	<form action="update" method="post">
		<table>
			<tr>
				<th>번호(ID)</th>
				<td><input type="text" name="id"
					value="${requestScope.coffee.id}" readonly /></td>
			</tr>
			<tr>
				<th>이름(name)</th>
				<td><input type="text" name="name"
					value="${requestScope.coffee.name}"></td>
			</tr>
			<tr>
				<th>사이즈(size)</th>
				<td><input type="text" name="size"
					value="${requestScope.coffee.size}"></td>
			</tr>
			<tr>
				<th>가격(price)</th>
				<td><input type="text" name="price"
					value="${requestScope.coffee.price}"></td>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>