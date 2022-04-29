package gestiondevotantes;

import java.io.*;

/**
 *
 * @author Nicolás Acuña
 */

// Clase que tiene las funcionalidades de la aplicación.
public class Funcionalidad {
    
    public Funcionalidad(){
    
    }
    
    /*  Funcion inicial: llena las colecciones con datos iniciales.
        
    */
    public Region funcionInicial(Region valparaiso){
    
        Local local1;
        Local local2;
        Local local3;
        Votante votante1;
        Votante votante2;
        Votante votante3;
        
        votante1 = new Votante("PEDRO ALBERTO LOPEZ GONZALEZ", "13800755-0", "VINA DEL MAR", "15 NORTE 567", 1, "UNIVERSIDAD ANDRES BELLO", 50);
        valparaiso.agregarVotante(votante1);
        
        votante2 = new Votante("PATRICIA CABRERO QUISPE", "8444987-2", "VALPARAISO", "CALLE ZENTENO 130", 1, "PUCV CASA CENTRAL", 34);
        valparaiso.agregarVotante(votante2);
        
        votante3 = new Votante("JUAN RICARDO ASTORGA BERMUDEZ", "19731000-K", "CONCON", "CALLE CUATRO 111", 1, "LICEO POLITECNICO CONCON", 1);
        valparaiso.agregarVotante(votante3);
        
        local1 = new Local("UNIVERSIDAD ANDRES BELLO", "VINA DEL MAR", "QUILLOTA 980", 10002, 31, 70);
        valparaiso.agregarLocal(local1);
        valparaiso.agregarMesa(local1, local1.getNumeroPrimeraMesa(), local1.getNumeroUltimaMesa());
        
        local2 = new Local("PUCV CASA CENTRAL", "VALPARAISO", "BRASIL 2950", 3000, 21, 35);
        valparaiso.agregarLocal(local2);
        valparaiso.agregarMesa(local2, local2.getNumeroPrimeraMesa(), local2.getNumeroUltimaMesa());
        
        local3 = new Local("LICEO POLITECNICO CONCON", "CONCON", "PORVENIR 865", 1500, 1, 7);
        valparaiso.agregarLocal(local3);
        valparaiso.agregarMesa(local3, local3.getNumeroPrimeraMesa(), local3.getNumeroUltimaMesa());

        return valparaiso;
    }
    
    /* función 0: mostrar Votantes
    
    */
    public void funcionMostrarVotantes(Region valparaiso){
        valparaiso.mostrarVotantes();
    }
    
    /* Función 1: agrega un nuevo votante.
    
    */
    public Region funcionAgregarVotante(Region valparaiso)throws IOException{
        Local localNuevo;
        Votante votanteNuevo;
        String nombreCompleto;
        String rut;
        String comuna;
        String direccion;
        int estadoElectoral;
        String localAsignado;
        int numeroDeMesa;
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
        estadoElectoral = Integer.parseInt(lector.readLine());
        while(estadoElectoral != 1 && estadoElectoral != 0){
            System.out.println("Ingrese un numero valido, 1 o 0");
            estadoElectoral = Integer.parseInt(lector.readLine());
        }

        System.out.println("Ingrese Nombre del Local Asignado");
        localAsignado = lector.readLine();

        System.out.println("Ingrese numero de mesa del votante");
        numeroDeMesa = Integer.parseInt(lector.readLine());

        // Instanciación de la variable de Clase Votante.
        votanteNuevo = new Votante(nombreCompleto, rut, comuna, direccion, estadoElectoral, localAsignado, numeroDeMesa);
        
        if(valparaiso.agregarVotante(votanteNuevo) == false){
            System.out.println("El votante ya existe");
            return valparaiso;
        }else System.out.println("El votante se agrego con exito");
        
        // Se busca si existe el local del votante.
        localNuevo = valparaiso.buscarLocal(votanteNuevo.getLocalAsignado());


        if(localNuevo == null){
            // Si no existe el local dentro del mapa, se agrega.
            int capacidadMaxima;
            int numeroPrimeraMesa;
            int numeroUltimaMesa;

            // Solicitud de ingreso de datos del local.
            System.out.println("Ingrese dirección del local");
            direccion = lector.readLine();

            System.out.println("Ingrese capacidad maxima del local");
            capacidadMaxima = Integer.parseInt(lector.readLine());

            System.out.println("Ingrese el numero de la primera mesa");
            numeroPrimeraMesa = Integer.parseInt(lector.readLine());
            while(numeroPrimeraMesa > votanteNuevo.getNumeroDeMesa() || numeroPrimeraMesa < 1){
                System.out.println("Ingrese numero de mesa valido");
                numeroPrimeraMesa = Integer.parseInt(lector.readLine());
            }

            System.out.println("Ingrese el numero de la ultima mesa");
            numeroUltimaMesa = Integer.parseInt(lector.readLine());
            while(numeroUltimaMesa < votanteNuevo.getNumeroDeMesa()){
                System.out.println("Ingrese numero de mesa valido");
                numeroUltimaMesa = Integer.parseInt(lector.readLine());
            }

            // Instanciación de la variable de Clase Local.
            localNuevo = new Local(votanteNuevo.getLocalAsignado(), votanteNuevo.getComuna(), direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
            
            if( valparaiso.agregarLocal(localNuevo) == false){
                System.out.println("El local no se agrego");
                return valparaiso;
            }else System.out.println("El local se agrego con exito");
            
            valparaiso.agregarMesa(localNuevo, numeroPrimeraMesa, numeroUltimaMesa);

        }
        
        return valparaiso;
    
    }
    
    /* Función 2: modifica datos de un votante.
    
    */
    public Region funcionModificarDatosVotante(Region valparaiso)throws IOException{
        String rut;
        String nombreLocalNuevo;
        int numeroMesaNueva;
        String direccionNueva;
        String comunaNueva;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Se solicita ingresar el rut del votante para realizar los cambios necesarios.
        System.out.println("Ingrese rut del votante que necesite modificar datos");
        rut = lector.readLine();
        
        System.out.println("Ingrese nombre del local a cambiar");
        nombreLocalNuevo = lector.readLine();

        System.out.println("Ingrese numero de mesa");
        numeroMesaNueva = Integer.parseInt(lector.readLine());
 
        System.out.println("Ingrese comuna (si es la misma de la direccion anterior, ingresela ingualmente)");
        comunaNueva = lector.readLine();
        
        System.out.println("Ingrese direccion nueva del domicilio");
        direccionNueva = lector.readLine();

        
        if( valparaiso.modificarDatosVotante(rut, nombreLocalNuevo, numeroMesaNueva, comunaNueva, direccionNueva) == true){
            System.out.println("Los datos del votante fueron modificados");
        }else System.out.println("No se modificaron los datos");
        
        return valparaiso;
    }

    

    
    /* Función 3: elimina votante del registro
    
    */
    public Region funcionEliminarVotante(Region valparaiso) throws IOException{
        String rut;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese un RUT");
        rut = lector.readLine();
        
        if( valparaiso.eliminarVotante(rut) == true){
            System.out.println("Votante eliminado");
        }else System.out.println("No existe votante");
        
        return valparaiso;
    }
    
    /* Función 4: muestra los datos del votante.
    
    */
    public void funcionConsultarDatosVotante(Region valparaiso)throws IOException{        
        String rut;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();
        
        if(valparaiso.mostrarDatosVotante(rut) == true){
            System.out.println("Se consulto con exito");
        }else System.out.println("El votante no existe en el registro");
    }
    
    /* Función 5: agrega un nuevo local.
    
    */
    public Region funcionAgregarLocal(Region valparaiso)throws IOException{
        String nombre;
        String comuna;
        String direccion;
        int capacidadMaxima;
        int numeroPrimeraMesa;
        int numeroUltimaMesa;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Solicitud de ingreso de datos del local.
        System.out.println("Ingrese nombre del local");
        nombre = lector.readLine();
        
        System.out.println("Ingrese comuna del local");
        comuna = lector.readLine();
        
        System.out.println("Ingrese dirección del local");
        direccion = lector.readLine();
        
        System.out.println("Ingrese capacidad maxima del local");
        capacidadMaxima = Integer.parseInt(lector.readLine());
        
        System.out.println("Ingrese el numero de la primera mesa");
        numeroPrimeraMesa = Integer.parseInt(lector.readLine());
        while(numeroPrimeraMesa < 1){
            System.out.println("Ingrese numero de mesa valido");
            numeroPrimeraMesa = Integer.parseInt(lector.readLine());
        }
        
        System.out.println("Ingrese el numero de la ultima mesa");
        numeroUltimaMesa = Integer.parseInt(lector.readLine());
        while(numeroUltimaMesa < numeroPrimeraMesa){
            System.out.println("Ingrese numero de mesa valido");
            numeroUltimaMesa = Integer.parseInt(lector.readLine());
        }
        
        // Instanciación de la variable de Clase Local.
        Local b = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        
        if( valparaiso.agregarLocal(b) == true){
            valparaiso.agregarMesa(b, numeroPrimeraMesa, numeroUltimaMesa);
        }else System.out.println("No se agrego el local.");
        
        return valparaiso;
    }
    
    /* Función 6: modifica datos del local.
    
    */
    public Region funcionModificarDatosLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        String comuna;
        String direccion;
        int capacidadMaxima;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            
        System.out.println("Ingrese nombre nuevo del local");
        nombreLocal = lector.readLine();   

        System.out.println("Ingrese comuna nueva del local");
        comuna = lector.readLine();

        System.out.println("Ingrese direccion nueva del local");
        direccion = lector.readLine();

        System.out.println("Ingrese capacidad maxima nueva del local");
        capacidadMaxima = Integer.parseInt(lector.readLine());
        
        if( valparaiso.modificarDatosLocal(nombreLocal, comuna, direccion, capacidadMaxima) == true ){
            System.out.println("El local fue modificado con exito");
        }else System.out.println("No existe Local");
        
        return valparaiso;
    }
    
    /* Función 7: elimina local del registro.
    
    */
    public Region funcionEliminarLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine();
        
        if(valparaiso.eliminarLocal(nombreLocal)){
            System.out.println("El local fue eliminado con exito");
        }else System.out.println("No se elimino local");
        
        
        return valparaiso;
    }
    
    /* Función 8: busca y muestra los datos del local.
    
    */
    public void funcionConsultarDatosLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine();

        if( valparaiso.mostrarDatosLocal(nombreLocal) == true ){
            System.out.println("Se mostraron los datos del local con exito");
        }else System.out.println("No existe Local");
    
    }
    
    
    /* Función 9: muestra los locales de votacion de la región.
    
    */
    public void funcionMostrarLocales(Region valparaiso){
        System.out.println("Locales de votacion de la region de Valparaiso");
        valparaiso.mostrarLocales();
    }
    
    /* Función 10: agrega mesa al local.
    
    */
    public Region funcionAgregarMesa(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine();
        
        if( valparaiso.agregarMesa(nombreLocal) == true){
            System.out.println("La mesa se agrego con exito");
        }else System.out.println("No existe Local");
        
        return valparaiso;
    
    }
    
    /* Función 11: modifica datos de la mesa.
    
    */
    public Region funcionModificarDatosMesa(Region valparaiso)throws IOException{
        String nombreLocal;
        int numeroDeMesa;
        int capacidadMaximaNueva;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre local");
        nombreLocal = lector.readLine();
        
        System.out.println("Ingrese numero de mesa");
        numeroDeMesa = Integer.parseInt(lector.readLine());
        
        System.out.println("Ingrese capacidad maxima nueva");
        capacidadMaximaNueva = Integer.parseInt(lector.readLine());
        
        valparaiso.modificarDatosMesa(nombreLocal, numeroDeMesa, capacidadMaximaNueva);
        
        return valparaiso;
    }
    
    /* Función 12: elimina mesa del local.
    
    */
    public Region funcionEliminarMesa(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine();
        
        if( valparaiso.eliminarMesa(nombreLocal) == true ){
            System.out.println("La mesa se elimino con exito");
        }else System.out.println("No existe Local");
        
        return valparaiso;
    }
    
    /* Función 13: muestra las mesas de un local.
    
    */
    public void funcionMostrarMesas(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine();
        
        if(valparaiso.mostrarMesas(nombreLocal) == true){
            System.out.println("Se mostraron las mesas del local");
        }else System.out.println("No existe Local");

    }
    
    /* Función 14: exportar
    
    */
    public void funcionExportar(String nombreArchivo, Region valparaiso){
        valparaiso.exportar(nombreArchivo);
    }
    

}