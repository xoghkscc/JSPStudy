<%@page import="chap02.quiz.Quizmodel"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 	<ol> -->
	<!-- 		<li>DB�� ȸ�� ������ ������ �� �ִ� ���̺��� �ϳ� �����Ѵ�.(id, password, email)</li> -->
	<!-- 		<li>��й�ȣ�� �ؽð����� �����ؾ� �Ѵ�.(SHA256)</li> -->
	<!-- 		<li>����ڴ� ���� �� ���������� ���̵�� ��й�ȣ�� �Է��Ѵ�</li> -->
	<!-- 		<li>��Ʈ�ѷ����� DB���� ������ ���̵�/��й�ȣ�� ����ڰ� �Է��� ���̵�.��й�ȣ�� �����Ͽ� -->
	<!-- 		���ǿ� �α��� ���� ���θ� �����Ѵ�.</li> -->
	<!-- 		<li>�α��� �� ���·� ���� �������� ���� �α��� ���� ������� -->
	<!-- 		ȸ�� ������ �α׾ƿ� ��ư�� ��������</li> -->
	<!-- 		<li>�α׾ƿ� ��ɵ� �����ؾ���</li> -->
	<!-- 	</ol> -->
	<%
	if(session.getAttribute("loginfalse") != null){
	%>
	<script>
	alert('���̵� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.');
	location.href = "./removeLogin.jsp";
	</script>
	<%}
	//�α����� �����Ͽ��� ��쿡 �۵��ϴ� �ڵ�
	%>
	
	<%
	if ((session.getAttribute("login")) == null) {
	%>
	<form id="sessionForm" action="../quiz_servlet">
		<label>���̵�</label> <input type="text" name="id" /> <label>���</label>
		<input type="text" name="pw" /> <input type="submit"
			value="�α���" />
	</form>
	<%//���� �α����� ���� �ʾ��� ���� �۵��ϴ� �ڵ�
	} else {
	Quizmodel ud = (Quizmodel) session.getAttribute("login");
	out.print(ud);
	%>
	<button id="logout">�α׾ƿ�</button>
	<script>
		var logout = document.getElementById("logout");
		logout.addEventListener('click', (e) => {
			location.href = "./removeLogin.jsp";
	})</script>
	<%
	//�α����� �Ͽ��� ���� �۵��ϴ� �ڵ�
	}
	%>

</body>
</html>