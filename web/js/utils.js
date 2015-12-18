/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
$("#addRespuesta").on('click',function() {
    var r="<div class=\"radio\"> <label> <input type=\"radio\" name=\"respuesta\"id=\"respuesta\" value=\"1\"> <input type=\"text\" class=\"form-control col-sm-8\" id=\"Respuesta\" name=\"respuestaText[]\" value placeholder=\"Respuesta\" > </label> </div>";
   $("#answers").append(r);
});
});
