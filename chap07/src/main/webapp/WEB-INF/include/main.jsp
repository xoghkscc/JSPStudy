<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.container {
	display: grid;
	grid-template-columns: 1fr 2fr 1fr;
}

.container>* {
	background-color: black;
	margin: 5px;
	color: white;
	padding: 50px;
}
</style>

</head>
<body>
	<h3># include</h3>

	<div class="container">
		<jsp:include page="./sub.jsp"></jsp:include>
	</div>
	
	<hr />
	
	<footer>
		<jsp:include page="./footer.jsp"></jsp:include>
	</footer>
</body>
</html>