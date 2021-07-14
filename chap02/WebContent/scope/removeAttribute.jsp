<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<% 
	session.removeAttribute("choice");
	response.sendRedirect("/chap02/scope/scope.jsp");


%>