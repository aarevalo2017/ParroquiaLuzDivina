<%-- 
    Document   : index
    Created on : 10-10-2017, 16:06:31
    Author     : Alejandra Coello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARROQUIA LUZ DIVINA</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
    <center>
        <h1>Bienvenido: ${login.getUser()}</h1>
        <a href="otro.jsp">La otra pagina</a>
        <form action="servletErogante" method="POST">
            <table class="table table-striped" style="width: 50%">
                <tbody>
                    <tr>
                        <td>Rut:</td>
                        <td><input type="text" name="txtRut" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="txtNombre" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td><input type="number" name="txtEdad" class="form-control"/></td>
                    </tr>
                     <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="txtTelefono" class="form-control"/></td>
                    </tr>
                     <tr>
                        <td>Direccion:</td>
                        <td><input type="text" name="txtDireccion" class="form-control"/></td>
                    </tr>
                     <tr>
                        <td>Tipo Comunidad:</td>
                        <td><input type="text" name="txtTipoComunidad" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <c:choose>
                                <c:when test="${login.getTipo_usuario() == 1}">
                                    <input type="submit" value="Agregar" name="btnAccion" class="btn btn-success"/>
                                    <input type="submit" value="Modificar" name="btnAccion" class="btn btn-info"/>
                                    <input type="submit" value="Eliminar" name="btnAccion" class="btn btn-danger"/>
                                    <input type="submit" value="Listar" name="btnAccion" class="btn btn-primary"/>
                                </c:when>
                                <c:when test="${login.getTipo_usuario() == 2}">
                                    <input type="submit" value="Listar" name="btnAccion" class="btn btn-primary"/>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        <c:choose>
            <c:when test="${msjOK != null}">
                <div class="alert alert-success alert-dismissable" style="width: 50%">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Success!</strong> ${msjOK}.
                </div>
            </c:when>
            <c:when test="${msjNO != null}">
                <div class="alert alert-danger alert-dismissable" style="width: 50%">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>ERROR!</strong> ${msjNO}.
                </div>
            </c:when>
            <c:when test="${listaErogantes != null}">
                <table class="table table-striped" style="width: 50%">
                    <thead>
                        <tr>
                            <th>RUT</th>
                            <th>NOMBRE</th>
                            <th>EDAD</th>
                            <th>TELEFONO</th>
                            <th>DIRECCION</th>
                            <th>TIPO COMUNIDAD</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="aux" items="${listaErogantes}">
                            <tr>
                                <td>${aux.getRut()}</td>
                                <td>${aux.getNombre()}</td>
                                <td>${aux.getEdad()}</td>
                                <td>${aux.getTelefono()}</td>
                                <td>${aux.getDireccion()}</td>
                                <td>${aux.getTipoComunidad()}</td>
                            </tr>
                         </c:forEach> 
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
        </center>
    </body>
</html>