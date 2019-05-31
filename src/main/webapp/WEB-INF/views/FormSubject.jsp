<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />

<div align="center">
	<h1>User Management</h1>
</div>
<div align="center">
	<c:if test="${subject != null}">
		<form action="/SubjectServlet/update" method="post">
	</c:if>
	<c:if test="${subject == null}">
		<form action="/SubjectServlet/insert" method="post">
	</c:if>
	<div class="container">
		<div  class="form-group col-md-7">
			<label class="control-label col-sm-3">ID: </label>
			<div class="col-md-9">
				<input  type="text" name="id" class="form-control"
					value="<c:out value='${subject.id}' />" />
			</div>
		</div>


		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Name: </label>
			<div class="col-md-9">
				<input type="text" name="name" class="form-control"
					value="<c:out value='${subject.name}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<button class="btn btn-success" type="submit">Save</button>
		</div>
	</div>
	</form>
</div>
<jsp:include page="/elements/footer.jsp" />