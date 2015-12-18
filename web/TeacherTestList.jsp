<%-- 

    Author     : Alejandro
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html" %>

<div class="col-md-offset-2 text-primary col-md-8" style="margin-top: 30px">  
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
<%@include file="Footer.html"%>
