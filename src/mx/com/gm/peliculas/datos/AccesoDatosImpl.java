/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author john hernandez
 */
public class AccesoDatosImpl implements AccesoDatos{
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx{
        File archivo = new File(nombreArchivo);
        List<Pelicula>peliculas = new ArrayList();
        try {
            /**
             * con esta linea capturamos todo lo que sea enviado por consola
             */
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            /**
             * definimos una variable linea = null;
             */
            String linea = null;
            /**
             * a la variable linea le asignamos lo que se capture por teclado
             */
            
            linea = entrada.readLine();
            
            while (linea != null) {
              Pelicula pelicula = new Pelicula(linea);
              peliculas.add(pelicula);
              linea = entrada.readLine();
                
            }
            entrada.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
    
    @Override
     public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx{
         
         File archivo = new File(nombreArchivo);
         try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
             System.out.println("se ha escrito el archivo correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
         
     }
     
     @Override
     public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
         File archivo = new File(nombreArchivo);
         String resultado = null;
         try {
             BufferedReader entrada = new BufferedReader(new FileReader(archivo));
             String linea = null;
             int i = 0;
             linea = entrada.readLine();
             while (linea!=null) {
                 if (buscar !=null && buscar.equalsIgnoreCase(linea)) {
                     resultado = "Pelicula " + linea + "enconrada en indice " + i;
                     break;
                     
                 }
                 linea = entrada.readLine();
                 i++;
                 
                 
             
             }
             entrada.close();
         } 
             catch (IOException e) {
                 e.printStackTrace();
         }
         return resultado;
     }
     @Override
     public void crear(String nombreArchivo) throws AccesoDatosEx{
         
         File archivo = new File(nombreArchivo);
         try {
             PrintWriter salida = new PrintWriter(new FileWriter(archivo));
             salida.close();
             System.out.println("se ha creado el archivo correctamente");
         } catch (IOException e) {
             e.printStackTrace();
         }
         
     }
     @Override
     public void borrar(String nombreArchivo)throws AccesoDatosEx{
         File archivo = new File(nombreArchivo);
         archivo.delete();
         System.out.println("se ha borrado correctamente");
         
     }
    
}
