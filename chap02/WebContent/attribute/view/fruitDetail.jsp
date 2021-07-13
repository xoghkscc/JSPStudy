<%@page import="chap02.model.Apple"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><%=request.getAttribute("fruitName") %>의 상세정보 페이지</title>
</head>
<body>
	<h1><%= request.getAttribute("fruitName") %></h1>
	<h1><%= request.getAttribute("fruitDetail") %></h1>
	<h1><%= request.getAttribute("apple1") %></h1>
	<%
	Object[] apples = (Object[])request.getAttribute("appleArray");
	for(int i = 0; i<apples.length; i++){
		out.print(apples[i]);
	}
	%>	
	
	<h3>${fruitName }</h3>
	<h3>${apple1.price }</h3>
	<h3>${apple1.size }</h3>
	
	
</body>
</html>