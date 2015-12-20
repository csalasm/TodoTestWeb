<%-- 
    Document   : ShowResults
    Created on : 16-dic-2015, 16:38:41
    Author     : Jesus
--%>

<%@include file="StudentHeader.html" %>

<div class="col-sm-6 col-sm-offset-3"style="margin-top: 80px" >
    <div class="panel panel-primary">
        
        <a href="#" class="list-group-item active">
            Bienvenid@ ${user.nombre}
        </a> 
        
        <div class="panel-body">

            <div class="list-group" style="text-align: center">


                <a href="AvailableTestListServlet" class="list-group-item"">
                    <span class="glyphicon glyphicon-list-alt"></span> Realizar Test
                </a>

                <a href="ResultStudentServlet" class="list-group-item">
                    <span class="glyphicon glyphicon-book"></span> Resultados
                </a>
                </a>
            </div>


        </div>    

    </div>
</div> 
<%@include file="Footer.html"%>
