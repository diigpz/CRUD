<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <form action="Controlador" method="POST">
                <div class="card border-info mb-3" style="max-width: 18rem;">
                    <div class="card-header">ACTUALIZAR PERSONA</div>
                    <div class="card-body text-info">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" value="${persona.id}" name="txtId" readonly="" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NOMBRES</label>
                            <input type="text" value="${persona.nombres}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>DEPENDENCIA</label>
                            <input type="text" value="${persona.dependencia}" name="txtDependencia" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>FECHA</label>
                            <input type="date" value="${persona.fecha}" name="txtFecha" class="form-control">
                        </div>
                       
                        <div class="form-group">
                            <label>ARCHIVO</label>
                            <textarea class="form-control" rows="3" name="txtArchivo" placeholder="JSON..." > ${persona.archivo} </textarea>
                            <!--<input type="file" name="txtArchivos" class="form-control" accepted=".json">-->
                        </div>
                    <div class="card-footer">
                        <input type="submit" value="Actualizar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link ml-2">Volver</a>
                    </div>
                </div>
            </form>

        </div>
    </body>
</html>
