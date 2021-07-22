<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../vote" method="post">
		<select name="win_id">
			<c:forEach items="${itemList }" var="itemList">
				<option value="${itemList.id }">${itemList }</option>
			</c:forEach>
		</select>
		<input type="submit" value="vote!" />
	</form>
</body>
</html>