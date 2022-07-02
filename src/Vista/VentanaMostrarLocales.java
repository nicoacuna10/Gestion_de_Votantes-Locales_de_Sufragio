package Vista;


import Modelo.Local;
import Modelo.Region;
import javax.swing.JFrame;
import javax.swing.table.*;

/**
 *  Ventana mostrar locales de votacion
 * @author Nicolás Acuña
 */
public class VentanaMostrarLocales extends javax.swing.JFrame {
    private final JFrame menu;
    private final Region valparaiso;
    
    
    /**
     * Creates new form VentanaMostrarLocales
     * @param menu Ventana menu
     * @param valparaiso region de valparaiso
     */
    public VentanaMostrarLocales(JFrame menu, Region valparaiso) {
        initComponents();
        this.menu = menu;
        this.valparaiso = valparaiso;
        this.setLocationRelativeTo(null);
        
        this.mostrarLocales();
        
    }
    
    private void mostrarLocales(){
        DefaultTableModel modelo = (DefaultTableModel) tablaLocales.getModel();
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonVolverMenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLocales = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonVolverMenu.setText("Volver al menu");
        botonVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverMenuActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(456, 1000));

        tablaLocales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "comuna", "direccion", "capacidad maxima", "mesas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLocales);
        if (tablaLocales.getColumnModel().getColumnCount() > 0) {
            tablaLocales.getColumnModel().getColumn(0).setMinWidth(300);
            tablaLocales.getColumnModel().getColumn(0).setMaxWidth(300);
            tablaLocales.getColumnModel().getColumn(1).setMinWidth(150);
            tablaLocales.getColumnModel().getColumn(1).setMaxWidth(150);
            tablaLocales.getColumnModel().getColumn(3).setMinWidth(130);
            tablaLocales.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaLocales.getColumnModel().getColumn(3).setMaxWidth(130);
            tablaLocales.getColumnModel().getColumn(4).setMinWidth(80);
            tablaLocales.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaLocales.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Locales de votación de la región de Valparaiso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolverMenu)
                .addGap(497, 497, 497))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonVolverMenu)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverMenuActionPerformed
        this.setVisible(false);
        this.menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolverMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaLocales;
    // End of variables declaration//GEN-END:variables
}