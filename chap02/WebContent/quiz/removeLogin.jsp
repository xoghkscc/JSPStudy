<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	session.removeAttribute("login");
	session.removeAttribute("loginfalse");
	response.sendRedirect("/chap02/quiz/quiz.jsp");
%>