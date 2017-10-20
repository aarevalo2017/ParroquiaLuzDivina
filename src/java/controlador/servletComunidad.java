package controlador;

import dao.ComunidadesDAO;
import dto.ComunidadesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandra Coello
 */
public class servletComunidad extends HttpServlet {

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
            String nombre = request.getParameter("txtNombre");
            String direccion = request.getParameter("txtDireccion");
            String telefono = request.getParameter("txtTelefono");

            // Validamos con la parte logica, DTO ( validaciones dentro de los set )
            ComunidadesDTO comunidad = new ComunidadesDTO(nombre, direccion, telefono);
            // Llamamos al DAO para conectarnos a la BD
            ComunidadesDAO dao = new ComunidadesDAO();

            if (dao.create(comunidad)) {
                request.setAttribute("msjOK", "COMUNIDAD AGREGADA!");
            } else {
                request.setAttribute("msjNO", "COMUNIDAD NO AGREGADA!");
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
            String nombre = request.getParameter("txtNombre");
            String direccion = request.getParameter("txtDireccion");
            String telefono = request.getParameter("txtTelefono");

            // Validamos con la parte logica, DTO ( validaciones dentro de los set )
            ComunidadesDTO comunidad = new ComunidadesDTO(nombre, direccion, telefono);
            // Llamamos al DAO para conectarnos a la BD
            ComunidadesDAO dao = new ComunidadesDAO();

            if (dao.update(comunidad)) {
                request.setAttribute("msjOK", "COMUNIDAD MODIFICADA!");
            } else {
                request.setAttribute("msjNO", "COMUNIDAD NO MODIFICADA!");
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
            String rut = request.getParameter("txtNombre");
            // Llamamos al DAO para conectarnos a la BD
            ComunidadesDAO dao = new ComunidadesDAO();

            if (dao.delete(rut)) {
                request.setAttribute("msjOK", "COMUNIDAD ELIMINADA!");
            } else {
                request.setAttribute("msjNO", "COMUNIDAD NO ELIMINADA!");
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
        ComunidadesDAO dao = new ComunidadesDAO();
        // Creamos una variable llamada listaComunidades con el contenido de readAll(todos los datos de la BD)
        request.setAttribute("listaComunidades", dao.readAll());
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
