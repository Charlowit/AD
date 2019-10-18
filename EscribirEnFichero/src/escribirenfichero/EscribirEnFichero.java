/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribirenfichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Charlowit
 */
public class EscribirEnFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Inidicar por favor nombre de fichero");
            return;
        }
        String nomFich = args[0];
        String nomFichero = "f_texto.txt";
        File f = new File(nomFichero);
        if(f.exists()){
            System.out.println("Fichero " + nomFichero+ " ya existe. No se hace nada");
            return;
        }
        
        try(BufferedReader fbr = new BufferedReader(new FileReader(nomFich))){
            String linea = fbr.readLine();
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            while(linea != null){
                bfw.write(linea);
                bfw.newLine();
                linea = fbr.readLine();
                
            }
            bfw.close();
        } catch(FileNotFoundException e){
            System.out.println("No existe fichero" + nomFich);
        } catch(IOException e){
            System.out.println("Error de E/S" + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
