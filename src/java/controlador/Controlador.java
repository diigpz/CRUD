package controlador;

import modelo.Persona;
import modeloDAO.PersonaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    PersonaDAO dAO= new PersonaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        List<Persona> personas = new ArrayList<>();
        switch (accion) {
            //toma los datos de la base de datos y lo muestra en el formulario que se enceuntra en el index.jsp
            case "listar":
                personas = dAO.getPersonas();
                request.setAttribute("Personas", personas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;//direccina a edd.jsp donde se agregan los registros a la base de datos 
            case "nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
                
                //obtiene los datos de los campos del formulario y los actualiza en la base de datos 
            case "Agregar":
                int r = 0;
                String nombres = request.getParameter("txtNombres");
                String dependencia = request.getParameter("txtDependencia");
                String fecha = request.getParameter("txtFecha");
                String archivo = request.getParameter("txtArchivo");
                Persona p = new Persona();
                p.setNombres(nombres);
                p.setDependencia(dependencia);
                p.setFecha(fecha);
                p.setArchivo(archivo);
                r = dAO.add(p);
                //mensaje que indica que los datos fueron agregados en la base de datos 
                if (r != 0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "SE AGREGO CON EXITO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    //mensaje que indica que no se pudo guardar los datos en la base de datos 
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL GUARDAR EL REGISTRO EN BD");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
                
                //aqui toma los datos de la base y los envia a la paginaditar.jsp
            case "Editar":
                int id = Integer.valueOf(request.getParameter("id"));
                Persona persona = dAO.getId(id);
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
                //en esta parte el programa captura los datos anteriores del formulario y los actualiza 
                //por los datos nuevos ingresado
            case "Actualizar":
                String nombres1 = request.getParameter("txtNombres");
                String dependencia1 = request.getParameter("txtDependencia");
                String fecha1 = request.getParameter("txtFecha");
                String archivo1 = request.getParameter("txtArchivo");
                int idPersona = Integer.valueOf(request.getParameter("txtId"));
                Persona per = new Persona(idPersona, nombres1, dependencia1, fecha1, archivo1);
                int respuesta = dAO.update(per);
                if (respuesta != 0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "SE ACTUALIZÓ CON EXITO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL ACTUALIZAR EL REGISTRO EN BD");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
                
                //borra los datos de la base de datos
            case "Delete":
                int idperso = Integer.valueOf(request.getParameter("id"));
                int res = dAO.delete(idperso);
                if (res != 0) {
                    //mensaje de borrad exitoso de la eliminacion de la base de datos
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "SE HA ELIMINADO EL REGISTRO DE LA BD");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    //mensaje cuando no se pueda eliminar los registros en la base de datos
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL ELIMINAR EL REGISTRO DE LA BD");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
