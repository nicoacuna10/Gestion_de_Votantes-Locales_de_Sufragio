package gestiondevotantes;

import java.util.*;
import java.io.*;

/**
 *  Menú de la aplicación
 * @author jpail
 */
public class Menu {
    
    /**
     * Constructor de la clase Menu
     */
    public Menu() {
    }
    
    /**
     * Método menuOperaciones: menu con las opciones de la aplicacion
     * @throws IOException Excepcion Input/Output
     */
    public void menuOperaciones() throws IOException{
        System.out.println(" -----------------------------------------");
        System.out.println("| Gestion de Votantes-Locales de votacion |");
        System.out.println(" -----------------------------------------");
        
        Region valparaiso = new Region();
        Funcionalidad f = new Funcionalidad();
        CSV administradorCSV = new CSV();
        
        f.funcionInicial(valparaiso);
        administradorCSV.importarCSV("datosImportar.csv", valparaiso);
        Scanner sn = new Scanner(System.in);
        
        boolean salir = false;
        int opcion;
        while (!salir) {

            System.out.println("MENU");

            System.out.println("1.  Agregar local al registro");
            System.out.println("2.  Modificar datos del local");
            System.out.println("3.  Eliminar local del registro");
            System.out.println("4.  Consultar datos del local");
            System.out.println("5.  Mostrar locales de votacion");
            System.out.println("6.  Agregar persona al registro");
            System.out.println("7.  Modificar datos de la persona");
            System.out.println("8.  Eliminar persona del registro");
            System.out.println("9.  Buscar persona en el registro");
            System.out.println("10. Mostrar los votantes de un local");
            System.out.println("11. Mostrar todos los votantes de la region");
            System.out.println("12. Mostrar local con mas votantes");
            System.out.println("13. Mostrar votantes de un mismo nombre, o apellido");
            System.out.println("14. Mostrar todos los no votantes de la region");
            System.out.println("15. Exportar archivo *.csv");
            System.out.println("16. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        f.funcionAgregarLocal(valparaiso);
                        break;

                    case 2:
                        f.funcionModificarDatosLocal(valparaiso);
                        break;

                    case 3:
                        f.funcionEliminarLocal(valparaiso);
                        break;

                    case 4:
                        f.funcionBuscarLocal(valparaiso);
                        break;

                    case 5:
                        f.funcionMostrarLocales(valparaiso);
                        break;

                    case 6:
                        f.funcionAgregarPersona(valparaiso);
                        break;

                    case 7:
                        f.funcionModificarDatosPersona(valparaiso);
                        break;

                    case 8:
                        f.funcionEliminarPersona(valparaiso);
                        break;

                    case 9:
                        f.funcionBuscarPersona(valparaiso);
                        break;

                    case 10:
                        f.funcionMostrarVotantesLocal(valparaiso);
                        break;

                    case 11:
                        f.funcionMostrarVotantes(valparaiso);
                        break;

                    case 12:
                        f.funcionMostrarLocalMasLleno(valparaiso);
                        break;

                    case 13:
                        f.funcionMostrarVotantesNombreoApellido(valparaiso);
                        break;

                    case 14:
                        f.funcionMostrarNoVotantes(valparaiso);
                        break;

                    case 15:
                        administradorCSV.exportarCSV("datosExportar.csv", valparaiso);
                        break;

                    case 16:
                        salir = true;
                        break;

                    default:
                        System.out.println("Solo números entre 1 y 16");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

   
}