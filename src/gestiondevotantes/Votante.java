package gestiondevotantes;

/**
 * Votante almacena información con respecto a un votante.
 * Extiende de Persona.
 * @see Persona
 * @author jpail
 * @author Nicolás Acuña
 */
public class Votante extends Persona {

    private int numeroDeMesa;
    //private int estadoElectoral;
    
    /**
     * Constructor clase votante con local asignado.
     * @param nombreCompleto nombre completo del votante
     * @param rut rut del votante
     * @param comuna comuna del votante
     * @param direccion dirección del votante
     * @param estadoElectoral estado electoral del votante
     * @param numeroDeMesa numero de mesa del votante
     */
    public Votante(String nombreCompleto, String rut, String comuna, String direccion, int estadoElectoral, int numeroDeMesa) {
        super(nombreCompleto, rut, comuna, direccion, estadoElectoral);
        //this.estadoElectoral = estadoElectoral;
        this.numeroDeMesa = numeroDeMesa;
    }
    /**
     * Método identificarse
     */
    @Override
    public void identificarse(){
        System.out.println("SOY VOTANTE");
    }
    
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }    
    
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }

    /*public int getEstadoElectoral() {
        return estadoElectoral;
    }
    public void setEstadoElectoral(int estadoElectoral) {
        this.estadoElectoral = estadoElectoral;
    }*/
     public Object crearPersona(){
         return null;
     }
}