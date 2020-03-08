<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="camion" scope="request" class="ORM.Camion"/>
<jsp:setProperty name="camion" property="*"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de Camion</title>
    </head>
    <body>
        <form method="post" action="controlador">
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="op" value="insertCamion"/>
                        <input type="text" readonly="true"  value="Nombre"/>
                    </td>
                    <td><input name="nombreCamion" required type="text" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Velocidad Maxima"/></td>
                    <td><input name="velocidadMaxima" required type="text" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Masa Maxima Autorizada"/></td>
                    <td><input name="mma" required type="text" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Litros por Tanque"/></td>
                    <td><input name="litrosTanque" required type="text" size="20" maxlength="20"/></td>
                </tr>
                
                <tr>
                    <td>
                        <input type="submit" value="Crear"/>
                        <input type="reset" name="cancelar" value="Cancelar"/>
                    </td>
                </tr>
            </table>
        </form>
        <a href="controlador">Inicio</a>
    </body>
</html>
