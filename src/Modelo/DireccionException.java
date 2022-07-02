package Modelo;

/**
 *Excepcion de direccion, ocurre cuando no se respeta el formato
 * @author jpail
 */
public class DireccionException extends Exception{
    public DireccionException(){
        super("la Direccion NO se encuentra en el formato correcto");
    }
}
