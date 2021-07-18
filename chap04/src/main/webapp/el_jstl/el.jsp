<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("most", "티모");
	request.setAttribute("most", "가렌");
	session.setAttribute("most", "다리우스");
	application.setAttribute("most", "야스오");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<il>
	<li>그냥 출력: ${most }(가장 좁은 범위의 어트리뷰트가 선택됨-page)</li><%-- 티모 --%>
	<li>request를 출력: ${requestScope.most }</li><%-- 가렌 --%>
	<li>session를 출력: ${sessionScope.most }</li><%-- 다리우스 --%>
	<li>application를 출력: ${applicationScope.most }</li><%-- 야스오 --%>
</il>


<!-- <ul> -->
<%-- 	<li>${param.name }</li> --%>
<%-- 	<li>${param.age }</li> --%>
<%-- 	<li>${paramValues.hobby[0] }</li>hobby의 값이 여러개인 경우 --%>
<%-- 	<li>${paramValues.hobby[1] }</li>hobby의 값이 여러개인 경우 --%>
<!-- </ul> -->

<ul>
	<li>boolean : ${true }, ${false }</li>
	<li>정수 : ${123 }, ${234 }, ${123 + 456 }, ${5*30 }</li>
	<li>실수 : ${123.123 * 3 }, ${234 }, ${123 + 456 }, ${5*30 }</li>
	<li>문자열 : ${'hello ,world' }</li>
</ul>
<ul>
	<li>3이 7보다 큰가요? : ${3 > 7 }, ${3 gt 7 }</li>
	<li>${requestScope.most < sessionScope.most }</li>
	<li>${empty value1}</li>
	
</ul>




</body>
</html>