<%@include file="TeacherHeader.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-top:80px; margin-bottom: 80px">

    <div class="col-sm-6 col-sm-offset-3">

        <div class="panel responsive panel-primary" style="border-color: #31b0d5;">

            <a href="#" class="list-group-item active">
                A&ntildeadir pregunta
            </a>
            <div class="panel-body" style="margin: 15px">

                <c:if test="${AddQuestion_OK eq 'true'}">
                    <div class="alert alert-success">La pregunta se ha añadido correctamente</div>
                </c:if>
                <form name="Category" class="form-horizontal" action="AddCategoryServlet" method="post">

                    <div class="form-group">
                        <label class="control-label">Nueva categoría: </label>
                        <input type="text" class="form-control" id="addcategoria" name="addcategory" value placeholder="Categoría">

                        <button type="submit" class="btn btn-primary btn-xs pull-right">Añadir Categoría</button>
                    </div> 
                </form>


                <form  class="form-horizontal" action="AddQuestionServlet"  method="post" enctype="multipart/form-data" >
                    <div class="form-group">

                        <label for="Categoría" class="control-label">Categoría: </label>
                        <div>
                            <select class="form-control" id="categoria" name="Categoria" required>
                                <c:forEach var="categorias" items="${categories}">
                                    <c:choose>
                                        <c:when test="${categoria == categorias.nombre}">
                                            <option value="${categorias.nombre}" selected="">${categorias.nombre}</option>

                                        </c:when>
                                        <c:otherwise>
                                            <option value="${categorias.nombre}">${categorias.nombre}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="form-group">

                        <label for="Pregunta" class="control-label">Pregunta: </label>
                        <div >
                            <textarea name="pregunta" class="form-control" rows="3"  placeholder="Pregunta" required></textarea>
                        </div>

                    </div>
                    <div class="form-group">

                        <label for="Imagen" class="control-label">Selecciona una imagen:</label>
                        <div>

                            <input type="file" name="fileName" class="btn">
                        </div>

                    </div>

                    <div class="form-group ">

                        <label for="Respuestas" class="control-label" >Respuestas: </label>

                        <div id="answers">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="respuesta" id="respuesta" value="0" checked>
                                    <input type="text" class="form-control " id="Respuesta" name="respuestaText[]" value placeholder="Respuesta" required>
                                </label>
                            </div>
                            <div class="radio">
                                <label>

                                    <input type="radio" name="respuesta" id="respuesta" value="1" >
                                    <input type="text" class="form-control" id="Respuesta" name="respuestaText[]" value placeholder="Respuesta" required>
                                </label>
                            </div>
                        </div>

                        <div  id="answersadded">
                        </div>

                    </div>


                    <div class="form-group">
                        <div class="btn-group-vertical pull-left">

                        </div>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-xs " id="boton" name="ActionButton" value="0" >Guardar</button>
                        <button type="button" class="btn btn-primary btn-xs" id="addRespuesta"><i class="glyphicon glyphicon-plus"></i></button>
                        <button type="button" class="btn btn-primary btn-xs" id="removeRespuesta"><i class="glyphicon glyphicon-minus"></i></button>


                    </div>


                </form>

                <form  class="form-vertical" action="AddQuestionServlet"  method="post" enctype="multipart/form-data" >
                    <div class="btn-group-vertical pull-right">
                        <button type="submit" class="btn btn-primary btn-xs pull-right" id="boton" name="ActionButton" value="1">Añadir preguntas de una categoria</button>

                        <button type="submit" class="btn btn-primary btn-xs pull-right" id="boton" name="ActionButton" value="2">Volver</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>


<%@include file="Footer.html"%>