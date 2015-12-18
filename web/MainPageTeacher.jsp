<%-- 
    Document   : ShowResults
    Created on : 16-dic-2015, 16:38:41
    Author     : Jesus
--%>

<%@include file="TeacherHeader.html" %>
<div class="container">
<div class="col-sm-6 col-sm-offset-3" style="margin-top: 30px">
    <div class="panel panel-primary">
        <div class="panel-heading"><h3><span class="glyphicon glyphicon-home"></span> Bienvenid@ ${user.nombre}</h3></div>
        <div class="panel-body">
            
      <a href="ShowAddTestServlet" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-list-alt"></span> Añadir test
      </a>
            <br><br>
   <a href="TeacherListServlet" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-book"></span> Añadir pregunta
        </a>
      
       <a href="AddUser.jsp" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-list-alt"></span> Añadir usuario
      </a>
            <br><br>
   <a href="ShowActiveTestServlet" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-book"></span> Activar/Desactivar test
        </a>
      <a href="ResultTeacherServlet" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-book"></span> Resultados
        </a>
        </div>    

    </div>
</div> 
</div>
        
<%@include file="Footer.html"%>