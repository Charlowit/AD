/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.util.ArrayList;
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
public class LeerXML {
    
    public static ArrayList<Camion> camiones = new ArrayList();
    public static ArrayList<Camionero> camioneros = new ArrayList();
    public static ArrayList<Ruta> rutas = new ArrayList();
    public static ArrayList<Paquete> paquetes = new ArrayList();

    public static ArrayList<Camion> getCamiones() {
        return camiones;
    }

    public static ArrayList<Camionero> getCamioneros() {
        return camioneros;
    }

    public static ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public static ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }
    
    
    public static void LeerCamion() throws SAXException, IOException{
        
         XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido_Camion gestor= new GestionContenido_Camion();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("Camiones.xml");	    
         procesadorXML.parse(fileXML); 

    }
    public static void LeerCamionero() throws SAXException, IOException{
        
         XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido_Camionero gestor= new GestionContenido_Camionero();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("Camioneros.xml");	    
         procesadorXML.parse(fileXML); 
        
        
    }
    public static void LeerRuta() throws SAXException, IOException{
        
         XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido_Ruta gestor= new GestionContenido_Ruta();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("Rutas.xml");	    
         procesadorXML.parse(fileXML); 
        
        
    }
    public static void LeerPaquete() throws SAXException, IOException{
        
         XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido_Paquete gestor= new GestionContenido_Paquete();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("Paquetes.xml");	    
         procesadorXML.parse(fileXML); 
        
       
    }
    
}
class GestionContenido_Camion extends DefaultHandler {
            private String elemento;
            private Camion aux;
	    public GestionContenido_Camion() {
	        super();
	    }	    
	    public void startDocument() {
	        //System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	    }	 	    
	    public void startElement(String uri, String nombre,
	        String nombreC, org.xml.sax.Attributes atts) {
                elemento=nombre;
                if (elemento=="camion"){
                    aux= new Camion();
                }
	        //System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
	    } 	
	    public void endElement(String uri, String nombre, 
                          String nombreC) {
                if (nombre=="camion"){
                    LeerXML.camiones.add(aux);
                }
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                            throws org.xml.sax.SAXException {
		   String car=new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");
                   
                   if (elemento=="id_camion"){
                       aux.setId_camion(Integer.parseInt(car));
                   }else if(elemento=="nombre_camion"){
                       aux.setNombre_camion(car);
                   }
                   else if(elemento=="velocidad_maxima"){
                       aux.setVelocidad_maxima(Integer.parseInt(car));
                   }
                   else if(elemento=="mma"){
                       aux.setMma(Integer.parseInt(car));
                   }
                   else if(elemento=="listros_tanque"){
                       aux.setLitros_tanque(Double.parseDouble(car));
                   }
		   //System.out.printf ("\t Caracteres: %s %n", car);		
	    }


}
class GestionContenido_Camionero extends DefaultHandler {
            private String elemento;
            private Camionero aux;
	    public GestionContenido_Camionero() {
	        super();
	    }	    
	    public void startDocument() {
	        //System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	    }	 	    
	    public void startElement(String uri, String nombre,
	        String nombreC, org.xml.sax.Attributes atts) {
                elemento=nombre;
                if (elemento=="camionero"){
                    aux = new Camionero();
                }
	        //System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
	    } 	
	    public void endElement(String uri, String nombre, 
                          String nombreC) {
                if (nombre=="camionero"){
                    LeerXML.camioneros.add(aux);
                }
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                            throws org.xml.sax.SAXException {
		   String car=new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");
                   
                   if (elemento=="id_camionero"){
                       aux.setId_camionero(Integer.parseInt(car));
                   }else if(elemento=="nombre"){
                      aux.setNombre(car);
                   }
                   else if(elemento=="apellidos"){
                       aux.setApellidos(car);
                   }
                   else if(elemento == "edad"){
                       aux.setEdad(Integer.parseInt(car));
                   }
                   else if(elemento=="salario"){
                       aux.setSalario(Double.parseDouble(car));
                   }
                   else if(elemento=="id_camion"){
                       aux.setId_camion(Integer.parseInt(car));
                   }
		   //System.out.printf ("\t Caracteres: %s %n", car);		
	    }
}

class GestionContenido_Ruta extends DefaultHandler {
            private String elemento;
            private Ruta aux;
	    public GestionContenido_Ruta() {
	        super();
	    }	    
	    public void startDocument() {
	        //System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	    }	 	    
	    public void startElement(String uri, String nombre,
	        String nombreC, org.xml.sax.Attributes atts) {
                elemento=nombre;
                if (elemento=="ruta"){
                    aux = new Ruta();
                }
	        //System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
	    } 	
	    public void endElement(String uri, String nombre, 
                          String nombreC) {
                if (nombre=="ruta"){
                    LeerXML.rutas.add(aux);
                }
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                            throws org.xml.sax.SAXException {
		   String car=new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");
                   
                   if (elemento=="id_ruta"){
                       aux.setId_ruta(Integer.parseInt(car));
                   }else if(elemento=="origen"){
                      aux.setOrigen(car);
                   }
                   else if(elemento=="destino"){
                       aux.setDestino(car);
                   }
                   else if(elemento == "hora"){
                       aux.setHora(car);
                   }
                   else if(elemento=="fecha"){
                       aux.setFecha(car);
                   }
                   else if(elemento=="id_camionero"){
                       aux.setId_camionero(Integer.parseInt(car));
                   }
		   //System.out.printf ("\t Caracteres: %s %n", car);		
	    }
}

class GestionContenido_Paquete extends DefaultHandler {
            private String elemento;
            private Paquete aux;
	    public GestionContenido_Paquete() {
	        super();
	    }	    
	    public void startDocument() {
	        //System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	    }	 	    
	    public void startElement(String uri, String nombre,
	        String nombreC, org.xml.sax.Attributes atts) {
                elemento=nombre;
                if (elemento=="paquete"){
                    aux = new Paquete();
                }
	        //System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
	    } 	
	    public void endElement(String uri, String nombre, 
                          String nombreC) {
                if (nombre=="paquete"){
                    LeerXML.paquetes.add(aux);
                }
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                            throws org.xml.sax.SAXException {
		   String car=new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");
                   
                   if (elemento=="id_paquete"){
                       aux.setId_paquete(Integer.parseInt(car));
                   }else if(elemento=="peso"){
                      aux.setPeso(Double.parseDouble(car));
                   }
                   else if(elemento=="altura"){
                       aux.setAltura(Double.parseDouble(car));
                   }
                   else if(elemento == "ancho"){
                       aux.setAncho(Double.parseDouble(car));
                   }
                   else if(elemento=="profundidad"){
                       aux.setProfundidad(Double.parseDouble(car));
                   }
                   else if(elemento=="id_ruta"){
                       aux.setId_ruta(Integer.parseInt(car));
                   }
		   //System.out.printf ("\t Caracteres: %s %n", car);		
	    }
}
