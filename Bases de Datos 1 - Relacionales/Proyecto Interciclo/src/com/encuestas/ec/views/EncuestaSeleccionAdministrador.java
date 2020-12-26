/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;

import com.encuestas.ec.bo.ObjectBo;
import com.encuestas.ec.dao.ObjectDao;
import com.encuestas.ec.entity.Consultas;
import com.encuestas.ec.entity.Encuesta;
import com.encuestas.ec.entity.Opciones;
import com.encuestas.ec.entity.Pregunta;
import com.encuestas.ec.entity.RespuestaTexto;
import com.encuestas.ec.entity.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Freddie
 */
public class EncuestaSeleccionAdministrador extends javax.swing.JFrame {

    Encuesta encuesta = new Encuesta();
    ObjectBo obo = new ObjectBo();
    ObjectDao objeto = new ObjectDao();
    Consultas consultas;

    public EncuestaSeleccionAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        listarObjetoE();
    }

    public void listarObjetoE() {
        /*
        String[] tableO = {"IDENCUESTA", "NOMBRE", "DESCRIPCION", "IDTIPOENCUESTA"};
        try {
            obo.listarObjetoE(tblEncuestas, encuesta, tableO);//, labelsTablas, lblsTablas, dataty
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         */

        String columna = " IDENCUESTA, NOMBRE, DESCRIPCION, IDTIPOENCUESTA ";
        String tablas = " ENCUESTA ";
        String complemento = " "; //order by
        int joinInt = 1;
        consultas = new Consultas(columna, tablas, complemento, joinInt);
        obo.listarObjetoGenerico(tblEncuestas, consultas);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEncuestas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarEncuesta = new javax.swing.JButton();
        btnSeleccionEncuesta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEncuestas.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        tblEncuestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ENCUESTA", "Nombre Encuesta", "Descripcion", "TipoEncuesta"
            }
        ));
        jScrollPane1.setViewportView(tblEncuestas);

        jLabel1.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(214, 217, 223));
        jLabel1.setText("jLabel1");

        btnAgregarEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnAgregarEncuesta.setText("Nueva Encuesta");
        btnAgregarEncuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEncuestaActionPerformed(evt);
            }
        });

        btnSeleccionEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSeleccionEncuesta.setText("Seleccionar");
        btnSeleccionEncuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionEncuestaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel2.setText("Seleccione una encuesta");

        btnCancelar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAgregarEncuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btnSeleccionEncuesta)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(btnAgregarEncuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSeleccionEncuesta)
                        .addGap(111, 111, 111)
                        .addComponent(btnCancelar)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionEncuestaActionPerformed
        int column = 0;
        int row = tblEncuestas.getSelectedRow();
        String selection = tblEncuestas.getModel().getValueAt(row, column).toString();
        try {
            int valorIndice = Integer.parseInt(tblEncuestas.getValueAt(row, 0).toString());
            String valorN = tblEncuestas.getValueAt(row, 1).toString();
            String valorD = tblEncuestas.getValueAt(row, 2).toString();
            EncuestaFrame eframe = new EncuestaFrame(valorIndice, valorN, valorD);
            eframe.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnSeleccionEncuestaActionPerformed

    private void btnAgregarEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEncuestaActionPerformed
        EncuestaFrame ven = new EncuestaFrame();
        ven.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarEncuestaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEncuesta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionEncuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEncuestas;
    // End of variables declaration//GEN-END:variables
}
