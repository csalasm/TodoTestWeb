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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
        <script type="text/javascript" src="js/jsnow.js"></script>
        <style>

            body {
                background:url(9small.png) top left no-repeat #001e28;
                margin: 0 !important;
                padding: 0 !important;
            }



        </style>
    </head>
    <body>

        <div style="margin-bottom: 20px; background-color: black; border-bottom: 1px #31b0d5 solid">
            <a class="brand" style="margin: 0; float: none; text-align:center" href="#">
                <img class="img-responsive center-block" src="images/final_banner.png" alt="banner" > </a>
        </div>

        <div class="container">

            <div class="col-sm-6 col-sm-offset-3" >

                <div class="panel responsive panel-primary" style="border-color: #31b0d5;">

                    <div class="panel-body">


                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label>DNI</label>
                                <input type="text" class="form-control" name="user" value="33333333P">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="password" value="1234">
                            </div>

                            <c:if test="${error_login eq true}">
                                <div class="alert alert-danger small-margin">Usuario / Contraseña incorrecta</div>
                            </c:if>
                            <c:if test="${already_identified eq true}">
                                <div class="alert alert-danger small-margin">Este usuario ya está conectado</div>
                            </c:if>
                            <p>
                                <button style="align-content: center" type="submit" class="btn btn-primary btn-md center-block">Acceder</button>
                            </p>
                        </form>

                    </div>
                </div>


                <!-- LOGIN FORM -->
                <script type="text/javascript">
                    $(function () {
                        $().jSnow();
                    });
                </script>	

            </div>

        </div>

        <%@include file="Footer.html"%>

