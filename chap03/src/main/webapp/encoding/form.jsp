<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>GET ���</h2>
	<form action="../language/kr" method="get">
		<input type="hidden" name="msg" value="�ȳ��ϼ���" />
		<input type="submit" value='"�ȳ��ϼ���" ������' />
	</form>
	
<h2>POST ���</h2>
	<form action="../language/kr" method="post">
		<input type="hidden" name="msg" value="�ȳ��ϼ���" />
		<input type="submit" value='"�ȳ��ϼ���" ������' />
	</form>
</body>
</html>