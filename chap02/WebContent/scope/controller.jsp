<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<% 
	String fruit = request.getParameter("fruit");
	session.setAttribute("choice", fruit.toUpperCase());
	
	session.setMaxInactiveInterval(10);
	//�������� ������ �⺻ 30�� �Ŀ� �����̸� 10�� ���� ������� ��û�� ������ ����Ǵ� ����
	
	response.sendRedirect("/chap02/scope/scope.jsp");


%>