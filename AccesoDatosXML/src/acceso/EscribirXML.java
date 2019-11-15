/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.io.*;
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
public class EscribirXML {
    
    public static void Escribir_Camion(ArrayList<Camion> camiones){
             
        String id_camion, nombre_camion, velocidad_maxima, mma, litros_tanque;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     try{     
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "camiones", null);
        document.setXmlVersion("1.0"); 


      for(Camion camion : camiones) {
        id_camion = String.valueOf(camion.getId_camion());
        nombre_camion = camion.getNombre_camion();
        velocidad_maxima = String.valueOf(camion.getVelocidad_maxima());
        mma = String.valueOf(camion.getMma());
        litros_tanque = String.valueOf(camion.getLitros_tanque());


         if(camiones.size()>0) {
          Element raiz = document.createElement("camion");
          document.getDocumentElement().appendChild(raiz); 

          CrearElemento("id_camion",id_camion, raiz, document); 
          CrearElemento("nombre_camion",nombre_camion, raiz, document);
          CrearElemento("velocidad_maxima",velocidad_maxima, raiz, document); 
          CrearElemento("mma",mma, raiz, document);
          CrearElemento("litros_tanque",litros_tanque, raiz, document);


         }
      }
      Source source = new DOMSource(document);
         Result result = 
                new StreamResult(new java.io.File("Camiones.xml"));        
         Transformer transformer =
                TransformerFactory.newInstance().newTransformer();
         transformer.transform(source, result);




     }
     catch(Exception e){
         System.err.println("Error: "+e); 
     }
    }
    
    public static void Escribir_Camioneros(ArrayList<Camionero> camioneros){
             
        String id_camionero, nombre, apellidos, edad, salario, id_camion;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     try{     
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "camioneros", null);
        document.setXmlVersion("1.0"); 


      for(Camionero camionero : camioneros) {
        id_camionero = String.valueOf(camionero.getId_camion());
        nombre = camionero.getNombre();
        apellidos = camionero.getApellidos();
        edad = String.valueOf(camionero.getEdad());
        salario = String.valueOf(camionero.getSalario());
        id_camion = String.valueOf(camionero.getId_camion());



         if(camioneros.size()>0) {
          Element raiz = document.createElement("camionero");
          document.getDocumentElement().appendChild(raiz); 

          CrearElemento("id_camionero",id_camionero, raiz, document); 
          CrearElemento("nombre",nombre, raiz, document);
          CrearElemento("apellidos",apellidos, raiz, document); 
          CrearElemento("edad",edad, raiz, document);
          CrearElemento("salario",salario, raiz, document);
          CrearElemento("id_camion",id_camion, raiz, document);


         }
      }
      Source source = new DOMSource(document);
         Result result = 
                new StreamResult(new java.io.File("Camioneros.xml"));        
         Transformer transformer =
                TransformerFactory.newInstance().newTransformer();
         transformer.transform(source, result);




     }
     catch(Exception e){
         System.err.println("Error: "+e); 
     }
    }
    public static void Escribir_Rutas(ArrayList<Ruta> rutas){
             
        String id_ruta, origen, destino, hora, fecha, id_camionero;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     try{     
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "rutas", null);
        document.setXmlVersion("1.0"); 


      for(Ruta ruta : rutas) {
        id_ruta = String.valueOf(ruta.getId_ruta());
        origen = ruta.getOrigen();
        destino = ruta.getDestino();
        hora = ruta.getHora();
        fecha = ruta.getFecha();
        id_camionero = String.valueOf(ruta.getId_camionero());



         if(rutas.size()>0) {
          Element raiz = document.createElement("ruta");
          document.getDocumentElement().appendChild(raiz); 

          CrearElemento("id_ruta",id_ruta, raiz, document); 
          CrearElemento("origen",origen, raiz, document);
          CrearElemento("destino",destino, raiz, document); 
          CrearElemento("hora",hora, raiz, document);
          CrearElemento("fecha",fecha, raiz, document);
          CrearElemento("id_camionero",id_camionero, raiz, document);


         }
      }
      Source source = new DOMSource(document);
         Result result = 
                new StreamResult(new java.io.File("Rutas.xml"));        
         Transformer transformer =
                TransformerFactory.newInstance().newTransformer();
         transformer.transform(source, result);




     }
     catch(Exception e){
         System.err.println("Error: "+e); 
     }
    }
    public static void Escribir_Paquetes(ArrayList<Paquete> paquetes){
             
        String id_paquete, peso, altura, ancho, profundidad, id_ruta;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     try{     
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "paquetes", null);
        document.setXmlVersion("1.0"); 


      for(Paquete paquete : paquetes) {
        id_paquete = String.valueOf(paquete.getId_paquete());
        peso = String.valueOf(paquete.getPeso());
        altura = String.valueOf(paquete.getAltura());
        ancho = String.valueOf(paquete.getAncho());
        profundidad = String.valueOf(paquete.getProfundidad());
        id_ruta = String.valueOf(paquete.getId_ruta());



         if(paquetes.size()>0) {
          Element raiz = document.createElement("paquete");
          document.getDocumentElement().appendChild(raiz); 

          CrearElemento("id_paquete",id_paquete, raiz, document); 
          CrearElemento("peso",peso, raiz, document);
          CrearElemento("altura",altura, raiz, document); 
          CrearElemento("ancho",ancho, raiz, document);
          CrearElemento("profundidad",profundidad, raiz, document);
          CrearElemento("id_ruta",id_ruta, raiz, document);


         }
      }
      Source source = new DOMSource(document);
         Result result = 
                new StreamResult(new java.io.File("Paquetes.xml"));        
         Transformer transformer =
                TransformerFactory.newInstance().newTransformer();
         transformer.transform(source, result);




     }
     catch(Exception e){
         System.err.println("Error: "+e); 
     }
    }
    static void  CrearElemento(String datoEmple, String valor, Element raiz, Document document){
        Element elem = document.createElement(datoEmple); 
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }
}
