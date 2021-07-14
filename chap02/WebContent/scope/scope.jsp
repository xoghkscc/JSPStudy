<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("choice") == null){ %>
	<form id="sessionForm" action="./controller.jsp">
		<input id="select1" type="radio" name="fruit" value="apple" /> <label
			for="select1">apple</label> <input id="select2" type="radio"
			name="fruit" value="orange" /> <label for="select2">orange</label> <input
			id="select3" type="radio" name="fruit" value="grape" /> <label
			for="select3">grape</label> <input id="select4" type="radio"
			name="fruit" value="peach" /> <label for="select4">peach</label> <input
			id="select5" type="radio" name="fruit" value="melon" /> <label
			for="select5">melon</label> <input type="submit" value="����" />
	</form>
	<%} else { %>
	<h3>${choice }�������ϼ̽��ϴ�.</h3>
	<button id="choice-again-btn1">�ٸ� ���� �����ϱ�1</button>
	<button id="choice-again-btn2">�ٸ� ���� �����ϱ�2</button>
	<button id="choice-again-btn3">�ٸ� ���� �����ϱ�3</button>
	<%} %>

	<script>
	const btn1 = document.querySelector("#choice-again-btn1");	
	const btn2 = document.querySelector("#choice-again-btn2");	
	const btn3 = document.querySelector("#choice-again-btn3");	
	
	function invalidateSession(){
		location.href = "./invalidate.jsp";
	}	
	function deleteChoice(){
		location.href = "./removeAttribute.jsp";
	}	
	
	const servletSession = () => {
		location.href = "/chap02/fruit/re";
	}
	
	
	btn1.addEventListener('click', (e) => {
		deleteChoice();
	});
	btn2.addEventListener('click', (e) => {
		invalidateSession();
	});
	btn3.addEventListener('click', (e) => {
		servletSession();
	});
	
</script>
</body>
</html>