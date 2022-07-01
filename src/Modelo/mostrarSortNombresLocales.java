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
public class mostrarSortNombresLocales implements StrategySortMostrar {

    @Override
    public void mostrarDatos(HashMap<String,Local> registroNombresLocal) {
        
        List<String> localesPorNombre = new ArrayList<>(registroNombresLocal.keySet());
        Collections.sort(localesPorNombre);
        
        for(int i=0;i<localesPorNombre.size();i++){
            System.out.println(localesPorNombre.get(i));
            }
       }
    }
