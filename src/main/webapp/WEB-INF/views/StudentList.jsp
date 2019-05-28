<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Student Management</title>
</head>
<body>
	<center>
		<h1>Student Management</h1>
        <h2>
        	<a href="new">Add New Student</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Students</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="9">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>Roll Number</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Cmnd</th>
                <th>Email</th>
                <th>Medium Score</th>
                <th>Account ID</th>
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
                    <td><c:out value="${student.accountId}" /></td>
                    <td><c:out value="${student.email}" /></td>
                    <td>
                    	<a href="edit?rollNumber=<c:out value='${student.rollNumber}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?rollNumber=<c:out value='${student.rollNumber}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
