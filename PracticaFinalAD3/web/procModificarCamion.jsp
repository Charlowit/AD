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
        <title>Modificación de Camion</title>
    </head>
    <body>
        <%
           ORM.Camion camionBean = new ORM.Camion();
           camionBean.setIdCamion(Integer.parseInt(request.getParameter("idCamion")));
           camionBean.setNombreCamion(request.getParameter("nombreCamion"));
           camionBean.setVelocidadMaxima(Integer.parseInt(request.getParameter("velocidadMaxima")));
           camionBean.setMma(Integer.parseInt(request.getParameter("mma")));
           camionBean.setLitrosTanque(Double.parseDouble(request.getParameter("litrosTanque")));
            if (camionBean == null) {
        %>
        ERROR: no se proporcionaron datos de camion para crear.
        <%
        } else {
            Transaction t = null;
            Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
            try  {
                t = s.beginTransaction();
                s.update(camionBean);
                t.commit();
        %>
        Camion Modificado: [<%=camionBean.getIdCamion()%>] <%=camionBean.getNombreCamion()%><br/>
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

