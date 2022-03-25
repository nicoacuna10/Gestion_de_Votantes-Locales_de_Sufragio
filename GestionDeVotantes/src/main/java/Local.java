import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Local {
    
    private String nombreLocal;
    private String comuna;
    private int capacidadMaxima;
    private int cantidadDeMesas;
    private List <Mesa> listaDeMesas;

    public Local(String nombreLocal, String comuna, int capacidadMaxima, int cantidadDeMesas) {
        this.nombreLocal = nombreLocal;
        this.comuna = comuna;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadDeMesas = cantidadDeMesas;
        this.listaDeMesas = new LinkedList <Mesa>();
    }

    public String getNombreLocal() {
        return nombreLocal;
    }
    public String getComuna() {
        return comuna;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public int getCantidadDeMesas() {
        return cantidadDeMesas;
    }
    public List getListaDeMesas() {
        return listaDeMesas;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public void setCantidadDeMesas(int cantidadDeMesas) {
        this.cantidadDeMesas = cantidadDeMesas;
    }
    public void setListaDeMesas(List listaDeMesas) {
        this.listaDeMesas = listaDeMesas;
    }
    
    
    
}
