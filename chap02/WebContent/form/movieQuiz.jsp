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
			<th>�󿵽ð�</th>
			<th>����</th>
			<th>û�ҳ�</th>
			<th>�ôϾ�</th>
			<th>�����</th>
		</tr>
		<tr>
			<td>����</td>
			<td>6000</td>
			<td>6000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>�Ϲ�</td>
			<td>7000</td>
			<td>7000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>������</td>
			<td>9000</td>
			<td>8000</td>
			<td>5000</td>
			<td>5000</td>
		</tr>
		<tr>
			<td>�ɾ�</td>
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
				<label>�󿵽ð�</label> <select name="time1">
					<option>����</option>
					<option>�Ϲ�</option>
					<option>������</option>
					<option>�ɾ�</option>
				</select> <label>����</label> <input type="text" name="����" width="10px" />
			</div>
			<div>
				<label>�󿵽ð�</label> <select name="time2">
					<option>����</option>
					<option>�Ϲ�</option>
					<option>������</option>
					<option>�ɾ�</option>
				</select> <label>û�ҳ�</label> <input type="text" name="û�ҳ�" width="10px" />
			</div>
			<div>
				<label>�󿵽ð�</label> <select name="time3">
					<option>����</option>
					<option>�Ϲ�</option>
					<option>������</option>
					<option>�ɾ�</option>
				</select> <label>�ôϾ�</label> <input type="text" name="�ôϾ�" width="10px" />
			</div>
			<div>
				<label>�󿵽ð�</label> <select name="time4">
					<option>����</option>
					<option>�Ϲ�</option>
					<option>������</option>
					<option>�ɾ�</option>
				</select> <label>�����</label> <input type="text" name="�����" />
			</div>
			<div id="add"></div>
			<input type="button" id="�߰�" />
			<div>
				<input type="submit" />
			</div>
		</form>
	</div>
	<script>
        var add = document.getElementById("add");
        var add2 = document.getElementById("�߰�");
        add2.addEventListener('click', (e => {
            add.innerHTML += "<div><label>�󿵽ð�</label> <select name='time1'><option>����</option><option>�Ϲ�</option><option>������</option><option>�ɾ�</option></select> <label >����</label> <input type='text' name='����' width='10px' /></div>"
        }))
    </script>
</body>
</html>