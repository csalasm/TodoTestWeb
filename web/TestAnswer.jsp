<%-- 
    Document   : TestAnswer
    Created on : 16-dic-2015, 17:12:07
    Author     : alejandroruiz
--%>

<%@include file="StudentHeader.html" %>
<div class="container">
            <div class="col-md-offset-2 col-md-8">


                <div class="form-vertical form-required">

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h2>Titulo Test</h2></div>
                        <div class="panel-body">
                            <p id="pregunta">Pregunta:</p>
                            <label for="radio-one">
                                <input type="radio" name="exampleRadios" id="radio-one" value="radio-one"/>
                                <i></i>
                                <span>Radio One</span>
                            </label><br>
                            <label for="radio-two">
                                <input type="radio" name="exampleRadios" id="radio-two" value="doggie"/>
                                <i></i>
                                <span>Radio Two</span>
                            </label><br>
                            <button type="button" class="btn btn-primary btn-xs">Siguiente</button>

                        </div>
                    </div>

                </div>
            </div>
        </div>
<%@include file="Footer.html" %>

