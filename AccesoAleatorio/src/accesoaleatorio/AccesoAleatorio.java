/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoaleatorio;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Charlowit
 */
public class AccesoAleatorio {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File("Fichero.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        ArrayList<Empleado> empleados = new ArrayList();
        
        empleados.add(new Empleado(1,"Galvez",1,1200.50));
        empleados.add(new Empleado(2,"Payares",2,5400.50));
        empleados.add(new Empleado(3,"Nieto",3,1300.50));
        empleados.add(new Empleado(1,"Alarcon",3,1340.50));
        empleados.add(new Empleado(1,"Hernandez",2,1760.50));
        empleados.add(new Empleado(1,"Cabellos",1,2220.50));
        
   
    StringBuffer buffer = null;//buffer para almacenar apellido

     for (Empleado empleado : empleados){ //recorro los arrays          	  
         buffer = new StringBuffer( empleado.getApellido() );      
         buffer.setLength(10); //10 caracteres para el apellido
         file.writeInt(empleado.getId());
         file.writeChars(buffer.toString());//insertar apellido
         file.writeInt(empleado.getDepepartamento());       //insertar departamento
         file.writeDouble(empleado.getSalario());//insertar salario
    }     
    file.close();  //cerrar fichero 
    
   File fichero1 = new File("Fichero.dat");
   //declara el fichero de acceso aleatorio
   RandomAccessFile file1 = new RandomAccessFile(fichero1, "r");
   //

   char apellido[] = new char[10];
   ArrayList<Empleado> empleados1 = new ArrayList();

   for(int posicion = 0; posicion < file1.length() ; posicion= posicion + 36){  //recorro el ficheroç
       Empleado aux = new Empleado();
	file1.seek(posicion); //nos posicionamos en posicion
	aux.setId(file1.readInt());   // obtengo id de empleado	  	  
      
      //recorro uno a uno los caracteres del apellido
      for (int i = 0; i < apellido.length; i++) {         
         apellido[i] = file1.readChar(); 
      }

      //convierto a String el array
      String apellidos = new String(apellido);
      aux.setApellido(apellidos);
	aux.setDepepartamento(file1.readInt());        //obtengo dep
  	aux.setSalario(file1.readDouble());  //obtengo salario
	  
	if(aux.getId() >0){
                System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
        	aux.getId(),   aux.getApellido(), aux.getDepepartamento(), aux.getSalario());     
        }
      //me posiciono para el sig empleado, cada empleado ocupa 36 bytes 

	//Si he recorrido todos los bytes salgo del for	 	  
   
   }//fin bucle for 
   file.close();  //cerrar fichero 
   }
}
    
