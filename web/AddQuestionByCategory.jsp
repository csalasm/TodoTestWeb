<%-- 
    Document   : AddTest
    Created on : 16-dic-2015, 16:23:32
    Author     : andresbailen93
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<div class="container" style="margin-top:80px; margin-bottom: 10px">




    <div class="col-sm-6 col-sm-offset-3">

        <div class="panel responsive panel-primary" style="border-color: #31b0d5;">

            <a href="#" class="list-group-item active">
                A&ntildeadir preguntas por categoria
            </a>

            <div class="panel-body">

                <c:if test="${AddQuestionByCategory_OK eq 'true'}">
                    <div class="alert alert-success">Las preguntas se ha añadido correctamente</div>
                </c:if>

                <!-- AddTest FORM -->
                <!-- AddTest FORM -->
                <form action="AddQuestionByCategoryServlet" method="post">
                    <div class="form-group">
                        <div class="form-group ">
                            <label>Nombre Test</label>
                            <input type="text" class="form-control" name="testname" value="${test.nombre}" readonly>
                        </div>
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
                        </div><br>
                        <div class="col-sm-6">
                            <div>
                                <label>Numero de preguntas</label>
                                <select id="numeroPreg" name="numeroPreg" class="form-control">    

                                    <c:forEach var="i" begin="1" end="15">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Autor</label>
                            <input type="text" class="form-control" name="username" value="${usuario.dni}" readonly>
                        </div>
                        <button type="submit" name="AddQuestionByCategory_ACTION" value="0" class="btn btn-primary btn-xs pull-right">Añadir Preguntas</button>
                        <button type="submit" name="AddQuestionByCategory_ACTION" value="1" class="btn btn-primary btn-xs pull-right">Volver</button>
                    </div>
                </form>


            </div>
        </div>





    </div>

</div>



<%@include file="Footer.html"%>
