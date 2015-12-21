
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
<div class="container"  style="margin-top:80px; margin-bottom: 80px">
    <div class="col-sm-10 col-sm-offset-1">
        <div class="panel panel-primary">
          
             <a href="#" class="list-group-item active">
            Test activos:
        </a>
            <div class="panel-body">

              
                <c:if test="${ADD_TEST_OK eq 'true'}">
                    <div class="alert alert-danger">Se ha modificado la configuracion de los test seleccionados</div>
                </c:if>
                <form method="post" action="ActivateTestServlet">
                    <div class="checkbox" action="ActivateTestServlet">

                        <c:forEach var="test" items="${ActiveTest}"> 
                            <c:choose>
                                <c:when test="${test.activo == '1'}">
                                    <div class="checkbox-primary">
                                        <label><input type="checkbox" name="activeTests" value="${test.idTest}" checked>${test.nombre}<br></label>
                                    </div>

                                </c:when>
                                <c:when test="${test.activo == '0'}">
                                    <div class="checkbox-primary">
                                        <label><input type="checkbox" name="activeTests" value="${test.idTest}">${test.nombre}<br></label>
                                    </div>
                                </c:when>   
                            </c:choose>

                        </c:forEach>
                        <br>
                        <div class="btn-group-vertical pull-right">
                        <button type="submit" value="guardar" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-save"></span> Guardar</button>
                        <a href="ShowAddTestServlet" class="btn btn-primary btn-md">
          <span class="glyphicon glyphicon-list-alt"></span> Añadir test</a>
                        </div>
                    </div>
                </form>
             


        </div>

    </div>    

</div>
</div>
<%@include file="Footer.html"%>
