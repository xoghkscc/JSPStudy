<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>���� ����</h3>

	<ol>
		<li>���� �������� �Ʒ��� �л��� �̸��� ������ �Է��ϴ� ���� �����Ѵ�</li>
		<li>�̸��� ������ �Բ� ������ ��û�� ������ ����ǥ �������� ��ȯ�޴´�.</li>
		<li>����ǥ���� �̸�/�� ���� ����/���/����� �����ִ�</li>
		<li>Student Ŭ������ �޼���� �ʵ�� �����Ӱ� �߰��� �� �ִ�.</li>
	</ol>

	<form action="../student_servlet">
		<label>�̸�</label> <input type="text" name="name" autocomplete="false" />
		<label>��������</label><input type="number" name="kor" /> 
		<label>��������</label><input type="number" name="eng" /> 
		<label>��������</label><input type="number" name="math" /> 
		<input type="submit" value="������" />
	</form>
	
	<hr />
	<form action="./useBeanController.jsp">
		<label>�̸�</label> <input type="text" name="name" autocomplete="false" />
		<label>��������</label><input type="number" name="kor" /> 
		<label>��������</label><input type="number" name="eng" /> 
		<label>��������</label><input type="number" name="math" /> 
		<input type="submit" value="������" />
	</form>
	
	
</body>
</html>