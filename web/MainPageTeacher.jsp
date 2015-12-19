<%-- 
    Document   : ShowResults
    Created on : 16-dic-2015, 16:38:41
    Author     : Jesus
--%>

<%@include file="TeacherHeader.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${AddQuestion_OK eq 'true'}">
    <div class="alert alert-info">Pregunta a�adida correctamente</div>
</c:if>
<c:if test="${ADD_USER eq 'true'}">
    <div class="alert alert-info">Usuario a�adido correctamente</div>
</c:if>
<div class="container">
    <div class="col-sm-6 col-sm-offset-3" style="margin-top: 30px">
        <div class="panel panel-primary">
            <div class="panel-heading"><h3><span class="glyphicon glyphicon-home"></span> Bienvenid@ ${user.nombre}</h3></div>
            <div class="panel-body">

                <a href="ShowAddTestServlet" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-list-alt"></span> A�adir test
                </a>
                <br>
                <br>
                <a href="TeacherListServlet" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-book"></span> A�adir pregunta
                </a>
                <br>
                <a href="AddUser.jsp" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-list-alt"></span> A�adir usuario
                </a>
                <br><br>
                <a href="ShowActiveTestServlet" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-book"></span> Activar/Desactivar test
                </a>
                <br>
                <a href="ResultTeacherServlet" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-book"></span> Resultados
                </a>
            </div>    

        </div>
    </div> 
</div>

<%@include file="Footer.html"%>
