package gestiondevotantes;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Votante extends Persona {

    private int numeroDeMesa;
    //private int estadoElectoral;
    // Constructor clase votante con local asignado.
    public Votante(String nombreCompleto, String rut, String comuna, String direccion, int estadoElectoral, int numeroDeMesa) {
        super(nombreCompleto, rut, comuna, direccion, estadoElectoral);
        //this.estadoElectoral = estadoElectoral;
        this.numeroDeMesa = numeroDeMesa;
    }
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