/**
 *
 * @author jpail
 * @author Nicolás Acuña
 */


public class GestionDeVotantes {

    public static void main(String[] args) {
        
        Votante p1 = new Votante("NICOLAS ACUNA", "10000009-2", 20, "VINA DEL MAR", "AV DEL LAGO 554", 1, 0, "COLEGIO X1-AE", 12);
        Votante p2 = new Votante("JOSE", "19111000-2", 22, "QUILPUE", "AV LOS CARRERA 1", 1, 0, "COLEGIO E-10", 29);
        Votante p3 = new Votante("GERARD", "20111555-7", 17, "SAN ANTONIO", "PASAJE SIETE 9", 0, 0, "ESTADIO MUNICIPAL 98", 50);
        
        /*Mesa[] m1 = new Mesa[30];
        for(int i=0; i<30; i++){
            //m1[i].setNumeroDeMesa(i+1);
            m1[i].setCantidadDeVotantes(17);
        }*/
        
        Local l1 = new Local("COLEGIO X1-AE", "VINA DEL MAR", 310, 28, null);
        
        
        System.out.println("La edad del votante "+p1.getNombreCompleto()+" es "+p1.getEdad()+" y vive en la comuna de "+p1.getComuna());
        System.out.println("La edad del votante "+p2.getNombreCompleto()+" es "+p2.getEdad()+" y vive en la comuna de "+p2.getComuna());
        System.out.println("La edad del votante "+p3.getNombreCompleto()+" es "+p3.getEdad()+" y vive en la comuna de "+p3.getComuna());
        
        System.out.println("El colegio "+l1.getNombreLocal()+" de la comuna de "+l1.getComuna()+" tiene una capacidad para "+l1.getCapacidadMaxima()+" personas");
        
        
  
    }
    
}