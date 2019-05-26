<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Management Application</title>
</head>
<body>
	<div align="center">
		<h1>Subject Management</h1>
		<h2>
			<a href="new">Add New Subject</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Subject</a>

		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Subjects</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
			<c:forEach var="subject" items="${listSubject}">
				<tr>
					<td><c:out value="${subject.id}" /></td>
					<td><c:out value="${subject.name}" /></td>
					<td><a href="edit?id=<c:out value='${subject.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${subject.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>