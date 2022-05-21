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
     * Método identificarse: guarda los datos del votante en un string
     * @return Retorna un string con los datos del votante
     */
    @Override
    public String[] obtenerDatosPersona(){
        String[] datosVotante = new String[7];
        
        datosVotante[0] = getNombreCompleto();
        datosVotante[1] = getRut();
        datosVotante[2] = getComuna();
        datosVotante[3] = getDireccion();
        datosVotante[4] = String.valueOf(numeroDeMesa);
        
        return datosVotante;
    }
    
    /**
     * Método setNumeroDeMesa: almacena un nuevo número de mesa
     * @param numeroDeMesa número de la mesa del votante
     */
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }    
    
    /**
     * Método getNumeroDeMesa
     * @return Retorna el número de la mesa del votante
     */
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }


     public Object crearPersona(){
         return null;
     }
}