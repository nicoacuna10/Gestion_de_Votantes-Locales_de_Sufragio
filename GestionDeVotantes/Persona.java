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
public class Persona {
    
    private String ubicacion;
    private int run;
    private int edad;
    private String nombre; 
    
    public Persona (int run, int edad, String nombre, String ubicacion){
        //constructor
        this.run = run;
        this.edad = edad;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
    public int getRun(){
        return run;
    }
    public int getEdad(){
        return edad;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setRun(int run){
        this.run = run;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
