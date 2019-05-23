<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
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
</body>
</html>