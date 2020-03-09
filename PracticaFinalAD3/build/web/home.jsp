<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Camiones</title>
    </head>
    <body>
        <form name="frm_muestra_camion" method="post" action="controlador">
            <input type="hidden" name="op" value="muestraCamion">
            <input type="hidden" name="idCamion">
            <table border="1">
                <tr><td colspan="2" align="center">Camiones [<a href="javascript:void(0)" onclick="javascript:document.frm_muestra_camion.op.value = 'altaCamion';document.frm_muestra_camion.submit();">Nuevo Camion</a>]</td></tr>
                <%
                    Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
                    try {
                        Query q = s.createQuery("FROM Camion ORDER BY nombreCamion,idCamion").setReadOnly(true);
                        List<ORM.Camion> listaCamiones = (List<ORM.Camion>) q.list();
                if (listaCamiones.isEmpty()) {%>
                <tr><td colspan="2">No existen camiones</td></tr>
                <%
        } else {
            for (ORM.Camion unCamion : listaCamiones ) {%>
                <tr>
                    <td><%=unCamion.getIdCamion()%></td>
                    <td><a href="javascript:void(0)" onclick="javascript:document.frm_muestra_camion.idCamion.value = '<%=unCamion.getIdCamion()%>';
                            document.frm_muestra_camion.submit();"><%=unCamion.getNombreCamion()%></a></td>
                    <td> <input type="button" value="Borrar Camion" onclick="document.frm_muestra_camion.op.value = 'borrarCamion';javascript:document.frm_muestra_camion.idCamion.value = '<%=unCamion.getIdCamion()%>'; document.frm_muestra_camion.submit();"></td>
                    <td> <input type="button" value="Modificar Camion" onclick="document.frm_muestra_camion.op.value = 'modificarCamion';javascript:document.frm_muestra_camion.idCamion.value = '<%=unCamion.getIdCamion()%>'; document.frm_muestra_camion.submit();"></td>
                </tr>
                <%
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                %>
            </table>
        </form>
    </body>
</html>
