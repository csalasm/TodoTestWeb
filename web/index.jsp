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
            body {
                background: whitesmoke;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <p style="text-align: center">
                <img src="images/banner.png" />
            </p>
	<div class="panel panel-primary col-md-6 col-md-offset-3">
     
      <div class="panel-body">

                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label>DNI</label>
                                <input type="text" class="form-control" name="user" value="77774444P">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="password" value="test">
                            </div>
                            <c:if test="${Session_Loggin eq false}">
                                <div class="alert alert-danger small-margin">La sesion a expirado</div>
                            </c:if>

                            <c:if test="${error_login eq true}">
                                <div class="alert alert-danger small-margin">Usuario / Contraseña incorrecta</div>
                            </c:if>
                            <c:if test="${already_identified eq true}">
                                <div class="alert alert-danger small-margin">Este usuario ya está conectado</div>
                            </c:if>

                            <button type="submit" class="btn btn-primary btn-md">Acceder</button>
                        </form>

                    </div>
                </div>

                <!-- show any messages that come back with authentication -->
                <!-- LOGIN FORM -->

            </div>

    </body>
</html>
