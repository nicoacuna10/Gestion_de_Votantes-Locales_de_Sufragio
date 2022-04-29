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
    private LinkedList <Mesa> listaDeMesas; // Lista de las mesas, contiene los números de las mesas del local.
    
    
    // Constructor clase Local
    public Local(String nombreLocal, String comuna, String direccion,  int capacidadMaxima, int numeroPrimeraMesa, int numeroUltimaMesa) {
        this.nombreLocal = nombreLocal;
        this.comuna = comuna;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.numeroPrimeraMesa = numeroPrimeraMesa;
        this.numeroUltimaMesa = numeroUltimaMesa;
        listaDeMesas = new LinkedList();
    }
    
    
    /*  Método agregarMesa: agrega una nueva mesa al final de la lista de un local existente.
        El número de la mesa nueva es consecutivo al número de última.
    */
    public void agregarMesa(){
        Mesa mesaNueva = new Mesa(numeroUltimaMesa+1);
        listaDeMesas.add(mesaNueva); // Inserta la información de la mesa nueva al final de la lista.
    }
    
    /*  Método agregarMesa: agrega mesas a la lista de un local nuevo.
        Recibe los números de la primera y última mesa.
    
    */
    public void agregarMesa(int nPrimeraMesa, int nUltimaMesa){
        for(int i = nPrimeraMesa; i <= nUltimaMesa; i++){
            Mesa mesaNueva = new Mesa(i);
            listaDeMesas.add(mesaNueva);
        }
    }
    
    /*  Método buscarMesa
    */
    public Mesa buscarMesa(int numeroDeMesa){
        for(int i=0; i<listaDeMesas.size(); i++){
            Mesa m = (Mesa) listaDeMesas.get(i);
            if(m.getNumeroDeMesa() == numeroDeMesa){
                return m;
            }
        }
        return null;
    }
    
    /*  Método modificarDatosMesa: modifica la capacidad máxima de una mesa en el
        caso que esta exista. Si existe la mesa se modifica la capacidad máxima
        y retorna true. En caso de no existir, retorna false.
    */
    public boolean modificarDatosMesa(int numeroDeMesa, int capacidadMaximaNueva){
        for(int i=0; i<listaDeMesas.size(); i++){
            Mesa m = (Mesa) listaDeMesas.get(i);
            if(numeroDeMesa == m.getNumeroDeMesa()){
                m.setCapacidadMaxima(capacidadMaximaNueva);
                return true;
            }
        }
        return false;
    }
    
    /*  Método eliminarMesa: elimina la última mesa actual del local
        y la retorna.
    */
    public Mesa eliminarMesa(){
       Mesa mesaEliminada = (Mesa) listaDeMesas.removeLast();
       return mesaEliminada;
    }
    
  
    /*  Método mostrarMesas: muestra los números de mesas de un local.
    */
    public void mostrarMesas(){
        for(int i = 0; i < listaDeMesas.size() ; i++){
            Mesa m = (Mesa) listaDeMesas.get(i);
            System.out.println(m.getNumeroDeMesa());
        }
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