package Vista;

import Modelo.Region;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana mostrar votantes de un mismo nombre o apellido
 * @author Nicolás Acuña
 */
public class VentanaMostrarVotantesNombreoApellido extends javax.swing.JFrame {
    
    private final JFrame menu;
    private final Region valparaiso;

    /**
     * Creates new form VentanaMostrarVotantesNombreoApellido
     * @param menu Ventana menu
     * @param valparaiso región de valparaiso
     */
    public VentanaMostrarVotantesNombreoApellido(JFrame menu, Region valparaiso) {
        initComponents();
        this.menu = menu;
        this.valparaiso = valparaiso;
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVotantesNombreOApellido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese nombre o apellido");

        jButton1.setText("Buscar Votantes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver al menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablaVotantesNombreOApellido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Rut", "Comuna", "Dirección", "Local", "Dirección Local", "Mesa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVotantesNombreOApellido);
        if (tablaVotantesNombreOApellido.getColumnModel().getColumnCount() > 0) {
            tablaVotantesNombreOApellido.getColumnModel().getColumn(0).setMinWidth(300);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(0).setMaxWidth(300);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(1).setMinWidth(100);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(1).setMaxWidth(100);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(2).setMinWidth(150);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(2).setMaxWidth(150);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(3).setMinWidth(200);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(3).setMaxWidth(200);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(4).setMinWidth(300);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(4).setMaxWidth(300);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(5).setMinWidth(200);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(5).setMaxWidth(200);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(6).setMinWidth(60);
            tablaVotantesNombreOApellido.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(1211, 1211, 1211)
                                    .addComponent(jButton2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVotantesNombreOApellido.getModel();
        
        String nombreOApellido = jTextField1.getText();
        nombreOApellido = nombreOApellido.toUpperCase();
        
        String[] datos = valparaiso.votantesPorNombreoApellido(nombreOApellido);
        
        if (datos!=null){
            
            for(int i=0; i<datos.length ; i++){

                String datosPersona = valparaiso.obtenerDatosVotante(datos[i]);
                
                if(datosPersona != null){
                    
                    Object[] datosFila = new Object[7];
                    String[] arregloDatosPersona = datosPersona.split(",");
                  
                    jLabel1.setText("DATOS VOTANTE");

                    datosFila[0] = arregloDatosPersona[0];
                    datosFila[1] = arregloDatosPersona[1];
                    datosFila[2] = arregloDatosPersona[2];
                    datosFila[3] = arregloDatosPersona[3];
                    datosFila[4] = arregloDatosPersona[5];
                    datosFila[5] = arregloDatosPersona[6];
                    datosFila[6] = arregloDatosPersona[4];

                    modelo.addRow(datosFila);
                     
                }
            }
            
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "No hay registro de votantes con dicho nombre o apellido");
            this.setVisible(false);
            this.menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaVotantesNombreOApellido;
    // End of variables declaration//GEN-END:variables
}
