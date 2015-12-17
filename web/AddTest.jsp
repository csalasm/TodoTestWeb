<%-- 
    Document   : AddTest
    Created on : 16-dic-2015, 16:23:32
    Author     : andresbailen93
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="TeacherHeader.html"%>
        <div class="container">
            <div class="jumbotron">
                <h1>TODOTEST WEB</h1>
            </div>

            <div class="col-sm-6 col-sm-offset-3">

                <h1><span class="fa fa-sign-in"></span> Crear Test</h1>

                <c:if test="${ADD_TEST_OK eq 'false'}">
                    <div class="alert alert-danger">Ya existe un test con ese nombre</div>
                </c:if>

                <!-- AddTest FORM -->
                <form action="AddTestServlet" method="post">
                    <div class="form-group ">
                        <label>Nombre Test</label>
                        <input type="text" class="form-control" name="testname">
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label>Duracion</label>
                            <select id="duration" name="duration" class="form-control">
                                <option value="0">-</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                            </select> 
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label>Puntuacion negativa</label>
                            <select id="puntuation" name="puntuation" class="form-control">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Autor</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <button type="submit" class="btn btn-warning btn-lg">Crear Test</button>
                </form>

               

            </div>

        </div>
<%@include file="Footer.html"%>

