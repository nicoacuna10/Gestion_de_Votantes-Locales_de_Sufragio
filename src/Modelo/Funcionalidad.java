package Modelo;

import java.io.*;

/**
 * Funcionalidad
 * @author Nicolás Acuña
 */
public class Funcionalidad {
    
    /**
     * Constructor de la clase Funcionalidad
     */
    public Funcionalidad(){
    
    }
    
    /**
     * Funcion inicial: llena las colecciones con datos iniciales.
     * @param valparaiso Región de Valparaiso
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
        
        
        votante1 = new Votante("PEDRO ALBERTO LOPEZ GONZALEZ", "13800755-0", "VINA DEL MAR", "15 NORTE 567", 1, 50);
        valparaiso.agregarVotante("UNIVERSIDAD ANDRES BELLO", votante1);
        
        Votante votante4 = new Votante("PEDRO ANGEL LOPEZ QUISPE", "23845755-1", "VINA DEL MAR", "10 NORTE 567", 1, 25);
        valparaiso.agregarVotante("UNIVERSIDAD ANDRES BELLO", votante4);
        
        votante2 = new Votante("PATRICIA CABRERO QUISPE", "8444987-2", "VALPARAISO", "CALLE ZENTENO 130", 1, 34);
        valparaiso.agregarVotante("PUCV CASA CENTRAL", votante2);
        
        votante3 = new Votante("JUAN RICARDO ASTORGA BERMUDEZ", "19731000-K", "CONCON", "CALLE CUATRO 111", 1, 1);
        valparaiso.agregarVotante("LICEO POLITECNICO CONCON", votante3);
        
        noVotante1 = new NoVotante("MARIA JUANA DE LOS ANGELES RIVEROS", "12888012-9", "SAN ANTONIO", "RUBEN DARIO 1073", 0,"CARCEL");
        valparaiso.agregarNoVotante(noVotante1);
        
        noVotante2 = new NoVotante("JUANA VALENTINA SANCHEZ ORTUZAR", "24898012-1", "VIÑA DEL MAR", "6 ORIENTE 458", 0,"MENOR DE EDAD");
        valparaiso.agregarNoVotante(noVotante2);

    }

}