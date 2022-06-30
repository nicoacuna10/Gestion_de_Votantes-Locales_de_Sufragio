package Modelo;

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
        
        Votante votante4 = new Votante("PEDRO ANGEL LOPEZ QUISPE", "23845755-1", "VINA DEL MAR", "10 NORTE 567", 1, 25);
        valparaiso.agregarVotante("UNIVERSIDAD ANDRES BELLO", votante4);
        
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
     * Función 6: agregar una nueva persona.
     * @param valparaiso Región de Valparaiso
     * @throws IOException Excepcion Input/Output
     */
    public void funcionAgregarPersona(Region valparaiso)throws IOException, RutException{
        Votante votanteNuevo;
        String nombreLocal, nombreCompleto, rut, comuna, direccion;
        int estadoElectoral, numeroDeMesa;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Solicitud de ingreso de datos de la persona.
        System.out.println("Ingrese nombre completo de la persona");
        nombreCompleto = lector.readLine().toUpperCase();

        System.out.println("Ingrese rut del persona, Formato: 11222333-4");
        rut = lector.readLine();
        try {
            if(rut.indexOf('-')==-1 || rut.length()<9 || rut.length()>10){
                throw new RutException();
            }
        } catch (RutException e) {
            String rutAux = rut;
            while(rutAux.length()<9 || rutAux.length()<9 || rutAux.indexOf('-')==-1){
                System.out.println("Ingrese nuevamente el rut");
                if(rut.length()>9 && rut.length()<11)break;
                if(rut.indexOf('-')!=-1)break;
                rutAux = lector.readLine();
                rut=rutAux;
            }              
        }

        System.out.println("Ingrese comuna de domicilio de la persona");
        comuna = lector.readLine().toUpperCase();

        System.out.println("Ingrese dirección de domicilio de la persona, formato: CALLE #NUMERO");
        direccion = lector.readLine().toUpperCase();
        try {
            if(direccion.indexOf('#')==-1) throw new DireccionException();
        } catch (DireccionException e) {
            while (direccion.indexOf('#')==-1) {
                System.out.println("Ingrese nuevamente la direccion en el formato: CALLE #NUMERO");
                direccion=lector.readLine().toUpperCase();
            }
        }
        /*
        try{
            direccion = lector.readLine();
        }catch(DireccionException){
            e.printStackTrace();
            while(){
                ...
            }
        }
        */
        
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
     * @throws IOException Excepcion Input/Output
     */
    public void funcionModificarDatosPersona(Region valparaiso)throws IOException,RutException{
        String rut, nombreLocalNuevo;
        int numeroDeMesaNueva;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Se solicita ingresar el rut de la persona para realizar los cambios necesarios.
        System.out.println("Ingrese rut de la persona que necesite modificar datos, formato: 11222333-4");
        rut = lector.readLine();
        try {
            if(rut.indexOf('-')==-1 || rut.length()<9 || rut.length()>10){
                throw new RutException();
            }
        } catch (RutException e) {
            String rutAux = rut;
            while(rutAux.length()<9 || rutAux.length()<9 || rutAux.indexOf('-')==-1){
                System.out.println("Ingrese nuevamente el rut");
                if(rut.length()>9 && rut.length()<11)break;
                if(rut.indexOf('-')!=-1)break;
                rutAux = lector.readLine();
                rut=rutAux;
            }              
        }
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
}