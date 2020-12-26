package Interface;

import Class.BranchOffice;
import javax.swing.JOptionPane;

public class Sucursal extends javax.swing.JDialog {

    private Principal vPrincial = (Principal)this.getParent();
    
    public static int n,i;
    
    public Sucursal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String num = String.valueOf(this.vPrincial.nuevoGerente.getSucursales().size());
        this.numSucursal.setText(num);
    }
    public void revisar(int i){
        if(i < 1 || i > this.vPrincial.nuevoGerente.getSucursales().size()){
           JOptionPane.showMessageDialog(null,"CODIGO NO IDENTIFICADO VERIFIQUELO","ERROR CODIGO",JOptionPane.ERROR_MESSAGE);
        }else{
            this.codigo.setText(String.valueOf(i));
            this.jTextField1.setText(this.vPrincial.nuevoGerente.getSucursales().get(i-1).getNombreSucursal());
            this.jTextField2.setText(this.vPrincial.nuevoGerente.getSucursales().get(i-1).getDireccionSucursal());
            
            if(this.vPrincial.nuevoGerente.getSucursales().get(i-1).getAdministradores().size() == 0){
                this.jTextField3.setText("SIN ADMINISTRADOR");
                this.crearAdmi.setEnabled(true);
            }else{
                this.jTextField3.setText(this.vPrincial.nuevoGerente.getSucursales().get(i-1).getAdministradores().get(0).getNombre());
                this.mod.setEnabled(true);
                this.crearAdmi.setEnabled(false);
            }
        }
    }
    public void limpiar(){
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.codigo.setText("");
        this.mod.setEnabled(false);
        this.registrar.setEnabled(true);
        this.crearAdmi.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        numSucursal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        crearAdmi = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CREAR NUEVA SUCURSAL");

        jDesktopPane1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("NUMERO DE SUCURSALES:");

        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/guardar-archivo-icono-6713-64.png"))); // NOI18N
        registrar.setText("REGISTRAR");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        numSucursal.setEditable(false);
        numSucursal.setBackground(new java.awt.Color(0, 153, 153));
        numSucursal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numSucursal.setText("0");
        numSucursal.setBorder(null);

        jLabel2.setText("NOMBRE DE LA SUCURSAL:");

        jLabel3.setText("DIRECCION DE LA SUCURSAL:");

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/lupa.png"))); // NOI18N
        buscar.setText("BUSCAR");
        buscar.setBorder(null);
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/modificar.png"))); // NOI18N
        mod.setText("MODIFICAR");
        mod.setBorder(null);
        mod.setBorderPainted(false);
        mod.setContentAreaFilled(false);
        mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mod.setEnabled(false);
        mod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("Cayambe");
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("Av Cabambe y Juan Peralta");
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setText("CODIGO DE SUCURSAL:");

        codigo.setEditable(false);
        codigo.setBackground(new java.awt.Color(0, 153, 153));
        codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setText("ADMINISTRADOR: ");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 153, 153));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        crearAdmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/cliente-icono-5533-64.png"))); // NOI18N
        crearAdmi.setText("CREAR ADMIN");
        crearAdmi.setBorder(null);
        crearAdmi.setBorderPainted(false);
        crearAdmi.setContentAreaFilled(false);
        crearAdmi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearAdmi.setEnabled(false);
        crearAdmi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearAdmi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        crearAdmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAdmiActionPerformed(evt);
            }
        });

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/limpiar.png"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.setBorder(null);
        limpiar.setBorderPainted(false);
        limpiar.setContentAreaFilled(false);
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(numSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(mod)
                .addGap(42, 42, 42)
                .addComponent(limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crearAdmi)
                .addGap(36, 36, 36))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(registrar)
                        .addComponent(buscar))
                    .addComponent(mod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(crearAdmi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
        );
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(registrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(numSucursal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(buscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(mod, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(codigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(crearAdmi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(limpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        
        if( jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese NOMBRE de la Sucursal","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(jTextField2.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null,"Ingrese LA DIRECCION de la SUCURSAL","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
        BranchOffice nuevaSucursal = new BranchOffice(this.jTextField1.getText(),this.jTextField2.getText(),this.vPrincial.nuevoGerente);
        this.vPrincial.nuevoGerente.createBranchOffice(nuevaSucursal);
        
        n = this.vPrincial.nuevoGerente.getSucursales().size();
        String num = String.valueOf(n);
        this.numSucursal.setText(num);
        
        this.vPrincial.nuevoGerente.getSucursales().get(n-1).seeInfo();
        
        revisar(this.vPrincial.nuevoGerente.getSucursales().size());
        
        } 
    }//GEN-LAST:event_registrarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        i = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EL CODIGO DE LA SUCURSAL","BUSQUEDA",3));
            revisar(i);
    }//GEN-LAST:event_buscarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
        
    }//GEN-LAST:event_limpiarActionPerformed

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed
        if( jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese NOMBRE de la Sucursal","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(jTextField2.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null,"Ingrese LA DIRECCION de la SUCURSAL","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            this.vPrincial.nuevoGerente.getSucursales().get(i-1).setNombreSucursal(this.jTextField1.getText());
            this.vPrincial.nuevoGerente.getSucursales().get(i-1).setDireccionSucursa(this.jTextField2.getText());
            JOptionPane.showMessageDialog(null,"SE AH MODIFICADO CON EXITO ESTA SUCURSAL","SUCURSAL MODIFICADA",1);
        }
    }//GEN-LAST:event_modActionPerformed

    private void crearAdmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAdmiActionPerformed
        i = Integer.parseInt(this.codigo.getText());
        this.vPrincial.delGerente(i);
        revisar(i);
    }//GEN-LAST:event_crearAdmiActionPerformed

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
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sucursal dialog = new Sucursal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton crearAdmi;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton mod;
    private javax.swing.JTextField numSucursal;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
