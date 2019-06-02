<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />

<div align="center">
	<h1>Score Management</h1>
</div>
<div align="center">
	<c:if test="${score.scoreId != 0}">
		<form action="/ScoreManager/update" method="post">
	</c:if>
	<c:if test="${score.scoreId == 0}">
		<form action="/ScoreManager/insert" method="post">
	</c:if>
	<div class="container">
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">List Student:</label>
			<div class="col-md-9">
				<select class="form-control" name="idStudent">
					<c:forEach var="student" items="${listStudent}">
						<option value="<c:out value='${student.rollNumber}' />"><c:out
								value='${student.name}' /></option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">List Subject:</label>
			<div class="col-md-9">
				<select class="form-control" name="idSubject">
					<c:forEach var="subject" items="${listSubject}">
						<option value="<c:out value='${subject.id}' />"><c:out
								value='${subject.name}' /></option>
					</c:forEach>
				</select>
			</div>

		</div>
		<c:if test="${score.scoreId != 0}">
			<div class="form-group col-md-7">
				<label class="control-label col-sm-3">ScoreId: </label>
				<div class="col-md-9">
					<input type="text" name="scoreId" readonly class="form-control"
						value="<c:out value='${score.scoreId}' />" />
				</div>
			</div>
		</c:if>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Mark: </label>
			<div class="col-md-9">
				<input type="text" name="score" class="form-control"
					value="<c:out value='${score.score}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Account Id: </label>
			<div class="col-md-9">
				<input type="text" name="accountId" readonly class="form-control"
					value="A001" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<button class="btn btn-success" type="submit">Save</button>
		</div>
	</div>
	</form>
</div>
<jsp:include page="/elements/footer.jsp" />