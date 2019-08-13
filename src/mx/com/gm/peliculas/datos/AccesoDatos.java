/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author john hernandez
 */
public interface AccesoDatos {
    
    boolean existe(String nombreArchivo)throws AccesoDatosEx;
    public List<Pelicula> listar(String nombreArchivo)throws LecturaDatosEx;
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo)throws AccesoDatosEx;
    
}
