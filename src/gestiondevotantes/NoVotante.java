package gestiondevotantes;

/**
 * NoVotante almacena información respecto a un no votante.
 * Extiende de Persona
 * @see Persona
 * @author jpail
 */
public class NoVotante extends Persona{
    private String razon;
    //private int estadoElectoral;
    
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
     * Método identificarse
     */
    @Override
    public void identificarse(){
        System.out.println("SOY NO VOTANTE");
    }
    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
        
    public Object crearPersona(){
        return null;
    }
    public void jugar(){
        
    }
    
}