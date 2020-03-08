<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Query"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="camion" scope="request" class="ORM.Camion"/>
<jsp:setProperty name="camion" property="*"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creación de Camion</title>
    </head>
    <body>
        <%
            ORM.Camion camionBean = (ORM.Camion) request.getAttribute("camion");
            if (camionBean == null) {
        %>
        ERROR: no se proporcionaron datos de camion para crear.
        <%
        } else {
            Transaction t = null;
            Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
            try  {
                t = s.beginTransaction();
                s.save(camionBean);
                t.commit();
        %>
        Creado nuevo camion: [<%=camionBean.getIdCamion()%>] <%=camionBean.getNombreCamion()%><br/>
        <a href="controlador">Volver</a>
        <%
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                    if (t != null) {
                        t.rollback();
                    }
                }
            }
        %>
    </body>
</html>

