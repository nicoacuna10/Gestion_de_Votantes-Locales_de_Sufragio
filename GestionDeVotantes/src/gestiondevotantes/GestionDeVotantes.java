package gestiondevotantes;

import java.util.*;
import java.io.*;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */


public class GestionDeVotantes {
    
    // Función 1: agrega un nuevo votante.
    public static void funcion1(Region valparaiso)throws IOException{
        
        // Variables auxiliares
        Local auxL;
        Votante auxV;
        Votante votanteExistente;
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
        
        // Se busca si el votante existe.
        votanteExistente = valparaiso.buscarVotante(rut);
        if(votanteExistente == null){
            // Se llama al metodo de agregar votante para que el usuario ingrese los datos del nuevo votante.
            valparaiso.agregarVotante(auxV);
        }else auxV = votanteExistente;
        
        // Se busca si existe el local del votante.
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
            // Se busca la mesa del votante.
            auxM = auxL.buscarMesa(auxV.getNumeroDeMesa());
            // Se agrega el rut a la lista de ruts de los votantes de la mesa.
            auxM.agregarRutVotante(auxV.getRut());
        
        
    }
    
    // Función 2: modifica datos de un votante.
    public static void funcion2(Region valparaiso)throws IOException{
        
        Votante auxV;
        Local auxL1;
        Local auxL2;
        Mesa auxM;
        String rut;
        String nombreLocalNuevo;
        int numeroDeMesa;
        String auxNumero;
        String direccionNueva;
        String comuna;
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Se solicita ingresar el rut del votante para realizar los cambios necesarios.
        System.out.println("Ingrese rut del votante que necesite modificar dato");
        rut = lector.readLine();
        
        // Se busca en el registro. Si no lo encuentra, se le pide que ingrese otro.
        auxV = valparaiso.buscarVotante(rut);
        
        while(auxV == null){
            System.out.println("RUT no existe en el registro, ingrese otro");
            rut = lector.readLine();
            auxV = valparaiso.buscarVotante(rut);
        }
        
        /* MENU FUNCION MODIFICACION DATOS
            opciones:
            1. cambiar local de votacion
            2. cambiar direccion del domicilio
            3. salir.
        */
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        while(!salir){
            
            System.out.println("MENU : MODIFICACION DE DATOS VOTANTE");
            System.out.println("1. Cambiar local de votacion");
            System.out.println("2. Cambiar direccion de domicilio");
            System.out.println("3. Salir");
            
            try{
                
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                
                switch(opcion){
                    case 1:
                        
                        // Se busca el local actual del votante.
                        auxL1 = valparaiso.buscarLocal(auxV.getLocalAsignado());
                        
                        // Se le pide ingresar el nombre del local nuevo. Si no se encuentra, se le pide que ingrese otro.
                        System.out.println("Ingrese nombre del local a cambiar");
                        nombreLocalNuevo = lector.readLine();
                        auxL2 = valparaiso.buscarLocal(nombreLocalNuevo);
                        
                        while(auxL2 == null){
                            System.out.println("Nombre del local no existe en el registro, ingrese otro");
                            nombreLocalNuevo = lector.readLine();
                            auxL2 = valparaiso.buscarLocal(nombreLocalNuevo);
                        }
                        
                        // Se busca la mesa actual del votante.
                        auxM = auxL1.buscarMesa(auxV.getNumeroDeMesa());
                        // Se elimina el rut del votante de la lista de ruts de votantes de la mesa.
                        auxM.eliminarRutVotante(auxV.getRut());
                        
                        // Se modifica el local del votante.
                        auxV.setLocalAsignado(nombreLocalNuevo);
                        
                        // Se le pide que ingrese la mesa del local nuevo.
                        System.out.println("Ingrese numero de mesa");
                        auxNumero = lector.readLine();
                        numeroDeMesa = Integer.parseInt(auxNumero);
                        
                        while(numeroDeMesa < auxL2.getNumeroPrimeraMesa() || numeroDeMesa > auxL2.getNumeroUltimaMesa()){
                            System.out.println("Ingrese numero de mesa valido");
                            auxNumero = lector.readLine();
                            numeroDeMesa = Integer.parseInt(auxNumero);
                        }
                        
                        // Se modifica el número de mesa.
                        auxV.setNumeroDeMesa(numeroDeMesa);
                        
                        // Se busca la mesa nueva del votante.
                        auxM = auxL2.buscarMesa(auxV.getNumeroDeMesa());
                        // Se agrega el rut del votante a la lista de ruts de votantes de la mesa nueva.
                        auxM.agregarRutVotante(auxV.getRut());
                        
                        
                        break;
                    case 2:
                        
                        // Se le pide ingresar la dirección nueva del domicilio.
                        System.out.println("Ingrese direccion nueva del domicilio");
                        direccionNueva = lector.readLine();
                        
                        // Se modifica la dirección.
                        auxV.setDireccion(direccionNueva);
                        
                        // Se le pide ingresar la comuna. Aunque no cambie, se le pide que la ingrese nuevamente.
                        System.out.println("Ingrese comuna (si es la misma de la direccion anterior, ingresela ingualmente)");
                        comuna = lector.readLine();
                        
                        // Se modifica la comuna (en caso que sea la misma, no hay cambios).
                        auxV.setComuna(comuna);
                        
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                               
                
                }
            }catch(InputMismatchException e){
                System.out.println("Debe insertar un numero");
                sn.next();
            }
        
        }
        
        
    
    }
    
    // Función 3: muestra los datos del votante.
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
    
    // Función 4: agrega un nuevo local.
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
    
    // Función 5: muestra las mesas de un local.
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
                            funcion2(valparaiso);
                        }
                        break;
                    case 3:
                        if(valparaiso != null && valparaiso.registroVotantesRut != null){
                            System.out.println("Has seleccionado la opcion 3");
                            funcion3(valparaiso);
                        }
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        if(valparaiso == null){
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
