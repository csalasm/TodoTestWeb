/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    var value=2;
$("#addRespuesta").on('click',function() {
    var r="<div class=\"radio\"> <label> <input type=\"radio\" name=\"respuesta\"id=\"respuesta\" value=\""+(value)+"\"> <input type=\"text\" class=\"form-control\" id=\"Respuesta\" name=\"respuestaText[]\" value placeholder=\"Respuesta\" required> </label> </div>";
    $("#answersadded").append(r);
    value++;
});



$("#removeRespuesta").on('click',function() {
   $("#answersadded div:last-child").remove();
   value--;
});





$("#boton").on('click',function(){
    
    $("#DNIerror").remove();
    
    var dni = $("#DNI").val();
    var exp = /^\d{8}[a-zA-Z]$/;
    
    var error = "<div id=\"DNIerror\" class=\"alert alert-danger\">Introduce un DNI correcto</div>";
    if(exp.test(dni)==false){
        $("#errorDNI").append(error);
    }else{
        $("#errorDNI").hide();
    }
        
});   
});
