<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Student Management Application</title>
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
		<c:if test="${student != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="9">
            <caption>
            	<h2>
            		<c:if test="${student != null}">
            			Edit Student
            		</c:if>
            		<c:if test="${student == null}">
            			Add New Student
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${student != null}">
        			<input type="hidden" name="rollNumber" value="<c:out value='${student.rollNumber}' />" />
        		</c:if>            
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="name" 
                			value="<c:out value='${student.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Roll Number: </th>
                <td>
                	<input type="text" name="rollNumber" 
                			value="<c:out value='${student.rollNumber}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
                	<input type="text" name="gender" 
                			value="<c:out value='${student.gender}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Birth Of Date: </th>
                <td>
                	<input type="text" name="bod" 
                			value="<c:out value='${student.bodString}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Medium Score: </th>
                <td>
                	<input type="text" name="mediumScore" 
                			value="<c:out value='${student.mediumScore}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Phone: </th>
                <td>
                	<input type="text" name="phone" 
                			value="<c:out value='${student.phone}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Status: </th>
                <td>
                	<input type="text" name="status"
                			value="<c:out value='${student.status}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Address: </th>
                <td>
                	<input type="text" name="address"
                			value="<c:out value='${student.address}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Cmnd: </th>
                <td>
                	<input type="text" name="cmnd"
                			value="<c:out value='${student.cmnd}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                	<input type="text" name="email"
                			value="<c:out value='${student.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Account ID: </th>
                <td>
                	<input type="text" name="accountId"
                			value="<c:out value='${student.accountId}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
