package gestiondevotantes;

import java.io.*;

/**
 * GestionDeVotantes es la clase principal
 * @author jpail
 * @author Nicolás Acuña
 */
public class GestionDeVotantes {
    

    /**
     * Función principal de la clase
     * @param args args
     * @throws IOException Excepcion Input/Output
     */
    public static void main(String[] args)throws IOException{
        Menu m = new Menu();
        m.menuOperaciones();
        
    }
    
}