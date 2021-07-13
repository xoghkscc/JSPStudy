<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>이동할 페이지를 선택해 주세요</h3>
	<form action="../page/controller" method="get">
		<input type="radio" name="page" value="1"> <label>page1</label>
		<input type="radio" name="page" value="2"> <label>page2</label>
		<input type="radio" name="page" value="3"> <label>page3</label>
		<input type="submit" value="이동" />
	</form>
	<h3>이동할 페이지를 선택2 (리다이렉트)</h3>
	<form action="../page/controller2" method="get">
		<input type="radio" name="page" value="1"> <label>page1</label>
		<input type="radio" name="page" value="2"> <label>page2</label>
		<input type="radio" name="page" value="3"> <label>page3</label>
		<input type="submit" value="이동" />
	</form>
	<h3>이동할 페이지를 선택3 (JSP로 보내보기)</h3>
	<form action="controller/PageNumController.jsp" method="get">
		<input type="radio" name="page" value="1"> <label>page1</label>
		<input type="radio" name="page" value="2"> <label>page2</label>
		<input type="radio" name="page" value="3"> <label>page3</label>
		<input type="submit" value="이동" />
	</form>

	<%
		try {
			if (request.getParameter("page").equals("3")) {
				out.print(request.getParameter("page") + "입니다");
			}
		} catch (Exception e) {
		}
	%>
</body>
</html>