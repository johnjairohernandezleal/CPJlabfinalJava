/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.domain;

/**
 *
 * @author john hernandez
 */
public class Pelicula {
    
    private String nombre;
    
    
    public Pelicula(){
        
    }
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(String nombre){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre = "  + nombre + '}';
    }
    
    
}
