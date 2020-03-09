<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="camion" scope="request" class="ORM.Camion"/>
<jsp:setProperty name="camion" property="*"/>

<%
    ORM.Camion camionBean = (ORM.Camion) request.getAttribute("camion");
    if (camionBean == null) {
%>
ERROR: no se especific&oacute; sede a mostrar.
<%
} else {
    Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
    try  {
        s.refresh(camionBean);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Camion <%=camionBean.getIdCamion()%> - <%=camionBean.getNombreCamion()%></title>
    </head>
    <body>
        <form name="camion" method="post" action="controlador">
        <input type="hidden" name="idCamion" value="<%=camionBean.getIdCamion()%>">
            <table border="1"><tr><td colspan="2" align="center">Camion</td></tr>
                <tr><td>Nombre: </td><td>   <%=camionBean.getNombreCamion()%></td></tr>
                <tr><td>Velocidad Maxima:   </td><td>   <%=camionBean.getVelocidadMaxima()%> </td></tr>
                <tr><td>Masa Maxima Autorizada:   </td><td>   <%=camionBean.getMma()%> </td></tr>
                <tr><td>Litros en Tanque: </td> <td>  <%=camionBean.getLitrosTanque()%> </td></tr>
            </table>
        </form>    
    </body>
</html>
<%
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
%>
