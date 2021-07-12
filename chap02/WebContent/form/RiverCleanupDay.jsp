<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>River Cleanup Day Registration</title>
<style>
	td {
	padding-bottom: 20px 
	}
</style>


</head>
<body>
	<form action="../river/register" method="post" id="registForm"></form>

	
	<table style="margin: auto;">
		<tr>
			<th colspan="3">
				<h1 style="font-weight: normal;">River Cleanup Day</h1>
				<h1>Volunteer Registration</h1>
				<hr>
			</th>
		</tr>
		<tr>
			<td><b>Full Name</b></td>
			<td><input name="first-name" form="registForm" type="text" size="15"> <br> First Name</td>
			<td><input name="last-name" form="registForm" type="text" size="15"> <br> Last Name</td>
		</tr>
		<tr>
			<td><b>Contact No.</b></td>
			<td><input type="text" size="15"> - <br> Area Code
			</td>
			<td><input type="text" size="15"> <br> Phone Number
			</td>
		</tr>
		<tr>
			<td><b>E-mail</b></td>
			<td colspan="2"><input type="email" size="30"
				placeholder="ex:myname@example.com"> <br>
				example@example.com</td>
		</tr>
		<tr>
			<td><b>What time can <br> you work?
			</b></td>
			<td colspan="2"><input type="radio" name="time" id="" checked>
				<label>Any time</label> <br> <input type="radio" name="time"
				id=""> <label>8am - Noon</label> <br> <input
				type="radio" name="time" id=""> <label>1 - 5pm</label> <br>
				<input type="radio" name="time" id=""> <label>Other</label>
				<br></td>
		</tr>
		<tr>
			<td><b>Interested in:</b></td>
			<td colspan="2"><input type="checkbox" name="intrest" id="">
				Cleaning <br> <input type="checkbox" name="intrest" id="">
				Transportation <br> <input type="checkbox" name="intrest" id="">
				Wherever Needed <br> <input type="checkbox" name="intrest"
				id=""> Food Service <br> <input type="checkbox"
				name="intrest" id=""> First Aid <br> <input
				type="checkbox" name="intrest" id=""> Other</td>
		</tr>
		<tr>
			<td><b>Comments></b></td>
			<td colspan="2"><textarea cols="40" rows="7"></textarea></td>
		</tr>
		<tr>
			<th colspan="3"><input style="padding: 15px;" type="submit"
				value="Submit Form" form="registForm"></th>
		</tr>
	</table>

</body>
</html>