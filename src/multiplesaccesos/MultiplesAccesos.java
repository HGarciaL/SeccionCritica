/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesaccesos;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*** @author Marina
 *  Programa que lanza un número finito de veces la aplicación anterior, 
     * guardando el resultado en un archivo. Pasaremos por la línea de 
     * comandos el número de veces y el nombre del archivo    
     */

public class MultiplesAccesos {

    public static void main(String[] args) {
        Process nuevoProceso = null; //nuevo proceso
        String nombreArchivo ="";
        File archivo = null;
        int orden = 0;
        try {
            //Redireccionamos el stream de salida y de error al fichero "javalog.txt"
            PrintStream ps = new PrintStream(
                             new BufferedOutputStream(new FileOutputStream(
                             new File("javalog.txt"),true)), true);
            System.setOut(ps);
            System.setErr(ps);
        } catch (FileNotFoundException ex) {
            System.err.println ("Error. No se ha redirigido la salida");
        }
        try {
            for (int i=0; i<10; i++){
                nuevoProceso = Runtime.getRuntime().exec("java -jar " 
                        + "FicheroAccesoMultiple.jar " + i 
                        + " prueba.txt");
                System.out.println ("Creado el Proceso " );
            }
        } catch (SecurityException ex){
            System.err.println("Ha ocurrido un error de Seguridad."+
                    "No se ha podido crear el proceso por falta de permisos.");
        }catch (Exception ex){
            System.err.println("Ha ocurrido un error, descripción: "+
                    ex.toString());
        }
    }
    
}
