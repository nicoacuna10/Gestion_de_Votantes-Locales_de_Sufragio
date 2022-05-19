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
        
        /*  El local de nombre "SIN LOCAL" contiene los votantes que no están habiliatdos para votar, y por ende no se les
            puede asignar un local.
        */
        
        votante1 = new Votante("PEDRO ALBERTO LOPEZ GONZALEZ", "13800755-0", "VINA DEL MAR", "15 NORTE 567", 1, 50);
        valparaiso.agregarVotante("UNIVERSIDAD ANDRES BELLO", (Votante)votante1);
        
        votante2 = new Votante("PATRICIA CABRERO QUISPE", "8444987-2", "VALPARAISO", "CALLE ZENTENO 130", 1, 34);
        valparaiso.agregarVotante("PUCV CASA CENTRAL", votante2);
        
        votante3 = new Votante("JUAN RICARDO ASTORGA BERMUDEZ", "19731000-K", "CONCON", "CALLE CUATRO 111", 1, 1);
        valparaiso.agregarVotante("LICEO POLITECNICO CONCON", votante3);
        
        noVotante1 = new NoVotante("MARIA JUANA DE LOS ANGELES RIVEROS", "12888012-9", "SAN ANTONIO", "RUBEN DARIO 1073", 0,"CARCEL");
        valparaiso.agregarNoVotante(noVotante1);
        
        noVotante2 = new NoVotante("JUANA VALENTINA SANCHEZ ORTUZAR", "24898012-1", "VIÑA DEL MAR", "6 ORIENTE 458", 0,"MENOR DE EDAD");
        valparaiso.agregarNoVotante(noVotante2);

    }
    
    /*  Función 1: agregar local
    
    */
    public void funcionAgregarLocal(Region valparaiso)throws IOException{
        String nombre;
        String comuna;
        String direccion;
        int capacidadMaxima;
        int numeroPrimeraMesa;
        int numeroUltimaMesa;
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
        Local a = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        
        if( valparaiso.agregarLocal(a) == true){
            System.out.println("Se agregó local con exito");
        }else System.out.println("No se agregó el local.");
        
    }
    
    /*  Función 2: modificar datos de un local
    
    */
    public void funcionModificarDatosLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        String comuna;
        String direccion;
        int capacidadMaxima;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            
        System.out.println("Ingrese nombre nuevo del local");
        nombreLocal = lector.readLine().toUpperCase();   

        System.out.println("Ingrese comuna nueva del local");
        comuna = lector.readLine().toUpperCase();

        System.out.println("Ingrese direccion nueva del local");
        direccion = lector.readLine().toUpperCase();

        System.out.println("Ingrese capacidad maxima nueva del local");
        capacidadMaxima = Integer.parseInt(lector.readLine());
        
        if( valparaiso.modificarDatosLocal(nombreLocal, comuna, direccion, capacidadMaxima) == true ){
            System.out.println("El local fue modificado con exito");
        }else System.out.println("No existe Local");
        
    }
    
    /*  Función 3: eliminar local
    
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
    
    /*  Función 4: consultar (buscar y mostrar) datos de un local.
        Ademas se da la posibilidad de buscar y mostrar en otro nivel
    */
    public void funcionConsultarDatosLocal(Region valparaiso)throws IOException{
        String nombreLocal;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = lector.readLine().toUpperCase();

        if( valparaiso.mostrarDatosLocal(nombreLocal.toUpperCase()) == true ){
            //System.out.println("Se mostraron los datos del local con exito");
            
            System.out.println("¿Desea consultar datos de algun votante de este Local?");
            System.out.println("Por favor escriba SI o NO");
            String respuesta = lector.readLine();
            if((respuesta.toUpperCase()).equals("SI")){
                System.out.println("Escriba el RUT del usuario");
                String rut = lector.readLine();
                Votante v = valparaiso.buscarVotante(rut);
                if(v!=null){
                    System.out.println(v.getNombreCompleto()+" esta en el local "+nombreLocal.toUpperCase());
                    System.out.println("¿Desea consultar los datos del usuario?");
                    System.out.println("Por favor escriba SI o NO");
                    respuesta = lector.readLine();
                    if((respuesta.toUpperCase()).equals("SI"))valparaiso.mostrarDatosVotante(rut);
                    System.out.println("--------------------------------------------------------");
                }
                if(v == null)System.out.println("No esta dicha persona en el local "+nombreLocal.toUpperCase());
            }
                    
        }else System.out.println("No existe Local");
        
    
    }
    
    /*  Función 5: mostrar los locales de la región.
    
    */
        public void funcionMostrarLocales(Region valparaiso){
        System.out.println("Locales de votacion de la region de Valparaiso");
        valparaiso.mostrarLocales();
    }
    
    
    /* Función 6: agrega un nuevo votante.
    
    */
    public void funcionAgregarVotante(Region valparaiso)throws IOException{
        String nombreLocal;
        Votante votanteNuevo;
        String nombreCompleto;
        String rut;
        String comuna;
        String direccion;
        int estadoElectoral;
        int numeroDeMesa;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Solicitud de ingreso de datos del votante.
        System.out.println("Ingrese nombre completo del votante");
        nombreCompleto = lector.readLine().toUpperCase();

        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();

        System.out.println("Ingrese comuna de domicilio del votante");
        comuna = lector.readLine().toUpperCase();

        System.out.println("Ingrese dirección de domicilio del votante");
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
            
            if(valparaiso.agregarVotante(nombreLocal, (Votante)votanteNuevo) == false){
                System.out.println("El votante ya existe");
                return;
            }else System.out.println("El votante se agrego con exito");
            
        }else{
            System.out.println("Ingrese la razon");
            String razon = lector.readLine().toUpperCase();
            NoVotante noVotanteNuevo = new NoVotante(nombreCompleto, rut, comuna, direccion, estadoElectoral,razon);
            valparaiso.agregarNoVotante(noVotanteNuevo);
        }
        
    }
    
    /* Función 7: modifica datos de un votante.
    
    */
    public void funcionModificarDatosVotante(Region valparaiso)throws IOException{
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
        nombreLocalNuevo = lector.readLine().toUpperCase();

        System.out.println("Ingrese numero de mesa");
        numeroMesaNueva = Integer.parseInt(lector.readLine());
 
        System.out.println("Ingrese comuna (si es la misma de la direccion anterior, ingresela ingualmente)");
        comunaNueva = lector.readLine().toUpperCase();
        
        System.out.println("Ingrese direccion nueva del domicilio");
        direccionNueva = lector.readLine().toUpperCase();

        
        if( valparaiso.modificarDatosVotante(rut, nombreLocalNuevo, numeroMesaNueva, comunaNueva, direccionNueva) == true){
            System.out.println("Los datos del votante fueron modificados");
        }else System.out.println("No se modificaron los datos");
        
    }

    /* Función 8: elimina votante del registro
    
    */
    public void funcionEliminarVotante(Region valparaiso) throws IOException{
        String rut;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese un RUT");
        rut = lector.readLine();
        
        if( valparaiso.eliminarVotante(rut) == true){
            System.out.println("Votante eliminado");
        }else System.out.println("No existe votante");
        
    }
    
    /* Función 9: muestra los datos del votante.
    
    */
    public void funcionConsultarDatosVotante(Region valparaiso)throws IOException{        
        String rut;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();
        
        valparaiso.mostrarDatosVotante(rut);
    }
    
   
    /* función 10: mostrar Votantes
    
    */
    public void funcionMostrarVotantes(Region valparaiso){
        valparaiso.mostrarVotantes();
        valparaiso.mostrarDatos();
    }
    

    /* funcion 11: muestra Votantes por Local
    
    */
    public void funcionMostrarVotantesPorLocal(Region valparaiso) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el Nombre del local");
        String nombreLocal = lector.readLine().toUpperCase();
        valparaiso.mostrarVotantesLocal(nombreLocal);
    }
    /*funcion 12: busca un usuario mediante su rut y luego hace que se identifique
    
    */
    public void funcionIdentificarse(Region valparaiso) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del usuario");
        String rut = lector.readLine();
        valparaiso.consultarTipoUsuario(rut);
    }
    /* Función 13: exportar
    
    */
    public void funcionExportar(String nombreArchivo, Region valparaiso){
        valparaiso.exportar(nombreArchivo);
    }
}