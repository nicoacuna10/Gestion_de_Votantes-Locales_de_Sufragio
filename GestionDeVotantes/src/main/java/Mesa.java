import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Mesa {
    
    private int numeroDeMesa;
    private int cantidadDeVotantes;
    private int cantidadDeVocales;
    private List <String> listaDeRutsDeVotantes;
    private List <String> listaDeRutsDeVocales;

    public Mesa(int numeroDeMesa, int cantidadDeVotantes) {
        this.numeroDeMesa = numeroDeMesa;
        this.cantidadDeVotantes = cantidadDeVotantes;
        this.listaDeRutsDeVotantes = new LinkedList <String>();
    }
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }
    public int getCantidadDeVotantes() {
        return cantidadDeVotantes;
    }
    public int getCantidadDeVocales() {
        return cantidadDeVocales;
    }
    public List getListaDeRutsDeVotantes(){
        return listaDeRutsDeVotantes;
    }
    public List getListaDeRutsDeVocales(){
        return listaDeRutsDeVocales;
    }
    
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
    public void setCantidadDeVotantes(int cantidadDeVotantes) {
        this.cantidadDeVotantes = cantidadDeVotantes;
    }
    public void setCantidadDeVocales(int cantidadDeVocales) {
        this.cantidadDeVocales = cantidadDeVocales;
    }
    public void setListaDeVotantes(List listaDeRutsDeVotantes) {
        this.listaDeRutsDeVotantes = listaDeRutsDeVotantes;
    }
    public void setListaDeVocales(List listaDeRutsDeVocales) {
        this.listaDeRutsDeVocales = listaDeRutsDeVocales;
    }
    
    
    
}
