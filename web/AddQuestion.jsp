<%@include file="TeacherHeader.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class=" col-sm-offset-2">

        <div class="col-sm-offset-3 text-primary">
            <h1>Añadir Pregunta</h1> 
        </div>
        <form name="Category" class="form-horizontal" action="AddCategoryServlet" method="post">
            <div class="form-group">
                <label for="Categoría" class="col-sm-2 control-label">Categoría: </label>
                <div class="col-sm-6">
                    <select class="form-control" id="categoria" name="Categoria" required>
                        <c:forEach var="categorias" items="${categories}">
                            <option value="${categorias.nombre}">${categorias.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-4">
                    <input type="text" class="form-control" id="addcategoria" name="addcategory" value placeholder="Categoría">
                </div>
                <button type="submit" class="btn btn-primary col-sm-2">Añadir Categoría</button>
            </div> 
        </form>

        <form  class="form-horizontal" action="AddQuestionServlet"  method="post" enctype="multipart/form-data" >
            <div class="form-group">
                <label for="Pregunta" class="col-sm-2 control-label">Pregunta: </label>
                <div class="col-sm-6 ">
                    <textarea name="pregunta" class="form-control" rows="3"  placeholder="Pregunta" required></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="Imagen" class="col-sm-2 control-label">Selecciona un fichero:</label><div class="col-sm-6">
                    <input type="file" name="fileName" class="btn"><br>
                </div>
            </div>

            <div class="form-group ">
                <label for="Respuestas" class="col-sm-offset-3 control-label">Respuestas: </label>
                <div class="col-sm-offset-2" id="answers">
                    <div class="radio">
                        <label>
                            <input type="radio" name="respuesta" id="respuesta" value="0" checked>
                            <input type="text" class="form-control col-sm-8" id="Respuesta" name="respuestaText[]" value placeholder="Respuesta1" required>
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="respuesta" id="respuesta" value="1" checked>
                            <input type="text" class="form-control col-sm-8" id="Respuesta" name="respuestaText[]" value placeholder="Respuesta2" required>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2">
                        <button type="button" class="btn btn-primary" id="addRespuesta">Añadir Respuesta</button>
                    </div>  
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2">
                        <button type="submit" class="btn btn-primary" id="boton">Añadir Pregunta</button>
                    </div>
                </div>

        </form>
    </div>
</div>
<%@include file="Footer.html"%>

