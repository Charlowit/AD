<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="camion" scope="request" class="ORM.Camion"/>
<jsp:setProperty name="camion" property="*"/>

<!DOCTYPE html>

<%
    ORM.Camion camionBean = (ORM.Camion) request.getAttribute("camion");
    if (camionBean == null) {
%>
ERROR: no se especific&oacute; camion a mostrar.
<%
} else {
    Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
    try  {
        s.refresh(camionBean);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar de Camion</title>
    </head>
    <body>
        <form method="post" action="controlador">
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="op" value="guardarCamion"/>
                        <input type="int" readonly="true"  value="ID"/>
                    </td>
                    <td><input type="text" readonly="true"  name ="idCamion" value="<%=camionBean.getIdCamion()%>"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Nombre"/></td>
                    <td><input name="nombreCamion" required type="text" size="20" maxlength="20" value="<%=camionBean.getNombreCamion()%>"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Velocidad Maxima"/></td>
                    <td><input name="velocidadMaxima" required type="text" size="20" maxlength="50" value="<%=camionBean.getVelocidadMaxima()%>"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Masa Maxima Autorizada"/></td>
                    <td><input name="mma" required type="text" size="20" maxlength="30" value="<%=camionBean.getMma()%>"/></td>
                </tr>
                <tr>
                    <td><input type="text" readonly="true"  value="Litros por Tanque"/></td>
                    <td><input name="litrosTanque"  type="text" size="20" maxlength="30" value="<%=camionBean.getLitrosTanque()%>"/></td>
                </tr>
                
                <tr>
                    <td>
                        <input type="submit" value="Modificar"/>
                        <input type="reset" name="cancelar" value="Cancelar"/>
                    </td>
                </tr>
            </table>
        </form>
        <a href="controlador">Inicio</a>
    </body>
</html>
<%
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
%>
