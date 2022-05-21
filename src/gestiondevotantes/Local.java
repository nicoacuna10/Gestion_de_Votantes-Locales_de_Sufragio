package gestiondevotantes;

import java.io.*;
import java.util.*;


/**
 * Local almacena la información en relación a un local de votación.
 * 
 * @author jpail
 * @author Nicolás Acuña
 */
public class Local implements Mostrable{
    
    // Variables de instancia de la clase Local.
    private String nombreLocal; // Nombre del local.
    private String comuna; // Comuna donde se encuentra el local.
    private String direccion; // Dirección del local.
    private int capacidadMaxima; // Capacidad Maxima (Personas) del local.
    private int numeroPrimeraMesa; // Número de la primera mesa del local.
    private int numeroUltimaMesa; // Número de la última mesa del local.
    private HashMap <String, Votante> registroVotantesRut; // Mapa de Votantes con clave el rut.
    
    /**
     * Constructor de la clase Local
     * @param nombreLocal nombre del local
     */
    public Local(String nombreLocal){
        this.nombreLocal = nombreLocal;
        comuna = "0";
        direccion = "0";
        capacidadMaxima = 2000000;
        numeroPrimeraMesa = 0;
        numeroUltimaMesa = 0;
        registroVotantesRut = new HashMap();
    }
    
    /**
     * Constructor de la clase Local
     * @param nombreLocal nombre del local
     * @param comuna comuna del local
     * @param direccion dirección del local
     * @param capacidadMaxima capacidad máxima del local
     * @param numeroPrimeraMesa número de la primera mesa
     * @param numeroUltimaMesa número de la última mesa
     */
    public Local(String nombreLocal, String comuna, String direccion,  int capacidadMaxima, int numeroPrimeraMesa, int numeroUltimaMesa) {
        this.nombreLocal = nombreLocal;
        this.comuna = comuna;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.numeroPrimeraMesa = numeroPrimeraMesa;
        this.numeroUltimaMesa = numeroUltimaMesa;
        registroVotantesRut = new HashMap();
    }
    

    /**
     * Método agregarVotante: Agrega un votante al registro si el local no está
     * lleno o si no existe previamente el votante.
     * @param p votante
     * @return Retorna true si se agregó el votante, retorna false caso contrario.
     */
    public boolean agregarVotante(Votante p){
        if(registroVotantesRut.size() == capacidadMaxima){
            return false;
        }
        if(registroVotantesRut.containsKey(p.getRut())){
            return false;
        }
        registroVotantesRut.put(p.getRut(), p);
        return true;
    }
    

    /**
     * Método buscarVotante: Busca el votante en el registro.
     * @param rut rut del votante
     * @return Retorna el votante si se encuentra. Retorna null caso contrario
     */
    public Votante buscarVotante(String rut){
        if(!registroVotantesRut.containsKey(rut)){
            return null;
        }
        return registroVotantesRut.get(rut);
    }
    

    /**
     * Método modificarDatosVotante: Modifica el numero de mesa, la comuna y
     * la dirección siempre y cuando el votante se encuentre en el registro.
     * @param rut rut del votante
     * @param numeroDeMesa numero de mesa nuevo
     * @param comuna comuna nueva
     * @param direccion direccion nueva
     * @return Retorna true si se modificaron los datos, retorna false en caso contrario.
     */
    public boolean modificarDatosVotante(String rut, int numeroDeMesa, String comuna, String direccion){
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        Votante v = (Votante)registroVotantesRut.get(rut);
        v.setNumeroDeMesa(numeroDeMesa);
        v.setComuna(comuna);
        v.setDireccion(direccion);
        return true;
    }
    
    
    /**
     * Método modificarDatosVotante: Modifica el número de mesa del votante.
     * @param rut rut del votante
     * @param numeroDeMesa numero de mesa nuevo
     * @return Retorna true si se modifica el número de mesa, false en caso contrario.
     */
    public boolean modificarDatosVotante(String rut, int numeroDeMesa){
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        Votante v = (Votante)registroVotantesRut.get(rut);
        v.setNumeroDeMesa(numeroDeMesa);
        return true;
    }
    

    /**
     * Método eliminarVotante: Elimina un votante del registro si no se
     * encuentra vacio o si el votante se encuentra.
     * @param rut rut del votante
     * @return Retorna true si se elimina con éxito, retorna false caso contrario.
     */
    public boolean eliminarVotante(String rut){
        if(registroVotantesRut.isEmpty()){
            return false;
        }
        if(!registroVotantesRut.containsKey(rut)){
            return false;
        }
        registroVotantesRut.remove(rut);
        return true;
    }
    
    
    /**
     * Método obtenerDatosVotante: Guarda los datos del local del votante en
     * el arreglo de datos del votante.
     * @param v votante
     * @return Retorna un string con los datos del votante
     */
    public String[] obtenerDatosVotante(Votante v){
        String[] datosVotante = v.obtenerDatosPersona();
        datosVotante[5] = nombreLocal;
        datosVotante[6] = direccion;
        return datosVotante;
    }
   

    /**
     * Método mostrarVotantes: Muestra todos los votantes del local.
     */
    @Override
    public void mostrarDatos(){
        
        if(registroVotantesRut.size()>0){
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            // Se recorre el mapa registroVotantesRut
            for( String rut : registroVotantesRut.keySet()){
                Persona v = registroVotantesRut.get(rut);
                System.out.format("%-30s %-15s %-15s %-25s", v.getNombreCompleto(), rut, v.getComuna(), v.getDireccion());
                if(v.getEstadoElectoral()==1)System.out.println("SI");
                else System.out.println("NO");
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No hay datos");
        }
    }
    

    /**
     * Método obtenerCantidadVotantes: Obtiene la cantidad de votantes del local.
     * @return Retorna la cantidad de votantes del local
     */
    public int obtenerCantidadVotantes(){
        return registroVotantesRut.size();
    }
    

    /**
     * Método obtenerRutsVotantes: Obtiene un arreglo de strings con los ruts
     * de los votantes del local.
     * @return Retorna un arreglo de String con los ruts de los votantes de un local.
     */
    public String[] obtenerRutsVotantes(){
        String[] rutsVotantes = new String[ registroVotantesRut.size() ];   
        int i = 0;
        for(String rut : registroVotantesRut.keySet()){
            rutsVotantes[i] = rut;
        }
        return rutsVotantes;
    }
    
    /**
     * Método obtenerVotanteMasJoven: compara cada uno de los votantes del local,
     * hasta que encuentre el votante con el menor número de rut (sin el digito
     * verificador) y lo muestra.
     */
    public void obtenerVotanteMasJoven(){
        int guardado = 0; //almacenara el rut de valor mas alto encontrado hasta ese punto
        int aComparar; //Guardara el rut a comparar como int
        Votante vv = null; //votante que sera retornado
       for( String rut : registroVotantesRut.keySet()){
                Votante v = registroVotantesRut.get(rut);
                
                String input = v.getRut();   //string de entrada
                String primerosDigitos = "";   //contendra el rut sin digito verificador
 
                if (input.length() > 9) //Esta condicion verifica si el rut cuenta con 9 o 10 caracteres, guion incluido (12.345.678-9 o 1.234.567-8)
                     primerosDigitos = input.substring(0, 8);
                else
                   primerosDigitos = input.substring(0, 7);
                
                aComparar = Integer.parseInt(primerosDigitos); //Pasa los digitos a int
                
                if(aComparar > guardado){
                guardado = aComparar;
               vv = v;
                }
       }
    //mostrar VV;
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.format("%-30s %-15s %-15s %-25s", vv.getNombreCompleto(), vv.getRut(), vv.getComuna(), vv.getDireccion());
                if(vv.getEstadoElectoral()==1)System.out.println("SI");
                else System.out.println("NO");
    }
    
    /**
     * Método mostrarVotantesIntervalo: muestra los votantes que están en un intervalo de rut1 y rut2
     * que ingresa el usuario.
     * @throws IOException 
     */
    public void mostrarVotantesIntervalo() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int primerRut;
        int segundoRut = 0;
        int contador = 0;
        System.out.println("INGRESE PRIMER RUT SIN DIGITO VERIFICADOR (EJ: 1000000)");
        primerRut = Integer.parseInt(lector.readLine());
        
        //Ciclo que asegura un segundo rut mayor al primero
        System.out.println("INGRESE SEGUNDO RUT SIN DIGITO VERIFICADOR (MAYOR QUE EL PRIMERO)");
        segundoRut = Integer.parseInt(lector.readLine());
            if(segundoRut < primerRut)
                System.out.println("EL SEGUNDO RUT DEBE SER MAYOR AL PRIMERO");
        
        
         for( String rut : registroVotantesRut.keySet()){
                Votante v = registroVotantesRut.get(rut);
                String input = v.getRut();   //string de entrada
                String primerosDigitos = "";   //contendra el rut sin digito verificador
 
                if (input.length() > 9) //Esta condicion verifica si el rut cuenta con 9 o 10 caracteres, guion incluido (12.345.678-9 o 1.234.567-8)
                     primerosDigitos = input.substring(0, 8);
                else
                   primerosDigitos = input.substring(0, 7);
                int aComparar = Integer.parseInt(primerosDigitos); //Pasa los digitos a int
                
                if(aComparar >= primerRut && aComparar <= segundoRut){
                    if(contador == 0){
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println("\tNOMBRE\t\t\tRUT\t\tCOMUNA\t\tDIRECCION\tESTADO ELECTORAL ");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        contador++;
                    }
                    System.out.format("%-30s %-15s %-15s %-25s", v.getNombreCompleto(), v.getRut(), v.getComuna(), v.getDireccion());
                    if(v.getEstadoElectoral()==1)System.out.println("SI");
                    else System.out.println("NO");
                }
         }
         if(contador == 0)
             System.out.println("NO SE ENCONTRARON VOTANTES DENTRO DEL INTERVALO");
    }
    
    /**
     * Método getNombreLocal
     * @return Retorna el nombre del local
     */
    public String getNombreLocal() {
        return nombreLocal;
    }
    
    /**
     * Método getComuna
     * @return Retorna la comuna del local
     */
    public String getComuna() {
        return comuna;
    }
    
    /**
     * Método getDireccion
     * @return Retorna la dirección del local
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Método getCapacidadMaxima
     * @return Retorna la capacidad máxima de votantes del local
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    /**
     * Método getNumeroPrimeraMesa
     * @return Retorna el número de la primera mesa del local
     */
    public int getNumeroPrimeraMesa() {
        return numeroPrimeraMesa;
    }
    
    /**
     * Método getNumeroUltimaMesa
     * @return Retorna el número de la última mesa del local.
     */
    public int getNumeroUltimaMesa() {
        return numeroUltimaMesa;
    }
    
    /**
     * Método setNombreLocal
     * @param nombreLocal nombre del local de votación
     */
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    
    /**
     * Método setComuna
     * @param comuna comuna del local
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    /**
     * Método setDireccion
     * @param direccion dirección del local
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Método setCapacidadMaxima
     * @param capacidadMaxima capacidad máxima de votantes del local
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    /**
     * Método setPrimeraMesa
     * @param numeroPrimeraMesa número de la primera mesa del local
     */
    public void setNumeroPrimeraMesa(int numeroPrimeraMesa) {
        this.numeroPrimeraMesa = numeroPrimeraMesa;
    }
    
    /**
     * Métod setNumeroUltimaMesa
     * @param numeroUltimaMesa número de la última mesa del local
     */
    public void setNumeroUltimaMesa(int numeroUltimaMesa) {
        this.numeroUltimaMesa = numeroUltimaMesa;
    }

    /*@Override
    public void mostrarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
    
}