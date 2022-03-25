import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.LinkedHashMap;
import java.util.Map;

import java.io.*;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */


public class GestionDeVotantes {
    
    // Función agregar votante al registro.
    static void agregarVotante(Map registroDeVotantes, Map registroDeLocales) throws IOException{
        
        // Variables locales (auxiliares)
        String auxNombreCompleto;
        String auxRut;
        int auxEdad;
        String auxComuna;
        String auxDireccion;
        int auxEstadoElectoral;
        int auxVocalDeMesa;
        String auxLocalAsignado;
        int auxNumeroDeMesa;
        
        // Variable utilizada para obtener las entradas que posteriormente serán convertidas a enteros
        String auxNumeros;
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Se pregunta los datos del votante
        System.out.println("Ingrese nombre completo del votante");
        auxNombreCompleto = lector.readLine();
        
        System.out.println("Ingrese rut del votante (sin puntos)");
        auxRut = lector.readLine();
        
        System.out.println("Ingrese edad del votante");
        auxNumeros = lector.readLine();
        auxEdad = Integer.parseInt(auxNumeros);
        
        System.out.println("Ingrese comuna del votante");
        auxComuna = lector.readLine();
        
        System.out.println("Ingrese direccion del votante");
        auxDireccion = lector.readLine();
        
        System.out.println("Ingrese 1 si el votante esta habilitado para votar (0 caso contrario)");
        auxNumeros = lector.readLine();
        auxEstadoElectoral = Integer.parseInt(auxNumeros);
        
        System.out.println("Ingrese 1 si el votante fue designado vocal de mesa (0 caso contrario)");
        auxNumeros = lector.readLine();
        auxVocalDeMesa = Integer.parseInt(auxNumeros);
        
        System.out.println("Ingrese el nombre del local asignado");
        auxLocalAsignado = lector.readLine();
        
        System.out.println("Ingrese la mesa asignada");
        auxNumeros = lector.readLine();
        auxNumeroDeMesa = Integer.parseInt(auxNumeros);
        
        // Se almacenan los datos en una variable de tipo votante
        Votante auxVotante = new Votante(auxNombreCompleto, auxRut, auxEdad, auxComuna, auxDireccion, auxEstadoElectoral, auxVocalDeMesa, auxLocalAsignado, auxNumeroDeMesa);
        
        // Se inserta el votante en el registro de votantes, con clave el rut.
        registroDeVotantes.put(auxVotante.getRut(), auxVotante);
        
        
        // Se verifica la existencia del local. Si no existe, se pide ingresar los datos respectivos
        if( registroDeLocales.get(auxVotante.getLocalAsignado()) == null){
            
            int auxCapacidadMaxima;
            int primeraMesa;
            int ultimaMesa;
            
            // Se pregunta datos del local de votación.
            System.out.println("Ingrese la capacidad maxima del local");
            auxNumeros = lector.readLine();
            auxCapacidadMaxima = Integer.parseInt(auxNumeros);
            
            System.out.println("Ingrese el numero de la primera mesa del local");
            auxNumeros = lector.readLine();
            primeraMesa = Integer.parseInt(auxNumeros);
            
            System.out.println("Ingrese el numero de la ultima mesa del local");
            auxNumeros = lector.readLine();
            ultimaMesa = Integer.parseInt(auxNumeros);
            
            // Los datos se guardan en una variable auxiliar de tipo Local.
            Local auxLocalNuevo = new Local(auxVotante.getLocalAsignado(), auxVotante.getComuna(), auxCapacidadMaxima, (ultimaMesa-primeraMesa)+1);
            
            // Se insertan los numeros de informacion de las mesas en la lista.
            for(int index = primeraMesa; index <= ultimaMesa; index++){
                
                auxLocalNuevo.getListaDeMesas().add(index);
                
            }
            
        }
        
    }
    
    // Función principal de la clase
    public static void main(String[] args) throws IOException{
        
        System.out.println(" -----------------------------------------");
        System.out.println("| Gestion de Votantes-Locales de votacion |");
        System.out.println(" -----------------------------------------");
        
        // Mapa de registro de votantes, con clave String rut del votante
        Map <String, Votante> registroDeVotantes = new LinkedHashMap <String, Votante>();
        
        // Mapa de registro de locales, con clave String nombre del local
        Map <String, Local> registroDeLocales = new LinkedHashMap <String, Local>();
        
        
        // MENU
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            
            System.out.println("MENU");
            System.out.println("1. Agregar votante al registro");
            System.out.println("2. Modificar datos del votante");
            System.out.println("3. Consultar datos electorales");
            System.out.println("4. Mostrar los ruts de los votantes de una mesa");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        agregarVotante(registroDeVotantes, registroDeLocales);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        

        /*
        // Testing
        Votante aux1 = registroDeVotantes.get("10000000-5");
        
        System.out.println("El votante "+aux1.getNombreCompleto()+" de la comuna de "+aux1.getComuna()+" vota en "+aux1.getLocalAsignado());
        */
        
        
    }
    
}
