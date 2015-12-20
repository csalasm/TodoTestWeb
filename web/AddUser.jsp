<%-- 
    Document   : AddUser
    Created on : 16-dic-2015, 16:38:17
    Author     : alejandroruiz
--%>

<%@include file="TeacherHeader.html" %>


 <div class="container" style="margin-top:80px; margin-bottom: 10px">
            
            
            

            <div class="col-sm-6 col-sm-offset-3">

                <div class="panel responsive panel-primary" style="border-color: #31b0d5;">

                     <a href="#" class="list-group-item active">
            A&ntildeadir usuario
        </a>
                    
                    <div class="panel-body">


                       <form  class="form-horizontal" action="AddUserServlet"  method="post" >
                            <div class="form-group">

                                <label for="DNI" class="col-sm-2 control-label">DNI: </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control"  id="DNI" name="DNI" value placeholder="DNI" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Nombre" class="col-sm-2 control-label">Nombre: </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="nombre" name="Nombre" value placeholder="Nombre" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Apellidos" class="col-sm-2 control-label">Apellidos: </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="apellidos" name="Apellidos" value placeholder="Apellidos" required>
                                </div>
                            </div> 

                            <div class="form-group">
                                <label for="Contraseña" class="col-sm-2 control-label">Contraseña: </label>
                                <div class="col-sm-4">
                                    <input type="password" class="form-control" id="password" name="password" value placeholder="Contraseña" required>
                                </div>
                            </div>  
                            <div class="form-group">
                                <label for="Permisos" class="col-sm-2 control-label">Permisos: </label>
                                <div class="radio col-sm-2 col-sm-offset-1">
                                    <label>
                                        <input type="radio" name="permisos" id="permisos" value="true" checked>
                                        Si
                                    </label>
                                </div>
                                <div class="radio col-sm-2">
                                    <label>
                                        <input type="radio" name="permisos" id="permisos" value="false" checked>
                                        No
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3">
                                    <button type="submit" class="btn btn-primary" id="boton">Agregar</button>
                                </div>
                            </div>


                        </form>

                        <div id="errorDNI" class="col-sm-4 col-sm-offset-2"></div>


                    </div>
                </div>
                

                
               

            </div>

        </div>
<%@include file="Footer.html"%>


    