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
    private int estadoElectoral; // Si el valor es 1, el votante está habilitado para votar.
    
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
    
    /**
     * Método getEstadoElectoral
     * @return Retorna el estado electoral. 1 si está habilitado para votar, 0 caso contrario.
     */
    public int getEstadoElectoral() {
        return estadoElectoral;
    }
    
    /**
     * Método setEstadoElectoral
     * @param estadoElectoral estado electoral
     */
    public void setEstadoElectoral(int estadoElectoral) {
        this.estadoElectoral = estadoElectoral;
    }
    
    /**
     * 
     * @return 
     */
    public abstract Object crearPersona();
    
    /**
     * Declaración método abstracto obtenerDatosPersona
     * @return Retorna un String con los datos de la persona (votante o no votante).
     */
    @Override
    public abstract String[] obtenerDatosPersona();
    
    /**
     * Método getNombreCompleto
     * @return Retorna el nombre completo de la persona.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    /**
     * Método setNombreCompleto
     * @param nombreCompleto nombre completo de la persona
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    /**
     * Método getRut
     * @return Retorna el rut de la persona
     */
    public String getRut() {
        return rut;
    }
    
    /**
     * Método setRut
     * @param rut rut de la persona
     */
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    /**
     * Método getComuna
     * @return Retorna la comuna de la persona
     */
    public String getComuna() {
        return comuna;
    }
    
    /**
     * Método setComuna
     * @param comuna comuna de la persona
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    /**
     * Método getDireccion
     * @return Retorna la dirección de la persona
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Método setDireccion
     * @param direccion dirección de la persona
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
