<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<h1 align="center">Student Form</h1>
	<form action="SaveServlet" method="post" >
		<div align="center" >
			<table>
				<tr>
					<td></td>
					<td><input type="hidden" name="id" value="${student.id}" /></td>
				</tr>
				<tr>
					<td>First name:</td>
					<td><input type="text" name="firstName"
						value="${student.firstName}" required /></td>
				</tr>
				<tr>
					<td>last name:</td>
					<td><input type="text" name="lastName"
						value="${student.lastName}" required /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" value="${student.email}"
						required /></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><input type="text" name="phoneNumber"
						pattern="[1-9]{1}[0-9]{9}" value="${student.phoneNumber}" required /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="radio" name="gender" value="Male"
						value="${student.gender}"
						${student.gender == "Male" ? "checked" : ""} required />Male <input
						type="radio" name="gender" value="Female"
						value="${student.gender}"
						${student.gender == "Female" ? "checked" : ""} required />Female</td>
				</tr>
				<tr>
					<td>Course:</td>
					<td><select name="course" style="width: 150px">
							<option ${student.course == "BE" ? "selected" : ""}>BE</option>
							<option ${student.course == "ME" ? "selected" : ""}>ME</option>
							<option ${student.course == "BCA" ? "selected" : ""}>BCA</option>
							<option ${student.course == "MCA" ? "selected" : ""}>MCA</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save Student" /></td>
					<td><input type="reset" value="reset" /></td>
				</tr>
			</table>
		</div>
	</form>
	<br />
	<div align="center">
		<a href="ViewServlet">View Students</a>
	</div>
</body>
</html>
