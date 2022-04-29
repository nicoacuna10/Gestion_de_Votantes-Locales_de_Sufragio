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
    
    public Mesa(int numeroDeMesa, int capacidadMaxima) {
        this.numeroDeMesa = numeroDeMesa;
        this.capacidadMaxima = capacidadMaxima;
    }
    
    
    public Mesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
    
    // getters y setters
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    
    
}