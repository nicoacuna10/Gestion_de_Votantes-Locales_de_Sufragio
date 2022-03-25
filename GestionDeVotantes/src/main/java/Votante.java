/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Votante {
    
    // Variables de instancia
    private String nombreCompleto;
    private String rut;
    private int edad;
    private String comuna;
    private String direccion;
    
    // Si el valor de estadoElectoral es 1, el votante está habilitado para votar)
    private int estadoElectoral;
    // Si el valor de vocalDeMesa es 1, el votante fue designado vocal de mesa
    private int vocalDeMesa;
    
    private String localAsignado;
    private int numeroDeMesa;
    
    // Constructor de la clase
    public Votante(String nombreCompleto, String rut, int edad, String comuna, String direccion, int estadoElectoral, int vocalDeMesa, String localAsignado, int numeroDeMesa) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.edad = edad;
        this.comuna = comuna;
        this.direccion = direccion;
        this.estadoElectoral = estadoElectoral;
        this.vocalDeMesa = vocalDeMesa;
        this.localAsignado = localAsignado;
        this.numeroDeMesa = numeroDeMesa;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getRut() {
        return rut;
    }
    public int getEdad() {
        return edad;
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
    public int getVocalDeMesa() {
        return vocalDeMesa;
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
    public void setRun(String rut) {
        this.rut = rut;
    }
    public void setEdad(int edad) {
        this.edad = edad;
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
    public void setVocalDeMesa(int vocalDeMesa) {
        this.vocalDeMesa = vocalDeMesa;
    }
    public void setLocalAsignado(String localAsignado) {
        this.localAsignado = localAsignado;
    }
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
             
}