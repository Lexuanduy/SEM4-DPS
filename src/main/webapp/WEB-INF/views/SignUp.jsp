<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/elements/header.jsp" />

<div class="sale-statistic-area">
	<div class="container">
		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" id="_username" name="uname" required>
		<label for="psw"><b>Password</b></label> <input type="password"
			id="_password" placeholder="Enter Password" name="psw" required>

		<button id="signup">SignUp</button>
	</div>
</div>
<jsp:include page="/elements/footer.jsp" />