<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
<div class="container">
    <div class="col-sm-10 col-sm-offset-1">
        <div class="panel panel-primary">
            <div class="panel-heading">Manage Test</div>
            <div class="panel-body">

                <div class="table-responsive">          
                    
                   
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nombre del test</th>
                                <th>Activo</th>
                            </tr>
                        </thead>
                         
                       
                        <c:forEach var="test" items="${usuario.testCollection}">                        
                            <tbody>
                                <tr>
                                    <td>${test.nombre}</td>
                                    <c:choose>
                                        <c:when test="${test.activo == '1'}">
                                            <td><label><input name="${test.idTest}" type="checkbox" value="" checked></label></td>
                                        </c:when>
                                        <c:when test="${test.activo == '0'}">
                                            <td><label><input name="${test.idTest}" type="checkbox" value="" ></label></td>
                                        </c:when>   
                                    </c:choose>
                                    
                                </tr>    
                            </tbody>
                        </c:forEach>
                    </table>
                </div>


                <button type="button" class="btn btn-primary btn-xs">Guardar</button>
                <button type="button" class="btn btn-primary btn-xs">Nuevo Test</button>
            </div>

        </div>    

    </div>
</div>
<%@include file="Footer.html"%>
