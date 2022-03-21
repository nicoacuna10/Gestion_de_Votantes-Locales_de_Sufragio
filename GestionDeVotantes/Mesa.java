/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeVotantes;

/**
 *
 * @author jpail
 */
public class Mesa {
    
    private String ubicacion;
    private int capacidad;
    private String nombre;
    //private TreeMap <Persona> personas; 
    
    public Mesa(int capacidad, String nombre, String ubicacion){
        //constructor
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        //personas = TreeMap();
        //personas
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
}
