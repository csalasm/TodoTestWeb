<%-- 
    Document   : AddUser
    Created on : 16-dic-2015, 16:38:17
    Author     : alejandroruiz
--%>

<%@include file="TeacherHeader.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" style="margin-top:80px; margin-bottom: 80px">




    <div class="col-sm-6 col-sm-offset-3">

        <div class="panel responsive panel-primary" style="border-color: #31b0d5;">

            <a href="#" class="list-group-item active">
                A&ntildeadir usuario
            </a>

            <div class="panel-body">
                <c:if test="${ADD_USER_ERROR eq 'true'}">
                    <div class="alert alert-warning">Ya existe ese usuario</div>
                </c:if>

                <form  id="addUser"class="form-vertical" action="AddUserServlet"  method="post" >
                    <div class="form-group">

                        <label for="DNI" class="col-sm-2 control-label">DNI: </label>

                        <input type="text" class="form-control"  id="DNI" name="DNI" value placeholder="DNI" required>



                        <label for="Nombre" class="col-sm-2 control-label">Nombre: </label>

                        <input type="text" class="form-control" id="nombre" name="Nombre" value placeholder="Nombre" required>


                        <label for="Apellidos" class="col-sm-2 control-label">Apellidos: </label>

                        <input type="text" class="form-control" id="apellidos" name="Apellidos" value placeholder="Apellidos" required>


                        <label for="Contraseña" class="col-sm-2 control-label">Contraseña: </label>

                        <input type="password" class="form-control" id="password" name="password" value placeholder="Contraseña" required>


                        <label for="Permisos" class="col-sm-2 control-label">Permisos: </label>
                        <br>
                        <label>
                            <input type="radio" name="permisos" id="permisos" value="true" checked>
                            Si
                        </label>


                        <label>
                            <input type="radio" name="permisos" id="permisos" value="false" checked>
                            No
                        </label>

                    </div>
                    <div class="form-group">

                        <button type="submit" class="btn btn-primary" id="boton">Agregar</button>

                    </div>

                    <div id="errorDNI" class="col-sm-4 col-sm-offset-2"></div>

                </form>






            </div>
        </div>





    </div>

</div>
<%@include file="Footer.html"%>


