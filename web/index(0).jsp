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
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background:url(9small.png) top left no-repeat #001e28;
                 margin: 0 !important;
    padding: 0 !important;
            }
        </style>
    </head>
    
    <a class="brand" style="margin: 0; float: none; text-align:center" href="#">
                  <img class="img-responsive" src="images/banner.png" alt="banner"> </a>
    
        
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
                            <c:if test="${error_login eq true}">
                                <div class="alert alert-danger small-margin">Usuario / Contraseña incorrecta</div>
                            </c:if>
                            

                            <button type="submit" class="btn btn-primary btn-md">Acceder</button>
                        </form>

                    </div>
                </div>

                <!-- show any messages that come back with authentication -->
                <!-- LOGIN FORM -->

            </div>
        
        <%@include file="TeacherHeader.html"%>

   