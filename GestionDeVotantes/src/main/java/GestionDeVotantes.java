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
        Region valparaiso = null;
        
        // Variables auxiliares
        Local auxL;
        Votante auxV;
        Mesa auxM;
        
        
        // MENU
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            
            System.out.println("MENU");
            System.out.println("1. Agregar votante al registro");
            System.out.println("2. Modificar datos del votante");
            System.out.println("3. Consultar datos electorales del votante");
            System.out.println("4. Agregar local al registro");
            System.out.println("5. Mostrar las mesas de un local");
            System.out.println("6. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        if(valparaiso == null){
                            // Se instancia la variable valparaiso que contiene los mapas principales.
                            valparaiso = new Region();
                        }
                        
                        // Se llama al metodo de agregar votante para que el usuario ingrese los datos del nuevo votante.
                        auxV = valparaiso.agregarVotante();
                        // Luego de agregar el votante, se busca si existe el local del votante.
                        auxL = valparaiso.buscarLocal(auxV.getLocalAsignado());
                        
                       
                        if(auxL == null){
                            // Si no existe el local dentro del mapa, se agrega.
                            valparaiso.agregarLocal(auxV.getLocalAsignado(), auxV.getComuna(), auxV.getNumeroDeMesa());
                        }else{
                            // Si existe el local, se busca si existe la mesa en la lista dentro  local respectivo.
                            auxM = auxL.buscarMesa(auxV.getNumeroDeMesa());
                            if(auxM == null){
                                // Si la mesa no existe dentro de la lista, se agrega.
                                auxM = auxL.agregarMesa(auxV.getNumeroDeMesa());
                            }
                            // Se agrega el rut del votante a la lista respectiva
                            auxM.agregarRutVotante(auxV.getRut());
                        }
                        
                        break;
                    case 2:
                        if(valparaiso != null){
                            System.out.println("Has seleccionado la opcion 2");
                        }
                        break;
                    case 3:
                        if(valparaiso != null){
                            System.out.println("Has seleccionado la opcion 3");
                            // Se llama al metodo consultar datos electorales del votante.
                            valparaiso.consultarDatosVotante();
                        }
                        break;
                    case 4:
                        if(valparaiso == null){
                            System.out.println("Has seleccionado la opcion 4");
                            // Se instancia la variable valparaiso que contiene los mapas principales.
                            valparaiso = new Region();
                        }
                        
                        //Se llama al método, sin parametros, para que agregue un nuevo local.
                        valparaiso.agregarLocal();
                        
                        break;
                    case 5:
                        if(valparaiso != null){
                            System.out.println("Has seleccionado la opcion 5");
                            
                            auxL = valparaiso.buscarLocal();
                            if(auxL != null){
                                auxM = auxL.buscarMesa();
                                if(auxM != null){
                                    
                                }
                            }else System.out.println("No se encontro el local");
                        }
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        
        
    }
    
}