package gestiondevotantes;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *  VentanaMostrarLocales
 * @author Nicolás Acuña
 */
public class VentanaMostrarLocales extends JFrame{
    
    private JTable tabla = null;
    private DefaultTableModel modelo = null;
    private JScrollPane desplazamiento = null;
    
    /**
     * Constructor de la clase VentanaMostrarLocales
     * @param valparaiso 
     */
    public VentanaMostrarLocales(Region valparaiso) {
        String[] columnas = {"Nombre", "Comuna", "Direccion", "Capacidad Maxima", "Mesas"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);       

        // Parametros de la ventana
        this.setTitle("Locales de la region de Valparaiso");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);

        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);

        tabla.setModel(modelo);

        // Agregamos datos
        this.agregarDatos(modelo, valparaiso);
        
        
        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
        this.pack();
    }
    
    /**
     * Método agregarDatos: agrega los datos de los locales a la tabla.
     * @param modelo
     * @param valparaiso 
     */
    private void agregarDatos(DefaultTableModel modelo, Region valparaiso) {
        // Borramos todas las filas en la tabla
        modelo.setRowCount(0);
        
        String[] nombresLocales = valparaiso.obtenerNombresLocales();
        int cantidadLocales = nombresLocales.length;
        
        Object[] datosFila = new Object[5];
        
        for(int i = 0; i < cantidadLocales; i++) {
            Local a = valparaiso.buscarLocal(nombresLocales[i]);
            datosFila[0] = a.getNombreLocal();
            datosFila[1] = a.getComuna();
            datosFila[2] = a.getDireccion();
            datosFila[3] = String.valueOf(a.getCapacidadMaxima());
            datosFila[4] = String.valueOf(a.getNumeroPrimeraMesa()) + " - " + String.valueOf(a.getNumeroUltimaMesa());
            modelo.addRow(datosFila);
            
        }
    }
    
}
