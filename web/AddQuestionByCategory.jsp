<%-- 
    Document   : AddTest
    Created on : 16-dic-2015, 16:23:32
    Author     : andresbailen93
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">


    <div class="col-sm-6 col-sm-offset-3">

        <div class="text-primary">
            <h1>Añadir preguntas por Categoría</h1>
        </div>

        <c:if test="${AddQuestion_category eq 'true'}">
            <div class="alert alert-info">Preguntas añadidas al test correctamente</div>
        </c:if>
        <c:if test="${ADD_TEST_OK eq 'false'}">
            <div class="alert alert-danger">Ya existe un test con ese nombre</div>
        </c:if>

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
                <button type="submit" class="btn btn-primary btn-lg">Añadir Preguntas</button>
            </div>
        </form>
        <div>
            <form action="AddQuestion.jsp"  method="post">
                <button type="submit" class="btn btn-warning btn-lg">Volver</button>
            </form>
        </div>

    </div>

</div>

</div>
<%@include file="Footer.html"%>
