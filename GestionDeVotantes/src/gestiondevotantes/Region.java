package gestiondevotantes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolás Acuña
 * 
 */
public class Region {
    
    // Creación de mapas.
    private HashMap <String, Local> registroLocalesNombre; // Mapa de Locales con clave el nombre.
    private HashMap <String, Votante> registroVotantesRut; // Mapa de Votantes con clave el rut.
    
    // Constructor de la Clase Region.
    public Region(){
        registroLocalesNombre = new HashMap();
        registroVotantesRut = new HashMap();
    }
    
    /*  Método mostrarVotantes: muestra todos los votantes del registro
        en caso de existir al menos 1. En caso contrario muestra un mensaje
        indicando que no hay datos.
    */
    public void mostrarVotantes(){
        if(registroVotantesRut.size()>0){
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            // Se recorre el mapa registroVotantesRut
            registroVotantesRut.keySet().forEach(rutVotante -> {
                Votante v = registroVotantesRut.get(rutVotante);
                System.out.format("%-30s %-15s %-15s %-25s", v.getNombreCompleto(),v.getRut(),v.getComuna(),v.getDireccion());
                if(v.getEstadoElectoral()==1)System.out.println("SI");
                else System.out.println("NO");
            });
            System.out.println("-------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No hay datos");
        }
    }
    
    /*  Método agregarVotante: Ingresa un votantes y lo ingresa al mapa
        registroVotantesRut. Si ya existe no lo agrega y retorna false.
        En caso de no existir lo agrega y retorna true.
    */
    public boolean agregarVotante(Votante v){
        if(registroVotantesRut.containsKey(v.getRut())){
            return false;
        }
        
        registroVotantesRut.put(v.getRut(), v);
        return true;
    }
    
    /*  Método buscarVotante: busca un votante en el mapa registroVotantesRut
        con la clave el rut personal. Si el mapa contiene el rut, retorna el
        votante. En caso contrario retorna null.
    */
    public Votante buscarVotante(String rut){
        if(registroVotantesRut.containsKey(rut)){
            return registroVotantesRut.get(rut);
        }
        return null;
    }
    
    /*  Método modificarDatosVotante: modifica datos del votante (local, numero
        de mesa, comuna, dirección electoral). Solo se hace la modificación si
        el votante existe en el registro, el local existe en el registro, el número
        de mesa es valida, y la comuna nueva coincide con la comuna del local.
    
    */
    public boolean modificarDatosVotante(String rut, String nombreLocalNuevo, int numeroMesaNueva, String comunaNueva, String direccionNueva){
        if(!registroVotantesRut.containsKey(rut) || !registroLocalesNombre.containsKey(nombreLocalNuevo)){
            return false;
        }
        
        Votante v = registroVotantesRut.get(rut);
        Local b = registroLocalesNombre.get(nombreLocalNuevo);
        
        if(numeroMesaNueva < b.getNumeroPrimeraMesa() || numeroMesaNueva > b.getNumeroUltimaMesa()){
            return false;
        }
        
        if(!comunaNueva.equals(b.getComuna())){
            return false;
        }
        
        v.setComuna(comunaNueva);
        v.setDireccion(direccionNueva);
        v.setLocalAsignado(nombreLocalNuevo);
        v.setNumeroDeMesa(numeroMesaNueva);

        return true;
    }
    
    /*  Método eliminarVotante: Se elimina el votante del registro con la clave 
        el rut personal, siempre que exista en el registro. Si no se encuentra
        en el registro retorna false. Si se elimina con exito retorna true.
    
    */
    public boolean eliminarVotante(String rut){
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        registroVotantesRut.remove(rut);
        return true;
    }
    
    /*  Método mostrarDatosVotante: muestra los datos del votante.
        Se verifica que el votante se encuentre en registro.
        Si no se encuentra el votante en registro, retorna false.
        Si el votante está en registro, se muestran los datos y retorna
        true.
    
    */
    public boolean mostrarDatosVotante(String rut){
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        Votante v = registroVotantesRut.get(rut);
        Local b = registroLocalesNombre.get(v.getLocalAsignado());
        // Se imprimen los datos del votante
        System.out.println("------------------------------------------");
        System.out.println("DATOS VOTANTE");
        System.out.println("------------------------------------------");
        System.out.println("NOMBRE: "+v.getNombreCompleto());
        System.out.println("RUT "+v.getRut());
        System.out.println("COMUNA: "+v.getComuna());
        System.out.println("DIRECCION: "+v.getDireccion());

        if(v.getEstadoElectoral() == 1){
            System.out.println("HABILITADO(A) PARA VOTAR: SI");
            System.out.println("LOCAL: "+v.getLocalAsignado());
            System.out.println("DIRECCION LOCAL: "+b.getDireccion());
            System.out.println("NUMERO DE MESA: "+v.getNumeroDeMesa());
        }else System.out.println("HABILITADO(A) PARA VOTAR: NO");
        System.out.println("------------------------------------------");
        
        return true;
    }
    
    /*  Método agregarLocal: Se ingresa un local nuevo al registro. Se verifica 
        que el votante no se encuentre en el registro. Si se encuentra en el
        registro, no se agrega y retorna false. Si no existe en registro, se
        agrega y retorna true.
    
    */
    public boolean agregarLocal(Local b){
        if(registroLocalesNombre.containsKey(b.getNombreLocal())){
            return false;
        }
        registroLocalesNombre.put(b.getNombreLocal(), b);
        return true;
    }
        
    
    /*  Método buscarLocal: Se ingresa el nombre local y busca dentro del
        registro. Si lo encuentra retorna el local. En caso contrario retorna
        null.
    
    */
    public Local buscarLocal(String nombreLocal){
        if(registroLocalesNombre.containsKey(nombreLocal)){
            return registroLocalesNombre.get(nombreLocal);
        }
        return null;
    }
    
    /*  Método modificarDatosLocal: modifica datos del local (nombre, comuna,
        direccion, capacidadmaxima). Solo se hace la modificación si el local
        existe en el registro.
    
    */
    public boolean modificarDatosLocal(String nombreLocal, String comuna, String direccion, int capacidadMaxima){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocal);
        b.setNombreLocal(nombreLocal);
        b.setComuna(comuna);
        b.setDireccion(direccion);
        b.setCapacidadMaxima(capacidadMaxima);
        return true;
    }
    
    /*  Método eliminarLocal: Se ingresa el nombre del local y se elimina en caso
        de existir en el registro. Si se existe, se elimina y retorna true.
        En caso contrario retorna false.
    
    */
    public boolean eliminarLocal(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        registroLocalesNombre.remove(nombreLocal);
        return true;
    
    }
    
    /*  Método mostrarDatosLocal: muestra los datos del local solo si este existe
        en el registro. Si existe se muestran los datos asociados y retorna true.
        En caso contrario, retorna false.
    */
    public boolean mostrarDatosLocal(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocal);
        // Se imprimen los datos del local.
        System.out.println("DATOS LOCAL");
        System.out.println("NOMBRE: "+b.getNombreLocal());
        System.out.println("COMUNA: "+b.getComuna());
        System.out.println("DIRECCION: "+b.getDireccion());
        System.out.println("MESAS: "+b.getNumeroPrimeraMesa()+" - "+b.getNumeroUltimaMesa());
        
        return true;
    }
    
    /*  Método mostrarLocales: muestra todos los locales de votación del registro.
        Si no hay, no muestra nada.
    */
    public void mostrarLocales(){
        // Se recorre el mapa registroLocalesNombre
        registroLocalesNombre.keySet().forEach(nombreLocal -> {
            System.out.println(nombreLocal+"\t"+(registroLocalesNombre.get(nombreLocal)).getComuna());
        });
    }
    
    /*  Método agregarMesa: agrega una mesa nueva al local a partir del número
        de la última mesa actual solo si existe el local. Si no existe el local
        no se agrega y retorna false. Si existe, se llama al metodo agregaMesa
        de la clase Local y se actualiza el número de la última mesa.
    */
    public boolean agregarMesa(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocal);
        b.agregarMesa();
        b.setNumeroUltimaMesa(b.getNumeroUltimaMesa()+1);
        return true;
    }
    
    /*  Método agregarMesa: lista las mesas de un local cuando este se agrega por
        primera vez.
    */
    public void agregarMesa(Local b, int nPrimeraMesa, int nUltimaMesa){
        b.agregarMesa(nPrimeraMesa, nUltimaMesa);
    }
    
    /*  Método modificarDatosMesa: modifica la capacidad maxima de una mesa solo
        si el local donde se encuentra la mesa existe. Si no existe retorna false.
        Si existe retorna lo que retorne el metodo modificarDatosMesa de la clase
        Local.
    
    */
    public boolean modificarDatosMesa(String nombreLocal, int numeroDeMesa, int capacidadMaximaNueva){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocal);
        return b.modificarDatosMesa(numeroDeMesa, capacidadMaximaNueva);
    }
    
    /*  Método eliminarMesa: elimina la última mesa de local solo si existe este
        último. Si no existe el local, retorna false. Si existe se llama al método
        eliminarMesa de la clase Local para que elimine la mesa y se actualiza
        el numero de la última mesa.
    
    */
    public boolean eliminarMesa(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocal);
        Mesa mesaEliminada = b.eliminarMesa();
        b.setNumeroUltimaMesa(b.getNumeroUltimaMesa()-1);
        if(mesaEliminada != null){
            return true;
        }else return false;
    }
    
    /*  Método mostrarMesas: muestra los números de las mesas de un local solo
        si existe este último. Si no existe no muestra nada y retorna false.
        Si existe llama al método mostrarMesas de la clase Local para que muestre las mesas.
    
    */
    public boolean mostrarMesas(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local b = registroLocalesNombre.get(nombreLocal);
        System.out.println("Mesas Local: "+b.getNombreLocal());
        b.mostrarMesas();
        return true;
    }
    
    

    /* Método exportar: exporta archivo *csv con las colecciones.
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
        pw = new PrintWriter(bw);//int estadoElectoral, String localAsignado, int numeroDeMesa)
        pw.write("NOMBRE,RUT,COMUNA,DIRECCION,ESTADO ELECTORAL,LOCAL ASIGNADO,NUMERO DE MESA");
        registroVotantesRut.keySet().forEach((String rutVotante) -> {
                Votante v = registroVotantesRut.get(rutVotante);
                String linea = "\n"+v.getNombreCompleto()+","+v.getRut()+","+v.getComuna()+","+v.getDireccion()+","+v.getEstadoElectoral()+","+v.getLocalAsignado()+","+v.getNumeroDeMesa();
                pw.append(linea);
        });
        pw.write("\nNOMBRE,COMUNA,DIRECCION,CAPACIDAD MAXIMA,NUMERO PRIMERA MESA,NUMERO ULTIMA MESA");
        registroLocalesNombre.keySet().forEach((String nombreLocal) ->{
                Local b = registroLocalesNombre.get(nombreLocal);
                String linea = "\n"+b.getNombreLocal()+","+b.getComuna()+","+b.getDireccion()+","+b.getCapacidadMaxima()+","+b.getNumeroPrimeraMesa()+","+b.getNumeroUltimaMesa();
                pw.append(linea);
                pw.write("\nNUMERO MESA,CAPACIDAD MAXIMA");
                for(int n=b.getNumeroPrimeraMesa(); n<=b.getNumeroUltimaMesa(); n++){
                    Mesa m = (Mesa) b.buscarMesa(n);
                    linea = "\n"+m.getNumeroDeMesa()+","+m.getCapacidadMaxima();
                    pw.append(linea);
                }
        });
        pw.close();
        bw.close();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+ e);
    }

    }
    

}