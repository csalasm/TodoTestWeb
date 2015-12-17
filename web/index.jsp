<!doctype html>
<html>
<head>
	<title>TodoTestWeb</title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"> <!-- load bootstrap css -->
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"> <!-- load fontawesome -->
        <link href="css/personalizado.css" rel="stylesheet" type="text/css"/>
	<style>
		body 		{ padding-top:80px; }
	</style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>TODOTEST WEB</h1>
    </div>
    
<div class="col-sm-6 col-sm-offset-3">

	<h1><span class="fa fa-sign-in"></span> Login</h1>

	<!-- show any messages that come back with authentication -->
	
		<div class="alert alert-danger"></div>
	

	<!-- LOGIN FORM -->
	<form action="/login" method="post">
		<div class="form-group">
			<label>DNI</label>
			<input type="text" class="form-control" name="dni">
		</div>
		<div class="form-group">
			<label>Password</label>
			<input type="password" class="form-control" name="password">
		</div>

		<button type="submit" class="btn btn-warning btn-lg">Login</button>
	</form>

	

</div>

</div>
</body>
</html>