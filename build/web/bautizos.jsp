<%-- 
    Document   : bautizos
    Created on : 17-10-2017, 17:22:27
    Author     : Alejandra Coello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARROQUIA LUZ DIVINA</title>
        <%
            HttpSession session1 = request.getSession();
            
            if ( session1.getAttribute("login") == null ) {
                response.sendRedirect("login.jsp");
            }
        %>
    </head>
    <body background="imageness/bautizo2.jpg">
        <jsp:include page="menu.jsp"></jsp:include>
        <center>
            <h1>BAUTIZOS</h1>
            <form action="servletEvento" method="POST">
                <table>
                    <tr>
                        <td>Fecha:</td>
                        <td><input type="date" name="txtFecha" required="" ></td>
                    </tr>
                    <tr>
                        <td>Hora:</td>
                        <td><input type="time" name="txtHora" required="" ></td>
                    </tr>
                    <tr>
                        <td>Tipo Evento:</td>
                        <td><input type="txt" name="txtTipoEvento" required="" ></td>
                    </tr>
                    <tr>    
                        <td colspan="2">
                            <center>
                                <input type="submit" name="btnAccion" value="Agregar">
                                <input type="reset" name="btnAccion" value="Limpiar">
                            </center>
                        </td>
                    </tr>
                </table>
            </form>
            ${mensajeagregar}
        </center>  
    </body>
</html>


