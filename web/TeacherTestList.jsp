<%-- 

    Author     : Alejandro
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html" %>


<div class="container" style="margin-top:80px; margin-bottom: 10px">
            
            
            

            <div class="col-sm-6 col-sm-offset-3">

                <div class="panel responsive panel-primary" style="border-color: #31b0d5;">

                


                       <div class="list-group">
        <a href="#" class="list-group-item active">
            Seleccionar test
        </a>
        <form method="post" action="CreateTestSession">
        <c:forEach var="test" items="${user.testCollection}">
            <button name="idtest" value="${test.idTest}" class="list-group-item col-md-12">${test.nombre}</button>
        </c:forEach>
        </form>
    </div> 


                    </div>
                </div>
                

                
               

            </div>

       

<%@include file="Footer.html"%>
