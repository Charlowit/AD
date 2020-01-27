/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Charlowit
 */
public class ORM {
    
    public static int insertarCamion(Camion aux){
    
        Transaction t = null; 
        int row = 0;
        try { 
            
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.save(aux);
            t.commit();
            Query q = (Query) s.createQuery( "FROM Camion" ).setReadOnly(true);
            List<Camion> listacamiones  = s.createQuery( "FROM Camion" ).list();
            for (Camion camion: listacamiones) { 
                    row = camion.getIdCamion();
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
        return row;
    }
    public static void modificarCamion(Camion aux){
    
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.update(aux);
            t.commit();
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
         
    }
        
    public static void leerCamion(ArrayList<Camion> camiones)  {
        
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            Query q = (Query) s.createQuery( "FROM Camion" ).setReadOnly(true);
            List<Camion> listacamiones  = s.createQuery( "FROM Camion" ).list();
            for (Camion camion: listacamiones) { 
                    camiones.add(camion);
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }

        
    }
    
    public static void borrarCamion(Camion aux) {
        
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            if (aux != null) {
                s.delete(aux);
            }
            t.commit();
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
    }

    public static int insertarCamionero(Camionero aux) {
        
        Transaction t = null; 
        int row = 0;
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.save(aux);
            t.commit();
            s.refresh(aux.getCamion());
            Query q = (Query) s.createQuery( "FROM Camionero" ).setReadOnly(true);
            List<Camionero> listacamioneros  = s.createQuery( "FROM Camionero" ).list();
            for (Camionero camionero: listacamioneros) { 
                    row = camionero.getIdCamionero();
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
       return row; 
    }
    
    public static void modificarCamionero(Camionero aux, Camion auxca) {
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.update(aux);
            t.commit();
            s.refresh(auxca);
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
    }
    public static void leerCamionero(ArrayList<Camionero> camioneros) {
                Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            Query q = (Query) s.createQuery( "FROM Camionero" ).setReadOnly(true);
            List<Camionero> listacamioneros  = s.createQuery( "FROM Camionero" ).list();
            for (Camionero camionero: listacamioneros) { 
                    camioneros.add(camionero);
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }

    }
    
    public static void borrarCamionero(Camionero aux) {
        
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            if (aux != null) {
                s.delete(aux);
                s.refresh(aux.getCamion());
            }
            t.commit();
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
 
       
    }
    
    public static int insertarRuta(Ruta aux) {
        
        Transaction t = null; 
        int row = 0;
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.save(aux);
            t.commit();
            s.refresh(aux.getCamionero());
            Query q = (Query) s.createQuery( "FROM Ruta" ).setReadOnly(true);
            List<Ruta> listarutas  = s.createQuery( "FROM Ruta" ).list();
            for (Ruta ruta: listarutas) { 
                    row = ruta.getIdRuta();
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
       return row; 
    }
    
    public static void modificarRuta(Ruta aux) {
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.update(aux);
            t.commit();
            s.refresh(aux.getCamionero());
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }

    }
    public static void leerRuta(ArrayList<Ruta> rutas) {

                        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            Query q = (Query) s.createQuery( "FROM Ruta" ).setReadOnly(true);
            List<Ruta> listarutas  = s.createQuery( "FROM Ruta" ).list();
            for (Ruta ruta: listarutas) { 
                    rutas.add(ruta);
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
    }
    
    public static void borrarRuta(Ruta aux) {
        
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            if (aux != null) {
                s.delete(aux);
                s.refresh(aux.getCamionero());
            }
            t.commit();
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }

 
    }
    public static int insertarPaquete(Paquete aux) {
        
        Transaction t = null; 
        int row = 0;
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.save(aux);
            t.commit();
            s.refresh(aux.getRuta());
            Query q = (Query) s.createQuery( "FROM Paquete" ).setReadOnly(true);
            List<Paquete> listapaquetes  = s.createQuery( "FROM Paquete" ).list();
            for (Paquete paquete: listapaquetes) { 
                    row = paquete.getIdPaquete();
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
       return row; 

        
    }
    
    public static void modificarPaquete(Paquete aux) {
         
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            s.update(aux);
            t.commit();
            s.refresh(aux.getRuta());
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }

    }
    
    public static void leerPaquete(ArrayList<Paquete> paquetes)  {
                        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            Query q = (Query) s.createQuery( "FROM Paquete" ).setReadOnly(true);
            List<Paquete> listapaquetes  = s.createQuery( "FROM Paquete" ).list();
            for (Paquete paquete: listapaquetes) { 
                    paquetes.add(paquete);
            }
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }
 
    }
    
    public static void borrarPaquete(Paquete aux) {
       
        Transaction t = null; 
        try { 
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction(); 
            if (aux != null) {
                s.delete(aux);
                s.refresh(aux.getRuta());
            }
            t.commit();
            s.close();
        }catch (HibernateException e) { 
                    e.printStackTrace(System.err); 
                    if (t != null) { 
                            t.rollback(); 
                    }
        }

 
    }
}
