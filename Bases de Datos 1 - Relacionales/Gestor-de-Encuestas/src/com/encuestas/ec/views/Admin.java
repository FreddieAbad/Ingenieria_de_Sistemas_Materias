/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;

/**
 *
 * @author Freddie
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        setTitle("Gestor de Encuestas - Administrador");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdGroupSeleccionTexto = new javax.swing.ButtonGroup();
        rdGroupSelUnicaMultiple = new javax.swing.ButtonGroup();
        rdGroupRespuestas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreEncuesta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionEncuesta = new javax.swing.JTextArea();
        rdRespuestaLarga = new javax.swing.JRadioButton();
        rdSeleccion = new javax.swing.JRadioButton();
        rdOpcionMultiple = new javax.swing.JRadioButton();
        txtPregunta = new javax.swing.JTextField();
        txtOpcion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tcPreguntas = new javax.swing.JTable();
        btnAgregarOpcion = new javax.swing.JButton();
        btnCancelarPregunta = new javax.swing.JButton();
        btnAgregarEncuesta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiarPregunta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnLimpiarEncuesta = new javax.swing.JButton();
        btnCancelarEncuesta = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbOpciones = new javax.swing.JTable();
        btnEliminarPregunta = new javax.swing.JButton();
        rdSeleccionUnica = new javax.swing.JRadioButton();
        rdTexto = new javax.swing.JRadioButton();
        rdRespuestaCorta = new javax.swing.JRadioButton();
        btnAgregarPregunta1 = new javax.swing.JButton();
        btnEliminarOpcion1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Gestor de Encuestas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        txtNombreEncuesta.setText("Nombre de la Encuesta");
        txtNombreEncuesta.setToolTipText("");
        jPanel1.add(txtNombreEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 400, -1));

        txtDescripcionEncuesta.setColumns(20);
        txtDescripcionEncuesta.setRows(5);
        txtDescripcionEncuesta.setText("Descripcion de la Encuesta");
        jScrollPane1.setViewportView(txtDescripcionEncuesta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 400, 60));

        rdGroupRespuestas.add(rdRespuestaLarga);
        rdRespuestaLarga.setText("Respuesta Larga");
        jPanel1.add(rdRespuestaLarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        rdGroupSeleccionTexto.add(rdSeleccion);
        rdSeleccion.setText("Seleccion");
        jPanel1.add(rdSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        rdGroupSelUnicaMultiple.add(rdOpcionMultiple);
        rdOpcionMultiple.setText("Opcion Multiple");
        jPanel1.add(rdOpcionMultiple, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        txtPregunta.setText("Pregunta");
        txtPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 410, -1));

        txtOpcion.setText("Opcion");
        txtOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpcionActionPerformed(evt);
            }
        });
        jPanel1.add(txtOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, -1));

        tcPreguntas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PREGUNTA", "TIPO"
            }
        ));
        jScrollPane2.setViewportView(tcPreguntas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 570, 110));

        btnAgregarOpcion.setText("Agregar");
        jPanel1.add(btnAgregarOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        btnCancelarPregunta.setText("Cancelar");
        jPanel1.add(btnCancelarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, -1, -1));

        btnAgregarEncuesta.setText("Aceptar");
        jPanel1.add(btnAgregarEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, -1, -1));

        jLabel2.setText("Agregar Pregunta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        btnLimpiarPregunta.setText("Limpiar");
        jPanel1.add(btnLimpiarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 412, 640, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 660, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 660, 80));

        btnLimpiarEncuesta.setText("Limpiar");
        jPanel1.add(btnLimpiarEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, -1, -1));

        btnCancelarEncuesta.setText("Cancelar");
        jPanel1.add(btnCancelarEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 660, 30));

        tbOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opciones"
            }
        ));
        jScrollPane3.setViewportView(tbOpciones);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 220, 80));

        btnEliminarPregunta.setText("Eliminar");
        jPanel1.add(btnEliminarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, -1, -1));

        rdGroupSelUnicaMultiple.add(rdSeleccionUnica);
        rdSeleccionUnica.setText("Seleccion Unica");
        jPanel1.add(rdSeleccionUnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        rdGroupSeleccionTexto.add(rdTexto);
        rdTexto.setText("Texto");
        jPanel1.add(rdTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        rdGroupRespuestas.add(rdRespuestaCorta);
        rdRespuestaCorta.setText("Respuesta Corta");
        jPanel1.add(rdRespuestaCorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        btnAgregarPregunta1.setText("Agregar");
        jPanel1.add(btnAgregarPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, -1));

        btnEliminarOpcion1.setText("Eliminar");
        jPanel1.add(btnEliminarOpcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreguntaActionPerformed

    private void txtOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOpcionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEncuesta;
    private javax.swing.JButton btnAgregarOpcion;
    private javax.swing.JButton btnAgregarPregunta1;
    private javax.swing.JButton btnCancelarEncuesta;
    private javax.swing.JButton btnCancelarPregunta;
    private javax.swing.JButton btnEliminarOpcion1;
    private javax.swing.JButton btnEliminarPregunta;
    private javax.swing.JButton btnLimpiarEncuesta;
    private javax.swing.JButton btnLimpiarPregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.ButtonGroup rdGroupRespuestas;
    private javax.swing.ButtonGroup rdGroupSelUnicaMultiple;
    private javax.swing.ButtonGroup rdGroupSeleccionTexto;
    private javax.swing.JRadioButton rdOpcionMultiple;
    private javax.swing.JRadioButton rdRespuestaCorta;
    private javax.swing.JRadioButton rdRespuestaLarga;
    private javax.swing.JRadioButton rdSeleccion;
    private javax.swing.JRadioButton rdSeleccionUnica;
    private javax.swing.JRadioButton rdTexto;
    private javax.swing.JTable tbOpciones;
    private javax.swing.JTable tcPreguntas;
    private javax.swing.JTextArea txtDescripcionEncuesta;
    private javax.swing.JTextField txtNombreEncuesta;
    private javax.swing.JTextField txtOpcion;
    private javax.swing.JTextField txtPregunta;
    // End of variables declaration//GEN-END:variables
}
