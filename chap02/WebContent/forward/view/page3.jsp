<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>������ 3�Դϴ�</h1>
	<h1>
		<% 
			String page2 = request.getParameter("page");//3
			out.print(page2+"�Դϴ�.");
		%>
	</h1>
</body>
</html>