package gestiondevotantes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolás Acuña
 */
public class Region {
    
    // Creación de mapas.
    private HashMap <String, Local> registroLocalesNombre; // Mapa de Locales con clave el nombre.
    private HashMap <String, Votante> registroVotantesRut; // Mapa de Votantes con clave el rut.
    private ArrayList <String> usuariosRut;  // Lista de Rut
    
    // Constructor de la Clase Region.
    public Region(){
        registroLocalesNombre = new HashMap();
        registroVotantesRut = new HashMap();
        usuariosRut = new ArrayList();
    }
    
    // Método agregar local, con parámetros objetos de clase Local y Votante
    public void agregarLocal(Local auxL, Votante auxV){
        // Inserción del los datos del local nuevo en el mapa respectivo, con la clave el nombre.
        registroLocalesNombre.put(auxV.getLocalAsignado(), auxL);
    }
    
    
    // Método agregar local, con parámetro objeto de clase Local
    public boolean agregarLocal(Local auxL){
        if(registroLocalesNombre.containsKey(auxL.getNombreLocal()) == true){
            return false;
        }
        // Inserción del los datos del local nuevo en el mapa respectivo, con la clave el nombre.
        registroLocalesNombre.put(auxL.getNombreLocal(), auxL);
        return true;
    }
        
    
    // Método buscar local.
    public Local buscarLocal(String nombre){
        if(registroLocalesNombre.containsValue(nombre))return registroLocalesNombre.get(nombre);
        return null;
    }
    
    // Método eliminar local.
    public boolean eliminarLocal(String nombre){
        if(registroLocalesNombre.containsKey(nombre) == false){
            return false;
        }
        // eliminación del local.
        registroLocalesNombre.remove(nombre);
        return true;
    
    }
    
    // Método mostrar datos local
    public void mostrarDatosLocal(Local auxL){
        // Se imprimen los datos del local.
        System.out.println("DATOS LOCAL");
        System.out.println("NOMBRE: "+auxL.getNombreLocal());
        System.out.println("COMUNA: "+auxL.getComuna());
        System.out.println("DIRECCION: "+auxL.getDireccion());
        System.out.println("MESAS: "+auxL.getNumeroPrimeraMesa()+" - "+auxL.getNumeroUltimaMesa());
    
    }
    
    // Método mostrar locales.
    public void mostrarLocales(){
        registroLocalesNombre.keySet().forEach(nombreLocal -> {
            System.out.println(nombreLocal+"\t"+(registroLocalesNombre.get(nombreLocal)).getComuna());
        });
    }
    
    // Método agregar votante.
    public void agregarVotante(Votante aux){
        // Inserción del los datos del votante nuevo en el mapa respectivo, con la clave el rut.
        registroVotantesRut.put(aux.getRut(), aux);
        usuariosRut.add(aux.getRut());
    }
    
    public Votante buscarVotante(String rut){
        // Búsqueda del votante con la clave el rut
        if(registroVotantesRut.containsKey(rut))return registroVotantesRut.get(rut);
        return null;
    }
    public Votante eliminarVotante(String rut){
        if(registroVotantesRut.containsKey(rut)){
            for(int i=0;i<usuariosRut.size(); i++){
                if(usuariosRut.get(i).equals(rut))usuariosRut.remove(i);
            }
            return registroVotantesRut.remove(rut);
        }
        return null;
    }
    public void mostrarTodosVotantes(){
        if(usuariosRut.size()>0){
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            for(int i=0; i<usuariosRut.size();i++){
                Votante v = buscarVotante(usuariosRut.get(i));
                if(v==null)break;

                System.out.format("%-30s %-15s %-15s %-25s", v.getNombreCompleto(),v.getRut(),v.getComuna(),v.getDireccion());
                if(v.getEstadoElectoral()==1)System.out.println("SI");
                else System.out.println("NO");
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No hay datos");
        }
    }
    // Método mostrar datos votante.
    public void mostrarDatosVotante(Votante auxV, Local auxL){
        // Se imprimen los datos del votante
        System.out.println("------------------------------------------");
        System.out.println("DATOS VOTANTE");
        System.out.println("------------------------------------------");
        System.out.println("NOMBRE: "+auxV.getNombreCompleto());
        System.out.println("RUT "+auxV.getRut());
        System.out.println("COMUNA: "+auxV.getComuna());
        System.out.println("DIRECCION: "+auxV.getDireccion());

        if(auxV.getEstadoElectoral() == 1){
            System.out.println("HABILITADO(A) PARA VOTAR: SI");
            System.out.println("LOCAL: "+auxV.getLocalAsignado());
            System.out.println("DIRECCION LOCAL: "+auxL.getDireccion());
            System.out.println("NUMERO DE MESA: "+auxV.getNumeroDeMesa());
        }else System.out.println("HABILITADO(A) PARA VOTAR: NO");
        System.out.println("------------------------------------------");

    }
        public void exportar(String nombreArchivo){
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        
        try {
            f = new File(nombreArchivo);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);//int estadoElectoral, String localAsignado, int numeroDeMesa)
            pw.write("NOMBRE,RUT,COMUNA,DIRECCION,ESTADO ELECTORAL,LOCAL ASIGNADO,NUMERO DE MESA");
            for(int i=0; i<usuariosRut.size() ; i++){
                
                if(registroVotantesRut.containsKey(usuariosRut.get(i))){
                    Votante v = registroVotantesRut.get(usuariosRut.get(i));
                    String linea = "\n"+v.getNombreCompleto()+","+v.getRut()+","+v.getComuna()+","+v.getDireccion()+","+v.getEstadoElectoral()+","+v.getLocalAsignado()+","+v.getNumeroDeMesa();;
                    pw.append(linea);
                }
            }
            pw.close();
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+ e);
        }
        
    }
    

}

