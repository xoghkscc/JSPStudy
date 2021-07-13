<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String pageNum = request.getParameter("page");
	
	request.getRequestDispatcher(String.format("../view/page%s.jsp", pageNum))
			.forward(request, response);%>