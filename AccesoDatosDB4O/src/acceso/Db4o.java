/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
/**
 *
 * @author Charlowit
 */
public class Db4o {
    
    public static void insertarCamion(Camion aux){
    
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        db.store(aux);
        db.close();
         
    }
    
    public static void leerCamion(ArrayList<Camion> camiones)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        Query q = db.query();
        q.constrain(Camion.class);
        ObjectSet result = q.execute();
        
        System.out.println(result.size());
        
        while(result.hasNext()){
            
            Camion a = new Camion();
            a = (Camion) result.next();
            camiones.add(a);
        }
        db.close();
        
    }
    
    public static void borrarCamion(Camion aux) {
        
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Camion.class);
       q.descend("id_camion").constrain(new Integer(aux.getId_camion())).equal();
       ObjectSet result = q.execute();
       Camion borrar = (Camion) result.next();
       db.delete(borrar);
       db.close();
        
    }
    public static void modificarCamion(Camion aux)  {
        
      
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Camion.class);
       q.descend("id_camion").constrain(new Integer(aux.getId_camion())).equal();
       ObjectSet result = q.execute();

       Camion modificar = (Camion) result.next();
       modificar.setId_camion(aux.getId_camion());
       modificar.setNombre_camion(aux.getNombre_camion());
       modificar.setVelocidad_maxima(aux.getVelocidad_maxima());
       modificar.setMma(aux.getMma());
       modificar.setLitros_tanque(aux.getMma());
       db.store(modificar);
       db.close();
        
    }
    public static void insertarCamionero(Camionero aux) {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        db.store(aux);
        db.close();
        
    }
    
    public static void modificarCamionero(Camionero aux) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Camionero.class);
       q.descend("id_camionero").constrain(new Integer(aux.getId_camionero())).equal();
       ObjectSet result = q.execute();

       Camionero modificar = (Camionero) result.next();
       modificar.setId_camion(aux.getId_camionero());
       modificar.setNombre(aux.getNombre());
       modificar.setApellidos(aux.getApellidos());
       modificar.setEdad(aux.getEdad());
       modificar.setSalario(aux.getSalario());
       modificar.setId_camion(aux.getId_camion());
       db.store(modificar);
       db.close();
    }
    public static void leerCamionero(ArrayList<Camionero> camioneros) {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        Query q = db.query();
        q.constrain(Camionero.class);
        ObjectSet result = q.execute();
        
        System.out.println(result.size());
        
        while(result.hasNext()){
            
            Camionero a = new Camionero();
            a = (Camionero) result.next();
            camioneros.add(a);
        }
        db.close();
    }
    
    public static void borrarCamionero(Camionero aux) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Camionero.class);
       q.descend("id_camionero").constrain(new Integer(aux.getId_camionero())).equal();
       ObjectSet result = q.execute();
       Camionero borrar = (Camionero) result.next();
       db.delete(borrar);
       db.close();
       
    }
    
    public static void insertarRuta(Ruta aux) {
        
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        db.store(aux);
        db.close();
    }
    
    public static void modificarRuta(Ruta aux) {
       
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Ruta.class);
       q.descend("id_ruta").constrain(new Integer(aux.getId_ruta())).equal();
       ObjectSet result = q.execute();

       Ruta modificar = (Ruta) result.next();
       modificar.setId_ruta(aux.getId_ruta());
       modificar.setOrigen(aux.getOrigen());
       modificar.setDestino(aux.getDestino());
       modificar.setHora(aux.getHora());
       modificar.setFecha(aux.getFecha());
       modificar.setId_camionero(aux.getId_camionero());
       db.store(modificar);
       db.close();

    }
    public static void leerRuta(ArrayList<Ruta> rutas) {
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        Query q = db.query();
        q.constrain(Ruta.class);
        ObjectSet result = q.execute();
        
        System.out.println(result.size());
        
        while(result.hasNext()){
            
            Ruta a = new Ruta();
            a = (Ruta) result.next();
            rutas.add(a);
        }
        db.close();
    }
    
    public static void borrarRuta(Ruta aux) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Ruta.class);
       q.descend("id_ruta").constrain(new Integer(aux.getId_ruta())).equal();
       ObjectSet result = q.execute();
       Ruta borrar = (Ruta) result.next();
       db.delete(borrar);
       db.close();
 
    }
    public static void insertarPaquete(Paquete aux) {

        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        db.store(aux);
        db.close();
        
    }
    
    public static void modificarPaquete(Paquete aux) {
         
       ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Paquete.class);
       q.descend("id_paquete").constrain(new Integer(aux.getId_paquete())).equal();
       ObjectSet result = q.execute();

       Paquete modificar = (Paquete) result.next();
       modificar.setId_paquete(aux.getId_paquete());
       modificar.setAltura(aux.getAltura());
       modificar.setAncho(aux.getAncho());
       modificar.setPeso(aux.getPeso());
       modificar.setProfundidad(aux.getProfundidad());
       modificar.setId_ruta(aux.getId_ruta());
       db.store(modificar);
       db.close();

    }
    
    public static void leerPaquete(ArrayList<Paquete> paquetes)  {

        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        Query q = db.query();
        q.constrain(Paquete.class);
        ObjectSet result = q.execute();
        
        System.out.println(result.size());
        
        while(result.hasNext()){
            
            Paquete a = new Paquete();
            a = (Paquete) result.next();
            paquetes.add(a);
        }
        db.close();
    }
    
    public static void borrarPaquete(Paquete aux) {
       
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");    
       Query q = db.query();
       q.constrain(Paquete.class);
       q.descend("id_paquete").constrain(new Integer(aux.getId_paquete())).equal();
       ObjectSet result = q.execute();
       Paquete borrar = (Paquete) result.next();
       db.delete(borrar);
       db.close();          

 
    }
}
