package controlador;

import dao.ErogantesDAO;
import dto.ErogantesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandra Coello
 */
public class servletErogante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibimos los botones del formulario
        String opciones = request.getParameter("btnAccion");
        // Preguntamos por el contenido del boton
        if (opciones.equals("Agregar")) {
            agregar(request, response);
        }

        if (opciones.equals("Modificar")) {
            modificar(request, response);
        }

        if (opciones.equals("Eliminar")) {
            eliminar(request, response);
        }

        if (opciones.equals("Listar")) {
            listar(request, response);
        }
    }

    protected void agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Recibimos los datos del formulario
            String rut = request.getParameter("txtRut");
            String nombre = request.getParameter("txtNombre");
            java.util.Date fNac = null;
            fNac = new SimpleDateFormat("yyyy-MM-dd").parse("txtFNac");
            String telefono = request.getParameter("txtTelefono");
            String mail = request.getParameter("txtMail");
            String direccion = request.getParameter("txtDireccion");
            String estado = request.getParameter("txtEstado");
            String tipoErogante = request.getParameter("txtTipoErogante");

            // Validamos con la parte logica, DTO ( validaciones dentro de los set )
            ErogantesDTO erogante = new ErogantesDTO(rut, nombre, fNac, telefono, direccion, mail, estado, tipoErogante);
            // Llamamos al DAO para conectarnos a la BD
            ErogantesDAO dao = new ErogantesDAO();

            if (dao.create(erogante)) {
                request.setAttribute("msjOK", "EROGANTE AGREGADO!");
            } else {
                request.setAttribute("msjNO", "EROGANTE NO AGREGADO!");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Recibimos los datos del formulario
            String rut = request.getParameter("txtRut");
            String nombre = request.getParameter("txtNombre");
            java.util.Date fNac = null;
            fNac = new SimpleDateFormat("yyyy-MM-dd").parse("txtFNac");
            String telefono = request.getParameter("txtTelefono");
            String mail = request.getParameter("txtMail");
            String direccion = request.getParameter("txtDireccion");
            String estado = request.getParameter("txtEstado");
            String tipoErogante = request.getParameter("txtTipoErogante");

            // Validamos con la parte logica, DTO ( validaciones dentro de los set )
            ErogantesDTO erogante = new ErogantesDTO(rut, nombre, fNac, telefono, direccion, mail, estado, tipoErogante);
            // Llamamos al DAO para conectarnos a la BD
            ErogantesDAO dao = new ErogantesDAO();

            if (dao.update(erogante)) {
                request.setAttribute("msjOK", "EROGANTE MODIFICADO!");
            } else {
                request.setAttribute("msjNO", "EROGANTE NO MODIFICADO!");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Recibimos los datos del formulario
            String rut = request.getParameter("txtRut");
            // Llamamos al DAO para conectarnos a la BD
            ErogantesDAO dao = new ErogantesDAO();

            if (dao.delete(rut)) {
                request.setAttribute("msjOK", "EROGANTE ELIMINADO!");
            } else {
                request.setAttribute("msjNO", "EROGANTE NO ELIMINADO!");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Llamamos al DAO para conectarnos a la BD
        ErogantesDAO dao = new ErogantesDAO();
        // Creamos una variable llamada listaAlumnos con el contenido de readAll(todos los datos de la BD)
        request.setAttribute("listaErogantes", dao.readAll());
        // Envias la variable a la vista index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
