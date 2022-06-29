package Modelo;

/**
 * NoVotante almacena información respecto a un no votante.
 * Extiende de Persona
 * @see Persona
 * @author jpail
 */
public class NoVotante extends Persona{
    private String razon;
    
    /**
     * Constructor de la clase NoVotante.
     */
    public NoVotante(){
        super();
    }
    
    /**
     * Constructor de la clase NoVotante
     * @param nombreCompleto nombre del no votante
     * @param rut rut del no votante
     * @param comuna comuna del no votante
     * @param direccion dirección del no votante
     * @param estadoElectoral estado electoral del no votante
     * @param razon razón por la que no vota
     */
    public NoVotante(String nombreCompleto, String rut, String comuna, String direccion, int estadoElectoral, String razon){
        super(nombreCompleto, rut, comuna, direccion,estadoElectoral);
        this.razon = razon;
        //this.estadoElectoral=estadoElectoral;
        
    }
    
    /**
     * Método obtenerDatosPersona: guarda los datos del no votante en un string.
     * @return Retorna un arreglo de Strings con los datos del no votante.
     */
    @Override
    public String obtenerDatosPersona(){        
        return getNombreCompleto() + "," + getRut() + "," + getComuna() + "," + getDireccion() + "," + razon; 
    }
    
    /**
     * Método getRazon: Obtiene la razon por la que el no votante no puede votar.
     * @return Retorna la razon por la que el no votante no vota
     */
    public String getRazon() {
        return razon;
    }
    
    /**
     * Método setRazon: almacena la razón por la que no vota
     * @param razon razón por la que el no votante no vota
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }
        

    
}