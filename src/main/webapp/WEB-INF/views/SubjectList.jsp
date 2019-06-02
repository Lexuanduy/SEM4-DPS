<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />
<div class="container">

	<div style="clear:both;">
		<a style="float:right;" href="/SubjectServlet/new" class="btn btn-success">Add New Subject</a>
        
	</div>
</div>
<div class="container" align="center">
<table class="table-striped table" border="1" >
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var="subject" items="${listSubject}">
                <tr>
                    <td><c:out value="${subject.id}" /></td>
                    <td><c:out value="${subject.name}" /></td>
                    <td>
                    	<a href="/SubjectServlet/edit?id=<c:out value='${subject.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a
					href="/SubjectServlet/delete?id=<c:out value='${subject.id}' />">Delete</a>                  	
                    </td>
                </tr>
            </c:forEach>
        </table>
	
</div>
<jsp:include page="/elements/footer.jsp" />