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
     * 
     * @throws IOException 
     */
    public void menuOperaciones() throws IOException{
        System.out.println(" -----------------------------------------");
        System.out.println("| Gestion de Votantes-Locales de votacion |");
        System.out.println(" -----------------------------------------");
        
        Region valparaiso = new Region();
        Funcionalidad f = new Funcionalidad();
        f.funcionInicial(valparaiso);
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
                System.out.println("6.  Agregar usuario al registro");
                System.out.println("7.  Modificar datos del usuario");
                System.out.println("8.  Eliminar usuario del registro");
                System.out.println("9.  Consultar datos electorales del usuario");
                System.out.println("10. Mostrar todos los usuarios");
                System.out.println("11. Mostrar todos los votantes de un Local");
                System.out.println("12. Mostrar el votante mas joven de un Local");
                System.out.println("13. Mostrar votantes de un local en un intervalo");
                System.out.println("14. Consultar Tipo de Usuario");
                System.out.println("15. Exportar datos a archivo *.csv");
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
                            f.funcionConsultarDatosLocal(valparaiso);
                            break;
                            
                        case 5:
                            f.funcionMostrarLocales(valparaiso);
                            break;
                            
                        case 6:
                            f.funcionAgregarVotante(valparaiso);
                            break;
                        
                        case 7:
                            f.funcionModificarDatosVotante(valparaiso);
                            break;
                            
                        case 8:
                            f.funcionEliminarVotante(valparaiso);
                            break;
                            
                        case 9:
                            f.funcionConsultarDatosVotante(valparaiso);
                            break;
                            
                        case 10:
                            f.funcionMostrarVotantes(valparaiso);
                            break;
                        case 11:
                            f.funcionMostrarVotantesPorLocal(valparaiso);
                            break;
                        case 12:
                            f.funcionMostrarVotanteMasJoven(valparaiso);
                            break;
                        case 13:
                            f.funcionMostrarVotantesIntervalo(valparaiso);
                            break;
                        case 14:
                            f.funcionIdentificarse(valparaiso);
                            break;
                        case 15:
                            f.funcionExportar("datos.csv", valparaiso);
                            break;
                        case 16:
                            salir = true;
                            break;
                        
                        default:
                            System.out.println("Solo números entre 1 y 12");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sn.next();
                }
            }

    }

   
}