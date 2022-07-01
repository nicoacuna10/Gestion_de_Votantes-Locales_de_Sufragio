package Modelo;

import java.util.*;

/**
 * Region contiene las colecciones de Locales y de NoVotantes
 * @author Nicolás Acuña
 * 
 */
public class Region implements Mostrable{
    
    private final HashMap <String, Local> registroLocalesNombre; // Mapa de Locales con clave el nombre.
    private final HashMap <String, NoVotante> registroNoVotantesRut;// Mapa de No votantes con clave rut.
    
    /**
     * Constructor de la clase Region, inicializa las colecciones
     */
    StrategySortMostrar strategy;
    
    public Region(){
        registroLocalesNombre = new HashMap();
        registroNoVotantesRut = new HashMap();
    }
    
    /**
     * Método agregarLocal: Se ingresa un local nuevo al registro. Se verifica que el votante no se encuentre en el registro.
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
        
    
    /**
     * Método buscarLocal: Se ingresa el nombre local y busca dentro del registro.
     * @param nombreLocal nombre del local a buscar
     * @return Si lo encuentra retorna el local. En caso contrario retorna null.
     */
    public Local buscarLocal(String nombreLocal){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
           return null; 
        }
        return registroLocalesNombre.get(nombreLocal);
    }
    

    /**
     * Método modificarDatosLocal: modifica la capacidad maxima del local.
     * Solo se hace la modificación si el local existe en el registro.
     * @param nombreLocal nombre del local
     * @param capacidadMaximaNueva capacidad maxima
     * @return Si se modificaron los datos retorna true. En caso contrario retorna null.
     */
    public boolean modificarDatosLocal(String nombreLocal, int capacidadMaximaNueva){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        return a.modificarCapacidadMaxima(capacidadMaximaNueva);
    }
    

    /**
     * Método eliminarLocal: Se ingresa el nombre del local y se elimina en caso
     * de existir en el registro.
     * @param nombreLocal nombre del local
     * @return Si se existe, se elimina y retorna true. En caso contrario retorna false.
     */
    public boolean eliminarLocal(String nombreLocal){
        if(registroLocalesNombre.isEmpty() || !registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        registroLocalesNombre.remove(nombreLocal);
        return true;
    
    }
    
    /**
     * Método obtenerNombresLocales: Obtiene un arreglo de String con los nombres
     * de los locales.
     * @return Retorna un arreglo de String con los nombres de los locales.
     */
    public String[] obtenerNombresLocales(){
        String[] nombresLocales = new String[registroLocalesNombre.size()];
        int i = 0;
        for(String nombreLocal : registroLocalesNombre.keySet()){
            nombresLocales[i] = nombreLocal;
            i++;
        }
        return nombresLocales;
    }
    
    /**
     * Método obtenerCantidadLocales: Obtiene la cantidad de locales de la región.
     * @return Retorna la cantidad de locales de votación de la región.
     */
    public int obtenerCantidadLocales(){
        return registroLocalesNombre.size();
    }

    /**
     * Método agregarVotante: Agrega un nuevo votante si no existe dentro del local de votación.
     * Utiliza el método agregarVotante de la clase Local para agregarlo al mapa de votantes del local.
     * @param nombreLocal nombre del local
     * @param v votante nuevo
     * @return Retorna true si lo agrega, caso contrario false.
     */
    public boolean agregarVotante(String nombreLocal, Votante v){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return false;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        return a.agregarVotante(v);
    }
    

    /**
     * Método agregarNoVotante: Agrega un nuevo votante que no está habilitado para votar (estadoElectoral de valor 0).
     * @param nv no votante
     * @return Retorna true si lo agrega, caso contrario false. 
     */
    public boolean agregarNoVotante(NoVotante nv){
        if( registroNoVotantesRut.containsKey(nv.getRut())){
            return false;
        }
        registroNoVotantesRut.put(nv.getRut(), nv);
        return true;
    }
    
    
    /**
     * Método buscarVotante: Busca un votante en el local con el nombre que ingresa.
     * En caso de que exista el local ingresado, lo busca con el método buscarVotante de la clase Local.
     * @param nombreLocal nombre del local
     * @param rut rut del votante
     * @return Retorna el votante si lo encuentra en la colección del local. Retorna null si el local ingresado no existe en el registro o si no lo encontró en la colección de este.
     */
    public Votante buscarVotante(String nombreLocal, String rut){
        if(!registroLocalesNombre.containsKey(nombreLocal)){
            return null;
        }
        Local a = registroLocalesNombre.get(nombreLocal);
        return a.buscarVotante(rut);
    }
      
    /**
     * Método buscarVotante: Busca un votante en todos los locales de votación hasta que lo encuentre o términe de recorrer (lo que ocurra primero).
     * @param rut rut del votante
     * @return Si lo encuentra retorna el votante. Si termina de recorrer los locales sin éxito, retorna null.
     */
    @Override
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
     * Métoso buscarNoVotante: Busca un no votante en el registro con el rut personal.
     * @param rut rut no votante.
     * @return Retorna el no votante si lo encuentra, null caso contrario.
     */
    public NoVotante buscarNoVotante(String rut){
        if(!registroNoVotantesRut.containsKey(rut)){
            return null;
        }
        NoVotante nv = registroNoVotantesRut.get(rut);
        return nv;
    }
    
    /**
     * Método obtenerLocalVotante: Obtiene el local a partir de la búsqueda del votante.
     * @param rut rut del votante
     * @return Retorna el local si encontró al votante, null caso contrario.
     */
    public Local obtenerLocalVotante(String rut){
        for(String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            Votante v = a.buscarVotante(rut);
            if(v != null){
                return a;
            }
        
        }
        return null;
    }
    
    /**
     * Método modificarDatosVotante: Modifica el número de mesa de un votante.
     * Utiliza el método modificarNumeroDeMesaVotante para actualizar el dato.
     * @param v votante
     * @param a local
     * @param numeroDeMesaNueva número de mesa nuevo a cambiar
     * @return Retorna true, si se realizó la modificación, false caso contrario.
     */
    public boolean modificarDatosVotante(Votante v, Local a, int numeroDeMesaNueva){
        if(!registroLocalesNombre.containsKey(a.getNombreLocal()) || a.buscarVotante(v.getRut()) == null){
            return false;
        }
        return a.modificarNumeroDeMesaVotante(v.getRut(), numeroDeMesaNueva); 
    }
    
    /**
     * Método modificarDatosVotante: Cambia de local al votante.
     * Si el nombre ingresado del local nuevo coincide con el actual, no se hace al cambio.
     * Si los nombres de locales son distintos, se elimina del actual, se agrega al nuevo,
     * y en este último se llama al método modificarNumeroDeMesaVotante para verificar si es
     * necesario realizar la modificación del número de mesa.
     * @param v votante
     * @param a local actual del votante
     * @param b local nuevo del votante (local a cambiar)
     * @return Retorna true, si se realizó la modificación, false caso contrario.
     */
    public boolean modificarDatosVotante(Votante v, Local a, Local b){
        if(!registroLocalesNombre.containsKey(a.getNombreLocal()) || !registroLocalesNombre.containsKey(b.getNombreLocal()) || a.buscarVotante(v.getRut()) == null || a.getNombreLocal().equals(b.getNombreLocal())){
            return false;
        }
        a.eliminarVotante(v.getRut());
        b.agregarVotante(v);
        b.modificarNumeroDeMesaVotante(v.getRut());
        return true;
    }
    
    
    /**
     * Método modificarDatosNoVotante: Modifica la razón del no votante por la que no puede votar.
     * @param rut rut del no votante
     * @param razon razon por la que no vota
     * @return Retorna true si se modificó el dato, falso caso contrario.
     */
    public boolean modificarDatosNoVotante(String rut, String razon){
        if( !registroNoVotantesRut.containsKey(rut)){
            return false;
        }
        NoVotante nv = registroNoVotantesRut.get(rut);
        nv.setRazon(razon);
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
    @Override
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
     * Método eliminarNoVotante: elimina un no votante del registro si se encuentra.
     * @param rut rut del no votante
     * @return Retorna true si lo elimina, false caso contrario.
     */
    public boolean eliminarNoVotante(String rut){
        if(!registroNoVotantesRut.containsKey(rut)){
            return false;
        }
        registroNoVotantesRut.remove(rut);
        return true;
    }
    

    /**
     * Método obtenerDatosVotante: Busca el votante en todos los locales y obtiene
     * sus datos.
     * @param rut rut del votante 
     * @return Retorna un string con los datos del votante.
     */
    public String obtenerDatosVotante(String rut){
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
                Votante v = a.buscarVotante(rut);
                if(v != null){
                   return a.obtenerDatosVotante(v);
                }
        }
        return null;
    }
    
    /**
     * Método obtenerDatosNoVotante: Busca el no votante en el registro y obtiene
     * sus datos.
     * @param rut rut del no votante
     * @return Retorna un string con los datos del no votante
     */
    public String obtenerDatosNoVotante(String rut){
        NoVotante nv = buscarNoVotante(rut);
        if(nv != null){
            return nv.obtenerDatosPersona();
        }else return null;
    }
    
    /**
     * Método obtenerRutsVotantes: Obtiene un arreglo de String con los ruts
     * de los votantes de un local. Utiliza el método del mismo nombre.
     * @param a local
     * @return Retorna un arreglo de String con los ruts de los votantes de un local.
     */
    public String[] obtenerRutsVotantes(Local a){
        return a.obtenerRutsVotantes();
    }
    
    /**
     * Método obtenerRutsVotantes: Obtiene un arreglo de Strings con los ruts de
     * todos los votantes de la región. Utiliza el método del mismo nombre, que
     * le entrega un arreglo de String de ruts de los votantes de un solo local.
     * @return Retorna un arreglo de String con los ruts de todos los votantes de la región.
     */
    public String[] obtenerRutsVotantes(){
        int cantidadVotantesTotal = 0;
        for( String nombreLocal : registroLocalesNombre.keySet()){
            Local a = registroLocalesNombre.get(nombreLocal);
            cantidadVotantesTotal = cantidadVotantesTotal + a.obtenerCantidadVotantes();
        }
        
        String[] rutsVotantes = new String[cantidadVotantesTotal];
        int j = 0;
        for(String nombreLocal : registroLocalesNombre.keySet()){
            
            Local a =registroLocalesNombre.get(nombreLocal);
            String[] rutsVotantesLocal = a.obtenerRutsVotantes();
            
            for(int i = 0; i < rutsVotantesLocal.length; i++){
                rutsVotantes[j] = rutsVotantesLocal[i];
                j++;
            }
        }
        return rutsVotantes;
    }
    
    /**
     * Método obtenerRutsNoVotantes: Obtiene un arreglo de String con los ruts de
     * los no votantes de la región.
     * @return Retorna un arreglo de String con los ruts de los no votantes.
     */
    public String[] obtenerRutsNoVotantes(){
        String[] rutsNoVotantes = new String[registroNoVotantesRut.size()];
        int i = 0;
        for(String rutNoVotante : registroNoVotantesRut.keySet()){
            rutsNoVotantes[i] = rutNoVotante;
            i++;
        }
        return rutsNoVotantes;
    }
            
    /**
     * Método votantesPorNombreoApellido: Busca el no votante en el registro y obtiene
     * sus datos.
     * @param apellido Nombre o apellido del votante
     * @return Retorna un string con los datos de los votantes
     */
    public String[] votantesPorNombreoApellido(String apellido) {
        ArrayList votantes = new ArrayList();
        for(String nombreLocal : registroLocalesNombre.keySet()){
            Local lo = registroLocalesNombre.get(nombreLocal);
            lo.votantesPorNombreoApellido(apellido,votantes);
        }
        if(votantes.size()>0){
            String [] rutsVotantes = new String[votantes.size()];
            for(int i=0 ; i<votantes.size() ; i++){
                rutsVotantes[i] = ((Votante)votantes.get(i)).getRut();
            }
            return rutsVotantes;
        }
        return null;
    }
    /**
     * Método localMasLleno: Busca el local que posea mas votantes
     * @return Retorna un arreglo de Object, el que almacena el local y su cantidad
     * de votantes.
     */
    public Object[] localMaslleno() {
        Object[] datos = new Object[2];
        datos[1] = 0;
        int maxTamano;
        for(String nombreLocal : registroLocalesNombre.keySet()){
            Local localAux = registroLocalesNombre.get(nombreLocal);
            maxTamano = localAux.obtenerCantidadVotantes();
            if((int)datos[1] < maxTamano){
                datos[1] = maxTamano;
                datos[0] = localAux;
            }
        }
        return datos;
    }
    /*
    Metodos pertenecientes a Strategy
    Se establece el formato de salida en el primer metodo y se muestra en el segundo
    */
    public void setDisplayFormat( StrategySortMostrar ssm ) {
    strategy = ssm;
}
    public void mostrar(){
    strategy.mostrarDatos(registroLocalesNombre);
    }

}