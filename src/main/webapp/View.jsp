<%@ page import="java.util.List" import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student List</title>
</head>
<body>
	<div align="center">
		<a href='index.jsp'>Add New Student</a>
	</div>
	<h1>Student List</h1>
	<table border='1' style="width: 100%;">
		<tr>
			<th>Id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Gender</th>
			<th>Course</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
				<td>${student.phoneNumber}</td>
				<td>${student.gender}</td>
				<td>${student.course}</td>
				<td><a href='EditServlet?eId=${student.id}' class="edit">Edit</a></td>
				<td><a href='EditServlet?dId=${student.id}' class="delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
