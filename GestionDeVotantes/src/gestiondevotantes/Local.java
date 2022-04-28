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
    
    // Método agregar mesa, con dos parámetros int
    public void agregarMesa(int numeroPrimeraMesa, int numeroUltimaMesa){
        int index;
        Mesa auxM;
        
        for(index = numeroPrimeraMesa; index <= numeroUltimaMesa; index++){
            auxM = new Mesa(index);
            listaDeMesas.add(auxM);
        }
    }
    
    
    // Método agregar mesa, con parámetro int
    public void agregarMesa(int numeroMesaNueva){
        Mesa auxM = new Mesa(numeroMesaNueva);
        listaDeMesas.add(auxM); // Inserta la información de la mesa nueva al final de la lista.
    }
    
    // Método elminar mesa.
    public Mesa eliminarMesa(int numeroDeMesa){
        for(int i=0; i<listaDeMesas.size() ; i++){
            if(listaDeMesas.get(i).getNumeroDeMesa()==numeroDeMesa){
                System.out.println("Se ha eliminado la mesa "+numeroDeMesa);
                return listaDeMesas.remove(i);
            }
        }
        System.out.println("No existe la mesa");
        return null;
    
    }
    
    
    // Método buscar mesa. Retorna el valor de la variable (información de la mesa) si la encuentra, null caso contrario.
    public Mesa buscarMesa(int numeroDeMesa){
        for (int i=0;i<listaDeMesas.size();i++){
            if(numeroDeMesa == listaDeMesas.get(i).getNumeroDeMesa()){
                return listaDeMesas.get(i);
            }
        }
        System.out.println("No existe la mesa");
        return null;
    }
    
    // Método mostrar mesas de un local.
    public void mostrarMesas(){
        Mesa auxM;
        for(int index = 0; index < listaDeMesas.size() ; index++){
            auxM = (Mesa) listaDeMesas.get(index);
            System.out.println(auxM.getNumeroDeMesa());
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
