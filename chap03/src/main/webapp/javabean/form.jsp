<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>연습 문제</h3>

	<ol>
		<li>현재 페이지의 아래에 학생의 이름과 점수를 입력하는 폼을 생성한다</li>
		<li>이름과 점수와 함께 서버에 요청을 보내면 성적표 페이지를 반환받는다.</li>
		<li>성적표에는 이름/각 과목 점수/평균/등수가 적혀있다</li>
		<li>Student 클래스에 메서드와 필드는 자유롭게 추가할 수 있다.</li>
	</ol>

	<form action="../student_servlet">
		<label>이름</label> <input type="text" name="name" autocomplete="false" />
		<label>국어점수</label><input type="number" name="kor" /> 
		<label>영어점수</label><input type="number" name="eng" /> 
		<label>수학점수</label><input type="number" name="math" /> 
		<input type="submit" value="보내기" />
	</form>
	
	<hr />
	<form action="./useBeanController.jsp">
		<label>이름</label> <input type="text" name="name" autocomplete="false" />
		<label>국어점수</label><input type="number" name="kor" /> 
		<label>영어점수</label><input type="number" name="eng" /> 
		<label>수학점수</label><input type="number" name="math" /> 
		<input type="submit" value="보내기" />
	</form>
	
	
</body>
</html>