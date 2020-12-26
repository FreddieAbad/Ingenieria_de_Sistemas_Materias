/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;

import com.encuestas.ec.entity.TextPrompt;
import com.encuestas.ec.bo.ObjectBo;
import com.encuestas.ec.dao.ObjectDao;
import com.encuestas.ec.entity.Usuario;
import java.awt.Font;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    int valorIndice = 0;
    String valorN = "";
    String valorD = "";
    ObjectBo obo = new ObjectBo();
    ObjectDao objeto = new ObjectDao();
    Usuario usuario = new Usuario();

    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        TextPrompt placeholder = new TextPrompt("CI", txtCI);
        placeholder = new TextPrompt("DIRECCION", txtDireccion);
        placeholder = new TextPrompt("NOMBRES", txtNombre);
        placeholder = new TextPrompt("TELEFONO", txtTelefono);
        placeholder = new TextPrompt("USUARIO", txtLogCI);
        placeholder = new TextPrompt("CONTRASEÑA", txtLogPassw);

    }

    public LoginFrame(int valorIndice1, String valorN1, String valorD1) {
        initComponents();
        TextPrompt placeholder = new TextPrompt("CI", txtCI);
        placeholder = new TextPrompt("DIRECCION", txtDireccion);
        placeholder = new TextPrompt("NOMBRES", txtNombre);
        placeholder = new TextPrompt("TELEFONO", txtTelefono);
        placeholder = new TextPrompt("USUARIO", txtLogCI);
        placeholder = new TextPrompt("CONTRASEÑA", txtLogPassw);
        this.valorIndice = valorIndice1;
        this.valorN = valorN1;
        this.valorD = valorD1;
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSiguiente2 = new javax.swing.JButton();
        btnSiguiente3 = new javax.swing.JButton();
        btnSiguiente4 = new javax.swing.JButton();
        btnSiguiente5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtCI = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSiguiente1 = new javax.swing.JButton();
        txtLogCI = new javax.swing.JTextField();
        txtLogPassw = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnSiguiente7 = new javax.swing.JButton();

        btnSiguiente2.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente2.setText("Cancelar");
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });

        btnSiguiente3.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente3.setText("Siguiente");
        btnSiguiente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente3ActionPerformed(evt);
            }
        });

        btnSiguiente4.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente4.setText("Cancelar");
        btnSiguiente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente4ActionPerformed(evt);
            }
        });

        btnSiguiente5.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente5.setText("Siguiente");
        btnSiguiente5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N

        txtCI.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N

        btnSiguiente.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel1.setText("Ingrese los datos del Usuario");

        btnSiguiente1.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente1.setText("Cancelar");
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });

        txtLogCI.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N

        txtLogPassw.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N

        btnIngresar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnSiguiente7.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSiguiente7.setText("Cancelar");
        btnSiguiente7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLogCI)
                                    .addComponent(txtLogPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(158, 175, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCI, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtTelefono))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSiguiente1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSiguiente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSiguiente7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIngresar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnSiguiente1))
                .addGap(41, 41, 41)
                .addComponent(txtLogCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLogPassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnSiguiente7))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int valorIndice = this.valorIndice;
        String valorN = this.valorN;
        String valorD = this.valorD;
        String ci = txtCI.getText();
        String nombres = txtNombre.getText();
        if (ci.length() == 10) {
            try {
                if (guardarUsuario() == "1") {
                    obo.confirmarCambiosObjeto();
                    this.setVisible(false);
                    RespuestasFrame uframe = new RespuestasFrame(valorIndice, valorN, valorD, ci, nombres);
                    uframe.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario Existente");
                }

            } catch (NumberFormatException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Usuario Existente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de cedula correcto");
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void btnSiguiente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente3ActionPerformed

    private void btnSiguiente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente4ActionPerformed

    private void btnSiguiente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente5ActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        int valorIndice = this.valorIndice;
        String valorN = this.valorN;
        String valorD = this.valorD;
        String ci = txtLogCI.getText();
        String nombres = txtCI.getText();
        String temp = "";
        if (ci.length() == 10) {
            try {
                if (loginUsuario(ci, txtLogPassw.getText()).equals("1")) {
                    //obo.confirmarCambiosObjeto();
                    temp = obo.agregarObjetoE( ci);
                    if (temp.equals("1")) {
                        this.setVisible(false);
                        RespuestasFrame uframe = new RespuestasFrame(valorIndice, valorN, valorD, ci, nombres);
                        uframe.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Compra Membresia");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                    txtLogCI.setText("");
                    txtLogPassw.setText("");
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Usuario Existente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de cedula correcto");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSiguiente7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente7ActionPerformed

    public String guardarUsuario() {
        String ci = txtCI.getText();
        String nombres = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String mensaje = "";
        if (ci.isEmpty() || nombres.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            mensaje = "0";
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            usuario.setCEDULA(ci);
            usuario.setCONTRASENA("12345");
            usuario.setCORREO("i.com");
            usuario.setDIRECCION(direccion);
            usuario.setESTADOCIVIL("S");
            usuario.setGENERO("M");
            usuario.setTELEFONO(telefono);
            usuario.setNOMBRES(nombres);
            mensaje = obo.agregarObjeto(usuario);

        }
        return mensaje;
    }

    public String loginUsuario(String ci, String contrasena) {
        String respuesta = "";
        String cond = obo.comparacionObjeto(objeto, contrasena, ci);
        if (cond.equals("1")) {
            respuesta = "1";
        } else {
            respuesta = "0";
        }
        return respuesta;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JButton btnSiguiente3;
    private javax.swing.JButton btnSiguiente4;
    private javax.swing.JButton btnSiguiente5;
    private javax.swing.JButton btnSiguiente7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLogCI;
    private javax.swing.JTextField txtLogPassw;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
