/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.*;
/**
 *
 * @author Gerard Sagredo
 */
public class mostrarSortRutsVotantes implements StrategySortMostrar{
    
    @Override
    public void mostrarDatos(HashMap<String,Local> registroNombresLocal){
        
        List<String> localesPorNombre = new ArrayList<>(registroNombresLocal.keySet());
        Collections.sort(localesPorNombre);
        
        for(int i=0;i<(localesPorNombre.size());i++){
            
            String buscado = localesPorNombre.get(i);
            Local ll = registroNombresLocal.get(buscado);
            String[] ruts = ll.obtenerRutsVotantes();
            System.out.println("------- "+buscado +" -------");
            for(int j=0;j<ruts.length;j++){
                Votante vv = ll.buscarVotante(ruts[j]);
                String mostrar = vv.obtenerDatosPersona();
                System.out.println(mostrar );
            }
            
        }
    }
}
