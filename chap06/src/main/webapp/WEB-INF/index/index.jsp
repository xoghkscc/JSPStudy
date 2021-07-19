<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>관리자 메뉴</h3>

	<ul>
		<li><a href="./admin/addQuestion">새 질문 등록하기 [현재 ${q_count }개]</a></li>
	</ul>
	<hr />
	<h3>사용자 메뉴</h3>
	<c:if test="${!empty wcList }">
		<c:forEach items="${wcList }" var="wc">
			<div>
				<a href="./gamePage/?wid=${wc.getWid() }">${wc }</a>
			</div>
		</c:forEach>
	</c:if>
	<hr />
</body>
</html>