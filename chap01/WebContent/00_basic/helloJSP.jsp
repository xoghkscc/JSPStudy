<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
	private String createColorRedText(String text) {
		return String.format("<div style='color: red;'>%s</div>", text);
		
	}

	private String createBgColorRedText(String text) {
		return String.format("<div style='background-color: red; color: white;'>%s</div>", text);
	}%>

	<%
	//���� ���� �ڹ� �ڵ带 �� �� �� �ִ� ����
	class Apple {}
	
	int sum = 0;
	for(int i = 0; i<10; i++){
		sum +=i;
	}
			
	out.print(createColorRedText("Hello!"));//JSP ���� �������� �⺻������ �ݵ�� ������ ��ü���� �� ���� �ִ�.(���� ��ü)
	out.print(createBgColorRedText("Hello!"));
	%>

	<%=createColorRedText("HI!!!")%>
	<%=sum%>
	
<script>
	let a = <%=sum %>
	console.log(a)
</script>
<script src=""></script>
</body>
</html>











