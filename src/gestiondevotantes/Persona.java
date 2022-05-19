package gestiondevotantes;

/**
 * Persona almacena información básica de una persona.
 * Implementa la interfaz Identificarse.
 * @see Identificarse
 * @author jpail
 */
public abstract class Persona implements Identificarse{

    // Variables de instancia
    private String nombreCompleto; // Nombre del votante.
    private String rut; // Rut del votante.
    private String comuna; // Comuna de domiclio.
    private String direccion; // Dirección del domicilio.    
    private int estadoElectoral;
    //private int estadoElectoral; // Si el valor es 1, el votante está habilitado para votar.
    
    /**
     * Constructor de la clase Persona
     * @param nombreCompleto nombre de la persona
     * @param rut rut de la persona
     * @param comuna comuna de la persona
     * @param direccion dirección de la persona
     * @param estadoElectoral estado electoral de la persona
     */
    public Persona(String nombreCompleto, String rut, String comuna, String direccion, int estadoElectoral) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.comuna = comuna;
        this.direccion = direccion;
        this.estadoElectoral = estadoElectoral;
    }

    public int getEstadoElectoral() {
        return estadoElectoral;
    }

    public void setEstadoElectoral(int estadoElectoral) {
        this.estadoElectoral = estadoElectoral;
    }
    /*public String nombreCompleto; // Nombre del votante.
    public String rut; // Rut del votante.
    public String comuna; // Comuna de domiclio.
    public String direccion; // Dirección del domicilio.    
    public int estadoElectoral; // Si el valor es 1, el votante está habilitado para votar.*/
    public abstract Object crearPersona();
    
    @Override
    public abstract void identificarse();
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
