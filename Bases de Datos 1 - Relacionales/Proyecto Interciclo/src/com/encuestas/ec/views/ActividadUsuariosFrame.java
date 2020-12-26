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
import com.encuestas.ec.entity.Pregunta;
import com.encuestas.ec.entity.RespuestaTexto;
import com.encuestas.ec.entity.Usuario;
import static com.encuestas.ec.views.PreguntaFrame.reiniciarJTable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Freddie
 */
public class ActividadUsuariosFrame extends javax.swing.JFrame {

    Encuesta encuesta = new Encuesta();
    ObjectBo obo = new ObjectBo();
    ObjectDao objeto = new ObjectDao();
    Usuario usuario = new Usuario();
    Pregunta pregunta = new Pregunta();
    RespuestaTexto respuesta = new RespuestaTexto();
    Consultas consultas = new Consultas();

    public ActividadUsuariosFrame() {
        initComponents();
        listarObjeto();
    }

    public String seleccionarUsuario() {
        int column = 0;
        int row = tblUsuarios.getSelectedRow();
        String selection = tblUsuarios.getModel().getValueAt(row, column).toString();
        String cedula = tblUsuarios.getValueAt(row, 0).toString();
        String nombres = tblUsuarios.getValueAt(row, 1).toString();
        lblCI.setText(cedula);
        lblNombres.setText(nombres);
        return cedula;
    }

    public String seleccionarEncuesta() {
        int column = 0;
        int row = tblEncuesta.getSelectedRow();
        String selection = tblEncuesta.getModel().getValueAt(row, column).toString();
        String cedula = tblEncuesta.getValueAt(row, 0).toString();
        String nombres = tblEncuesta.getValueAt(row, 1).toString();
        lblIdEncuesta.setText(cedula);
        lblEncuestaNombre.setText(nombres);
        return cedula;
    }

    public void listarObjeto() {
        /*String[] tableO = {"CEDULA", "NOMBRES"};
        try {
            obo.listarObjetoE(tblUsuarios, usuario, tableO);//, labelsTablas, lblsTablas, dataty
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        String columna = " CEDULA, NOMBRES ";
        String tablas = " USUARIO ";
        String complemento = " CEDULA "; //order by
        int joinInt = 2;
        consultas = new Consultas(columna, tablas, complemento, joinInt);
        obo.listarObjetoGenerico(tblUsuarios, consultas);
    }

    public void listarObjetoEncuesta(String ci) {
        String columna = " O.idencuesta,en.nombre ";
        String tablas = "ENCUESTA en";
        String complemento = " RESPUESTAOPCIONMULTIPLE O ON O.idencuesta=en.idencuesta AND o.idusuario='" + ci + "'";
        int joinInt = 3;
        consultas = new Consultas(columna, tablas, complemento, joinInt);
        obo.listarObjetoGenerico(tblEncuesta, consultas);
    }

    public void listarObjetoPreguntasTOM(String ci) {
        String columna = " O.IDENCUESTA,O.IDPREGUNTA,en.pregunta,o.idrespuestaopcionmultiple,o.idopcion ";
        String tablas = " PREGUNTA en ";
        String complemento = " RESPUESTAOPCIONMULTIPLE O ON O.idencuesta=en.idencuesta AND o.idusuario='" + ci + "' and o.idpregunta=en.idpregunta";
        int joinInt = 3;
        consultas = new Consultas(columna, tablas, complemento, joinInt);
        obo.listarObjetoGenerico(tblPreguntaOM, consultas);
    }

    public void listarObjetoPreguntasTexto(String ci) {
        String columna = " o.IDENCUESTA,o.IDPREGUNTA,en.pregunta,o.idrespuestatexto,o.respuesta ";
        String tablas = " (PREGUNTA en) ";
        String complemento = " RESPUESTATEXTO o ON o.idencuesta=en.IDENCUESTA AND o.idusuario='" + ci + "' and o.idpregunta=en.idpregunta";
        /*
        try {
            obo.listarObjetoIJ(tblPreguntaTexto, encuesta, columna, tablas, complemento);
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         */

        int joinInt = 3;
        consultas = new Consultas(columna, tablas, complemento, joinInt);
        obo.listarObjetoGenerico(tblPreguntaTexto, consultas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEncuesta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCI = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblIdEncuesta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEncuestaNombre = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnSeleccionarUsuario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPreguntaOM = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPreguntaTexto = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnSeleccionarUsuario1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica World", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACTIVIDAD USUARIOS");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 450, 30));

        tblEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        tblEncuesta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENCUESTA", "ENCUESTA"
            }
        ));
        jScrollPane1.setViewportView(tblEncuesta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 320, 120));

        jLabel2.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel2.setText("CI:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel3.setText("NOMBRES:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        lblCI.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 200, 20));

        lblNombres.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 200, 20));

        jLabel4.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel4.setText("ID ENCUESTA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        lblIdEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblIdEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 200, 20));

        jLabel5.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel5.setText("NOMBRE ENCUESTA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        lblEncuestaNombre.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblEncuestaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 200, 20));

        btnInicio.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, -1, -1));

        btnSeleccionarUsuario.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSeleccionarUsuario.setText("FILTRAR");
        btnSeleccionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        tblPreguntaOM.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        tblPreguntaOM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPREGUNTA", "PREGUNTA", "IDRESPUESTAOM", "RESPUESTA"
            }
        ));
        jScrollPane2.setViewportView(tblPreguntaOM);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 560, 120));

        tblPreguntaTexto.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        tblPreguntaTexto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPREGUNTA", "PREGUNTA", "IDRESPUESTA", "RESPUESTA"
            }
        ));
        jScrollPane3.setViewportView(tblPreguntaTexto);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 560, 120));

        tblUsuarios.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "NOMBRES"
            }
        ));
        jScrollPane4.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 320, 220));

        btnSeleccionarUsuario1.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnSeleccionarUsuario1.setText("FILTRAR");
        btnSeleccionarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUsuario1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUsuarioActionPerformed
        reiniciarJTable(tblPreguntaOM);
        reiniciarJTable(tblPreguntaTexto);
        String ci = seleccionarUsuario();
        listarObjetoEncuesta(ci);

    }//GEN-LAST:event_btnSeleccionarUsuarioActionPerformed

    private void btnSeleccionarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUsuario1ActionPerformed
        String ci = seleccionarUsuario();
        String seleccionarEncuesta = seleccionarEncuesta();
        listarObjetoPreguntasTexto(ci);
        listarObjetoPreguntasTOM(ci);

    }//GEN-LAST:event_btnSeleccionarUsuario1ActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActividadUsuariosFrame().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnSeleccionarUsuario;
    private javax.swing.JButton btnSeleccionarUsuario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCI;
    private javax.swing.JLabel lblEncuestaNombre;
    private javax.swing.JLabel lblIdEncuesta;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTable tblEncuesta;
    private javax.swing.JTable tblPreguntaOM;
    private javax.swing.JTable tblPreguntaTexto;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
