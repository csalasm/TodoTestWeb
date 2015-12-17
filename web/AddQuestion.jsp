<%@include file="TeacherHeader.html"%>

<div class="container">
    <div class=" col-sm-offset-2">

        <div class="col-sm-offset-3 text-primary">
            <h1>Añadir Pregunta</h1> 
        </div>


        <form  class="form-horizontal" action="mailto:newcomputer@nc.com"  method="post" enctype="multipart/form-data" >
            <div class="form-group">
                <label for="Pregunta" class="col-sm-2 control-label">Pregunta: </label>
                <div class="col-sm-6 ">
                    <textarea class="form-control" rows="3"  placeholder="Pregunta" required></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="Categoría" class="col-sm-2 control-label">Categoría: </label>
                <div class="col-sm-6">
                    <select class="form-control" id="categoria" name="Categoria" required>
                        <option>Categoria1</option>
                        <option>Categoria2</option>
                    </select>

                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-4">
                    <input type="text" class="form-control" id="Tematica" name="Tematica" value placeholder="Temática" required>
                </div>
                <button type="submit" class="btn btn-primary col-sm-2">Añadir Tematica</button>
            </div> 

            <div class="form-group ">
                <label for="Respuestas" class="col-sm-offset-3 control-label">Respuestas: </label>
                <div class="col-sm-offset-2">
                    <div class="radio">
                        <label>
                            <input type="radio" name="respuesta" id="respuesta" value="Respuesta1" checked>
                            <input type="text" class="form-control col-sm-8" id="Respuesta" name="Respuesta1" value placeholder="Respuesta1" required>
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="respuesta" id="respuesta" value="Respuesta2" checked>
                            <input type="text" class="form-control col-sm-8" id="Respuesta" name="Respuesta2" value placeholder="Respuesta2" required>
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="respuesta" id="respuesta" value="Respuesta3" checked>
                            <input type="text" class="form-control col-sm-8" id="Respuesta" name="Respuesta3" value placeholder="Respuesta3" required>
                        </label>
                    </div>
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

