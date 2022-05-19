package gestiondevotantes;

/**
 *
 * @author jpail
 */
public class NoVotante extends Persona{
    private String razon;
    //private int estadoElectoral;
    public NoVotante(String nombreCompleto, String rut, String comuna, String direccion, int estadoElectoral, String razon){
        super(nombreCompleto, rut, comuna, direccion,estadoElectoral);
        this.razon = razon;
        //this.estadoElectoral=estadoElectoral;
        
    }
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
