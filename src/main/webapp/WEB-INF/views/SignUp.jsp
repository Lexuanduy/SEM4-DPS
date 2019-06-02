<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<title>Student Life Care</title>
<!-- <script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script> -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="asset/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="asset/css/util.css">
<link rel="stylesheet" type="text/css" href="asset/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<!-- <div class="sale-statistic-area">
	<div class="container">
		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" id="_username" name="uname" required>
		<label for="psw"><b>Password</b></label> <input type="password"
			id="_password" placeholder="Enter Password" name="psw" required>

		<button id="signup">SignUp</button>
	</div>
</div> -->

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('asset/images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41"> Account Register </span>
				<div class="login100-form validate-form p-b-33 p-t-5">

					<div class="wrap-input100 validate-input"
						data-validate="Enter username">
						<input class="input100" type="text" name="username"
							placeholder="User name" id="_username"> <span
							class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input class="input100" type="password" name="pass"
							placeholder="Password" id="_password"> <span
							class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn" id="signup">SignUp</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="asset/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="asset/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="asset/vendor/bootstrap/js/popper.js"></script>
	<script src="asset/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="asset/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="asset/vendor/daterangepicker/moment.min.js"></script>
	<script src="asset/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="asset/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="asset/js/main.js"></script>
	
	<script src="cookie.js"></script>

	<script>
		$("#signup").click(function() {
			var username = $("#_username").val();
			var password = $("#_password").val();
			if (username.length < 6) {
				alert('Please enter an username.');
				return;
			}
			if (password.length < 6) {
				alert('Please enter a password.');
				return;
			}
			console.log("sign up");
			$.ajax({
				url : "/SignUp?username=" + username + "&password=" + password,
				type : 'POST',
				success : function(data) {
					alert("sign up success!");
					window.location = "/";
				},
				error : function(jqXHR, textStatus, errorThrown) {
					if (jqXHR.status == 404) {
						alert("Signup error!");
					}
				}
			});
		});
	</script>
</body>
</html>