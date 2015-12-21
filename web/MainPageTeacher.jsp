<%-- 
    Document   : ShowResults
    Created on : 16-dic-2015, 16:38:41
    Author     : Jesus
--%>

<%@include file="TeacherHeader.html" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${AddQuestion_OK eq 'true'}">
    <div class="alert alert-info">Pregunta añadida correctamente</div>
</c:if>
<c:if test="${ADD_USER eq 'true'}">
    <div class="alert alert-info">Usuario añadido correctamente</div>
</c:if>


<div class="container" style="margin-top:80px; margin-bottom: 10px">
    <div class="col-sm-6 col-sm-offset-3" >
        <div class="panel panel-primary">
            <a href="#" class="list-group-item active">
                Bienvenid@ ${user.nombre}
            </a> 
            <div class="panel-body">
                <br>
                <div class="list-group" style="text-align: center">
                    <a href="ShowAddTestServlet" class="list-group-item"">
                        <span class="glyphicon glyphicon-list-alt"></span> Añadir test
                    </a>
                    <a href="TeacherListServlet" class="list-group-item">
                        <span class="glyphicon glyphicon-book"></span> Añadir pregunta
                    </a>
                    <a href="AddUser.jsp" class="list-group-item">
                        <span class="glyphicon glyphicon-list-alt"></span> Añadir usuario
                    </a>
                    <a href="ShowActiveTestServlet" class="list-group-item">
                        <span class="glyphicon glyphicon-book"></span> Activar/Desactivar test
                    </a>
                    <a href="ResultTeacherServlet" class="list-group-item">
                        <span class="glyphicon glyphicon-book"></span> Resultados
                    </a>
                </div>    
            </div>
        </div>
    </div> 
</div>

<%@include file="Footer.html"%>
