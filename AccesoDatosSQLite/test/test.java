/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acceso.Camion;
import acceso.Ventana;
import acceso.Ruta;
import acceso.Camionero;
import acceso.Paquete;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
    public void insertar_camion_en_array() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, SQLException{
        Camion aux = new Camion("trucki",123,23423,234234);
        Ventana ventana = new Ventana();       
        int tamanio = ventana.camiones.size();
        ventana.insertarCamion(aux);
        
        Assert.assertEquals(tamanio+1,ventana.camiones.size());
    }
    @Test
    public void insertar_camionero_en_array() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, SQLException{
        Camionero aux = new Camionero("Pepe","Antonio",23423,234234,1);
        Ventana ventana = new Ventana();
        int tamanio = ventana.camioneros.size();
        ventana.insertarCamionero(aux);
        Assert.assertEquals(tamanio+1,ventana.camioneros.size());
    }
    @Test
    public void insertar_ruta_en_array() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, SQLException{
        Ruta aux = new Ruta("Malaga1","Granada1","23.30","12/12/12",1);
        Ventana ventana = new Ventana();
        int tamanio = ventana.rutas.size();
        ventana.insertarRuta(aux); 
        Assert.assertEquals(tamanio+1,ventana.rutas.size());
    }
    @Test
    public void insertar_paquete_en_array() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, SQLException{
        Paquete aux = new Paquete(20,20,20,20,1);
        Ventana ventana = new Ventana();
        int tamanio = ventana.paquetes.size();
        ventana.insertarPaquete(aux);   
        Assert.assertEquals(tamanio+1,ventana.paquetes.size());
    }
    @Test
    public void borrar_camion_de_array() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, SQLException{
        Ventana ventana = new Ventana();
        int tamanio = ventana.camiones.size();
        ventana.BorrarCamion(1);
        Assert.assertEquals(tamanio-1,ventana.paquetes.size());
    }
}
