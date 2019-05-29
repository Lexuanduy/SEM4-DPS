<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/elements/header.jsp" />

<div class="sale-statistic-area">
	<div class="container">
		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" id="username" name="uname" required>
		<label for="psw"><b>Password</b></label> <input type="password"
			id="password" placeholder="Enter Password" name="psw" required>

		<button id="login">Login</button>
	</div>
	</div>
	<script>
		$("#login")
				.click(
						function() {
							
							var username = $("#username").val();
							var password = $("#password").val();
							if (username.length < 6) {
								alert('Please enter an username.');
								return;
							}
							if (password.length < 6) {
								alert('Please enter a password.');
								return;
							}
							console.log("sign in");
							$.ajax({
										url : "/Login?username="
												+ username
												+ "&password="
												+ password,
										type : 'POST',
										success : function(data) {
											alert("Login success");
											window.location = "/students";
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											if (jqXHR.status == 404) {
												alert("Account does not exist or error passWord!");
											}
										}
									});
						});
	</script>
<jsp:include page="/elements/footer.jsp" />