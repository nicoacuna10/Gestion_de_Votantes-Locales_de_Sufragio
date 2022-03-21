/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeVotantes;

/**
 *
 * @author jpail
 */
public class GestionDeVotantes {

    public static void main(String[] args) {
        
        Persona p1 = new Persona(20875698, 20, "Zenitsu God", "Valparaiso");
        Persona p2 = new Persona(19852654, 22, "Apografo Blado", "Viña");
        Persona p3 = new Persona(22987654, 17, "Aquario Lemon", "San Antonio");
         //mesas;
        Mesa m1 = new Mesa(30, "Caballo", "Viña");
        Mesa m2 = new Mesa(40, "Cebra", "San Antonio");
        
        System.out.println("La edad de " +p1.getNombre()+ " es:"+p1.getEdad());
        System.out.println("La edad de " +p2.getNombre()+ " es:"+p2.getEdad());
        System.out.println("La edad de " +p3.getNombre()+ " es:"+p3.getEdad());
        System.out.println("La capacidad de la mesa " +m1.getNombre()+ " es:"+m1.getCapacidad());
        System.out.println("La capacidad de la mesa " +m2.getNombre()+ " es:"+m2.getCapacidad());
        
    }
    
}
