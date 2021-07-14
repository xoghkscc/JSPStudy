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
	<!-- 		<li>DB에 회원 정보를 저장할 수 있는 테이블을 하나 생성한다.(id, password, email)</li> -->
	<!-- 		<li>비밀번호는 해시값으로 저장해야 한다.(SHA256)</li> -->
	<!-- 		<li>사용자는 지금 이 페이지에서 아이디와 비밀번호를 입력한다</li> -->
	<!-- 		<li>컨트롤러에서 DB에서 꺼내온 아이디/비밀번호와 사용자가 입력한 아이디.비밀번호를 대조하여 -->
	<!-- 		세션에 로그인 성공 여부를 저장한다.</li> -->
	<!-- 		<li>로그인 된 상태로 현재 페이지를 보면 로그인 폼은 사라지고 -->
	<!-- 		회원 정보와 로그아웃 버튼이 보여아함</li> -->
	<!-- 		<li>로그아웃 기능도 구현해야함</li> -->
	<!-- 	</ol> -->
	<%
	if(session.getAttribute("loginfalse") != null){
	%>
	<script>
	alert('아이디 혹은 비밀번호가 틀렸습니다.');
	location.href = "./removeLogin.jsp";
	</script>
	<%}
	//로그인을 실패하였을 경우에 작동하는 코드
	%>
	
	<%
	if ((session.getAttribute("login")) == null) {
	%>
	<form id="sessionForm" action="../quiz_servlet">
		<label>아이디</label> <input type="text" name="id" /> <label>비번</label>
		<input type="text" name="pw" /> <input type="submit"
			value="로그인" />
	</form>
	<%//아직 로그인을 하지 않았을 때에 작동하는 코드
	} else {
	Quizmodel ud = (Quizmodel) session.getAttribute("login");
	out.print(ud);
	%>
	<button id="logout">로그아웃</button>
	<script>
		var logout = document.getElementById("logout");
		logout.addEventListener('click', (e) => {
			location.href = "./removeLogin.jsp";
	})</script>
	<%
	//로그인을 하였을 때에 작동하는 코드
	}
	%>

</body>
</html>