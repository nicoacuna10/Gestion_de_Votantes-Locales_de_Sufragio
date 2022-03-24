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
    private Mesa[] listaDeMesas = new Mesa[30];

    public Local(String nombreLocal, String comuna, int capacidadMaxima, int cantidadDeMesas, Mesa[] listaDeMesas) {
        this.nombreLocal = nombreLocal;
        this.comuna = comuna;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadDeMesas = cantidadDeMesas;
        this.listaDeMesas = listaDeMesas;
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
    public Mesa[] getListaDeMesas() {
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
    public void setListaDeMesas(Mesa[] listaDeMesas) {
        this.listaDeMesas = listaDeMesas;
    }
    
    
    
}
