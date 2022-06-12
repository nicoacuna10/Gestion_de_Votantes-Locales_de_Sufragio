package gestiondevotantes;

import java.io.*;
import javax.swing.*;

/**
 *  CSV
 * @author Nicolás Acuña
 */
public class CSV {
    
    /**
     * Constructor de la clase CSV.
     */
    public CSV(){
    
    }
    
    /**
     * Método importarCSV: Importa un archivo en formato *.csv con la información de las colecciones anidadas
     * Locales y Votantes.
     * @param nombreArchivo nombre del archivo
     * @param valparaiso region de valparaiso
     * @throws IOException Excepcion Input/Output
     */
    public void importarCSV(String nombreArchivo, Region valparaiso)throws IOException{
        
        File archivo = new File(nombreArchivo);
        if(!archivo.canRead()){
            System.out.println("No existe el archivo");
            return;
        }
        
        FileReader lectorArchivo;
        BufferedReader lectorLinea;
        
        try{
            lectorArchivo = new FileReader(archivo);
            lectorLinea = new BufferedReader(lectorArchivo);
            
            // Lectura primera linea
            String linea = lectorLinea.readLine();
            
            while( (linea = lectorLinea.readLine() ) != null ){
                String datos[] = linea.split(";");
                
                Local a = new Local(datos[5], datos[2], datos[7], Integer.parseInt(datos[8]), Integer.parseInt(datos[9]), Integer.parseInt(datos[10]));
                valparaiso.agregarLocal(a);
                
                Votante v = new Votante(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]), Integer.parseInt(datos[6]));
                valparaiso.agregarVotante(a.getNombreLocal(), v);

            }
        
        }catch(Exception e){
        
        }
    }
    
    /**
     * Método exportarCSV: Exporta un archivo en formato *.csv con la información de las colecciones anidadas
     * Locales y Votantes.
     * @param nombreArchivo nombre del archivo
     * @param valparaiso region de valparaiso
     */
    public void exportarCSV(String nombreArchivo, Region valparaiso){
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;

        try {
            f = new File(nombreArchivo);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.write("NOMBRE,RUT,COMUNA,DIRECCION,ESTADO ELECTORAL,NOMBRE LOCAL,NUMERO DE MESA,DIRECCION LOCAL,CAPACIDAD MAXIMA,NUMERO PRIMERA MESA,NUMERO ULTIMA MESA");
            
            String[] rutsVotantes = valparaiso.obtenerRutsVotantes();
            int cantidadVotantes = rutsVotantes.length;
            
            for(int i = 0; i < cantidadVotantes; i++){
                
                Votante v = valparaiso.buscarVotante(rutsVotantes[i]);
                Local a = valparaiso.obtenerLocalVotante(rutsVotantes[i]);
                if(v == null)break;
                String linea = "\n"+v.getNombreCompleto()+","+v.getRut()+","+v.getComuna()+","+v.getDireccion()+","+v.getEstadoElectoral()+","+a.getNombreLocal()+","+v.getNumeroDeMesa()+","+a.getDireccion()+","+a.getCapacidadMaxima()+","+a.getNumeroPrimeraMesa()+","+a.getNumeroUltimaMesa();
                pw.append(linea);
            }

            pw.close();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+ e);
        }
        
        System.out.println("El archivo *.csv se ha exportado con exito");
    }
    
}
