<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<body>
	<table border="1px">
		<tr>
			<th>상영시간</th>
			<th>성인</th>
			<th>청소년</th>
			<th>시니어</th>
			<th>장애인</th>
		</tr>
		<tr>
			<td>조조</td>
			<td>6000</td>
			<td>6000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>일반</td>
			<td>7000</td>
			<td>7000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>프라임</td>
			<td>9000</td>
			<td>8000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>심야</td>
			<td>7000</td>
			<td>7000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
	</table>
	<div>
		<form action="http://localhost:8080/chap02/movie_register"
			method="post">
			<div>
				<label>상영시간</label> <select name="time1">
					<option>조조</option>
					<option>일반</option>
					<option>프라임</option>
					<option>심야</option>
				</select> <label>성인</label> <input type="text" name="성인" width="10px" />
			</div>
			<div>
				<label>상영시간</label> <select name="time2">
					<option>조조</option>
					<option>일반</option>
					<option>프라임</option>
					<option>심야</option>
				</select> <label>청소년</label> <input type="text" name="청소년" width="10px" />
			</div>
			<div>
				<label>상영시간</label> <select name="time3">
					<option>조조</option>
					<option>일반</option>
					<option>프라임</option>
					<option>심야</option>
				</select> <label>시니어</label> <input type="text" name="시니어" width="10px" />
			</div>
			<div>
				<label>상영시간</label> <select name="time4">
					<option>조조</option>
					<option>일반</option>
					<option>프라임</option>
					<option>심야</option>
				</select> <label>장애인</label> <input type="text" name="장애인" />
			</div>
			<div id="add"></div>
			<input type="button" id="추가" />
			<div>
				<input type="submit" />
			</div>
		</form>
	</div>
	<script>
        var add = document.getElementById("add");
        var add2 = document.getElementById("추가");
        add2.addEventListener('click', (e => {
            add.innerHTML += "<div><label>상영시간</label> <select name='time1'><option>조조</option><option>일반</option><option>프라임</option><option>심야</option></select> <label >성인</label> <input type='text' name='성인' width='10px' /></div>"
        }))
    </script>
</body>
</html>