<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" id="username" name="uname" required>
		<label for="psw"><b>Password</b></label> <input type="password"
			id="password" placeholder="Enter Password" name="psw" required>

		<button id="login">Login</button>
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

										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											if (jqXHR.status == 404) {
												alert("Account does not exist or was deleted!");
											}
											if (jqXHR.status == 403) {
												alert("Wrong password. Please log in again!");
											}
										}
									});
						});
	</script>
</body>
</html>