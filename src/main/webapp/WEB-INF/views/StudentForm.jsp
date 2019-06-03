<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />
<div align="center">
	<c:if test="${student != null}">
		<form class="form-horizontal" action="update" method="post">
	</c:if>
	<c:if test="${student == null}">
		<form class="form-horizontal" action="insert" method="post">
	</c:if>

	<div class="container">
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Name: </label>
			<div class="col-md-9">
				<input type="text" name="name" class="form-control"
					value="<c:out value='${student.name}' />" />
			</div>
		</div>


		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Roll Number: </label>
			<div class="col-md-9">
				<input type="text" name="rollNumber" class="form-control"
					value="<c:out value='${student.rollNumber}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Gender: </label>
			<div class="col-md-9">
				<input type="text" name="gender" class="form-control"
					value="<c:out value='${student.gender}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Birth Of Date: </label>
			<div class="col-md-9">
				<input type="text" name="bod" class="form-control"
					value="<c:out value='${student.bodString}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Medium Score: </label>
			<div class="col-md-9">
				<input type="text" name="mediumScore" class="form-control"
					value="<c:out value='${student.mediumScore}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Phone: </label>
			<div class="col-md-9">
				<input type="text" name="phone" class="form-control"
					value="<c:out value='${student.phone}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Status: </label>
			<div class="col-md-9">
				<input type="text" name="status" class="form-control"
					value="<c:out value='${student.status}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Address: </label>
			<div class="col-md-9">
				<input type="text" name="address" class="form-control"
					value="<c:out value='${student.address}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Cmnd: </label>
			<div class="col-md-9">
				<input type="text" name="cmnd" class="form-control"
					value="<c:out value='${student.cmnd}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Email: </label>
			<div class="col-md-9">
				<input type="text" name="email" class="form-control"
					value="<c:out value='${student.email}' />" />
			</div>
		</div>
		<div class="form-group col-md-7">
			<label class="control-label col-sm-3">Account ID: </label>
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
