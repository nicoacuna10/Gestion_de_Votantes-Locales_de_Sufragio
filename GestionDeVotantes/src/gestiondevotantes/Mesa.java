package gestiondevotantes;
        
import java.util.*;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Mesa {
    
    private int numeroDeMesa;
    private int capacidadMaxima;
    private LinkedList <String> listaRutsVotantes;

    public Mesa(int numeroDeMesa, int capacidadMaxima) {
        this.numeroDeMesa = numeroDeMesa;
        this.capacidadMaxima = capacidadMaxima;
        this.listaRutsVotantes = new LinkedList();
    }
    
    
    public Mesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
        this.capacidadMaxima = 250;
        this.listaRutsVotantes = new LinkedList();
    }
    
    // Método agregar rut de votante a la lista.
    public void agregarRutVotante(String rut){
        listaRutsVotantes.add(rut);
    }
    
    // Método eliminar rut de votante de la lista.
    public void eliminarRutVotante(String rut){
        String auxRut;
        for(int i=0; i<listaRutsVotantes.size(); i++){
            auxRut = listaRutsVotantes.get(i);
            if( auxRut == rut){
                listaRutsVotantes.remove(i);
                break;
            }
        
        }
    }
    
    // getters y setters
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public LinkedList getListaDeRutsDeVocales(){
        return listaRutsVotantes;
    }
    
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public void setListaRutsVotantes(LinkedList listaRutsVotantes) {
        this.listaRutsVotantes = listaRutsVotantes;
    }
    
    
}
