package gestiondevotantes;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Region contiene las colecciones de Locales y de NoVotantes
 * @author Nicolás Acuña
 * 
 */
public class Region implements Mostrable{
    
    private HashMap <String, Local> registroLocalesNombre; // Mapa de Locales con clave el nombre.
    private HashMap <String, NoVotante> registroNoVotantesRut;// Mapa de No votantes con clave rut.

    
    /**
     * Constructor de la clase Region, inicializa las colecciones
     */
    public Region(){
        registroLocalesNombre = new HashMap();
        registroNoVotantesRut = new HashMap();
    }
    

    
    /**
     * Método agregarLocal: Se ingresa un local nuevo al registro. Se verifica 
     * que el votante no se encuentre en el registro.
     * @param a local nuevo
     * @return Si se encuentra en el registro, no se agrega y retorna false. Si no existe en registro, se agrega y retorna true.
     */
    public boolean agregarLocal(Local a){
        if(registroLocalesNombre.containsKey(a.getNombreLocal())){
            return false;
        }
        registroLocalesNombre.put(a.getNombreLocal(), a);
        return true;
    }
    
    public Local agregarLocal(String nombreLocal){
        if(registroLocalesNombre.containsKey(nombreLocal))return null;
        Local l = new Local(nombreLocal);
        registroLocalesNombre.put(nombreLocal, l);
        return l;
    }
        
    
    /**
     * Método buscarLocal: Se ingresa el nombre local y busca dentro del registro.
     * @param nombreLocal nombre del local a buscar
     * @return Si lo encuentra retorna el local. En caso contrario retorna null.
     */
    public Local buscarLocal(String nombreLocal){
        if(registroLocalesNombre.containsKey(nombreLocal)){
            return registroLocalesNombre.get(nombreLocal);
        }
        return null;
    }
    

    /**
     * Método modificarDatosLocal: modifica datos del local (nombre, comuna,
     * direccion, capacidadmaxima). Solo se hace la modificación si el local
     * existe en el registro.
     * @param nombreLocal nombre del local
     * @param comuna comuna del local
     * @param direccion direccion del local
     * @param capacidadMaxima capacidad maxima
     * @return Si se modificaron los datos retorna true. En caso contrario retorna null.
     */
    public boolean modificarDatosLocal(String nombreLocal, String comuna, String direccion, int capacidadMaxima){
        if(!registroLocalesNombre.containsKey(nombreLocal) || nombreLocal.equals("SIN LOCAL")){
            return false;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        a.setNombreLocal(nombreLocal);
        a.setComuna(comuna);
        a.setDireccion(direccion);
        a.setCapacidadMaxima(capacidadMaxima);
        return true;
    }
    

    /**
     * Método eliminarLocal: Se ingresa el nombre del local y se elimina en caso
     * de existir en el registro.
     * @param nombreLocal nombre del local
     * @return Si se existe, se elimina y retorna true. En caso contrario retorna false.
     */
    public boolean eliminarLocal(String nombreLocal){
        if(registroLocalesNombre.isEmpty()){
            return false;
        }
        if(!registroLocalesNombre.containsKey(nombreLocal) || nombreLocal.equals("SIN LOCAL")){
            return false;
        }
        registroLocalesNombre.remove(nombreLocal);
        return true;
    
    }
    

    /**
     * Método mostrarDatosLocal: muestra los datos del local solo si este existe
     * en el registro.
     * @param nombreLocal nombre del local
     * @return Si existe se muestran los datos asociados y retorna true. En caso contrario, retorna false.
     */
    public boolean mostrarDatosLocal(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal) || nombreLocal.equals("SIN LOCAL")){
            return false;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        // Se imprimen los datos del local.
        System.out.println("DATOS LOCAL");
        System.out.println("NOMBRE: "+a.getNombreLocal());
        System.out.println("COMUNA: "+a.getComuna());
        System.out.println("DIRECCION: "+a.getDireccion());
        System.out.println("MESAS: "+a.getNumeroPrimeraMesa()+" - "+a.getNumeroUltimaMesa());
        
        return true;
    }
    

    /**
     * Método mostrarLocales: muestra todos los locales de votación del registro.
     * Si no hay, no muestra nada.
     */
    public void mostrarLocales(){
        // Se recorre el mapa registroLocalesNombre
        for(String nombreLocal : registroLocalesNombre.keySet()){
            if(!nombreLocal.equals("SIN LOCAL")){
                System.out.println(nombreLocal+"\t"+(registroLocalesNombre.get(nombreLocal)).getComuna());
            }
        }
    }

    /**
     * Método agregarVotante: Agrega un nuevo votante si no existe dentro del local
     * de votación. Utiliza el método agregarVotante de la clase Local para
     * agregarlo al mapa de votantes del local.
     * @param nombreLocal nombre del local
     * @param v votante nuevo
     * @return Retorna true si lo agrega, caso contrario false.
     */
    public boolean agregarVotante(String nombreLocal, Votante v){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            Local auxLocal = agregarLocal(nombreLocal);  
            return auxLocal.agregarVotante(v);
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        return a.agregarVotante(v);
    }
    

    /**
     * Método agregarVotante: Agrega un nuevo votante que no está habilitado para
     * votar (estadoElectoral de valor 0. Utiliza el método agregarVotante de la
     * clase Local para agregarlo al mapa de votantes del local de nombre "SIN LOCAL".
     * @param nv no votante
     * @return Retorna true si lo agrega, caso contrario false. 
     */
    public boolean agregarNoVotante(NoVotante nv){
        if(registroNoVotantesRut.containsKey(nv.getRut())==false){
            registroNoVotantesRut.put(nv.getRut(), nv);
            //System.out.println("ENTRA ANV");
            return true;
        }
        //System.out.println("NO ENTRA ANV");
        return false;
    }
    
    
    /**
     * Método buscarVotante: Busca un votante en el local con el nombre que ingresa.
     * En caso de que exista el local ingresado, lo busca con el método
     * buscarVotante de la clase Local.
     * @param nombreLocal nombre del local
     * @param rut rut del votante
     * @return Retorna el votante si lo encunetra en la colección del local. Retorna null si el local ingresado no existe en el registro o si no lo encontró en la colección de este.
     */
    public Votante buscarVotante(String nombreLocal, String rut){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return null;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        return a.buscarVotante(rut);
    }
    

    
    /**
     * Método buscarVotante: Busca un votante en todos los locales de votación
     * hasta que lo encuentre o términe de recorrer (lo que ocurra primero).
     * @param rut rut del votante
     * @return Si lo encuentra retorna el votante. Si termina de recorrer los locales sin éxito, retorna null.
     */
    public Votante buscarVotante(String rut){
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            Votante v = a.buscarVotante(rut);
            if(v != null){
                return v;
            }
        }
        return null;
    }

    
    /**
     * Método modificarDatosVotante: Modifica los datos del votante (el nombre
     * del local, número de la mesa, la comuna y la dirección) si se cumple lo
     * siguiente: <br>
     * 1.- El votante se encuentre en alguno de los locales. <br>
     * 2.- El nombre del local al que se quiere cambiar sea el mismo donde se encuentra alctualmente el votante. <br>
     * 3.- La comuna del nuevo local sea distinta a la del domicilio del votante.
     * @param rut rut del votante
     * @param nombreLocalB nombre del local nuevo
     * @param numeroDeMesa numero de mesa nuevo del votante
     * @param comuna comuna nueva del votante
     * @param direccion dirección nueva del votante
     * @return Retorna true si se modificaron los datos, false caso contrario.
     */
    public boolean modificarDatosVotante(String rut, String nombreLocalB, int numeroDeMesa, String comuna, String direccion){
        String nombreLocalA = "0";
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            Votante v = a.buscarVotante(rut);
            if(v != null){
                nombreLocalA = a.getNombreLocal();
            }
        }
        if(nombreLocalA.equals("0")){
            return false;
        }
        Local a = registroLocalesNombre.get(nombreLocalA);
        if(!registroLocalesNombre.containsKey(nombreLocalB)){
            return false;
        }
        if(nombreLocalB.equals(nombreLocalA)){
            return a.modificarDatosVotante(rut, numeroDeMesa);
        }
        if(!a.getComuna().equals(comuna)){
            return false;
        }
        if( !a.modificarDatosVotante(rut, numeroDeMesa, comuna, direccion) ){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocalB);
        Votante v = a.buscarVotante(rut);
        b.agregarVotante(v);
        a.eliminarVotante(rut);
        return true;
    }
    

    /**
     * Método eliminarVotante: Elimina un votante si existe dentro del local de votación.
     * @param nombreLocal nombre del local
     * @param rut rut del votante
     * @return Retorna false si el local no existe o si no se encuentra dentro de este. Retorna true en caso de que lo elimine con exito.
     */
    public boolean eliminarVotante(String nombreLocal, String rut){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        return a.eliminarVotante(rut);
    }
    

    /**
     * Método eliminarVotante: Elimina el votante buscando el votante en todos
     * los locales de votación.
     * @param rut rut del votante
     * @return Retorna false si no se eliminó el votante (no se encontraba en ninguno de los locales). Retorna true si se eliminó correctamente
     */
    public boolean eliminarVotante(String rut){
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            Votante w = a.buscarVotante(rut);
            if(w != null){
                return a.eliminarVotante(rut);
            }
        }
        return false;
    }
    

    /**
     * Método mostrarDatosVotante: Muestra los datos de un votante.
     * @param rut 
     */
    public void mostrarDatosVotante(String rut){
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            
            if(a.buscarVotante(rut).getEstadoElectoral()==1){
                Votante v = a.buscarVotante(rut);
                if(v != null){
                    
                   a.mostrarDatosVotante(v, a.getNombreLocal(), a.getDireccion()); 
                }
            }else{
                System.out.println("ERROR");
            }
            

        }
    }
    

    /**
     * Método mostrarDatos: Muestra los datos de los No votantes.
     */
    @Override
    public void mostrarDatos(){
        if(registroNoVotantesRut.size()>0){
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\tNO VOTANTES");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            // Se recorre el mapa registroVotantesRut
            for( String rut : registroNoVotantesRut.keySet()){
                NoVotante v = registroNoVotantesRut.get(rut);
                System.out.format("%-30s %-15s %-15s %-25s", v.getNombreCompleto(), rut, v.getComuna(), v.getDireccion());
                if(v.getEstadoElectoral()==1)System.out.println("SI");
                else System.out.println("NO");
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No hay datos2");
        }
    }
    

    /**
     * Método mostrarVotantes: Muestra todos los votantes de todos los locales de votación.
     */
    public void mostrarVotantes(){
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tVOTANTES");
        // Se recorre el mapa registroLocalesNombre
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            a.mostrarDatos();
        }
    }
    

    /**
     * Método exportar: exporta archivo *csv con las 2 colecciones anidadas.
     * @param nombreArchivo nombre del archivo
     */
    public void exportar(String nombreArchivo){
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;

        try {
            f = new File(nombreArchivo);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.write("NOMBRE,RUT,COMUNA,DIRECCION,ESTADO ELECTORAL,NOMBRE LOCAL,NUMERO DE MESA,DIRECCION,CAPACIDAD MAXIMA,NUMERO PRIMERA MESA,NUMERO ULTIMA MESA");
            for(String nombreLocal : registroLocalesNombre.keySet()){
                    Local a = registroLocalesNombre.get(nombreLocal);
                    //System.out.println("ENTRA afuera");
                    int cantidadVotantes = a.obtenerCantidadVotantes();
                    String[] rutsVotantes = a.obtenerRutsVotantes();
                    //System.out.println("cant: "+cantidadVotantes);
                    for(int i = 0; i < cantidadVotantes; i++){
                        //System.out.println("ENTRA "+i);
                        Votante v = a.buscarVotante(rutsVotantes[i]);
                        if(v == null)break;
                        String linea = "\n"+v.getNombreCompleto()+","+v.getRut()+","+v.getComuna()+","+v.getDireccion()+","+v.getEstadoElectoral()+","+a.getNombreLocal()+","+v.getNumeroDeMesa()+","+a.getDireccion()+","+a.getCapacidadMaxima()+","+a.getNumeroPrimeraMesa()+","+a.getNumeroUltimaMesa();
                        pw.append(linea);
                    }
            }
            pw.close();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+ e);
        }

    }
    
    /**
     * Método mostrarVotantesLocal: muestra los votantes de un local en específico.
     * @param nombreL nombre del local
     */
    public void mostrarVotantesLocal(String nombreL){
        Local lo = registroLocalesNombre.get(nombreL);
        if(lo !=null){
            lo.mostrarDatos();
        }
    }

    /**
     * Método consultarTipoUsuario: muestra el tipo de usuario de una persona,
     * indica si es votante o no votante.
     * @param rut rut del usuario
     */
    public void consultarTipoUsuario(String rut) {
        if(registroNoVotantesRut.containsKey(rut)==true){
            NoVotante nv = registroNoVotantesRut.get(rut);
            System.out.print("MI NOMBRE ES "+nv.getNombreCompleto()+" Y ");
            nv.identificarse();
        }else
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            Votante v = a.buscarVotante(rut);
            if(v!=null){
                System.out.print("MI NOMBRE ES "+v.getNombreCompleto()+" Y ");
                v.identificarse();
            }
            
        }
        
    }

}