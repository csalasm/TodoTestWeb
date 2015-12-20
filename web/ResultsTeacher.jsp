<%-- 
    Document   : ShowResults
    Created on : 16-dic-2015, 16:38:41
    Author     : Jesus
--%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@include file="TeacherHeader.html" %>
     
    <div class="container" style="margin-top:80px; margin-bottom: 10px">
  <div class="col-md-offset-2 text-primary col-md-8">  
    
      
            <div class="panel panel-primary">
                 <a href="#" class="list-group-item active">
            Resultados:
        </a>
                     
                    <div class="panel-body">
                        <div class="table-responsive">          
                            <table class="table  table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>DNI</th>
                                        <th>Fecha</th>
                                        <th>Test</th>
                                        <th>Aciertos</th>
                                        <th>Fallos</th>
                                        <th>Puntuacion</th>
                                    </tr>
                                </thead>
                                <c:forEach var="test" items="${usuario.testCollection}">
                                    <c:forEach var="exam" items="${test.examenCollection}">
                                        <tbody>
                                            <tr>
                                                <td>${test.idTest}</td>
                                                <td>${exam.usuario.dni}</td>
                                                <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${exam.fecha}" /></td>
                                                <td>${exam.test.nombre}</td>
                                                <td>${exam.aciertos}</td>
                                                <td>${exam.fallos}</td>
                                                <td>${exam.nota}</td>
                                            </tr>
                                        </tbody>
                                    </c:forEach>
                                </c:forEach>
                            </table>
                        </div>
                 
                </div>    

            </div>
        </div> 
    </div>
  <%@include file="Footer.html" %>