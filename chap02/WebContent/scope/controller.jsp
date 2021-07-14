<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<% 
	String fruit = request.getParameter("fruit");
	session.setAttribute("choice", fruit.toUpperCase());
	
	session.setMaxInactiveInterval(10);
	//설정하지 않으면 기본 30분 후에 만료이며 10초 동안 사용자의 요청이 없으면 만료되는 세션
	
	response.sendRedirect("/chap02/scope/scope.jsp");


%>