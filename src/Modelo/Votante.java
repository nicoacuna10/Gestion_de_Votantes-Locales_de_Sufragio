package Modelo;

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
     * Constructor de la clase Votante.
     */
    public Votante(){
        super();
    }
    
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
        this.numeroDeMesa = numeroDeMesa;
    }
    /**
     * Método obtenerDatosPersona: guarda los datos del votante en un string
     * @return Retorna un string con los datos del votante
     */
    @Override
    public String obtenerDatosPersona(){  
        return getNombreCompleto() + "," + getRut() + "," + getComuna() + "," + getDireccion() + "," + String.valueOf(numeroDeMesa);
    }
    
    /**
     * Método setNumeroDeMesa: Almacena un número de mesa del votante
     * @param numeroDeMesa número de la mesa del votante
     */
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }    
    
    /**
     * Método getNumeroDeMesa: Obtiene el número de mesa del votante.
     * @return Retorna el número de la mesa del votante
     */
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }

}