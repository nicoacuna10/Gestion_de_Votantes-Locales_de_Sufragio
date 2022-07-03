
package Vista;

import Modelo.Local;
import Modelo.Region;
import Modelo.StrategySortMostrar;
import Modelo.Votante;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gerard Sagredo
 */
public class VentanaMostrarSortRutsVotantes extends javax.swing.JFrame implements StrategySortMostrar{
    private final JFrame menu;
    private final Region valparaiso;  
    /**
     * Creates new form VentanaMostrarLocales
     * @param menu Ventana menu
     * @param valparaiso region de valparaiso
     */
    public VentanaMostrarSortRutsVotantes(JFrame menu, Region valparaiso) {
        initComponents();
        this.menu = menu;
        this.valparaiso = valparaiso;
        this.setLocationRelativeTo(null);   
        
        this.mostrarDatos();
    }
    
     @Override
    public void mostrarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaLocales.getModel();
        
        String[] localesPorNombre = valparaiso.obtenerNombresLocales();
        Arrays.sort(localesPorNombre);
        Object[] datosFila = new Object[7];
        
        for(int i=0;i<(localesPorNombre.length);i++){
            
            String buscado = localesPorNombre[i];
            Local ll = valparaiso.buscarLocal(buscado);
            String[] ruts = ll.obtenerRutsVotantes();
            for(int j=0;j<ruts.length;j++){
                String datosVotante = valparaiso.obtenerDatosVotante(ruts[j]);
                String [] arregloDatosVotante = datosVotante.split(",");
            
                datosFila[0] = arregloDatosVotante[5];
                datosFila[1] = arregloDatosVotante[0];
                datosFila[2] = arregloDatosVotante[1];
                datosFila[3] = arregloDatosVotante[2];
                datosFila[4] = arregloDatosVotante[3];
                datosFila[5] = arregloDatosVotante[6];
                datosFila[6] = arregloDatosVotante[4];
            
            modelo.addRow(datosFila);
            }
            
        }
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonVolverMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLocales = new javax.swing.JTable();
        botonVolverMenu1 = new javax.swing.JButton();

        botonVolverMenu.setText("Volver al menu");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Todos los votantes de todos los locales en orden alfabético");

        tablaLocales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "Nombre", "Rut", "Comuna", "Dirección", "Dirección Local", "Mesa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLocales);

        botonVolverMenu1.setText("Volver al menu");
        botonVolverMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverMenu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolverMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonVolverMenu1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverMenu1ActionPerformed
        this.setVisible(false);
        this.menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverMenu1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolverMenu;
    private javax.swing.JButton botonVolverMenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLocales;
    // End of variables declaration//GEN-END:variables

}
