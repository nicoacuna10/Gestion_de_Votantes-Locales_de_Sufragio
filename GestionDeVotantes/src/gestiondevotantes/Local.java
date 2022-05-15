package gestiondevotantes;

import java.util.*;


/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Local {
    
    // Variables de instancia de la clase Local.
    private String nombreLocal; // Nombre del local.
    private String comuna; // Comuna donde se encuentra el local.
    private String direccion; // Dirección del local.
    private int capacidadMaxima; // Capacidad Maxima (Personas) del local.
    private int numeroPrimeraMesa; // Número de la primera mesa del local.
    private int numeroUltimaMesa; // Número de la última mesa del local.
    private HashMap <String, Votante> registroVotantesRut; // Mapa de Votantes con clave el rut.
    
    // Constructor clase Local
    public Local(String nombreLocal){
        this.nombreLocal = nombreLocal;
        comuna = "0";
        direccion = "0";
        capacidadMaxima = 2000000;
        numeroPrimeraMesa = 0;
        numeroUltimaMesa = 0;
        registroVotantesRut = new HashMap();
    }
    
    // Constructor clase Local
    public Local(String nombreLocal, String comuna, String direccion,  int capacidadMaxima, int numeroPrimeraMesa, int numeroUltimaMesa) {
        this.nombreLocal = nombreLocal;
        this.comuna = comuna;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.numeroPrimeraMesa = numeroPrimeraMesa;
        this.numeroUltimaMesa = numeroUltimaMesa;
        registroVotantesRut = new HashMap();
    }
    
    /*  Método agregarVotante: Agrega un votante al registro si el local no está
        lleno o si no existe previamente el votante. Retorna true si se agregó
        el votante, retorna false caso contrario.
    */
    public boolean agregarVotante(Votante v){
        if(registroVotantesRut.size() == capacidadMaxima){
            return false;
        }
        if(registroVotantesRut.containsKey(v.getRut())){
            return false;
        }
        registroVotantesRut.put(v.getRut(), v);
        return true;
    }
    
    /*  Método buscarVotante: Busca el votante en el registro.
        Retorna el votante si se encuentra. Retorna null caso contrario
    */
    public Votante buscarVotante(String rut){
        if(!registroVotantesRut.containsKey(rut)){
            return null;
        }
        return registroVotantesRut.get(rut);
    }
    
    /*  Método modificarDatosVotante: Modifica el numero de mesa, la comuna y
        la dirección siempre y cuando el votante se encuentre en el registro.
        Retorna true si se modificaron los datos, retorna false en caso contrario.
    */
    public boolean modificarDatosVotante(String rut, int numeroDeMesa, String comuna, String direccion){
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        Votante v = registroVotantesRut.get(rut);
        v.setNumeroDeMesa(numeroDeMesa);
        v.setComuna(comuna);
        v.setDireccion(direccion);
        return true;
    }
    
    /*  Método modificarDatosVotante: Modifica el número de mesa del votante.
        Retorna true si se modifica el número de mesa, false en caso contrario.
    */
    public boolean modificarDatosVotante(String rut, int numeroDeMesa){
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        Votante v = registroVotantesRut.get(rut);
        v.setNumeroDeMesa(numeroDeMesa);
        return true;
    }
    
    /*  Método eliminarVotante: Elimina un votante del registro si no se
        encuentra vacio o si el votante se encuentra. Retorna true si se elimina
        con éxito, retorna false caso contrario.
    */
    public boolean eliminarVotante(String rut){
        if(registroVotantesRut.isEmpty()){
            return false;
        }
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        registroVotantesRut.remove(rut);
        return true;
    }
    
    /*  Método mostrarDatosVotante: Muestra los datos del votante
    */
    public void mostrarDatosVotante(Votante v, String nombreLocal, String direccionLocal){
        // Se imprimen los datos del votante
        System.out.println("------------------------------------------");
        System.out.println("DATOS VOTANTE");
        System.out.println("------------------------------------------");
        System.out.println("NOMBRE: "+v.getNombreCompleto());
        System.out.println("RUT "+v.getRut());
        System.out.println("COMUNA: "+v.getComuna());
        System.out.println("DIRECCION: "+v.getDireccion());
        
        if(v.getEstadoElectoral() == 1){
           System.out.println("HABILITADO(A) PARA VOTAR: SI");
           System.out.println("LOCAL: "+nombreLocal);
           System.out.println("DIRECCION LOCAL: "+direccionLocal);
           System.out.println("NUMERO DE MESA: "+v.getNumeroDeMesa());
        }else System.out.println("HABILITADO(A) PARA VOTAR: NO");
        System.out.println("------------------------------------------");
    }
   
    /*   Método mostrarVotantes: Muestra todos los votantes del local.
    */
    public void mostrarVotantes(){
        if(registroVotantesRut.size()>0){
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            // Se recorre el mapa registroVotantesRut
            for( String rut : registroVotantesRut.keySet()){
                Votante v = registroVotantesRut.get(rut);
                System.out.format("%-30s %-15s %-15s %-25s", v.getNombreCompleto(), rut, v.getComuna(), v.getDireccion());
                if(v.getEstadoElectoral()==1)System.out.println("SI");
                else System.out.println("NO");
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No hay datos");
        }
    }
    
    /*  Método obtenerCantidadVotantes: Obtiene la cantidad de votantes del local.
    */
    public int obtenerCantidadVotantes(){
        return registroVotantesRut.size();
    }
    
    /*  Método obtenerRutsVotantes: Obtiene un arreglo de strings con los ruts
        de los votantes del local.
    */
    public String[] obtenerRutsVotantes(){
        String[] rutsVotantes = new String[ registroVotantesRut.size() ];   
        int i = 0;
        for(String rut : registroVotantesRut.keySet()){
            rutsVotantes[i] = rut;
        }
        return rutsVotantes;
    }
    public void mostrarVotantesPorLocal(String nombreLocal){ 
        
    }

    public String getNombreLocal() {
        return nombreLocal;
    }
    public String getComuna() {
        return comuna;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public int getNumeroPrimeraMesa() {
        return numeroPrimeraMesa;
    }
    public int getNumeroUltimaMesa() {
        return numeroUltimaMesa;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public void setNumeroPrimeraMesa(int numeroPrimeraMesa) {
        this.numeroPrimeraMesa = numeroPrimeraMesa;
    }
    public void setNumeroUltimaMesa(int numeroUltimaMesa) {
        this.numeroUltimaMesa = numeroUltimaMesa;
    }
    
    
    
}