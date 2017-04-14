<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<head>
	<title> Login to Admin Panel - mdCMS </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<s:url value="/resources/admin/css/login.css" />" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container">
		<div class="wrapper">
			<c:url var="loginUrl" value="/login" />

			<form action="${loginUrl}" method="post" name="Login_Form" class="form-signin">
			    <h2 class="form-signin-heading">Admin Panel Login</h2>
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<hr class="style">
				<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required autofocus="" />
				<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required />
				<input type="checkbox" id="remember-me" name="remember-me"> Remember Me <br/><br/>
				<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
				<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="submit">Login</button>
			</form>			
		</div>
	</div>
</body>