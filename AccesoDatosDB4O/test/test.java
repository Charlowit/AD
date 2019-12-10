/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acceso.Camion;
import acceso.Ventana;
import acceso.Ruta;
import acceso.Camionero;
import acceso.Db4o;
import acceso.Paquete;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
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
    
    //@Test
    public void leer_camiones_meter_array() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{

        
        ObjectContainer db = com.db4o.Db4o.openFile("Envios.db");
        Query q = db.query();
        q.constrain(Camion.class);
        ObjectSet result = q.execute();
        
        System.out.println(result.size());
        
        while(result.hasNext()){
            
            Camion a = new Camion();
            a = (Camion) result.next();
            arraycamion.add(a);
        }
        db.close();
    }
    //@Test
    public void insertar_camion_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
        int tamanio = arraycamion.size();
        Camion aux = new Camion(50,"trololo",123,23423,234234);
        
        ObjectContainer db  = com.db4o.Db4o.openFile("Envios.db");
        db.store(aux);

          
       Query q = db.query();
       q.constrain(Camion.class);
       q.descend("id_camion").constrain(new Integer(aux.getId_camion())).equal();
       ObjectSet result = q.execute();
       

       Camion modificar = (Camion) result.next();
       
       arraycamion.add(modificar);
       
        
        Assert.assertEquals(tamanio+1,arraycamion.size());
        db.close();
    }
    
    //@Test
    public void borrar_camion_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
 
       
       Camion aux = new Camion(50,"trololo",123,23423,234234);
       Db4o.borrarCamion(aux);
       
    }
    //@Test
    public void insertar_camionero_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
        int tamanio = arraycamionero.size();
        Camionero aux = new Camionero(50,"trololo","lalala",23423,234234,1);
        
        ObjectContainer db  = com.db4o.Db4o.openFile("Envios.db");
        db.store(aux);
          
       Query q = db.query();
       q.constrain(Camionero.class);
       q.descend("id_camionero").constrain(new Integer(aux.getId_camionero())).equal();
       ObjectSet result = q.execute();
       

       Camionero modificar = (Camionero) result.next();
       
       arraycamionero.add(modificar);
       
        
        Assert.assertEquals(tamanio+1,arraycamionero.size());
        db.close();
    }
    
    //@Test
    public void borrar_camionero_db() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException{
 
       
       Camionero aux = new Camionero(50,"trololo","lalala",23423,234234,1);
       Db4o.borrarCamionero(aux);
       
    }
   
    
}
