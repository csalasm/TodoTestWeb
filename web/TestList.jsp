<%-- 

    Author     : Jesus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="StudentHeader.html" %>

<div class="container" style="margin-top:80px; margin-bottom: 10px">
            
            
            

            <div class="col-sm-6 col-sm-offset-3">

               

                    
                    
                    <div class="panel-body">


                       <div class="list-group">
        <a href="#" class="list-group-item active">
            Seleccionar test
        </a>
        <c:forEach var="test" items="${testList}">
            <a href="DoTestServlet?id=${test.idTest}" class="list-group-item">${test.nombre}</a>
        </c:forEach>
    </div>


                    </div>
                </div>
                

                
               

            </div>

       
<%@include file="Footer.html"%>