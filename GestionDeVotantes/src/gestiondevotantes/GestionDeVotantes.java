package gestiondevotantes;

import java.util.*;
import java.io.*;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */


public class GestionDeVotantes {
    
    public static void funcion1(Region valparaiso)throws IOException{
        
        // Variables auxiliares
        Local auxL;
        Votante auxV;
        Mesa auxM;
        String nombreCompleto;
        String rut;
        String comuna;
        String direccion;
        int estadoElectoral;
        String localAsignado;
        int numeroDeMesa;
        
        String auxNumero; // variable utilizada para obtener strings que luego se convertiran a numeros.
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Solicitud de ingreso de datos del votante.
        System.out.println("Ingrese nombre completo del votante");
        nombreCompleto = lector.readLine();
        
        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();
        
        System.out.println("Ingrese comuna de domicilio del votante");
        comuna = lector.readLine();
        
        System.out.println("Ingrese dirección de domicilio del votante");
        direccion = lector.readLine();
        
        System.out.println("Ingrese 1 si la persona esta habilitada para votar, 0 caso contrario");
        auxNumero = lector.readLine();
        estadoElectoral = Integer.parseInt(auxNumero);
        while(estadoElectoral != 1 && estadoElectoral != 0){
            System.out.println("Ingrese un numero valido, 1 o 0");
            auxNumero = lector.readLine();
            estadoElectoral = Integer.parseInt(auxNumero);
        }
        
        System.out.println("Ingrese Nombre del Local Asignado");
        localAsignado = lector.readLine();
        
        System.out.println("Ingrese numero de mesa del votante");
        auxNumero = lector.readLine();
        numeroDeMesa = Integer.parseInt(auxNumero);
        
        // Instanciación de la variable de Clase Votante.
        auxV = new Votante(nombreCompleto, rut, comuna, direccion, estadoElectoral, localAsignado, numeroDeMesa);
        
        // Se llama al metodo de agregar votante para que el usuario ingrese los datos del nuevo votante.
        valparaiso.agregarVotante(auxV);
        // Luego de agregar el votante, se busca si existe el local del votante.
        auxL = valparaiso.buscarLocal(auxV.getLocalAsignado());


        if(auxL == null){
            // Si no existe el local dentro del mapa, se agrega.
            int capacidadMaxima;
            int numeroPrimeraMesa;
            int numeroUltimaMesa;
           
            // Solicitud de ingreso de datos del local.
            System.out.println("Ingrese dirección del local");
            direccion = lector.readLine();

            System.out.println("Ingrese capacidad maxima del local");
            auxNumero = lector.readLine();
            capacidadMaxima = Integer.parseInt(auxNumero);

            System.out.println("Ingrese el numero de la primera mesa");
            auxNumero = lector.readLine();
            numeroPrimeraMesa = Integer.parseInt(auxNumero);
            while(numeroPrimeraMesa > auxV.getNumeroDeMesa() || numeroPrimeraMesa < 1){
                System.out.println("Ingrese numero de mesa valido");
                auxNumero = lector.readLine();
                numeroPrimeraMesa = Integer.parseInt(auxNumero);
            }

            System.out.println("Ingrese el numero de la ultima mesa");
            auxNumero = lector.readLine();
            numeroUltimaMesa = Integer.parseInt(auxNumero);
            while(numeroUltimaMesa < auxV.getNumeroDeMesa()){
                System.out.println("Ingrese numero de mesa valido");
                auxNumero = lector.readLine();
                numeroUltimaMesa = Integer.parseInt(auxNumero);
            }

            // Instanciación de la variable de Clase Local.
            auxL = new Local(auxV.getLocalAsignado(), auxV.getComuna(), direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
            valparaiso.agregarLocal(auxL, auxV);
            
            int index;
            for(index = auxL.getNumeroPrimeraMesa(); index <= auxL.getNumeroUltimaMesa(); index++){
                auxL.agregarMesa(numeroDeMesa);
            }

        }
            auxM = auxL.buscarMesa(auxV.getNumeroDeMesa());
            auxM.agregarRutVotante(auxV.getRut());
        
        
    }
    
    public static void funcion3(Region valparaiso)throws IOException{
        
        Votante auxV;
        Local auxL;
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        String rut;
        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();
        
        auxV = valparaiso.buscarVotante(rut);
        
        if(auxV != null){
            auxL = valparaiso.buscarLocal(auxV.getLocalAsignado());
            
            // Se imprimen los datos del votante
            System.out.println("DATOS VOTANTE");
            System.out.println("NOMBRE: "+auxV.getNombreCompleto());
            System.out.println("RUT "+auxV.getRut());
            System.out.println("COMUNA: "+auxV.getComuna());
            System.out.println("DIRECCION: "+auxV.getDireccion());

            if(auxV.getEstadoElectoral() == 1){
                System.out.println("HABILITADO(A) PARA VOTAR: SI");
            }else System.out.println("HABILITADO(A) PARA VOTAR: NO");

            System.out.println("LOCAL: "+auxV.getLocalAsignado());
            System.out.println("DIRECCION LOCAL: "+auxL.getDireccion());
            System.out.println("NUMERO DE MESA: "+auxV.getNumeroDeMesa());
            
            
        }else System.out.println("El votante no existe en el registro");

        
    }
    
    public static void funcion4(Region valparaiso)throws IOException{
        
        String nombre;
        String comuna;
        String direccion;
        int capacidadMaxima;
        int numeroPrimeraMesa;
        int numeroUltimaMesa;
        String auxNumero; // Variable utilizada para obtener un string que posteriormente se convertira en entero.
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Solicitud de ingreso de datos del local.
        System.out.println("Ingrese nombre del local");
        nombre = lector.readLine();
        
        System.out.println("Ingrese comuna del local");
        comuna = lector.readLine();
        
        System.out.println("Ingrese dirección del local");
        direccion = lector.readLine();
        
        System.out.println("Ingrese capacidad maxima del local");
        auxNumero = lector.readLine();
        capacidadMaxima = Integer.parseInt(auxNumero);
        
        System.out.println("Ingrese el numero de la primera mesa");
        auxNumero = lector.readLine();
        numeroPrimeraMesa = Integer.parseInt(auxNumero);
        while(numeroPrimeraMesa < 1){
            System.out.println("Ingrese numero de mesa valido");
            auxNumero = lector.readLine();
            numeroPrimeraMesa = Integer.parseInt(auxNumero);
        }
        
        System.out.println("Ingrese el numero de la ultima mesa");
        auxNumero = lector.readLine();
        numeroUltimaMesa = Integer.parseInt(auxNumero);
        while(numeroUltimaMesa < numeroPrimeraMesa){
            System.out.println("Ingrese numero de mesa valido");
            auxNumero = lector.readLine();
            numeroUltimaMesa = Integer.parseInt(auxNumero);
        }
        
        // Instanciación de la variable de Clase Local.
        Local auxL = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        valparaiso.agregarLocal(auxL);
        
        // Se agregan las mesas.
        auxL.agregarMesa(numeroPrimeraMesa, numeroUltimaMesa);
    }
    
    public static void funcion5(Region valparaiso)throws IOException{
        
        // Variables auxiliares
        Local auxL;
        LinkedList auxLista;
        Mesa auxM;
        
        String nombre;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombre = lector.readLine();
        
        auxL = valparaiso.buscarLocal(nombre);
        if(auxL != null){
            int index;
            auxLista = auxL.getListaDeMesas();
            
            System.out.println("Lista de mesas del local "+auxL.getNombreLocal());
            for(index = 0; index < auxLista.size() ; index++){
                auxM = (Mesa) auxLista.get(index);
                System.out.println(auxM.getNumeroDeMesa());
            }
            
            
        }else System.out.println("El local no existe en el registro");
        
    }

    // Función principal de la clase
    public static void main(String[] args)throws IOException{
        
        System.out.println(" -----------------------------------------");
        System.out.println("| Gestion de Votantes-Locales de votacion |");
        System.out.println(" -----------------------------------------");
        
        // Se crea una variable de clase Region.
        Region valparaiso = null;
        
        
        
        
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
                        funcion1(valparaiso);
                        
                        break;
                    case 2:
                        if(valparaiso != null){
                            System.out.println("Has seleccionado la opcion 2");
                        }
                        break;
                    case 3:
                        if(valparaiso != null && valparaiso.registroVotantesRut != null){
                            System.out.println("Has seleccionado la opcion 3");
                            funcion3(valparaiso);
                        }
                        break;
                    case 4:
                        if(valparaiso == null){
                            System.out.println("Has seleccionado la opcion 4");
                            // Se instancia la variable valparaiso que contiene los mapas principales.
                            valparaiso = new Region();
                        }
                        
                        funcion4(valparaiso);
                        
                        break;
                    case 5:
                        if(valparaiso != null){
                            System.out.println("Has seleccionado la opcion 5");
                            funcion5(valparaiso);
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
