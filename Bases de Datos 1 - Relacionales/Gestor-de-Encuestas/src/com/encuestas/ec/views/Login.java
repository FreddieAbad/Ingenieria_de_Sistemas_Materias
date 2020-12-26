/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;

import com.encuestas.ec.bo.UsuarioBo;
import com.encuestas.ec.entity.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Freddie
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private UsuarioBo ubo = new UsuarioBo();

    public Login() {
        initComponents();
        setTitle("Gestor de Encuestas");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuarioU = new javax.swing.JTextField();
        btnLoginUser = new javax.swing.JButton();
        btnRegisterUser = new javax.swing.JButton();
        txtPasswordU = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtPasswordR = new javax.swing.JPasswordField();
        txtNombresR = new javax.swing.JTextField();
        txtCorreoR = new javax.swing.JTextField();
        txtTelefonoR = new javax.swing.JTextField();
        txtDireccionR = new javax.swing.JTextField();
        txtCIR = new javax.swing.JTextField();
        cbxGeneroR = new javax.swing.JComboBox<>();
        cbxEstadoCivilR = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        txtUsuarioU.setText("Usuario");
        jPanel1.add(txtUsuarioU, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 110, -1));

        btnLoginUser.setText("Login");
        btnLoginUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnLoginUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 88, -1));

        btnRegisterUser.setText("Registrar");
        btnRegisterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegisterUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 88, -1));

        txtPasswordU.setText("jPasswordField1");
        jPanel1.add(txtPasswordU, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabel3.setText("Registrarse");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        txtPasswordR.setText("jPasswordField2");
        jPanel1.add(txtPasswordR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        txtNombresR.setText("Nombres");
        jPanel1.add(txtNombresR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 110, -1));

        txtCorreoR.setText("Correo");
        jPanel1.add(txtCorreoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 110, -1));

        txtTelefonoR.setText("Telefono");
        jPanel1.add(txtTelefonoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 110, -1));

        txtDireccionR.setText("Direccion");
        jPanel1.add(txtDireccionR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 110, -1));

        txtCIR.setText("CI");
        jPanel1.add(txtCIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 110, -1));

        cbxGeneroR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbxGeneroR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGeneroRActionPerformed(evt);
            }
        });
        jPanel1.add(cbxGeneroR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 110, -1));

        cbxEstadoCivilR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Union Libre", "Divorciado", "Viudo" }));
        cbxEstadoCivilR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoCivilRActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstadoCivilR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxGeneroRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGeneroRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGeneroRActionPerformed

    private void cbxEstadoCivilRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoCivilRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoCivilRActionPerformed

    private void btnRegisterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterUserActionPerformed
        if (txtCIR.getText().isEmpty() || txtCorreoR.getText().isEmpty() || txtDireccionR.getText().isEmpty() || txtNombresR.getText().isEmpty()
                || txtPasswordR.getPassword().length == 0 || txtTelefonoR.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            char estado, genero;
            if (cbxGeneroR.getSelectedItem().toString() == "Femenino") {
                genero = 'F';
            } else {
                genero = 'M';
            }
            String contrasena = new String(txtPasswordR.getPassword());
            Usuario usuario = new Usuario();
            usuario.setCedula(txtCIR.getText());
            usuario.setContrasena(contrasena);
            usuario.setDireccion(txtDireccionR.getText());
            usuario.setEmail(txtCorreoR.getText());
            usuario.setEstadoCivil(cbxEstadoCivilR.getSelectedItem().toString());
            usuario.setGenero(genero);
            usuario.setNombres(txtNombresR.getText());
            usuario.setTelefono(txtTelefonoR.getText());
            String mensaje = ubo.agregarUsuario(usuario);
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }//GEN-LAST:event_btnRegisterUserActionPerformed

    private void btnLoginUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginUserActionPerformed
        if (txtUsuarioU.getText().isEmpty() || txtPasswordU.getPassword().length==0) {
            JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña");
        } else {
            String usuario=txtUsuarioU.getText();
            String contrasena = new String(txtPasswordR.getPassword());
            int opcionUsuario = ubo.validarUsuario(usuario,contrasena);
            switch(opcionUsuario){
                case 1:
                    System.out.println("admin");
                case 2:
                    System.out.println("usuario");
                case 3:
                    JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña");
            }
        }
    }//GEN-LAST:event_btnLoginUserActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginUser;
    private javax.swing.JButton btnRegisterUser;
    private javax.swing.JComboBox<String> cbxEstadoCivilR;
    private javax.swing.JComboBox<String> cbxGeneroR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCIR;
    private javax.swing.JTextField txtCorreoR;
    private javax.swing.JTextField txtDireccionR;
    private javax.swing.JTextField txtNombresR;
    private javax.swing.JPasswordField txtPasswordR;
    private javax.swing.JPasswordField txtPasswordU;
    private javax.swing.JTextField txtTelefonoR;
    private javax.swing.JTextField txtUsuarioU;
    // End of variables declaration//GEN-END:variables
}
