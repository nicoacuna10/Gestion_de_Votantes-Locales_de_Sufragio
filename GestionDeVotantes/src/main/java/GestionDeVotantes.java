import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */


public class GestionDeVotantes {

    public static void main(String[] args) {
        
        System.out.println(" -----------------------------------------");
        System.out.println("| Gestion de Votantes-Locales de votacion |");
        System.out.println(" -----------------------------------------");
        
        // Mapa de registro de votantes, con clave String rut del votante
        Map <String, Votante> registroDeVotantes = new LinkedHashMap <String, Votante>();
        
        // Mapa de registro de locales, con clave String nombre del local
        Map <String, Local> registroDeLocales = new LinkedHashMap <String, Local>();
        
        
        // Testing
        Votante v1 = new Votante("Pedro Mauricio Lopez Gomez", "15660899-0", 35, "Vina del Mar", "Avenida del lago 89", 1, 1, "Colegio X1-AE", 28);
        Votante v2 = new Votante("Maria Margarita Abarca Obrador", "10981544-8", 53, "Quilpue", "Avenida los carrera 100", 1, 0, "Colegio Aconcagua", 9);
        
        registroDeVotantes.put(v1.getRut(), v1);
        registroDeVotantes.put(v2.getRut(), v2);
        
        Votante aux1 = registroDeVotantes.get("15660899-0");
        Votante aux2 = registroDeVotantes.get("10981544-8");
        
        
        System.out.println("El(La) votante "+aux1.getNombreCompleto()+" vota en la mesa "+aux1.getNumeroDeMesa()+" del local "+aux1.getLocalAsignado());
        System.out.println("El(La) votante "+aux2.getNombreCompleto()+" vive en la comuna de "+aux1.getComuna()+" y tiene "+aux1.getEdad()+" anios");
        
        
    }
    
}