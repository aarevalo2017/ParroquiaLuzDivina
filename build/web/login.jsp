<%-- 
    Document   : login
    Created on : 10-10-2017, 16:06:52
    Author     : Alejandra Coello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARROQUIA LUZ DIVINA</title>
    </head>
    <body>
    <center>
        <h1>Hello World!</h1>
        <form action="servletUsuario" method="POST">
            <input type="text" name="txtUser" placeholder="Ingrese Usuario"/>
            <input type="password" name="txtPass" placeholder="Ingrese Contraseña"/>
            <input type="submit" value="Ingresar" name="btnIngresar" />
        </form>
        ${msj}
        </center>
    </body>
</html>
