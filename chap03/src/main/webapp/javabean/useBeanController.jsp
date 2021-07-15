<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="stu" class="chap03.bean.Student" scope="session"></jsp:useBean>
	<!-- session.setAttribute("stu", new Student())와 같다-->
	<jsp:setProperty property="*" name="stu" />
	<!-- stu.setName(request.getParameter("name");-->
	<!-- stu.setKor(request.getParameter("kor");... 와 같다-->
	<p>${stu.name }, ${stu.kor }, ${stu.eng }, ${stu.math }</p>
</body>
</html>