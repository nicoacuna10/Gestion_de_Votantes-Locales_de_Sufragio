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
     * Contructor de la clase Local.
     */
    public Local(){
    
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
     * @param v votante
     * @return Retorna true si se agregó el votante, retorna false caso contrario.
     */
    public boolean agregarVotante(Votante v){
        if(registroVotantesRut.size() == capacidadMaxima || registroVotantesRut.containsKey(v.getRut())){
            return false;
        }
        registroVotantesRut.put(v.getRut(), v);
        return true;
        
    }
    

    /**
     * Método buscarVotante: Busca el votante en el registro.
     * @param rut rut del votante
     * @return Retorna el votante si se encuentra. Retorna null caso contrario
     */
    @Override
    public Votante buscarVotante(String rut){
        if(!registroVotantesRut.containsKey(rut)){
            return null;
        }
        return registroVotantesRut.get(rut);
    }
        
    
    /**
     * Método modificarNumeroDeMesaVotante: Modifica el número de mesa del votante.
     * Verifica que el número de mesa a cambiar del votante se encuentre entre los
     * rangos de mesa del local, es decir, que se encuentre entre el número de la primera mesa
     * y el de la última mesa (ambos límites inclusive).
     * @param rut rut del votante
     * @param numeroDeMesaNueva
     * @return Retorna true si se modifica el número de mesa, false en caso contrario.
     */
    public boolean modificarNumeroDeMesaVotante(String rut, int numeroDeMesaNueva){
        Votante v = registroVotantesRut.get(rut);
        if(numeroDeMesaNueva < numeroPrimeraMesa || numeroDeMesaNueva > numeroUltimaMesa){
            return false;
        }
        v.setNumeroDeMesa(numeroDeMesaNueva);
        return true;
    }
    
    /**
     * Método modificarNumeroDeMesaVotante: Modifica el número de mesa del votante.
     * Solo en caso de que la mesa del votante no se encuentre en el rango de mesas
     * del local. En ese caso, se realiza una reasignación aleatoria entre los rangos
     * de mesas del local.
     * @param rut rut del votante
     */
    public void modificarNumeroDeMesaVotante(String rut){
        Votante v = registroVotantesRut.get(rut);
        if(v.getNumeroDeMesa() < numeroPrimeraMesa || v.getNumeroDeMesa() > numeroUltimaMesa){
            int numeroDeMesa = (int) Math.floor(Math.random()*(numeroUltimaMesa - numeroPrimeraMesa + 1) + numeroPrimeraMesa);
            v.setNumeroDeMesa(numeroDeMesa);
        }
    
    }
    

    /**
     * Método eliminarVotante: Elimina un votante del registro si no se encuentra vacio o si el votante se encuentra.
     * @param rut rut del votante
     * @return Retorna true si se elimina con éxito, retorna false caso contrario.
     */
    @Override
    public boolean eliminarVotante(String rut){
        if(registroVotantesRut.isEmpty() || !registroVotantesRut.containsKey(rut)){
            return false;
        }
        registroVotantesRut.remove(rut);
        return true;
    }
    
    
    /**
     * Método obtenerDatosVotante: Guarda los datos del local del votante en
     * el String de datos del votante.
     * @param v votante
     * @return Retorna un string con los datos del votante
     */
    public String obtenerDatosVotante(Votante v){
        return v.obtenerDatosPersona() + ", " + nombreLocal + ", " + direccion;
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
            i++;
        }
        return rutsVotantes;
    }
    
    /**
     * Método modificaCapacidadMaxima: Modifica la capacidad maxima del local si
     * es mayor o igual a cien y distinta al valor actual.
     * @param capacidadMaximaNueva capacidad maxima nueva del local
     * @return Retorna true si se realizó la modificación, false caso contrario.
     */
    public boolean modificarCapacidadMaxima(int capacidadMaximaNueva){
        if(capacidadMaximaNueva < 100 || capacidadMaximaNueva == capacidadMaxima){
            return false;
        }
        setCapacidadMaxima(capacidadMaximaNueva);
        return true;
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
     * Método getNombreLocal: Obtiene el nombre del local.
     * @return Retorna el nombre del local
     */
    public String getNombreLocal() {
        return nombreLocal;
    }
    
    /**
     * Método getComuna: Obtienen la comuna donde se encuentra el local.
     * @return Retorna la comuna del local
     */
    public String getComuna() {
        return comuna;
    }
    
    /**
     * Método getDireccion: Obtiene la dirección del local.
     * @return Retorna la dirección del local
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Método getCapacidadMaxima: Obtiene la capacidad máxima del local.
     * @return Retorna la capacidad máxima de votantes del local
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    /**
     * Método getNumeroPrimeraMesa: Obtiene el número de la primera mesa del local.
     * @return Retorna el número de la primera mesa del local
     */
    public int getNumeroPrimeraMesa() {
        return numeroPrimeraMesa;
    }
    
    /**
     * Método getNumeroUltimaMesa: Obtiene el número de la última mesa del local.
     * @return Retorna el número de la última mesa del local.
     */
    public int getNumeroUltimaMesa() {
        return numeroUltimaMesa;
    }
    
    /**
     * Método setNombreLocal: Almacena el nombre del local.
     * @param nombreLocal nombre del local de votación
     */
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    
    /**
     * Método setComuna: Almacena la comuna donde se encuentra el local.
     * @param comuna comuna del local
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    /**
     * Método setDireccion: Almacena la dirección del local.
     * @param direccion dirección del local
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Método setCapacidadMaxima: Almacena la capacidad máxima del local.
     * @param capacidadMaxima capacidad máxima de votantes del local
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    /**
     * Método setPrimeraMesa: Almacena el número de la primera mesa del local.
     * @param numeroPrimeraMesa número de la primera mesa del local
     */
    public void setNumeroPrimeraMesa(int numeroPrimeraMesa) {
        this.numeroPrimeraMesa = numeroPrimeraMesa;
    }
    
    /**
     * Métod setNumeroUltimaMesa: Almacena el número de la última mesa del local.
     * @param numeroUltimaMesa número de la última mesa del local
     */
    public void setNumeroUltimaMesa(int numeroUltimaMesa) {
        this.numeroUltimaMesa = numeroUltimaMesa;
    }
    /**
     * Métod votantesPorNombreoApellido: Almacena los votantes que tengan un mismo nombre o apellido.
     * @param apellido nombre o apellido del votante
     * @param votantes arraylist que almacena votantes con un mismo nombre o apellido
     * @return Retorna un arraylist de votantes
     */
    public ArrayList votantesPorNombreoApellido(String apellido, ArrayList votantes) {
        int i=0;
        //Votante votantes[] = new Votante[lo.getCapacidadMaxima()];
        for(String rut : registroVotantesRut.keySet()){
            Votante v = registroVotantesRut.get(rut);
            String datos[] = (v.getNombreCompleto()).split(" ");
            for(int j=0 ; j<datos.length ; j++){
                if(datos[j].equals(apellido)){
                    votantes.add(v);
                    i++;
                }
            }
        }
        if(i==0)return null;
        return votantes;
    }
        
}