<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:include page="/includes/navbar.html"></jsp:include>
	
	<jsp:include page="/includes/error-message.jsp"></jsp:include>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="card shadow-sm">
					<div class="card-body">
						<h5 class="card-title text-center mb-4">Login</h5>
						<form action="/airport/frontController" method="post">

							<input type="text" id="command" name="command"
								value="LoginCommand" hidden> <input type="text"
								id="action" name="action" value="login" hidden>

							<div class="mb-3">
								<label for="username" class="form-label">Username:</label> <input
									type="text" class="form-control" id="username" name="username"
									placeholder="Enter your username" required>
							</div>

							<div class="mb-3">
								<label for="password" class="form-label">Password:</label> <input
									type="password" class="form-control" id="password"
									name="password" placeholder="Enter your password" required>
							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>