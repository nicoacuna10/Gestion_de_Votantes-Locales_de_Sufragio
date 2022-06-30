/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondevotantes;

/**
 *Excepcion de rut, ocurre cuando no se respeta el formato
 * @author jpail
 */
public class RutException extends Exception{
    public RutException(){
        super("El rut NO esta en el formato correcto");
    }
}
