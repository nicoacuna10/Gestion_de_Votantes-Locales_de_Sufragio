package gestiondevotantes;

import java.io.*;

/**
 * Funcionalidad contiene las funciones de la aplicación.
 * @author Nicolás Acuña
 */
public class Funcionalidad {
    
    /**
     * Constructor de la clase Funcionalidad
     */
    public Funcionalidad(){
    
    }
    
    /**
     * Funcion inicial: llena las colecciones con datos iniciales.
     * @param valparaiso Región de Valparaiso
     */
    public void funcionInicial(Region valparaiso){
    
        Local local1, local2, local3;
        Votante votante1, votante2, votante3;
        NoVotante noVotante1, noVotante2;
        
        local1 = new Local("UNIVERSIDAD ANDRES BELLO", "VINA DEL MAR", "QUILLOTA 980", 10002, 31, 70);
        valparaiso.agregarLocal(local1);
        
        local2 = new Local("PUCV CASA CENTRAL", "VALPARAISO", "BRASIL 2950", 3000, 21, 35);
        valparaiso.agregarLocal(local2);
        
        local3 = new Local("LICEO POLITECNICO CONCON", "CONCON", "PORVENIR 865", 1500, 1, 7);
        valparaiso.agregarLocal(local3);
        
        
        votante1 = new Votante("PEDRO ALBERTO LOPEZ GONZALEZ", "13800755-0", "VINA DEL MAR", "15 NORTE 567", 1, 50);
        valparaiso.agregarVotante("UNIVERSIDAD ANDRES BELLO", votante1);
        
        votante2 = new Votante("PATRICIA CABRERO QUISPE", "8444987-2", "VALPARAISO", "CALLE ZENTENO 130", 1, 34);
        valparaiso.agregarVotante("PUCV CASA CENTRAL", votante2);
        
        votante3 = new Votante("JUAN RICARDO ASTORGA BERMUDEZ", "19731000-K", "CONCON", "CALLE CUATRO 111", 1, 1);
        valparaiso.agregarVotante("LICEO POLITECNICO CONCON", votante3);
        
        noVotante1 = new NoVotante("MARIA JUANA DE LOS ANGELES RIVEROS", "12888012-9", "SAN ANTONIO", "RUBEN DARIO 1073", 0,"CARCEL");
        valparaiso.agregarNoVotante(noVotante1);
        
        noVotante2 = new NoVotante("JUANA VALENTINA SANCHEZ ORTUZAR", "24898012-1", "VIÑA DEL MAR", "6 ORIENTE 458", 0,"MENOR DE EDAD");
        valparaiso.agregarNoVotante(noVotante2);

    }
    

    /**
     * Función 1: agregar local
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionAgregarLocal(Region valparaiso)throws IOException{
        
        String nombre, comuna, direccion;
        int capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Solicitud de ingreso de datos del local.
        System.out.println("Ingrese nombre del local");
        nombre = lector.readLine().toUpperCase();
        
        System.out.println("Ingrese comuna del local");
        comuna = lector.readLine().toUpperCase();
        
        System.out.println("Ingrese dirección del local");
        direccion = lector.readLine().toUpperCase();
        
        System.out.println("Ingrese capacidad maxima del local");
        capacidadMaxima = Integer.parseInt(lector.readLine());
        while(capacidadMaxima < 100){
            System.out.println("Ingrese un valor mayor o igual a 100");
            capacidadMaxima = Integer.parseInt(lector.readLine());
        }
        
        System.out.println("Ingrese el numero de la primera mesa");
        numeroPrimeraMesa = Integer.parseInt(lector.readLine());
        while(numeroPrimeraMesa <= 0){
            System.out.println("Ingrese un valor mayor a 0");
            numeroPrimeraMesa = Integer.parseInt(lector.readLine());
        }
        
        System.out.println("Ingrese el numero de la ultima mesa");
        numeroUltimaMesa = Integer.parseInt(lector.readLine());
        while(numeroUltimaMesa <= numeroPrimeraMesa){
            System.out.println("Ingrese un valor mayor a "+numeroPrimeraMesa);
            numeroUltimaMesa = Integer.parseInt(lector.readLine());
        }
        
        // Instanciación de la variable de Clase Local.
        Local a = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        
        if( valparaiso.agregarLocal(a) == true){
            System.out.println("Se agregó local con exito");
        }else System.out.println("No se agregó el local.");
        
    }
    
    
    /**
     * Función 2: modificar datos de un local
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionModificarDatosLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        int capacidadMaximaNueva;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine().toUpperCase();   

        System.out.println("Ingrese capacidad maxima nueva del local");
        capacidadMaximaNueva = Integer.parseInt(lector.readLine());
        
        if( valparaiso.modificarDatosLocal(nombreLocal, capacidadMaximaNueva) == true ){
            System.out.println("Los datos del local fueron modificados con exito");
        }else System.out.println("No existe Local");
        
    }
    

    /**
     * Función 3: eliminar local
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionEliminarLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine().toUpperCase();
        
        if(valparaiso.eliminarLocal(nombreLocal)){
            System.out.println("El local fue eliminado con exito");
        }else System.out.println("No se elimino local");
        
    }
    

    /**
     * Función 4: buscar un local en el registro y mostrar sus datos.
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionBuscarLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine().toUpperCase();
        
        Local a = valparaiso.buscarLocal(nombreLocal);

        if( a != null ){
            // mostrar datos
            System.out.println("DATOS LOCAL");
            System.out.println("NOMBRE: "+a.getNombreLocal());
            System.out.println("COMUNA: "+a.getComuna());
            System.out.println("DIRECCION: "+a.getDireccion());
            System.out.println("CAPACIDAD MAXIMA: "+a.getCapacidadMaxima());
            System.out.println("MESAS: "+a.getNumeroPrimeraMesa()+" - "+a.getNumeroUltimaMesa());
        }else System.out.println("No existe Local");

    }
    

    /**
     * Función 5: mostrar los locales de la región.
     * @param valparaiso Región de Valparaiso
     */
    public void funcionMostrarLocales(Region valparaiso){
        
       String[] nombresLocales = valparaiso.obtenerNombresLocales();
       int cantidadLocales = nombresLocales.length;
       
       if(cantidadLocales > 0){
           System.out.println("Locales de votacion de la region de Valparaiso");
           System.out.println("Nombre\t\tComuna\t\tCapacidad Maxima\t\tDireccion\t\tMesas");
       }
       
       for(int i = 0; i < cantidadLocales; i++){
           Local a = valparaiso.buscarLocal(nombresLocales[i]);
           System.out.println(a.getNombreLocal()+"\t\t"+a.getComuna()+"\t\t"+a.getDireccion()+"\t\t"+a.getCapacidadMaxima()+"\t\t"+a.getNumeroPrimeraMesa()+" - "+a.getNumeroUltimaMesa());
       }

    }

    /**
     * Función 6: agregar una nueva persona.
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionAgregarPersona(Region valparaiso)throws IOException{
        Votante votanteNuevo;
        String nombreLocal, nombreCompleto, rut, comuna, direccion;
        int estadoElectoral, numeroDeMesa;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Solicitud de ingreso de datos de la persona.
        System.out.println("Ingrese nombre completo de la persona");
        nombreCompleto = lector.readLine().toUpperCase();

        System.out.println("Ingrese rut del persona");
        rut = lector.readLine();

        System.out.println("Ingrese comuna de domicilio de la persona");
        comuna = lector.readLine().toUpperCase();

        System.out.println("Ingrese dirección de domicilio de la persona");
        direccion = lector.readLine().toUpperCase();

        System.out.println("Ingrese 1 si la persona esta habilitada para votar, 0 caso contrario");
        estadoElectoral = Integer.parseInt(lector.readLine());
        while(estadoElectoral != 1 && estadoElectoral != 0){
            System.out.println("Ingrese un numero valido, 1 o 0");
            estadoElectoral = Integer.parseInt(lector.readLine());
        }
        
        if(estadoElectoral == 1){
            System.out.println("Ingrese nombre del local");
            nombreLocal = lector.readLine().toUpperCase();
            
            System.out.println("Ingrese numero de mesa del votante");
            numeroDeMesa = Integer.parseInt(lector.readLine());
            
            // Instanciación de la variable de Clase Votante.
            votanteNuevo = new Votante(nombreCompleto, rut, comuna, direccion, estadoElectoral, numeroDeMesa);
            
            if(valparaiso.agregarVotante(nombreLocal, votanteNuevo)){
                System.out.println("El votante se agrego con exito");
            }else System.out.println("El votante ya existe");
            
        }else{
            System.out.println("Ingrese la razon");
            String razon = lector.readLine().toUpperCase();
            NoVotante noVotanteNuevo = new NoVotante(nombreCompleto, rut, comuna, direccion, estadoElectoral,razon);
            if(valparaiso.agregarNoVotante(noVotanteNuevo)){
                System.out.println("El no votante se agrego con exito");
            }else System.out.println("El no votante ya existe");
        }
        
    }
    

    /**
     * Función 7: modificar datos de una persona.
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionModificarDatosPersona(Region valparaiso)throws IOException{
        String rut, nombreLocalNuevo;
        int numeroDeMesaNueva;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Se solicita ingresar el rut de la persona para realizar los cambios necesarios.
        System.out.println("Ingrese rut de la persona que necesite modificar datos");
        rut = lector.readLine();
        
        Votante v = valparaiso.buscarVotante(rut);
        if(v != null){
            Local a = valparaiso.obtenerLocalVotante(rut);
            
            int opcion = 0;
            while(opcion!= 1 && opcion!=2){
                System.out.println("1. Modificar número de mesa");
                System.out.println("2. Modificar Local");
                System.out.println("Ingrese opcion");
                opcion = Integer.parseInt(lector.readLine());
            }
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese numero de mesa nueva");
                    numeroDeMesaNueva = Integer.parseInt(lector.readLine());

                    if( valparaiso.modificarDatosVotante(v, a, numeroDeMesaNueva) ){
                        System.out.println("Los datos del votante fueron modificados");
                    }else System.out.println("No se modificaron los datos del votante");
                    break;
                
                case 2:
                    System.out.println("Ingrese nombre del local nuevo");
                    nombreLocalNuevo = lector.readLine();
                    
                    Local b = valparaiso.buscarLocal(nombreLocalNuevo);

                    if( valparaiso.modificarDatosVotante(v, a, b) ){
                        System.out.println("Los datos del votante fueron modificados");
                    }else System.out.println("No se modificaron los datos del votante");
            }
        
        }else{
            
            NoVotante nv = valparaiso.buscarNoVotante(rut);
            if(nv != null){
                System.out.println("Ingrese razon nueva");
                String razon = lector.readLine().toUpperCase();
                
                if( valparaiso.modificarDatosNoVotante(rut, razon) ){
                    System.out.println("Los datos del no votante fueron modificados");
                }else System.out.println("No se modificaron los datos del no votante");

            }else System.out.println("La persona no existe en el registro");
        
        }
   
    }


    /**
     * Función 8: elimina persona del registro
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionEliminarPersona(Region valparaiso) throws IOException{
        String rut;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese un RUT");
        rut = lector.readLine();
        
        if( valparaiso.eliminarVotante(rut) ){
            System.out.println("Votante eliminado");
        }else{
            if( valparaiso.eliminarNoVotante(rut) ){
                System.out.println("No Votante eliminado");
            }else System.out.println("Persona no eliminada");
        }
        
    }
    

    /**
     * Función 9: buscar una persona en el registro y mostrar sus datos.
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionBuscarPersona(Region valparaiso)throws IOException{        
        String rut;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();
        
        String[] datosPersona = valparaiso.obtenerDatosVotante(rut);
        
        if(datosPersona != null){

           // Se imprimen los datos del votante
           System.out.println("------------------------------------------");
           System.out.println("DATOS VOTANTE");
           System.out.println("------------------------------------------");
           System.out.println("NOMBRE: "+datosPersona[0]);
           System.out.println("RUT "+datosPersona[1]);
           System.out.println("COMUNA: "+datosPersona[2]);
           System.out.println("DIRECCION: "+datosPersona[3]);
           System.out.println("HABILITADO(A) PARA VOTAR: SI");
           System.out.println("LOCAL: "+datosPersona[5]);
           System.out.println("DIRECCION LOCAL: "+datosPersona[6]);
           System.out.println("NUMERO DE MESA: "+datosPersona[4]);
           System.out.println("------------------------------------------");
        }else{
            
            datosPersona = valparaiso.obtenerDatosNoVotante(rut);
            
            if(datosPersona != null){
                
                // Se imprimen los datos del no votante
                System.out.println("------------------------------------------");
                System.out.println("DATOS NO VOTANTE");
                System.out.println("------------------------------------------");
                System.out.println("NOMBRE: "+datosPersona[0]);
                System.out.println("RUT "+datosPersona[1]);
                System.out.println("COMUNA: "+datosPersona[2]);
                System.out.println("DIRECCION: "+datosPersona[3]);
                System.out.println("HABILITADO(A) PARA VOTAR: NO");
                System.out.println("RAZON: "+datosPersona[5]);
                System.out.println("------------------------------------------");
            }else System.out.println("La persona no existe en el registro");
                 
        }
        
       
    }

    /**
     * Funcion 10: muestra Votantes de un Local.
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionMostrarVotantesLocal(Region valparaiso) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el Nombre del local");
        String nombreLocal = lector.readLine().toUpperCase();
        
        Local a = valparaiso.buscarLocal(nombreLocal);
        
        if(a != null){
            System.out.println("Votantes del local: "+nombreLocal);
            System.out.println("Nombre\t\tRut\t\tComuna\t\tDireccion\t\tMesa");
            
            String[] rutsVotantes = valparaiso.obtenerRutsVotantes(a);
            
            for( int i = 0; i < rutsVotantes.length; i++){
                Votante v = valparaiso.buscarVotante(nombreLocal, rutsVotantes[i]);
                
                // Se imprimen datos
                System.out.println(v.getNombreCompleto()+"\t\t"+v.getRut()+"\t\t"+v.getComuna()+"\t\t"+v.getDireccion()+"\t\t"+v.getNumeroDeMesa());
            }
        }else System.out.println("No existe el local");
        
        
    }
    
    /**
     * Función 11: muestra todos los votantes de la región.
     * @param valparaiso Región de Valparaiso
     */
    public void funcionMostrarVotantes(Region valparaiso){
        
        if( valparaiso.obtenerCantidadLocales() > 0){
            
            String[] rutsVotantes = valparaiso.obtenerRutsVotantes();
            
            System.out.println("Votantes de la region de valparaiso");
            System.out.println("Nombre\t\tRut\t\tComuna\t\tDireccion\t\tLocal\t\tDireccion Local\t\tMesa");
            
            for(int i = 0; i < rutsVotantes.length; i++){     
                String[] datosVotante = valparaiso.obtenerDatosVotante(rutsVotantes[i]);        
                // Se imprimen datos
                    System.out.println(datosVotante[0]+"\t\t"+datosVotante[1]+"\t\t"+datosVotante[2]+"\t\t"+datosVotante[3]+"\t\t"+datosVotante[5]+"\t\t"+datosVotante[6]+"\t\t"+datosVotante[4]);
            }
        }
  
    }

    /**
     * Funcion 12: muestra el votante mas joven de un local especifico
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionMostrarVotanteMasJoven(Region valparaiso) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre del local");
        String nombreLocal = lector.readLine().toUpperCase();
        valparaiso.mostrarVotanteMasJoven(nombreLocal);
    }

    /**
     *  Funcion 13: muestra todos los votantes de un local en un intervalo
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionMostrarVotantesIntervalo(Region valparaiso) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre del local");
        String nombreLocal = lector.readLine().toUpperCase();
        valparaiso.mostrarVotantesIntervalo(nombreLocal);
    }
    
    /**
     * Función 14: Muestra todos los no votantes
     * @param valparaiso Región de Valparaiso
     * @throws IOException 
     */
    public void funcionMostrarNoVotantes(Region valparaiso)throws IOException{
        
        String[] rutsNoVotantes = valparaiso.obtenerRutsNoVotantes();
        int cantidadNoVotantes = rutsNoVotantes.length;

        if(cantidadNoVotantes > 0){
            System.out.println("No votantes de la region de valparaiso");
            System.out.println("Nombre\t\tRut\t\tComuna\t\tDireccion\t\tRazon");
        }

        for(int i = 0; i < cantidadNoVotantes; i++){
            String[] datosNoVotante = valparaiso.obtenerDatosNoVotante(rutsNoVotantes[i]);
            System.out.println(datosNoVotante[0]+"\t\t"+datosNoVotante[1]+"\t\t"+datosNoVotante[2]+"\t\t"+datosNoVotante[3]+"\t\t"+datosNoVotante[4]);
        }

    }
    
}