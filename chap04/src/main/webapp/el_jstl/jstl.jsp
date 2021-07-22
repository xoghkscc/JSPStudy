<%@page import="java.util.ArrayList"%>
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

	<c:set var="fruit" value="pineapple" scope="application"></c:set>

	<c:set var="fruit" value="apple" />
	<p>${fruit }</p>
	<c:set var="fruit" value="banana" />
	<p>${fruit }</p>

	<c:if test="true">
		<p>if문에서 실행될 문장</p>
	</c:if>
	<c:if test="${fruit == 'apple' }">
		<p>if문에서 실행될 문장</p>
	</c:if>

	<c:set var="color" value="blue"></c:set>
	<c:choose>
		<c:when test="${empty color }">
			<p>color 어트리뷰트가 비어있습니다.</p>
		</c:when>
		<c:when test="${color == 'red' }">
			<p>color가 빨간색</p>
		</c:when>
		<c:otherwise>
			<p style="color: ${color};">빨간색 이외의 색상입니다.</p>
		</c:otherwise>
	</c:choose>
	<div class="container">
		<c:forEach begin="0" end="10" var="i" varStatus="status">
			<div>이 반복문은 ${status.begin }부터 시작하여 ${status.end }에서 끝남</div>
		</c:forEach>
	</div>

	<%
		ArrayList<String> list = new ArrayList();
		list.add("철수");
		list.add("민수");
		list.add("만식");
		pageContext.setAttribute("list", list);
	%>
		
	<c:forEach items="${list }" var="item" varStatus="status">
		${status.count }. ${item }
	</c:forEach>


	<c:forTokens var="animal" items="cow/chicken/dog/cat/monkey" delims="/">
		${animal }
	</c:forTokens>
	
	<c:if test="${empty login }">
		<c:redirect url="http://naver.com"></c:redirect>
	</c:if>
	
	만들어진 URL:
	<c:url value="/news/add"><!-- /chap04/news/add -->
		<c:param name="type" value="weather"></c:param>
		<c:param name="reporter" value="waitingPark"></c:param>
	</c:url>
	원래 URL만드는 방식: <%= request.getContextPath() %>/news/add?type=<%="type" %>&reporter=<%="reporter" %>











</body>
</html>