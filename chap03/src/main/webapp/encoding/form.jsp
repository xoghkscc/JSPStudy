<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>GET 방식</h2>
	<form action="../language/kr" method="get">
		<input type="hidden" name="msg" value="안녕하세요" />
		<input type="submit" value='"안녕하세요" 보내기' />
	</form>
	
<h2>POST 방식</h2>
	<form action="../language/kr" method="post">
		<input type="hidden" name="msg" value="안녕하세요" />
		<input type="submit" value='"안녕하세요" 보내기' />
	</form>
</body>
</html>