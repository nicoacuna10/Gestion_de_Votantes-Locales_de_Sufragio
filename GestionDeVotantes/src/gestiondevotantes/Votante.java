package gestiondevotantes;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Votante {
    
    // Variables de instancia
    private String nombreCompleto; // Nombre del votante.
    private String rut; // Rut del votante.
    private String comuna; // Comuna de domiclio.
    private String direccion; // Dirección del domicilio.    
    private int estadoElectoral; // Si el valor es 1, el votante está habilitado para votar.
    private String localAsignado; // Nombre del local donde le toca votar.
    private int numeroDeMesa; // Número de mesa donde le toca votar.
    
    // Constructor de la clase
    public Votante(String nombreCompleto, String rut, String comuna, String direccion, int estadoElectoral, String localAsignado, int numeroDeMesa) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.comuna = comuna;
        this.direccion = direccion;
        this.estadoElectoral = estadoElectoral;
        this.localAsignado = localAsignado;
        this.numeroDeMesa = numeroDeMesa;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getRut() {
        return rut;
    }
    public String getComuna() {
        return comuna;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getEstadoElectoral() {
        return estadoElectoral;
    }
    public String getLocalAsignado() {
        return localAsignado;
    }
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEstadoElectoral(int estadoElectoral) {
        this.estadoElectoral = estadoElectoral;
    }
    public void setLocalAsignado(String localAsignado) {
        this.localAsignado = localAsignado;
    }
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
             
}
