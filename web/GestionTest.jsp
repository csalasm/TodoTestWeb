
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
<div class="container">
    <div class="col-sm-10 col-sm-offset-1">
        <div class="panel panel-primary">
         
            <div class="panel-body">

                <h3>Test activos:</h3>

                <form method="post" action="ActivateTestServlet">
                    <div class="checkbox" action="ActivateTestServlet">

                        <c:forEach var="test" items="${ActiveTest}"> 
                            <c:choose>
                                <c:when test="${test.activo == '1'}">
                                    <div class="checkbox-primary">
                                        <label><input type="checkbox" name="activeTests" value="${test.idTest}" checked>${test.nombre} (Activo)<br></label>
                                    </div>

                                </c:when>
                                <c:when test="${test.activo == '0'}">
                                    <div class="checkbox-primary">
                                        <label><input type="checkbox" name="activeTests" value="${test.idTest}">${test.nombre} (Desactivado)<br></label>
                                    </div>
                                </c:when>   
                            </c:choose>

                        </c:forEach>
                        <br>
                        
                        <button type="submit" value="guardar" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-save"></span> Guardar</button>

                    </div>
                </form>
             <a href="ShowAddTestServlet" class="btn btn-primary btn-md">
          <span class="glyphicon glyphicon-list-alt"></span> Añadir test</a>


        </div>

    </div>    

</div>
</div>
<%@include file="Footer.html"%>
