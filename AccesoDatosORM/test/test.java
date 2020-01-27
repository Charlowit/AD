/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acceso.Camion;
import acceso.Ventana;
import acceso.Ruta;
import acceso.Camionero;
import acceso.ORM;
import acceso.Paquete;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
    public void insertar_camion_en_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{

        Camion aux = new Camion();
        aux.setNombreCamion("Lilo");
        aux.setLitrosTanque(123.23);
        aux.setMma(123);
        aux.setVelocidadMaxima(123);
        ORM.insertarCamion(aux);
        
    }
    @Test
    public void borrar_camion_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
        Camion aux = new Camion();
        aux.setNombreCamion("Lilo");
        aux.setLitrosTanque(123.23);
        aux.setMma(123);
        aux.setVelocidadMaxima(123);
        ORM.borrarCamion(aux);
        
    }
    
    @Test
    public void leer_todos_los_camiones() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
 
       ArrayList<Camion> aux_camiones = new ArrayList();
       int size = aux_camiones.size();
       ORM.leerCamion(aux_camiones);
       
       Assert.assertNotEquals(size,aux_camiones.size());
       
       
    }
    @Test
    public void leer_todos_los_camioneros() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
       
       ArrayList<Camion> aux_camioneros = new ArrayList();
       int size = aux_camioneros.size();
       ORM.leerCamion(aux_camioneros);
       
       Assert.assertNotEquals(size,aux_camioneros.size());
    }
    
    @Test
    public void leer_todas_las_rutas() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{

       ArrayList<Camion> aux_rutas = new ArrayList();
       int size = aux_rutas.size();
       ORM.leerCamion(aux_rutas);
       
       Assert.assertNotEquals(size,aux_rutas.size());
    }
   
    
}
