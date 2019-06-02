<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/elements/header.jsp" />
<div class="container">

	<div style="clear:both;">
		<a href="/ScoreManager/new" class="btn btn-success">Add New Score</a>
        
	</div>
</div>
<div class="container" align="center">
<table class="table-striped table" border="1" >
            <caption><h2>List of Scores</h2></caption>
            <tr>
                <th>Roll Number</th>
                <th>Name</th>
                <th>Subject</th>
                <th>Mark</th>
                <th>Created By</th>
                <th>Action</th>
            </tr>
            <c:forEach var="score" items="${listScores}">
                <tr>
                    <td><c:out value="${score.idStudent}" /></td>
                    <td><c:out value="${score.name}" /></td>
                    <td><c:out value="${score.idSubject}" /></td>
                    <td><c:out value="${score.score}" /></td>
                    <td><c:out value="${score.accountId}" /></td>
                    <td>
                    	<a href="/ScoreManager/edit?stuId=<c:out value='${score.idStudent}'&subId=<c:out value='score.idSubject'/>">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a
					href="/ScoreManager/delete?stuId=<c:out value='${score.idStudent}'&subId=<c:out value='score.idSubject'/>">Delete</a>                  	
                    </td>
                </tr>
            </c:forEach>
        </table>
	
</div>
<jsp:include page="/elements/footer.jsp" />