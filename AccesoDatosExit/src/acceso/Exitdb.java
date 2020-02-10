/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;
/**
 *
 * @author Charlowit
 */
public class Exitdb {
    
    private static String nomClaseDS="net.xqj.exist.ExistXQDataSource";
    private static XQConnection c;
    
    public static void getConnection() throws ClassNotFoundException,
        InstantiationException, IllegalAccessException, XQException{
        XQDataSource xqs= (XQDataSource) Class.forName(nomClaseDS).newInstance();
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        xqs.setProperty("user", "admin");
        xqs.setProperty("password", "josegras");
        c=xqs.getConnection();
        
    }
    
    public static void insertarCamion(Camion aux) throws XQException{
    
       
            String cad = "update insert ( \n<camion>\n<id_camion>"+aux.getId_camion()+"</id_camion>\n<nombre_camion>"+aux.getNombre_camion() +"</nombre_camion>\n<velocidad_maxima>"+aux.getVelocidad_maxima()+"</velocidad_maxima>\n<mma>"+aux.getMma()+"</mma>\n<litros_tanque>"+aux.getLitros_tanque()+"</litros_tanque>\n</camion>\n) into doc('/db/AD/Camiones.xml')/camiones";
            XQExpression xqe = c.createExpression();
            xqe.executeCommand(cad);
   
         
    }
    
    public static void leerCamion(ArrayList<Camion> camiones) throws XMLStreamException, XQException  {
        
           
            
            String cad = "doc('/db/AD/Camiones.xml')/camiones/camion"; 
            XQExpression xqe = c.createExpression(); 
            XQResultSequence xqrs = xqe.executeQuery(cad);
            int contador=0;
            while (xqrs.next()) { 
                XMLStreamReader xsr = xqrs.getItemAsStream(); 
                Camion aux= new Camion();
                while (xsr.hasNext()) { 
                    
                    if (xsr.getEventType() == XMLStreamConstants.CHARACTERS) {
                        String datos= limpiarCadena(xsr.getText());
                        if(!datos.equals("")){
                        
                            datos=datos.replace("_", " ");
                            if(contador==0){
                                aux.setId_camion(Integer.parseInt(datos));
                                
                            }else if(contador==1){
                            
                                aux.setNombre_camion(datos);
                               
                            }else if(contador==2){
                              
                                aux.setVelocidad_maxima(Integer.parseInt(datos));
                                
                            }else if(contador==3){
                             
                                aux.setMma(Integer.parseInt(datos));
                               
                            }else if(contador==4){
                      
                                aux.setLitros_tanque(Double.parseDouble(datos));
                                
                            }
                             contador=contador+1;
                        }
                       
                    } 
                    
                    
                    xsr.next(); 
                }
                camiones.add(aux);
                contador=0;
            }
        }

       
    
        private static String limpiarCadena(String cad){
        cad=cad.replace("\n","");
        cad=cad.replace(" ","");
        cad=cad.replace("\t","");
        cad=cad.replace("\r","");
        return cad;
    }
        
    public static void borrarCamion(Camion aux) throws XQException {
        
        String cad = "update delete doc('/db/AD/Camiones.xml')/camiones/camion[id_camion=\""+aux.getId_camion()+"\"]";
        XQExpression xqe = c.createExpression();
        xqe.executeCommand(cad);
        
        
    }
    public static void modificarCamion(Camion aux) throws XQException  {
        
            int id_camion= aux.getId_camion();
            String nombre_camion= aux.getNombre_camion().replace(" ","_");
            int velocidad_maxima=aux.getVelocidad_maxima();
            int mma=aux.getMma();
            Double litros_tanque=aux.getLitros_tanque();      
            String cad = "update replace doc('/db/AD/Camiones.xml')/camiones/camion[id_camion=\""+id_camion+"\"] with \n<camion>\n<id_camion>"+id_camion+"</id_camion>\n<nombre_camion>"+nombre_camion+"</nombre_camion>\n<velocidad_maxima>"+velocidad_maxima+"</velocidad_maxima>\n<mma>"+mma+"</mma>\n<litros_tanque>"+litros_tanque+"</litros_tanque>\n</camion>";
            XQExpression xqe = c.createExpression();
            xqe.executeCommand(cad);
     
        
    }
    /*
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
*/
}
