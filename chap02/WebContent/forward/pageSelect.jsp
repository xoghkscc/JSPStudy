<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>�̵��� �������� ������ �ּ���</h3>
	<form action="../page/controller" method="get">
		<input type="radio" name="page" value="1"> <label>page1</label>
		<input type="radio" name="page" value="2"> <label>page2</label>
		<input type="radio" name="page" value="3"> <label>page3</label>
		<input type="submit" value="�̵�" />
	</form>
	<h3>�̵��� �������� ����2 (�����̷�Ʈ)</h3>
	<form action="../page/controller2" method="get">
		<input type="radio" name="page" value="1"> <label>page1</label>
		<input type="radio" name="page" value="2"> <label>page2</label>
		<input type="radio" name="page" value="3"> <label>page3</label>
		<input type="submit" value="�̵�" />
	</form>
	<h3>�̵��� �������� ����3 (JSP�� ��������)</h3>
	<form action="controller/PageNumController.jsp" method="get">
		<input type="radio" name="page" value="1"> <label>page1</label>
		<input type="radio" name="page" value="2"> <label>page2</label>
		<input type="radio" name="page" value="3"> <label>page3</label>
		<input type="submit" value="�̵�" />
	</form>

	<%
		try {
			if (request.getParameter("page").equals("3")) {
				out.print(request.getParameter("page") + "�Դϴ�");
			}
		} catch (Exception e) {
		}
	%>
</body>
</html>