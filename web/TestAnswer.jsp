<%-- 
    Document   : TestAnswer
    Created on : 16-dic-2015, 17:12:07
    Author     : alejandroruiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="StudentHeader.html" %>
<div class="container" style="margin-top: 80px; margin-bottom: 80px">
    <div class="col-md-offset-2 col-md-8">
        <div class="form-vertical form-required">
            <div class="panel panel-primary">
                

                    <a href="#" class="list-group-item active">
                        ${question.testName}
                    </a>
              
                <div class="panel-body">
                    <c:if test="${question.answerList != null}">
                        <form method="post" action="DoTestServlet?id=${param.id}">
                            <p id="pregunta">(${question.currentQuestion} / ${question.totalQuestions}) ${question.question.texto}</p>
                            <p id="chronometer" style="text-align: right; font-size: 18px"></p>
                            <c:if test="${question.question.imagen != null}">
                                <p style="text-align: center"><img src="ImageServlet?image=${question.question.idPregunta}" /></p>
                                </c:if>
                                <c:forEach var="answer" items="${question.answerList}">
                                <div><label for="radio-one">
                                        <input type="radio" name="answer" id="radio-one" value="${answer.idRespuesta}"/>
                                        <span class="">${answer.texto}</span>
                                    </label></br>   
                                </div>
                            </c:forEach>
                            <c:if test="${question.lastQuestion == true}">
                                <button id="nextQuestion" type="submit" class="btn btn-primary btn-xs" style="float: right">Finalizar</button>
                            </c:if>
                            <c:if test="${question.lastQuestion == false}">
                                <button id="nextQuestion" type="submit" class="btn btn-primary btn-xs" style="float: right">Siguiente</button>
                            </c:if>
                        </form>
                    </c:if>
                    <c:if test="${question.answerList == null}">
                        <p>La calificación obtenida en el test es: <strong>${question.mark}</strong></p>
                        <c:if test="${question.pdf == true}">
                            <p>Descarga los resultados: <a href="pdf/${sessionScope.user.dni}.pdf"><img src="images/pdf.png" width="20" height="20"></a></p>
                                </c:if>

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
<script type="text/javascript" src="js/chronometer.js"></script>
<c:if test="${question.currentTestTime > 0}">
    <script type="text/javascript">
        display = jQuery('#chronometer');
        startTimer(${question.currentTestTime}, display);
    </script>
</c:if> 

<%@include file="Footer.html" %>
