<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />

<div align="center">
	<h1>User Management</h1>
	<h2>
		<a href="new">Add New Subject</a> &nbsp;&nbsp;&nbsp; <a href="list">List
			All Subject</a>

	</h2>
</div>
<div align="center">
	<c:if test="${subject != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test="${subject == null}">
		<form action="insert" method="post">
	</c:if>
	<table border="1" cellpadding="5">
		<caption>
			<h2>
				<c:if test="${subject != null}">
               Edit User
              </c:if>
				<c:if test="${subject == null}">
               Add New Subject
              </c:if>
			</h2>
		</caption>
		<c:if test="${subject != null}">
			<input type="hidden" name="id"
				value="<c:out value='${subject.id}' />" />
		</c:if>
		<tr>
			<th>User Name:</th>
			<td><input type="text" name="name" size="45"
				value="<c:out value='${subject.name}' />" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Save" /></td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="/elements/footer.jsp" />