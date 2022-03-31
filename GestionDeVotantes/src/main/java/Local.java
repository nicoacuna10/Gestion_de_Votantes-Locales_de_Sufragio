import java.util.*;
import java.io.*;


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
    
    // Coordenadas de la ubicación del local.
    private int coordenadaX; // Coordenada X.
    private int coordenadaY; // Coordenada Y.
    
    private int capacidadMaxima; // Capacidad Maxima (Personas) del local.
    private int numeroPrimeraMesa; // Número de la primera mesa del local.
    private int numeroUltimaMesa; // Número de la última mesa del local.
    
    private LinkedList <Mesa> listaDeMesas; // Lista de las mesas, contiene los números de las mesas del local.
    
    // Constructor clase Local
    public Local(String nombreLocal, String comuna, String direccion, int coordenadaX, int coordenadaY, int capacidadMaxima, int numeroPrimeraMesa, int numeroUltimaMesa) {
        this.nombreLocal = nombreLocal;
        this.comuna = comuna;
        this.direccion = direccion;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.capacidadMaxima = capacidadMaxima;
        this.numeroPrimeraMesa = numeroPrimeraMesa;
        this.numeroUltimaMesa = numeroUltimaMesa;
        this.listaDeMesas = new LinkedList();
    }
    
    
    // Método agregar mesa, con parámetro int
    public Mesa agregarMesa(int numeroMesaNueva){
        Mesa aux = new Mesa(numeroMesaNueva);
        listaDeMesas.add(aux); // Inserta la información de la mesa nueva al final de la lista.
        
        return aux;
    }
    
    // Método buscar mesa.
    public Mesa buscarMesa()throws IOException{
        int numeroDeMesa;
        String auxNumero;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese numero de la mesa");
        auxNumero = lector.readLine();
        numeroDeMesa = Integer.parseInt(auxNumero);
        
        // Variables locales del método.
        boolean encontrado = false; // Bandera que indica si se encontró el numero de la mesa dentro de la lista.
        int index; // iterador
        Mesa aux;
        
        // Se posicona en el primer elemento de la lista
        index = 0;
        aux = listaDeMesas.get(index);
        
        // Se busca la mesa, avanzando en la lista hasta que se encuentre el elmento o se llegue al final de la lista.
        while(!encontrado && index <= listaDeMesas.size()){
        
            if(aux.getNumeroDeMesa() == numeroDeMesa){
                encontrado = true;
                break;
            }
            
            index++;
            aux = listaDeMesas.get(index);
        }
        
        if(encontrado){
            return aux; // Si encuentra la mesa, retorna el valor de esta.
        }else return null; // Si no encuentra la mesa, retorna null.
        
    
    }
    
    // Método buscar mesa. Retorna el valor de la variable (información de la mesa) si la encuentra, null caso contrario.
    public Mesa buscarMesa(int numeroDeMesa){
        // Variables locales del método.
        boolean encontrado = false; // Bandera que indica si se encontró el numero de la mesa dentro de la lista.
        int index; // iterador
        Mesa aux;
        
        // Se posicona en el primer elemento de la lista
        index = 0;
        aux = listaDeMesas.get(index);
        
        // Se busca la mesa, avanzando en la lista hasta que se encuentre el elmento o se llegue al final de la lista.
        while(!encontrado && index <= listaDeMesas.size()){
        
            if(aux.getNumeroDeMesa() == numeroDeMesa){
                encontrado = true;
                break;
            }
            
            index++;
            aux = listaDeMesas.get(index);
        }
        
        if(encontrado){
            return aux; // Si encuentra la mesa, retorna el valor de esta.
        }else return null; // Si no encuentra la mesa, retorna null.
        
        
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
    public int getCoordenadaX() {
        return coordenadaX;
    }
    public int getCoordenadaY() {
        return coordenadaY;
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
    public LinkedList getListaDeMesas() {
        return listaDeMesas;
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
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
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
    public void setListaDeMesas(LinkedList listaDeMesas) {
        this.listaDeMesas = listaDeMesas;
    }
    
    
    
}
