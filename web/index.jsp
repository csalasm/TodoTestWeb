<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:if test="${sessionScope.user != null}">
    <c:choose>
    <c:when test="${sessionScope.user.esProf == 0}">
        <c:redirect url="MainPageStudent.jsp" ></c:redirect>
    </c:when>
    <c:when test="${sessionScope.user.esProf == 1}">
        <c:redirect url="MainPageTeacher.jsp"></c:redirect>
    </c:when>
    </c:choose>
</c:if>
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
        <c:if test="${error_login eq true}">
            <div class="alert alert-danger">Usuario / Contraseña incorrecta</div>
        </c:if>
	

	<!-- LOGIN FORM -->
	<form action="LoginServlet" method="post">
		<div class="form-group">
			<label>DNI</label>
			<input type="text" class="form-control" name="user" value="77774444P">
		</div>
		<div class="form-group">
			<label>Password</label>
			<input type="password" class="form-control" name="password" value="test">
		</div>

		<button type="submit" class="btn btn-warning btn-lg">Login</button>
	</form>

	

</div>

</div>
</body>
</html>
