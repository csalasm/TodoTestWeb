<%-- 
    Document   : ShowResults
    Created on : 16-dic-2015, 16:38:41
    Author     : Jesus
--%>
    <%@include file="StudentHeader.html" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <div class="container" style="margin-top:80px; margin-bottom: 10px">
     <div class="col-md-offset-2 text-primary col-md-8"> 
         <h1>Resultados </h1> 
            <div class="panel panel-primary">
                <div class="panel-heading">DNI ${usuario.user.dni}</div>
                <div class="panel-body">
                        <div class="table-responsive">          
                            <table class="table  table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Fecha</th>
                                        <th>Test</th>
                                        <th>Aciertos</th>
                                        <th>Fallos</th>
                                        <th>Puntuacion</th>
                                    </tr>
                                </thead>
                                <c:forEach var="examen" items="${usuario.user.examenCollection}">
                                        
                                <tbody>
                                    <tr>
                                        <td>${examen.examenPK.idTest}</td>
                                        <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${examen.fecha}" /></td>
                                        <td>${examen.test.nombre}</td>
                                        <td>${examen.aciertos}</td>
                                        <td>${examen.fallos}</td>
                                        <td>${examen.nota}</td>
                                    </tr>
                                </tbody>
                                </c:forEach>
                            </table>
                        </div>
                 
                </div>    

            </div>
        </div>  
     <div class="col-md-offset-2 text-primary col-md-8"> 
            <div class="panel panel-primary">
                <div class="panel-heading">Resumen:</div>
                <div class="panel-body">
                        <div class="table-responsive">          
                            <table class="table  table-striped">
                                <thead>
                                    <tr>
                                        <th>Test realizados</th>
                                        <th>Total aciertos</th>
                                        <th>Total fallos</th>
                                        <th>Media</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${usuario.totalTest}</td>
                                        <td>${usuario.success}</td>
                                        <td>${usuario.fails}</td>
                                        <td>${usuario.average}</td>                                  
                                    </tr>
                                </tbody>
                            </table>
                        </div>                 
                </div>    
            </div>
        </div> 
 </div>
    <%@include file="Footer.html" %>
