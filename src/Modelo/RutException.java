package Modelo;

/**
 *Excepcion de rut, ocurre cuando no se respeta el formato
 * @author jpail
 */
public class RutException extends Exception{
    public RutException(){
        super("El rut NO esta en el formato correcto");
    }
}
