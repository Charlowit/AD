/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acceso.Camion;
import acceso.Ventana;
import acceso.Ruta;
import acceso.Camionero;
import acceso.Exitdb;
import acceso.Paquete;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import javax.xml.xquery.XQException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;


/**
 *
 * @author Charlowit
 */
public class test {
    public ArrayList<Camion> arraycamion = new ArrayList();
    public ArrayList<Camionero> arraycamionero = new ArrayList();
    
    public test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void insertar_camion_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, XQException, XMLStreamException{
        try {
            Exitdb.getConnection();
            Exitdb.leerCamion(arraycamion);
            int tamaño= arraycamion.size();
            Camion aux=new Camion();
            aux.setId_camion(tamaño);
            aux.setNombre_camion("lolo");
            Exitdb.insertarCamion(aux);
            Exitdb.leerCamion(arraycamion);
            Assert.assertNotEquals(tamaño,arraycamion.size());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XQException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void borrar_camion_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, XMLStreamException{
        
        try {
            Exitdb.getConnection();
            arraycamion.clear();
            Exitdb.leerCamion(arraycamion);
            int tamaño= arraycamion.size();
            Exitdb.borrarCamion(arraycamion.get(tamaño-1));
            arraycamion.clear();
            Exitdb.leerCamion(arraycamion);
            Assert.assertEquals(tamaño-1,arraycamion.size());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XQException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }

   
    
}
