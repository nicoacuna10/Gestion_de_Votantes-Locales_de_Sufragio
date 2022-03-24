/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */

public class Mesa {
    
    private int numeroDeMesa;
    private int cantidadDeVotantes;

    public Mesa(int numeroDeMesa, int cantidadDeVotantes) {
        this.numeroDeMesa = numeroDeMesa;
        this.cantidadDeVotantes = cantidadDeVotantes;
    }
    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }
    public int getCantidadDeVotantes() {
        return cantidadDeVotantes;
    }
    
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }
    public void setCantidadDeVotantes(int cantidadDeVotantes) {
        this.cantidadDeVotantes = cantidadDeVotantes;
    }

    
    
    
}
