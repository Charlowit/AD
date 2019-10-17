/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribeconnumerodelineas;
import java.io.*;
/**
 *
 * @author Charlowit
 */
public class EscribeConNumeroDeLineas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Inidicar por favor nombre de fichero");
            return;
        }
        String nomFich = args[0];
        String nomPalabra = "";
        for(int i=1; i<args.length -1 ; i++){
            nomPalabra += args[i] + " ";
        }
        nomPalabra += args[args.length];
        try(BufferedReader fbr = new BufferedReader(new FileReader(nomFich))){
            int i = 0;

            String linea = fbr.readLine();
            while(linea != null){
                i++;
                int columna = linea.indexOf(nomPalabra);
                if(columna != -1){
                    System.out.format("La palabra %s esta en la columna %d  en la linea %d", nomPalabra, columna, i);
                    System.out.println();
                }
                
                linea = fbr.readLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("No existe fichero" + nomFich);
        } catch(IOException e){
            System.out.println("Error de E/S" + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
    

