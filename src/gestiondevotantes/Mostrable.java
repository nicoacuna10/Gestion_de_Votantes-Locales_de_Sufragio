package gestiondevotantes;

/**
 * Interfaz Mostrable
 * @author jpail
 */
public interface Mostrable {
    public Votante buscarVotante(String rut);
    public boolean eliminarVotante(String rut);
}
