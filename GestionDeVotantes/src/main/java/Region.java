import java.util.*;
import java.io.*;

/**
 *
 * @author Nicolás Acuña
 */
public class Region {
    
    // Creación de mapas.
    Map <String, Local> registroLocalesNombre; // Mapa de Locales con clave el nombre.
    Map <String, Votante> registroVotantesRut; // Mapa de Votantes con clave el rut.
    
    // Constructor de la Clase Region.
    public Region(){
        this.registroLocalesNombre = new LinkedHashMap();
        this.registroVotantesRut = new LinkedHashMap();
    }
    
    // Método agregar local, sin parámetros
    public void agregarLocal()throws IOException{
        // Variables locales del metodo.
        String nombre;
        String comuna;
        String direccion;
        int capacidadMaxima;
        int numeroPrimeraMesa;
        int numeroUltimaMesa;
        String auxNumero; // Variable utilizada para obtener un string que posteriormente se convertira en entero.
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Solicitud de ingreso de datos del local.
        System.out.println("Ingrese dirección del local");
        nombre = lector.readLine();
        
        System.out.println("Ingrese dirección del local");
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
        Local aux = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        
        // Inserción del los datos del local nuevo en el mapa respectivo, con la clave el nombre.
        registroLocalesNombre.put(aux.getNombreLocal(), aux);
    
    }
    
    // Método agregar local, con parámetros String, String e int.
    public void agregarLocal(String nombre, String comuna, int numeroDeMesaVotanteNuevo)throws IOException{
        // Variables locales del metodo.
        String direccion;
        int capacidadMaxima;
        int numeroPrimeraMesa;
        int numeroUltimaMesa;
        String auxNumero; // Variable utilizada para obtener un string que posteriormente se convertira en entero.
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Solicitud de ingreso de datos del local.
        System.out.println("Ingrese dirección del local");
        direccion = lector.readLine();
        
        System.out.println("Ingrese capacidad maxima del local");
        auxNumero = lector.readLine();
        capacidadMaxima = Integer.parseInt(auxNumero);
        
        System.out.println("Ingrese el numero de la primera mesa");
        auxNumero = lector.readLine();
        numeroPrimeraMesa = Integer.parseInt(auxNumero);
        while(numeroPrimeraMesa > numeroDeMesaVotanteNuevo || numeroPrimeraMesa < 1){
            System.out.println("Ingrese numero de mesa valido");
            auxNumero = lector.readLine();
            numeroPrimeraMesa = Integer.parseInt(auxNumero);
        }
        
        System.out.println("Ingrese el numero de la ultima mesa");
        auxNumero = lector.readLine();
        numeroUltimaMesa = Integer.parseInt(auxNumero);
        while(numeroUltimaMesa < numeroDeMesaVotanteNuevo){
            System.out.println("Ingrese numero de mesa valido");
            auxNumero = lector.readLine();
            numeroUltimaMesa = Integer.parseInt(auxNumero);
        }
        
        // Instanciación de la variable de Clase Local.
        Local aux = new Local(nombre, comuna, direccion, capacidadMaxima, numeroPrimeraMesa, numeroUltimaMesa);
        
        // Inserción del los datos del local nuevo en el mapa respectivo, con la clave el nombre.
        registroLocalesNombre.put(aux.getNombreLocal(), aux);
    }
    
    // Método buscar local, sin parámetros.
    public Local buscarLocal()throws IOException{
        String nombre;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre del local");
        nombre = lector.readLine();
        
        return registroLocalesNombre.get(nombre);
    
    }
    
    
    // Método buscar local.
    public Local buscarLocal(String nombre){
        return registroLocalesNombre.get(nombre);
    }
    
    // Método agregar votante.
    public Votante agregarVotante()throws IOException{
        // Variables locales del método..
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
        Votante aux = new Votante(nombreCompleto, rut, comuna, direccion, estadoElectoral, localAsignado, numeroDeMesa);
        
        // Inserción del los datos del votante nuevo en el mapa respectivo, con la clave el rut.
        registroVotantesRut.put(aux.getRut(), aux);
        
        return aux;
    }
    
    // Método modificar datos del votante.
    public void modificarDatosVotante(String rut){
        //Votante aux = registroVotantesRut.get(rut);
        
        // Se solicita los datos a modificar
    }
    
    // Método consultar datos del votante.
    public void consultarDatosVotante()throws IOException{
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        String rut;
        System.out.println("Ingrese rut del votante");
        rut = lector.readLine();
        
        Votante auxV = registroVotantesRut.get(rut);
        Local auxL = registroLocalesNombre.get(auxV.getLocalAsignado());

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
        
        
    }
    
    // getters y setters
    public Map getRegistroLocalesNombre(){
        return registroLocalesNombre;
    }
    
    public Map getRegistroVotantesRut(){
        return registroVotantesRut;
    }
    
    public void setRegistroLocalesNombre(Map registroLocalesNombre){
        this.registroLocalesNombre = registroLocalesNombre;
    }
    
    public void setRegistroVotantesRut(Map registroVotantesRut){
        this.registroVotantesRut = registroVotantesRut;
    }
}
