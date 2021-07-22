<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 질문 등록 페이지</title>
</head>
<body>
	<select id="optionchoose" name="optionchoose">
		<option value=" "></option>
		<option value="2">2강</option>
		<option value="4">4강</option>
		<option value="8">8강</option>
		<option value="16">16강</option>
		<option value="32">32강</option>
		<option value="64">64강</option>
	</select>
		<c:if test="${!empty param.optionchoose }">
			<div>${param.optionchoose }강</div>
			<form action="../addInfo" method="post">
				<div>
					새 질문을 등록하세요: <input type="text" name="title" />
				</div>
				<c:forEach begin="1" end='<%=Integer.parseInt(request.getParameter("optionchoose")) %>' var="i">
					<div>
						항목 <input type="text" name="name" />
					</div>
				</c:forEach>
				<input type="submit" value="등록하기" />
			</form>
		</c:if>

	<script>
		var selectBox = document.getElementById("optionchoose");
		selectBox.addEventListener('change', (e) => {
		var choose = selectBox.options[selectBox.selectedIndex].value;
		location.href = "./addQuestion?optionchoose="+choose;
	})
	</script>
</body>
</html>