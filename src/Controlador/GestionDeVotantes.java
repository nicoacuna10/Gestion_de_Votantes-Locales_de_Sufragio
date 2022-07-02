package Controlador;


import Modelo.CSV;
import Modelo.Funcionalidad;
import Modelo.Region;
import Vista.VentanaMenu;
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
        Region valparaiso = new Region();
        Funcionalidad f = new Funcionalidad();
        CSV administradorCSV = new CSV();
        
        f.funcionInicial(valparaiso);
        administradorCSV.importarCSV("datosImportar.csv", valparaiso);
        
        VentanaMenu menu = new VentanaMenu(valparaiso, administradorCSV);
        menu.setVisible(true);
        
    }
    
}