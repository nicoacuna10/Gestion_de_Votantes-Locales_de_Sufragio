package gestiondevotantes;

import java.util.*;
import java.io.*;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class GestionDeVotantes {
    

    // Función principal de la clase
    public static void main(String[] args)throws IOException{
        
        System.out.println(" -----------------------------------------");
        System.out.println("| Gestion de Votantes-Locales de votacion |");
        System.out.println(" -----------------------------------------");
        
        // Se crea una variable de clase Region.
        Region valparaiso = new Region();
        Funcionalidad f = new Funcionalidad();
        
        valparaiso = f.funcionInicial(valparaiso);
        
        // MENU
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            
            System.out.println("MENU");
            System.out.println("1.  Agregar votante al registro");
            System.out.println("2.  Modificar datos del votante");
            System.out.println("3.  Eliminar votante del registro");
            System.out.println("4.  Consultar datos electorales del votante");
            
            System.out.println("5.  Agregar local al registro");
            System.out.println("6.  Modificar datos del local");
            System.out.println("7.  Eliminar local del registro");
            System.out.println("8.  Consultar datos del local");
            System.out.println("9.  Mostrar locales de votacion");
            
            System.out.println("10.  Agregar mesa");
            System.out.println("11. Modificar datos de la mesa");
            System.out.println("12. Eliminar Mesa");
            System.out.println("13. Mostrar las mesas de un local");
            
            System.out.println("14. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        valparaiso = f.funcionAgregarVotante(valparaiso);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        valparaiso = f.funcionModificarDatosVotante(valparaiso);
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        valparaiso = f.funcionEliminarVotante(valparaiso);
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        f.funcionConsultarDatosVotante(valparaiso);
                        break;
                        
                        
                    case 5:
                        System.out.println("Has seleccionado la opcion 5");
                        valparaiso = f.funcionAgregarLocal(valparaiso);
                        break;
                    case 6:
                        System.out.println("Has seleccionado la opcion 6");
                        valparaiso = f.funcionModificarDatosLocal(valparaiso);
                        break;
                    case 7:
                        System.out.println("Has seleccionado la opcion 7");
                        valparaiso = f.funcionEliminarLocal(valparaiso);
                        break;
                    case 8:
                        System.out.println("Has seleccionado la opcion 8");
                        f.funcionConsultarDatosLocal(valparaiso);
                        break;
                    case 9:
                        System.out.println("Has seleccionado la opcion 9");
                        f.funcionMostrarLocales(valparaiso);
                        break;
                        
                    
                    case 10:
                        System.out.println("Has seleccionado la opcion 10");
                        valparaiso = f.funcionAgregarMesa(valparaiso);
                        break;
                    case 11:
                        System.out.println("Has seleccionado la opcion 11");
                        valparaiso = f.funcionModificarDatosMesa(valparaiso);
                        break;
                    case 12:
                        System.out.println("Has seleccionado la opcion 12");
                        valparaiso = f.funcionEliminarMesa(valparaiso);
                        break;
                    case 13:
                        System.out.println("Has seleccionado la opcion 13");
                        f.funcionMostrarMesas(valparaiso);
                        break;
                        
                        
                    case 14:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 14");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        
    }
    
}
