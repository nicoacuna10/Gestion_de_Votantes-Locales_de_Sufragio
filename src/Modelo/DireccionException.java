/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondevotantes;

/**
 *Excepcion de direccion, ocurre cuando no se respeta el formato
 * @author jpail
 */
public class DireccionException extends Exception{
    public DireccionException(){
        super("la Direccion NO se encuentra en el formato correcto");
    }
}
