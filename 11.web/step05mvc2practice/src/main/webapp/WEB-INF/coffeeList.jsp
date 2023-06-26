<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<title>Insert title here</title>
</head>
<body>
	<!-- Java코드는 가급적 사용하지 않기로 했기 때문에 out.print()는 사용하지 않음 -->
	<!-- 
		JSP를 편하게 사용할 수 있도록 제공되는 라이브러리 TagLibrary(태그 라이브러리) 사용
		이 라이브러리를 사용하기 위해서는 의존성이 필요(lib/ 폴더에 추가)
		taglibs-standard-impl-1.2.5.jar 
		taglibs-standard-spec-1.2.5.jar
	 -->
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>사이즈</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<!-- 
				c:forEach는 Java 코드 대신 편하게 사용할 수 있는 템플릿 문법
				items Attribute: Servlet으로부터 전달받은 Model 데이터를 바인딩하는 부분
				var Attribute: 전달받은 Model 데이터를 어떤 변수 이름으로 사용할 것인지
			 -->
			<c:choose>
				<c:when test="${empty requestScope.list || fn:length(list) == 0}">
					<!-- DB에 데이터가 하나도 없을 때 처리할 내용 -->
					<tr>
						<td>등록된 커피 정보가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.list}" var="coffee">
						<tr>
							<td>${coffee.id}</td>
							<td>${coffee.name}</td>
							<td>${coffee.size}</td>
							<td>${coffee.price}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>