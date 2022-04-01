package gestiondevotantes;

import java.util.*;


/**
 *
 * @author Nicolás Acuña
 */
public class Region {
    
    // Creación de mapas.
    Map <String, Local> registroLocalesNombre; // Mapa de Locales con clave el nombre.
    Map <String, Votante> registroVotantesRut; // Mapa de Votantes con clave el rut.
    
    // Constructor de la Clase Region.
    public Region(){
        this.registroLocalesNombre = new LinkedHashMap();
        this.registroVotantesRut = new LinkedHashMap();
    }
    
    // Método agregar local, con parámetros objetos de clase Local y Votante
    public void agregarLocal(Local auxL, Votante auxV){
        // Inserción del los datos del local nuevo en el mapa respectivo, con la clave el nombre.
        registroLocalesNombre.put(auxV.getLocalAsignado(), auxL);
    }
    
    
    // Método agregar local, con parámetro objeto de clase Local
    public void agregarLocal(Local auxL){
        // Inserción del los datos del local nuevo en el mapa respectivo, con la clave el nombre.
        registroLocalesNombre.put(auxL.getNombreLocal(), auxL);
    }
        
    
    // Método buscar local.
    public Local buscarLocal(String nombre){
        return registroLocalesNombre.get(nombre);
    }
    
    // Método agregar votante.
    public void agregarVotante(Votante aux){
        // Inserción del los datos del votante nuevo en el mapa respectivo, con la clave el rut.
        registroVotantesRut.put(aux.getRut(), aux);
    }
    
    public Votante buscarVotante(String rut){
        // Búsqueda del votante con la clave el rut
        return registroVotantesRut.get(rut);
    }
    
    // getters y setters
    public Map getRegistroLocalesNombre(){
        return registroLocalesNombre;
    }
    
    public Map getRegistroVotantesRut(){
        return registroVotantesRut;
    }
    
    public void setRegistroLocalesNombre(Map registroLocalesNombre){
        this.registroLocalesNombre = registroLocalesNombre;
    }
    
    public void setRegistroVotantesRut(Map registroVotantesRut){
        this.registroVotantesRut = registroVotantesRut;
    }
}

