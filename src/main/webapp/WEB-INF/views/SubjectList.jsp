<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />
<div align="center">
	<h1>Subject Management</h1>
	<h2>
		<a href="new">Add New Subject</a> &nbsp;&nbsp;&nbsp; <a href="list">List
			All Subject</a>

	</h2>
</div>
<div align="center">
	<table border="1" style="width: 100%;">
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
<jsp:include page="/elements/footer.jsp" />