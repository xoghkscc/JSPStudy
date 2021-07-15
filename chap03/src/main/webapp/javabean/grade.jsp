<%@page import="chap03.bean.Student"%>
<%@page import="java.util.TreeSet"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	TreeSet<Student> rankList = (TreeSet<Student>) session.getAttribute("rankList");
	for (Student st : rankList) {
		out.println(st);%> <br /><%
	}
	%>
	<button id="formBack">성적 입력하기</button>

	<script>
		var formBack = document.getElementById("formBack");
		formBack.addEventListener('click', (e) => {
		location.href = "./form.jsp";
	})</script>

</body>
</html>