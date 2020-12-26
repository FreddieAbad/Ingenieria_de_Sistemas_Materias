/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;

import com.encuestas.ec.bo.ManejoDatos;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * <>
 * @author Carlos
 */
public class EncuestasConsultas extends javax.swing.JFrame {

    /**
     * <> Inicialisacion De Arraylist para los Atributos , Las condiciones (en
     * la calusula where), funciones de agregacion
     */
    ArrayList<String> attSeleccionados;
    ArrayList<String> condSeleccionados;
    ArrayList<String> funciones;

    /**
     * Inicio y creacion de los arraylist <>
     *
     */
    public EncuestasConsultas() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        attSeleccionados = new ArrayList();
        condSeleccionados = new ArrayList();
        funciones = new ArrayList();
        this.btnAgregar.setEnabled(false);
        this.btnQuitar.setEnabled(false);
        this.btnAceptar.setVisible(false);

        try {

            /**
             * Se carga los datos con los nombres delas tablas de la base de
             * datos en <String> nombres
             *
             */
            ArrayList<String> nombres = ManejoDatos.GestionarDatos().getNombresTablas();

            for (int i = 0; i < nombres.size(); i++) {
                this.cbxTabla.addItem(nombres.get(i));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPaneResultado = new javax.swing.JScrollPane();
        rbtnopcDesc = new javax.swing.JRadioButton();
        rbtnContarRB = new javax.swing.JRadioButton();
        cbxcondicionAtributos = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListAtributos = new javax.swing.JList<>();
        cbxOperaciones = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListCondicion = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        txtAtributo = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtvalorCondicion = new javax.swing.JTextField();
        cbxCondicion = new javax.swing.JComboBox<>();
        rbtnopcNing = new javax.swing.JRadioButton();
        cbxTabla = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JListAtributosSeleccionados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxorderAtributo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rbtnopcAsc = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneResultado.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        jPanel1.add(jScrollPaneResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 400, 160));

        rbtnopcDesc.setText("Descendente");
        rbtnopcDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnopcDescActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnopcDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 110, -1));

        rbtnContarRB.setText("Contar");
        jPanel1.add(rbtnContarRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1023, 130, -1, -1));

        cbxcondicionAtributos.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        jPanel1.add(cbxcondicionAtributos, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 130, 161, -1));

        JListAtributos.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        JListAtributos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JListAtributosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JListAtributos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 360, 104));

        cbxOperaciones.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        cbxOperaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "delete" }));
        cbxOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOperacionesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 130, 220, -1));

        btnAceptar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 120, 40));

        JListCondicion.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(JListCondicion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 297, 270, 160));

        jLabel7.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel7.setText("Atributos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        txtAtributo.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        txtAtributo.setText("Especifique el siguiente campo:");
        jPanel1.add(txtAtributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 105, 233, -1));

        btnConfirmar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 100, 60));

        jLabel12.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel12.setText("Ordenamiento:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        txtvalorCondicion.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        jPanel1.add(txtvalorCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 131, 130, -1));

        cbxCondicion.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        cbxCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=", "<", ">", "LIKE" }));
        jPanel1.add(cbxCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 130, 72, -1));

        rbtnopcNing.setText("Ninguno");
        rbtnopcNing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnopcNingActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnopcNing, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 128, -1));

        cbxTabla.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        cbxTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTablaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 130, 114, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel8.setText("Condiciones:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        JListAtributosSeleccionados.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        JListAtributosSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JListAtributosSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JListAtributosSeleccionados);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 370, 90));

        jLabel1.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione la tabla:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 105, -1, -1));

        btnQuitar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 135, 50));

        jLabel11.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel11.setText("Atributos a proyectar:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CONSULTAS GENERICAS");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 460, 30));

        cbxorderAtributo.setFont(new java.awt.Font("Helvetica World", 0, 12)); // NOI18N
        cbxorderAtributo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxorderAtributoMouseClicked(evt);
            }
        });
        cbxorderAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxorderAtributoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxorderAtributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 130, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel2.setText("Valor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, 60));

        btnAgregar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 136, 50));

        jLabel4.setFont(new java.awt.Font("Helvetica World", 1, 12)); // NOI18N
        jLabel4.setText("Atributos WHERE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));

        rbtnopcAsc.setText("Ascentente");
        rbtnopcAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnopcAscActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnopcAsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        /**
         * En nombreTabla se guarda la seleccion de las tablas mostradas en el
         * comobobox Tabla se recive <>
         *
         *
         */
        String nombreTabla = cbxTabla.getSelectedItem().toString();
        ArrayList<ArrayList<String>> registros;
        if (nombreTabla.isEmpty() || this.txtvalorCondicion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ninguna atributos", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {

            /**
             * Case para la selecion del comobox Operaciones con dos opciones ,
             * SELECT y DELETE
             */
            switch (this.cbxOperaciones.getSelectedItem().toString()) {
                /**
                 * en ls opcion SELECT se activa el radio Button => ContarRB
                 */
                case "select": {
                    try {
                        if (this.cbxorderAtributo.getSelectedItem().equals("Ningún atributo")) {
                            if (this.rbtnContarRB.isSelected()) {
                                funciones.add(cbxcondicionAtributos.getSelectedItem().toString());
                                registros = (ArrayList<ArrayList<String>>) ManejoDatos.GestionarDatos().obtenerRegistros(nombreTabla, null, this.condSeleccionados, this.funciones, null);
                                funciones.clear();
                            } else {
                                registros = (ArrayList<ArrayList<String>>) ManejoDatos.GestionarDatos().obtenerRegistros(nombreTabla, attSeleccionados, this.condSeleccionados, null, null);
                                funciones.clear();
                            }
                        } else {

                            ArrayList<String> order = new ArrayList();
                            order.add(this.cbxorderAtributo.getSelectedItem().toString());
                            if (this.rbtnopcAsc.isSelected()) {
                                order.add("ASC");
                            } else if (this.rbtnopcDesc.isSelected()) {
                                order.add("DESC");
                            } else {
                                order.add("");
                            }
                            registros = (ArrayList<ArrayList<String>>) ManejoDatos.GestionarDatos().obtenerRegistros(nombreTabla, this.attSeleccionados, this.condSeleccionados, this.funciones, order);
                        }

                        this.mostrarTabla(registros);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }

                /**
                 * en ls opcion DELETE se activa el radio Button => ContarRB
                 */
                case "delete": {
                    this.rbtnContarRB.setVisible(false);
                    this.rbtnContarRB.setSelected(false);
                    String NombreTabla = this.cbxTabla.getSelectedItem().toString();
                    ArrayList<String> atributos = new ArrayList<String>();
                    atributos.add(this.cbxcondicionAtributos.getSelectedItem().toString());
                    ArrayList<String> valores = new ArrayList<String>();
                    valores.add(txtvalorCondicion.getText().toString());
                    try {
                        ManejoDatos.GestionarDatos().obtener(NombreTabla, atributos, this.condSeleccionados);
                        JOptionPane.showMessageDialog(rootPane, "Eliminacion Exitosa", "Aviso Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                        this.txtvalorCondicion.setText("");
                        DefaultListModel listModel = (DefaultListModel) JListAtributosSeleccionados.getModel();
                        listModel.removeAllElements();
                        this.JListAtributosSeleccionados.removeAll();
                        DefaultListModel listModelc = (DefaultListModel) JListCondicion.getModel();
                        listModelc.removeAllElements();
                        this.JListCondicion.removeAll();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Aviso Eliminacion", JOptionPane.ERROR_MESSAGE);
                    }

                    try {
                        if (this.cbxorderAtributo.getSelectedItem().equals("Ningún atributo")) {
                            String Nombre = this.cbxTabla.getSelectedItem().toString();
                        } else {
                            ArrayList<String> order = new ArrayList();
                            order.add(this.cbxorderAtributo.getSelectedItem().toString());
                            if (this.rbtnopcAsc.isSelected()) {
                                order.add("ASC");
                            } else if (this.rbtnopcDesc.isSelected()) {
                                order.add("DESC");
                            } else {
                                order.add("");
                            }
                            registros = (ArrayList<ArrayList<String>>) ManejoDatos.GestionarDatos().obtenerRegistros(nombreTabla, this.attSeleccionados, this.condSeleccionados, null, order);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
            this.rbtnContarRB.setVisible(true);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Se muestra la informacion en un Jpanel
     */
    private void mostrarTabla(ArrayList<ArrayList<String>> registros) {
        int filas = registros.size() - 1;
        int columnas = registros.get(0).size();
        String cuerpo[][] = new String[filas][columnas];
        String cabecera[] = new String[columnas];
        //Cabecera de la tabla
        for (int i = 0; i < columnas; i++) {
            cabecera[i] = registros.get(0).get(i);
        }
        //Cuerpo de la tabla
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cuerpo[i][j] = registros.get(i + 1).get(j);
            }
        }
        //Creacion de la tabla 
        JTable table = new JTable(cuerpo, cabecera);
        table.setPreferredScrollableViewportSize(new Dimension(filas, columnas));

        this.jScrollPaneResultado.setViewportView(new JTable(cuerpo, cabecera));
    }// fin de metodo mostrar tabla 


    private void cbxOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOperacionesActionPerformed
        switch (this.cbxOperaciones.getSelectedItem().toString()) {

            case "select": {

                break;
            }/// finaliza er case

            case "delete": {
                // Eliminar();
                break;
            }/// finaliza er case

        }

    }//GEN-LAST:event_cbxOperacionesActionPerformed

    private void cbxorderAtributoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxorderAtributoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxorderAtributoMouseClicked

    private void cbxorderAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxorderAtributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxorderAtributoActionPerformed

    /**
     * cuando se selecicona el radiobuton Acendente
     *
     *
     */
    private void rbtnopcAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnopcAscActionPerformed
        if (rbtnopcDesc.isSelected() || rbtnopcNing.isSelected()) {
            rbtnopcDesc.setSelected(false);
            rbtnopcNing.setSelected(false);
        }
    }//GEN-LAST:event_rbtnopcAscActionPerformed

    /**
     * cuando se selecicona el radiobuton Ninguno
     *
     *
     */

    private void rbtnopcNingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnopcNingActionPerformed
        if (rbtnopcAsc.isSelected() || rbtnopcDesc.isSelected()) {
            rbtnopcAsc.setSelected(false);
            rbtnopcDesc.setSelected(false);
        }
    }//GEN-LAST:event_rbtnopcNingActionPerformed

    /**
     * cuando se selecicona el radiobuton Decendente
     *
     *
     */
    private void rbtnopcDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnopcDescActionPerformed
        if (rbtnopcAsc.isSelected() || rbtnopcNing.isSelected()) {
            rbtnopcAsc.setSelected(false);
            rbtnopcNing.setSelected(false);
        }
    }//GEN-LAST:event_rbtnopcDescActionPerformed

    /**
     * Accion a desencadenar cuando de haga clic en el comobobox Tabla
     *
     *
     */
    private void cbxTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTablaActionPerformed
        // TODO add your handling code here:
        try {
            this.cbxcondicionAtributos.removeAllItems();
            this.condSeleccionados = new ArrayList();
            this.attSeleccionados = new ArrayList();
            this.JListAtributosSeleccionados.setModel(new DefaultListModel());
            this.JListCondicion.setModel(new DefaultListModel());

            if (!this.cbxTabla.getSelectedItem().toString().isEmpty()) {
                ArrayList<String> atributos = (ArrayList<String>) ManejoDatos.GestionarDatos().getAtributosTabla(this.cbxTabla.getSelectedItem().toString());
                DefaultListModel model = new DefaultListModel();
                this.cbxcondicionAtributos.addItem("Ningún atributo");
                this.cbxorderAtributo.removeAllItems();
                this.cbxorderAtributo.addItem("Ningún atributo");

                for (int i = 0; i < atributos.size(); i++) {
                    model.addElement(atributos.get(i));
                    this.cbxcondicionAtributos.addItem(atributos.get(i));
                    this.cbxorderAtributo.addItem(atributos.get(i));

                }
                this.JListAtributos.setModel(model);
                this.btnAgregar.setEnabled(false);
                this.btnQuitar.setEnabled(false);
                //this.btnAgregar1.setEnabled(false);
                //this.btnQuitar1.setEnabled(false);
                this.btnAceptar.setVisible(true);
                //this.btnAgregar1.setEnabled(false);

            } else {

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);

        }//// fin de try 


    }//GEN-LAST:event_cbxTablaActionPerformed

    /**
     * se agrega la condicion en un arraylist la condicion que esta en el
     * jlistcondicion
     *
     *
     */

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String nombre = this.cbxcondicionAtributos.getSelectedItem().toString();
        if (this.condSeleccionados.contains(nombre)) {
            JOptionPane.showMessageDialog(rootPane, "Ese atributo ya se ha seleccionado", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else if (this.cbxCondicion.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Se debe escoger un condicional", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else if (this.txtvalorCondicion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Se debe especificar un valor para la condicion", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else if (this.cbxcondicionAtributos.getSelectedItem().equals("Ningún atributo")) {
            JOptionPane.showMessageDialog(rootPane, "Se debe escoger un atributo", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            String condGenerada = "";
            if (this.cbxCondicion.getSelectedItem().equals("LIKE")) {
                condGenerada = nombre + " " + this.cbxCondicion.getSelectedItem()
                        + " '" + this.txtvalorCondicion.getText() + "%" + "'";
                System.out.println("" + condGenerada);
            } else {
                condGenerada = nombre + " " + this.cbxCondicion.getSelectedItem()
                        + " '" + this.txtvalorCondicion.getText() + "'";
                System.out.println("" + condGenerada);
            }

            this.condSeleccionados.add(condGenerada);
            System.out.println("Entra a agrgar  " + this.condSeleccionados.toString());
            DefaultListModel model = new DefaultListModel();
            for (int i = 0; i < condSeleccionados.size(); i++) {
                model.addElement(this.condSeleccionados.get(i));
            }
            this.JListCondicion.setModel(model);
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * Quitar los atributos seleccionadps
     *
     *
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String nombre = this.JListCondicion.getModel().getElementAt(this.JListCondicion.getSelectedIndex());
        this.condSeleccionados.remove(nombre);
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < condSeleccionados.size(); i++) {
            model.addElement(condSeleccionados.get(i));
        }
        this.JListCondicion.setModel(model);
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     *
     *
     *
     */
    private void JListAtributosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JListAtributosMouseClicked
        this.btnAgregar.setEnabled(true);
        this.btnQuitar.setEnabled(false);
    }//GEN-LAST:event_JListAtributosMouseClicked

    /**
     * cuando se selecicona el radiobuton Acendente
     *
     *
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String nombre = this.JListAtributos.getModel().getElementAt(this.JListAtributos.getSelectedIndex());
        if (!this.attSeleccionados.contains(nombre)) {
            this.attSeleccionados.add(nombre);
            DefaultListModel model = new DefaultListModel();
            for (int i = 0; i < attSeleccionados.size(); i++) {
                model.addElement(attSeleccionados.get(i));
            }
            this.JListAtributosSeleccionados.setModel(model);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * cuando se selecicona el radiobuton Acendente
     *
     *
     */

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        String nombre = this.JListAtributos.getModel().getElementAt(this.JListAtributos.getSelectedIndex());
        this.attSeleccionados.remove(nombre);
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < attSeleccionados.size(); i++) {
            model.addElement(attSeleccionados.get(i));
        }
        this.JListAtributosSeleccionados.setModel(model);
    }//GEN-LAST:event_btnQuitarActionPerformed

    /**
     * cuando se selecicona el radiobuton Acendente
     *
     *
     */

    private void JListAtributosSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JListAtributosSeleccionadosMouseClicked
        this.btnQuitar.setEnabled(true);
        this.btnAgregar.setEnabled(false);
    }//GEN-LAST:event_JListAtributosSeleccionadosMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListAtributos;
    private javax.swing.JList<String> JListAtributosSeleccionados;
    private javax.swing.JList<String> JListCondicion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> cbxCondicion;
    private javax.swing.JComboBox<String> cbxOperaciones;
    private javax.swing.JComboBox<String> cbxTabla;
    private javax.swing.JComboBox<String> cbxcondicionAtributos;
    private javax.swing.JComboBox<String> cbxorderAtributo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneResultado;
    private javax.swing.JRadioButton rbtnContarRB;
    private javax.swing.JRadioButton rbtnopcAsc;
    private javax.swing.JRadioButton rbtnopcDesc;
    private javax.swing.JRadioButton rbtnopcNing;
    private javax.swing.JLabel txtAtributo;
    private javax.swing.JTextField txtvalorCondicion;
    // End of variables declaration//GEN-END:variables
}
