package Vista;

import Modelo.Local;
import Modelo.NoVotante;
import Modelo.Region;
import Modelo.RutException;
import Modelo.Votante;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Ventana modificar datos de una persona
 * @author Nicolás Acuña
 */
public class VentanaModificarDatosPersona extends javax.swing.JFrame {
    
    private JFrame menu;
    private Region valparaiso;

    /**
     * Creates new form VentanaModificarDatosPersona
     * @param menu Ventana menu
     * @param valparaiso Región de Valparaíso
     */
    public VentanaModificarDatosPersona(JFrame menu, Region valparaiso) {
        initComponents();
        this.menu = menu;
        this.valparaiso = valparaiso;
        
        jLabel3.setVisible(false);
        jTextField2.setVisible(false);
        jButton1.setEnabled(false);
    }
    
    public void habilitarBotonModificarDatosPersona(){
        if(botonModificarNumeroDeMesa.isSelected() || botonModificarLocal.isSelected() || botonModificarRazon.isSelected()){
            if(!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()){
                jButton1.setEnabled(true);
            }else jButton1.setEnabled(false);
        
        }else jButton1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonModificarNumeroDeMesa = new javax.swing.JRadioButton();
        botonModificarLocal = new javax.swing.JRadioButton();
        botonModificarRazon = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese rut de la persona para modificar sus datos:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setText("Seleccione opción de modificación:");

        buttonGroup1.add(botonModificarNumeroDeMesa);
        botonModificarNumeroDeMesa.setText("Modificar número mesa del votante");
        botonModificarNumeroDeMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarNumeroDeMesaActionPerformed(evt);
            }
        });

        buttonGroup1.add(botonModificarLocal);
        botonModificarLocal.setText("Modificar local de votación del votante");
        botonModificarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarLocalActionPerformed(evt);
            }
        });

        buttonGroup1.add(botonModificarRazon);
        botonModificarRazon.setText("Modificar razón del no votante");
        botonModificarRazon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarRazonActionPerformed(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton1.setText("Modificar datos");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificarRazon)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonModificarNumeroDeMesa)
                        .addGap(65, 65, 65)
                        .addComponent(botonModificarLocal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonModificarNumeroDeMesa)
                    .addComponent(botonModificarLocal))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonModificarRazon)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarNumeroDeMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarNumeroDeMesaActionPerformed
        jLabel3.setVisible(true);
        jTextField2.setVisible(true);
        
        jLabel3.setText("Ingrese número de mesa nuevo:");
    }//GEN-LAST:event_botonModificarNumeroDeMesaActionPerformed

    private void botonModificarRazonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarRazonActionPerformed
        jLabel3.setVisible(true);
        jTextField2.setVisible(true);
        
        jLabel3.setText("Ingrese razón nueva:");
    }//GEN-LAST:event_botonModificarRazonActionPerformed

    private void botonModificarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarLocalActionPerformed
        jLabel3.setVisible(true);
        jTextField2.setVisible(true);
        
        jLabel3.setText("Ingrese nombre del local a cambiar:");
    }//GEN-LAST:event_botonModificarLocalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String rut = jTextField1.getText().toUpperCase();
        
        try {
            if(rut.indexOf('-')==-1 || rut.length()<9 || rut.length()>10){
                throw new RutException();
            }
        } catch (RutException e) {
            String rutAux = rut;
            while(rutAux.length()<9 || rutAux.length()>10 || rutAux.indexOf('-')==-1){
                System.out.println(e.getMessage());
                rutAux = JOptionPane.showInputDialog("Ingrese nuevamente el rut");
                if(rut.length()>9 && rut.length()<11)break;
                if(rut.indexOf('-')!=-1)break;
                rut=rutAux;
            }              
        }
        
        
        if(botonModificarNumeroDeMesa.isSelected()){
            
            Votante v = valparaiso.buscarVotante(rut);
            if(v!= null){
                Local a = valparaiso.obtenerLocalVotante(rut);
                
                int numeroDeMesaNueva = Integer.parseInt(jTextField2.getText());
                if( valparaiso.modificarDatosVotante(v, a, numeroDeMesaNueva) ){
                        JOptionPane.showConfirmDialog(rootPane, "Los datos del votante fueron modificados");
                }else JOptionPane.showMessageDialog(rootPane, "No se modificaron los datos del votante");
                
            }else JOptionPane.showMessageDialog(rootPane, "No se encontró el votante en el registro");
        
        }else if(botonModificarLocal.isSelected()){
            
            Votante v = valparaiso.buscarVotante(rut);
            if(v!= null){
                Local a = valparaiso.obtenerLocalVotante(rut);
                
                String nombreLocalNuevo = jTextField2.getText().toUpperCase();
                
                Local b = valparaiso.buscarLocal(nombreLocalNuevo);
                
                if( valparaiso.modificarDatosVotante(v, a, b) ){
                        JOptionPane.showMessageDialog(rootPane, "Los datos del votante fueron modificados");
                }else JOptionPane.showMessageDialog(rootPane, "No se modificaron los datos del votante");
                
            }else JOptionPane.showMessageDialog(rootPane, "No se encontró el votante en el regitro");
        
        }else{
            
            NoVotante nv = valparaiso.buscarNoVotante(rut);
            if(nv!= null){
                String razonNueva = jTextField2.getText().toUpperCase();
                
                if( valparaiso.modificarDatosNoVotante(rut, razonNueva) ){
                    JOptionPane.showMessageDialog(rootPane, "Los datos del no votante fueron modificados");
                }else JOptionPane.showMessageDialog(rootPane, "No se modificaron los datos del no votante");
            
            }else JOptionPane.showMessageDialog(rootPane, "No se encontró el no votante en el registro");

        }

        this.setVisible(false);
        this.menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        habilitarBotonModificarDatosPersona();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        habilitarBotonModificarDatosPersona();
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonModificarLocal;
    private javax.swing.JRadioButton botonModificarNumeroDeMesa;
    private javax.swing.JRadioButton botonModificarRazon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
