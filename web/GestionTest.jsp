
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
<div class="container">
    <div class="col-sm-10 col-sm-offset-1">
        <div class="panel panel-primary">
            <div class="panel-heading">GestionTest</div>
            <div class="panel-body">

                <h1>Test activos:</h1>

                <form method="post" action="ActivateTestServlet">
                    <div class="checkbox" action="ActivateTestServlet">

                        <c:forEach var="test" items="${ActiveTest}"> 
                            <c:choose>
                                <c:when test="${test.activo == '1'}">
                                    <div class="checkbox-primary">
                                        <label><input type="checkbox" name="activeTests" value="${test.idTest}" checked>${test.nombre} (activo)<br></label>
                                    </div>

                                </c:when>
                                <c:when test="${test.activo == '0'}">
                                    <div class="checkbox-primary">
                                        <label><input type="checkbox" name="activeTests" value="${test.idTest}">${test.nombre} (desactivado)<br></label>
                                    </div>
                                </c:when>   
                            </c:choose>

                        </c:forEach>
                        <button type="submit" value="guardar" class="btn btn-primary ">Guardar</button>

                    </div>
                </form>

            <a href="ActivateTestServlet" class="btn btn-primary pull-right">
                <span class="glyphicon glyphicon-book"></span> Añadir nuevo test
            </a>      




        </div>

    </div>    

</div>
</div>
<%@include file="Footer.html"%>
