<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/elements/header.jsp" />
	<div class="container">
	<div class="row">
		<form action="/StudentController/list" method="GET">
		<div class="col-md-5 form-group">
			<label for="search">Search:</label>
    		<input type="text" name="search" class="form-control" >
		</div>	
		
	</form>
	</div>
	<div style="clear:both;">
		<a href="new" class="btn btn-success">Add New Student</a>
        
	</div>
    <div align="center">
        <table class="table-striped table" border="1" cellpadding="9">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>Roll Number</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Cmnd</th>
                <th>Email</th>
                <th>Medium Score</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.rollNumber}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.phone}" /></td>
                    <td><c:out value="${student.address}" /></td>
                    <td><c:out value="${student.cmnd}" /></td>
                    <td><c:out value="${student.email}" /></td>
                    <td><c:out value="${student.mediumScore}" /></td>
                    <td><c:out value="${student.email}" /></td>
                    <td>
                    	<a href="/StudentController/edit?rollNumber=<c:out value='${student.rollNumber}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="/StudentController/delete?rollNumber=<c:out value='${student.rollNumber}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    </div>
<jsp:include page="/elements/footer.jsp" />
