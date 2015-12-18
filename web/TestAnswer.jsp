<%-- 
    Document   : TestAnswer
    Created on : 16-dic-2015, 17:12:07
    Author     : alejandroruiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="StudentHeader.html" %>
<div class="container" style="margin-top: 30px">
            <div class="col-md-offset-2 col-md-8">
                <div class="form-vertical form-required">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h2>${question.testName}</h2></div>
                        <div class="panel-body">
                            <c:if test="${question.answerList != null}">
                                <form method="post" action="DoTestServlet?id=${param.id}">
                                    <p id="pregunta">(${question.currentQuestion} / ${question.totalQuestions}) ${question.question.texto}</p>
                                    <c:if test="${question.question.imagen != null}">
                                        <p style="text-align: center"><img src="ImageServlet?image=${question.question.idPregunta}" /></p>
                                    </c:if>
                                    <c:forEach var="answer" items="${question.answerList}">
                                        <label for="radio-one">
                                            <input type="radio" name="answer" id="radio-one" value="${answer.idRespuesta}"/>
                                            <i></i>
                                            <span>${answer.texto}</span>
                                        </label><br>    
                                    </c:forEach>
                                    <c:if test="${question.lastQuestion == true}">
                                        <button type="submit" class="btn btn-primary btn-xs" style="float: right">Finalizar</button>
                                    </c:if>
                                    <c:if test="${question.lastQuestion == false}">
                                        <button type="submit" class="btn btn-primary btn-xs" style="float: right">Siguiente</button>
                                    </c:if>
                                </form>
                            </c:if>
                            <c:if test="${question.answerList == null}">
                                La calificación obtenida en el test es: ${question.mark}
                            </c:if>
                        </div>
                            <c:if test="${answer == false}">
                                <div class="alert alert-info" style="margin-left: 30px; margin-right: 30px">Debes elegir una respuesta</div>
                            </c:if>
                    </div>

                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/back.js"></script>           
<%@include file="Footer.html" %>

