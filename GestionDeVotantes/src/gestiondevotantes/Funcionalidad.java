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
    
    
    public void MostrarDatosUsuarios (Region valparaiso){
        valparaiso.mostrarTodosVotantes();
    }
    public String leerDatos() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dato = leerDatos();
        return dato;
    }
    
    // Funcion inicial: llena las colecciones.
    public Region funcionInicial(Region valparaiso){
    
        Local local1;
        Local local2;
        Local local3;
        Votante votante1;
        Votante votante2;
        Votante votante3;
        Mesa mesa1;
        Mesa mesa2;
        Mesa mesa3;
        
        votante1 = new Votante("PEDRO ALBERTO LOPEZ GONZALEZ", "13800755-0", "VINA DEL MAR", "15 NORTE 567", 1, "UNIVERSIDAD ANDRES BELLO", 50);
        valparaiso.agregarVotante(votante1);
        
        votante2 = new Votante("PATRICIA CABRERO QUISPE", "8444987-2", "VALPARAISO", "CALLE ZENTENO 130", 1, "PUCV CASA CENTRAL", 34);
        valparaiso.agregarVotante(votante2);
        
        votante3 = new Votante("JUAN RICARDO ASTORGA BERMUDEZ", "19731000-K", "CONCON", "CALLE CUATRO 111", 1, "LICEO POLITECNICO CONCON", 1);
        valparaiso.agregarVotante(votante3);
        
        local1 = new Local("UNIVERSIDAD ANDRES BELLO", "VINA DEL MAR", "QUILLOTA 980", 10002, 31, 70);
        local1.agregarMesa(local1.getNumeroPrimeraMesa(), local1.getNumeroUltimaMesa());
        mesa1 = local1.buscarMesa(votante1.getNumeroDeMesa());
        valparaiso.agregarLocal(local1);
        
        local2 = new Local("PUCV CASA CENTRAL", "VALPARAISO", "BRASIL 2950", 3000, 21, 35);
        local2.agregarMesa(local2.getNumeroPrimeraMesa(), local2.getNumeroUltimaMesa());
        mesa2 = local2.buscarMesa(votante2.getNumeroDeMesa());
        valparaiso.agregarLocal(local2);
        
        local3 = new Local("LICEO POLITECNICO CONCON", "CONCON", "PORVENIR 865", 1500, 1, 7);
        local3.agregarMesa(local3.getNumeroPrimeraMesa(), local3.getNumeroUltimaMesa());
        mesa3 = local3.buscarMesa(votante3.getNumeroDeMesa());
        valparaiso.agregarLocal(local3);

        return valparaiso;
    }
    
    // Función 1: agrega un nuevo votante.
    public Region funcionAgregarVotante(Region valparaiso)throws IOException{
        
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
        

        // Solicitud de ingreso de datos del votante.
        System.out.println("Ingrese nombre completo del usuario");
        nombreCompleto = leerDatos();

        System.out.println("Ingrese rut del usuario");
        rut = leerDatos();

        System.out.println("Ingrese comuna de domicilio del usuario");
        comuna = leerDatos();

        System.out.println("Ingrese dirección de domicilio del usuario");
        direccion = leerDatos();

        System.out.println("Ingrese 1 si el usuario esta habilitado para votar, 0 caso contrario");
        estadoElectoral = Integer.parseInt(leerDatos());
        while(estadoElectoral != 1 && estadoElectoral != 0){
            System.out.println("Ingrese un numero valido, 1 o 0");
            estadoElectoral = Integer.parseInt(leerDatos());
        }

        if(estadoElectoral==0){
            System.out.println("El usuario "+nombreCompleto+" no esta habilitado para votar");
            auxV = new Votante(nombreCompleto, rut, comuna, direccion, estadoElectoral);
            votanteExistente = valparaiso.buscarVotante(rut);
            if(votanteExistente==null){
                valparaiso.agregarVotante(auxV);
                
            }
        }else{
            System.out.println("Ingrese Nombre del Local Asignado");
            localAsignado = leerDatos();

            System.out.println("Ingrese numero de mesa del votante");
            numeroDeMesa = Integer.parseInt(leerDatos());

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
                direccion = leerDatos();

                System.out.println("Ingrese capacidad maxima del local");
                capacidadMaxima = Integer.parseInt(leerDatos());

                System.out.println("Ingrese el numero de la primera mesa");
                numeroPrimeraMesa = Integer.parseInt(leerDatos());
                while(numeroPrimeraMesa > auxV.getNumeroDeMesa() || numeroPrimeraMesa < 1){
                    System.out.println("Ingrese numero de mesa valido");
                    numeroPrimeraMesa = Integer.parseInt(leerDatos());
                }

                System.out.println("Ingrese el numero de la ultima mesa");
                numeroUltimaMesa = Integer.parseInt(leerDatos());
                while(numeroUltimaMesa < auxV.getNumeroDeMesa()){
                    System.out.println("Ingrese numero de mesa valido");
                    numeroUltimaMesa = Integer.parseInt(leerDatos());
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
        }
        return valparaiso;
    
    }
    
    // Función 2: modifica datos de un votante.
    public Region funcionModificarDatosVotante(Region valparaiso)throws IOException{
        Votante auxV;
        Local auxL1;
        Local auxL2;
        Mesa auxM;
        String rut;
        String nombreLocalNuevo;
        int numeroDeMesa;
        String direccionNueva;
        String comuna;
        
        
        // Se solicita ingresar el rut del votante para realizar los cambios necesarios.
        System.out.println("Ingrese rut del votante que necesite modificar dato");
        rut = leerDatos();
        
        // Se busca en el registro. Si no lo encuentra.
        auxV = valparaiso.buscarVotante(rut);
        
        if(auxV == null){
            System.out.println("No se encontro el votante en el registro");
            return valparaiso;
        }
        
        // Se busca el local actual del votante.
        auxL1 = valparaiso.buscarLocal(auxV.getLocalAsignado());

        // Se le pide ingresar el nombre del local nuevo. Si no se encuentra, se le pide que ingrese otro.
        System.out.println("Ingrese nombre del local a cambiar");
        nombreLocalNuevo = leerDatos();
        auxL2 = valparaiso.buscarLocal(nombreLocalNuevo);

        while(auxL2 == null){
            System.out.println("Nombre del local no existe en el registro, ingrese otro");
            nombreLocalNuevo = leerDatos();
            auxL2 = valparaiso.buscarLocal(nombreLocalNuevo);
        }

        // Se busca la mesa actual del votante.
        auxM = auxL1.buscarMesa(auxV.getNumeroDeMesa());
        // Se elimina el rut del votante de la lista de ruts de votantes de la mesa.

        // Se modifica el local del votante.
        auxV.setLocalAsignado(nombreLocalNuevo);

        // Se le pide que ingrese la mesa del local nuevo.
        System.out.println("Ingrese numero de mesa");
        numeroDeMesa = Integer.parseInt(leerDatos());

        while(numeroDeMesa < auxL2.getNumeroPrimeraMesa() || numeroDeMesa > auxL2.getNumeroUltimaMesa()){
            System.out.println("Ingrese numero de mesa valido");
            numeroDeMesa = Integer.parseInt(leerDatos());
        }

        // Se modifica el número de mesa.
        auxV.setNumeroDeMesa(numeroDeMesa);

        // Se busca la mesa nueva del votante.
        auxM = auxL2.buscarMesa(auxV.getNumeroDeMesa());
        // Se agrega el rut del votante a la lista de ruts de votantes de la mesa nueva.
        
        
        // Se le pide ingresar la dirección nueva del domicilio.
        System.out.println("Ingrese direccion nueva del domicilio");
        direccionNueva = leerDatos();

        // Se modifica la dirección.
        auxV.setDireccion(direccionNueva);

        // Se le pide ingresar la comuna. Aunque no cambie, se le pide que la ingrese nuevamente.
        System.out.println("Ingrese comuna (si es la misma de la direccion anterior, ingresela ingualmente)");
        comuna = leerDatos();

        // Se modifica la comuna (en caso que sea la misma, no hay cambios).
        auxV.setComuna(comuna);
        
        return valparaiso;
    }
    
    // Función 3: elimina votante del registro
    public Region funcionEliminarVotante(Region valparaiso) throws IOException{
        //if(valparaiso == null)System.out.println("No hay votantes en Valparaiso");
        //valparaiso.
        System.out.println("Ingrese un RUT");
        String rut = leerDatos();
        Votante v = valparaiso.eliminarVotante(rut);
        if(v == null)System.out.println("En el registro no existe el rut ingresado");
        System.out.println("Se ha Eliminado a " +v.getNombreCompleto()+" del registro");
        return valparaiso;
    }
    
    // Función 4: muestra los datos del votante.
    public void funcionConsultarDatosVotante(Region valparaiso)throws IOException{
        Votante auxV;
        Local auxL;
        
        
        String rut;
        System.out.println("Ingrese rut del votante");
        rut = leerDatos();
        
        auxV = valparaiso.buscarVotante(rut);
        
        if(auxV != null){
            auxL = valparaiso.buscarLocal(auxV.getLocalAsignado());
            valparaiso.mostrarDatosVotante(auxV, auxL);
        }else System.out.println("El votante no existe en el registro");
    }
    
    // Función 5: agrega un nuevo local.
    public Region funcionAgregarLocal(Region valparaiso)throws IOException{
        String nombre;
        String comuna;
        String direccion;
        int capacidadMaxima;
        int numeroPrimeraMesa;
        int numeroUltimaMesa;
        boolean agregado;
        
        
        
        // Solicitud de ingreso de datos del local.
        System.out.println("Ingrese nombre del local");
        nombre = leerDatos();
        
        System.out.println("Ingrese comuna del local");
        comuna = leerDatos();
        
        System.out.println("Ingrese dirección del local");
        direccion = leerDatos();
        
        System.out.println("Ingrese capacidad maxima del local");
        capacidadMaxima = Integer.parseInt(leerDatos());
        
        System.out.println("Ingrese el numero de la primera mesa");
        numeroPrimeraMesa = Integer.parseInt(leerDatos());
        while(numeroPrimeraMesa < 1){
            System.out.println("Ingrese numero de mesa valido");
            numeroPrimeraMesa = Integer.parseInt(leerDatos());
        }
        
        System.out.println("Ingrese el numero de la ultima mesa");
        numeroUltimaMesa = Integer.parseInt(leerDatos());
        while(numeroUltimaMesa < numeroPrimeraMesa){
            System.out.println("Ingrese numero de mesa valido");
            numeroUltimaMesa = Integer.parseInt(leerDatos());
        }
        
        // Instanciación de la variable de Clase Local.
        Local auxL = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        agregado = valparaiso.agregarLocal(auxL);
        
        if(agregado){
            // Se agregan las mesas.
            auxL.agregarMesa(numeroPrimeraMesa, numeroUltimaMesa);
        }else System.out.println("No se agrego el local.");
        
        return valparaiso;
    }
    
    // Función 6: modifica datos del local.
    public Region funcionModificarDatosLocal(Region valparaiso)throws IOException{
        
        Local auxL;
        String nombreLocal;
        String comuna;
        String direccion;
        int capacidadMaxima;
        
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = leerDatos();
        
        auxL = valparaiso.buscarLocal(nombreLocal);
        
        if(auxL != null){
            
            System.out.println("Ingrese nombre nuevo del local");
            nombreLocal = leerDatos();
            auxL.setNombreLocal(nombreLocal);    
            
            System.out.println("Ingrese comuna nueva del local");
            comuna = leerDatos();
            auxL.setComuna(comuna);
            
            System.out.println("Ingrese direccion nueva del local");
            direccion = leerDatos();
            auxL.setDireccion(direccion);
            
            System.out.println("Ingrese capacidad maxima nueva del local");
            capacidadMaxima = Integer.parseInt(leerDatos());
            auxL.setCapacidadMaxima(capacidadMaxima);
            
            System.out.println("El local fue modificado con exito");
        
        }else System.out.println("No se encontro el local");
    
        return valparaiso;
    }
    
    // Función 7: elimina local del registro.
    public Region funcionEliminarLocal(Region valparaiso)throws IOException{
        
        boolean eliminado;
        String nombreLocal;
        
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = leerDatos();
        
        eliminado = valparaiso.eliminarLocal(nombreLocal);
        
        if(eliminado){
            System.out.println("El local fue eliminado con exito");
        }else System.out.println("No se elimino local");
        
        
        return valparaiso;
    }
    
    // Función 8: busca y muestra los datos del local.
    public void funcionConsultarDatosLocal(Region valparaiso)throws IOException{
        
        Local auxL;
        String nombreLocal;
        
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = leerDatos();
        
        // Búsqueda de local.
        auxL = valparaiso.buscarLocal(nombreLocal);
        
        if(auxL != null){
            valparaiso.mostrarDatosLocal(auxL);
        }else System.out.println("El local no existe en el registro");
    
    }
    
    
    // Función 9: muestra los locales de votacion de la región.
    public void funcionMostrarLocales(Region valparaiso){
        System.out.println("Locales de votacion de la region de Valparaiso");
        valparaiso.mostrarLocales();
    }
    
    // Función 10: agrega mesa al local.
    public Region funcionAgregarMesa(Region valparaiso)throws IOException{
        
        Local auxL;
        String nombreLocal;
        int numeroMesaNueva;
        
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = leerDatos();
        
        auxL = valparaiso.buscarLocal(nombreLocal);
        //Ya no se pide numero de la mesa nueva, se agrega automaticamente al final
        
            System.out.println("MESAS DISPONIBLES ANTERIORMENTE : " + auxL.getNumeroUltimaMesa() );
        
            numeroMesaNueva = (auxL.getNumeroUltimaMesa() + 1);
            auxL.agregarMesa(numeroMesaNueva);
            auxL.setNumeroUltimaMesa(numeroMesaNueva);
            
            System.out.println("MESAS DISPONIBLES AHORA : " + auxL.getNumeroUltimaMesa());
        
        return valparaiso;
    
    }
    
    // Función 11: modifica datos de la mesa.
    public Region funcionModificarDatosMesa(Region valparaiso)throws IOException{
        
        Local auxL;
        Mesa auxM;
        String nombreLocal;
        int numeroDeMesa;
        int capacidadMaxima;
        
        
        System.out.println("Ingrese nombre local");
        nombreLocal = leerDatos();
        
        auxL = valparaiso.buscarLocal(nombreLocal);
        
        System.out.println("Ingrese numero de mesa");
        numeroDeMesa = Integer.parseInt(leerDatos());
        
        auxM = auxL.buscarMesa(numeroDeMesa);
        
        System.out.println("Ingrese capacidad maxima nueva");
        capacidadMaxima = Integer.parseInt(leerDatos());
        auxM.setCapacidadMaxima(capacidadMaxima);       
        
        return valparaiso;
    }
    
    // Función 12: elimina mesa del local.
    public Region funcionEliminarMesa(Region valparaiso)throws IOException{
        
        Local auxL;
        Mesa auxM;
        String nombreLocal;
        int numeroDeMesa;
        
        
        System.out.println("Ingrese nombre del local");
        nombreLocal = leerDatos();
        
        auxL = valparaiso.buscarLocal(nombreLocal);
      
        System.out.println("La mesa a eliminar es : Mesa " + auxL.getNumeroUltimaMesa());
        //Se elimina la mesa y se reasigna la variable
        auxL.eliminarMesa(auxL.getNumeroUltimaMesa());
        auxL.setNumeroUltimaMesa((auxL.getNumeroUltimaMesa() - 1));
        
        
        return valparaiso;
    }
    
    // Función 13: muestra las mesas de un local.
    public void funcionMostrarMesas(Region valparaiso)throws IOException{
        // Variables auxiliares
        Local auxL;
        String nombre;
        
        
        System.out.println("Ingrese nombre del local");
        nombre = leerDatos();
        
        auxL = valparaiso.buscarLocal(nombre);
        if(auxL != null){
            System.out.println("Lista de mesas del local "+auxL.getNombreLocal());
            auxL.mostrarMesas();
            
        }else System.out.println("El local no existe en el registro");
    }
    

}
