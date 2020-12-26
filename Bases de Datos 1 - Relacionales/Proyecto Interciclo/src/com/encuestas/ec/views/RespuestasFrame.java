/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;

import com.encuestas.ec.bo.ObjectBo;
import com.encuestas.ec.entity.Encuesta;
import com.encuestas.ec.entity.Opciones;
import com.encuestas.ec.entity.Pregunta;
import com.encuestas.ec.entity.RespuestaOpcionMultiple;
import com.encuestas.ec.entity.RespuestaTexto;
import static com.encuestas.ec.views.choice.c;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import static jdk.internal.org.objectweb.asm.util.Printer.TYPES;

/**
 *
 * @author Freddie
 */
public class RespuestasFrame extends javax.swing.JFrame {

    Encuesta encuesta = new Encuesta();
    Pregunta pregunta = new Pregunta();
    Opciones opcion = new Opciones();
    ObjectBo obo = new ObjectBo();
    RespuestaTexto respuestaTexto = new RespuestaTexto();
    RespuestaOpcionMultiple respuestaOM = new RespuestaOpcionMultiple();
    int eleccionOpcion;
    String seleccionjcbx = "";
    int indicejcbx = 0;
    int indicePreguntajcbx = 0;

    public RespuestasFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public RespuestasFrame(int id, String nombre, String descripcion, String ci, String nombreU) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        lblIDEncuesta.setText(String.valueOf(id));
        lblNombreEncuesta.setText(nombre);
        lblDescripcionEncuesta.setText(descripcion);
        lblNombreUsu.setText(nombreU);
        lblCIU.setText(ci);
        responderPreguntas();
    }

    public void crearPanel(int totalP) {
        JTabbedPane tp = new JTabbedPane();

        //conseguir datos
        String valorConsultar = "PE.IDPREGUNTA,PE.PREGUNTA,PE.IDTIPORESPUESTA,PE.idencuesta pidencuesta ";
        String nombreTablas = "PREGUNTA PE";
        String filtros = "PE.IDENCUESTA = " + lblIDEncuesta.getText();// + " AND PE.IDTIPORESPUESTA=1";
        int totalRegistros = totalP;//es la variable resultante de conteo
        //datos son los registros necesarios para la pregunta despendiendo de la encuesta
        List<String> datos = obo.responderPreguntas(pregunta, Integer.valueOf(lblIDEncuesta.getText()), valorConsultar, nombreTablas, filtros, totalRegistros);
        System.out.println("fasdfasdf");
        List<List<String>> preguntas = separarPreguntas(datos, totalRegistros); // preguntas separadas, primer fila es encabezado
        System.out.println("fasdfasdf");
        List<String> cabecera = preguntas.get(0);
        preguntas.remove(0);
        System.out.println(Arrays.asList(preguntas));
        for (List<String> pregunta : preguntas) {
            System.out.println(">>>>>" + pregunta.toString());
            JTextArea ta = new JTextArea(200, 200);
            JPanel p1 = new JPanel();
            tp.setBounds(0, 0, f.getWidth(), f.getHeight());
            String etiqueta = "Pregunta ";//.concat(String.valueOf(i + 1));
            tp.add(etiqueta, p1);

            String label1 = "ID PREGUNTA: " + pregunta.get(0).toString();
            JLabel preguntaID = new JLabel(label1);
            p1.add(preguntaID, 0);

            String label2 = "PREGUNTA: " + pregunta.get(1);
            JLabel preguntaNombre = new JLabel(label2);
            p1.add(preguntaNombre, 1);

            String label3 = pregunta.get(2);
            JTextArea textoIngreso = new JTextArea(1, 10);

            if (Integer.parseInt(label3) == 1) {
                String label3T = "ID TIPO RESPUESTA: TEXTO";//+label3;
                JLabel preguntaIDTR = new JLabel(label3T);
                p1.add(preguntaIDTR, 2);

                String label4 = "ID ENCUESTA: " + pregunta.get(3);
                JLabel preguntaIDE = new JLabel(label4);
                p1.add(preguntaIDE, 3);

                textoIngreso.setBounds(10, 20, 10, 10);
                p1.add(textoIngreso, 4);
            }
            JComboBox<String> op = new JComboBox<>();

            if (Integer.parseInt(label3) == 2) {
                String label3T = "ID TIPO RESPUESTA: OPCION MULTIPLE";//+label3;
                JLabel preguntaIDTR = new JLabel(label3T);
                p1.add(preguntaIDTR, 2);
                String label4 = "ID ENCUESTA: " + pregunta.get(3);
                JLabel preguntaIDE = new JLabel(label4);
                p1.add(preguntaIDE, 3);
//                System.out.println("ddddasdfa");
                List<List<String>> infoRespuesta = conseguirOpciones(totalP, pregunta.get(3), label3);
                List<String> nombreOpciones = infoRespuesta.get(0);//conseguirOpciones(totalP, pregunta.get(3), label3).get(0);
                List<String> indiceOpciones = infoRespuesta.get(1);//conseguirOpciones(totalP, pregunta.get(3), label3).get(1);
                List<String> indicePregunta = infoRespuesta.get(2);//conseguirOpciones(totalP, pregunta.get(3), label3).get(2);

                String[] nombreOpcionesTemp = nombreOpciones.toArray(new String[0]);
                String[] indiceOpcionesTemp = indiceOpciones.toArray(new String[0]);
                String[] indicePreguntaTemp = indicePregunta.toArray(new String[0]);

                op = new JComboBox<>(nombreOpcionesTemp);
                op.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        JComboBox op = (JComboBox) event.getSource();
                        Object selected = op.getSelectedItem();
                        seleccionjcbx = selected.toString();
                        int indice = Arrays.asList(nombreOpcionesTemp).indexOf(seleccionjcbx);
                        indicejcbx = Integer.parseInt(indiceOpcionesTemp[indice]);
                        indicePreguntajcbx = Integer.parseInt(indicePreguntaTemp[indice]);

                        Object indexSelected = op.getSelectedIndex();
                        System.out.println("Selected Index  = " + indexSelected);
                        String command = event.getActionCommand();
                        System.out.println("Action Command = " + command);
                    }
                });
                getContentPane().add(op);
                p1.add(op, 4);
            }
            JLabel preguntaIDTR2 = new JLabel(label3);
            p1.add(preguntaIDTR2, 5);
            JButton btnPreguntaI = new JButton("Guardar Pregunta");
            btnPreguntaI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (Integer.parseInt(preguntaIDTR2.getText()) == 1) {
                        String mensaje;
                        respuestaTexto.setIDENCUESTA(Integer.parseInt(pregunta.get(3)));
                        respuestaTexto.setIDPREGUNTA(Integer.parseInt(pregunta.get(0)));
                        int id = obo.getMaxID(respuestaTexto);
                        respuestaTexto.setIDRESPUESTATEXTO(id);
                        respuestaTexto.setIDUSUARIO(lblCIU.getText());
                        respuestaTexto.setRESPUESTA(textoIngreso.getText());
                        mensaje = obo.agregarObjeto(respuestaTexto);
                    } else {
                        String mensaje;
                        //to do revisar opciones termargit s 
                        int id = obo.getMaxID(respuestaOM);
                        respuestaOM.setIDRESPUESTAOPCIONMULTIPLE(id);
                        respuestaOM.setIDENCUESTA(Integer.parseInt(pregunta.get(3)));
//                        int opcionTO = 1;//Integer.parseInt(op.getSelectedItem().toString()) + 1;
//                        int opcionMultiple = (int) op.getSelectedItem();
                        respuestaOM.setIDOPCION(indicejcbx);//
                        respuestaOM.setIDPREGUNTA(indicePreguntajcbx);//Integer.parseInt(pregunta.get(1)));
                        respuestaOM.setIDUSUARIO(lblCIU.getText());

                        mensaje = obo.agregarObjeto(respuestaOM);
                    }
                }
            });
            p1.add(btnPreguntaI, 5);
            f.add(tp);
        }

        f.setSize(
                800, 800);
        f.setLayout(
                null);
        f.setVisible(
                true);
    }

    public List<List<String>> conseguirOpciones(int totalP, String idEncuesta, String idTRespuesta) {
        List<String> opcionesF = new LinkedList<String>();
        List<String> opcionesI = new LinkedList<String>();
        List<String> preguntaI = new LinkedList<String>();

        //
//        String[] opcionesFL = new String[totalP + 2];
//        String[] opcionesIL = new String[totalP + 2];
        ///
        String valorConsultar = " O.IDOPCION,PE.IDPREGUNTA,O.NOMBREOPCION,PE.IDTIPORESPUESTA,PE.idencuesta,o.idencuesta ";
        String nombreTablas = "PREGUNTA PE";
        String innerJ = "INNER JOIN OPCIONES O ON O.idencuesta=PE.idencuesta AND PE.IDENCUESTA=" + idEncuesta + " AND PE.IDTIPORESPUESTA=" + idTRespuesta;
        int totalRegistros = totalP;
        System.out.println("DDDDA0" + totalRegistros);
        List<String> datos = obo.responderOpciones(opcion, Integer.valueOf(lblIDEncuesta.getText()), valorConsultar, nombreTablas, innerJ, totalRegistros);
        //sin cabecera
        List<List<String>> opciones = separarOpciones(datos, totalRegistros + 2); // preguntas separadas, primer fila es encabezado
        opciones.remove(0);
        //con cabeceras
        List<List<String>> opcionesTemp = separarOpciones(datos, totalRegistros + 2); // preguntas separadas, primer fila es encabezado
        int i = 0;
        for (List<String> opcion : opciones) {
            String label2 = opcion.get(2);
            opcionesF.add(label2);
            i++;
        }
        //IDS DE LAS OPCIONES
        int j = 0;
        for (List<String> opcion : opciones) {
            String label2 = opcion.get(0);
            opcionesI.add(label2);
            j++;
        }
        for (List<String> opcion : opciones) {
            String label2 = opcion.get(1);
            preguntaI.add(label2);
            j++;
        }

        List<List<String>> finalS = new ArrayList<List<String>>();
        finalS.add(opcionesF);
        finalS.add(opcionesI);
        finalS.add(preguntaI);

        /*
        finalS.add(Arrays.asList(opcionesFL));
        finalS.add(Arrays.asList(opcionesIL));*/
        return finalS;        //return opcionesF;

    }

    public int responderPreguntas() {
        String[] labelsPregunta = {"IDENCUESTA"};
        Object[] idPreguntaW = {Integer.parseInt(lblIDEncuesta.getText())};
        int[] tdPW = {1, 1, 1};
        int totalP = obo.contarObjeto(pregunta, labelsPregunta, idPreguntaW, tdPW);
        System.out.println("{{{{" + totalP);
        lblTotalP.setText(String.valueOf(totalP));
        crearPanel(totalP);
        return totalP;
    }

    public List<List<String>> separarPreguntas(List<String> datos, int tamanoP) {
        List<List<String>> preguntas = new ArrayList<List<String>>();
        System.out.println("DDDDDDDDDDD" + Arrays.asList(datos) + tamanoP);
        boolean bandera = true;
        //int i = 0, j = tamanoP;
        /*while (bandera) {
            if (i != datos.size()) {
                List<String> pregunta2 = datos.subList(i, tamanoP);
                preguntas.add(pregunta2);
                i = tamanoP;
                tamanoP = tamanoP + j;
            } else {
                bandera = false;
            }
        }*/
        final int N = datos.size();
        for (int i = 0; i < N; i += 4) {
            List<String> pregunta2 = datos.subList(i, Math.min(N, i + 4));
            preguntas.add(pregunta2);
//            preguntas.add(datos.subList(i, Math.min(N, i + 4)));
        }
        System.out.println("DDDDDDDDDDD>" + Arrays.asList(preguntas) + tamanoP);
        return preguntas;
    }

    public List<List<String>> separarOpciones(List<String> datos, int tamanoP) {
        List<List<String>> preguntas = new ArrayList<List<String>>();
        System.out.println("DDDDDDDDDDD" + Arrays.asList(datos) + tamanoP);
        boolean bandera = true;
        //int i = 0, j = tamanoP;
        /*while (bandera) {
            if (i != datos.size()) {
                List<String> pregunta2 = datos.subList(i, tamanoP);
                preguntas.add(pregunta2);
                i = tamanoP;
                tamanoP = tamanoP + j;
            } else {
                bandera = false;
            }
        }*/
        final int N = datos.size();
        for (int i = 0; i < N; i += 6) {
            List<String> pregunta2 = datos.subList(i, Math.min(N, i + 6));
            preguntas.add(pregunta2);
//            preguntas.add(datos.subList(i, Math.min(N, i + 4)));
        }
        System.out.println("DDDDDDDDDDD>" + Arrays.asList(preguntas) + tamanoP);
        return preguntas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIDEncuesta = new javax.swing.JLabel();
        lblNombreEncuesta = new javax.swing.JLabel();
        lblDescripcionEncuesta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblNombreUsu = new javax.swing.JLabel();
        lblCIU = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalP = new javax.swing.JLabel();
        f = new javax.swing.JPanel();
        l = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIDEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblIDEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 11, 139, 14));

        lblNombreEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblNombreEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 11, 260, 14));

        lblDescripcionEncuesta.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jPanel1.add(lblDescripcionEncuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 31, 122, 31));

        jLabel1.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel1.setText("ID ENCUESTA:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 11, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, -1, -1));

        lblNombreUsu.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        lblNombreUsu.setText("jLabel3");
        jPanel1.add(lblNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 160, -1));

        lblCIU.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        lblCIU.setText("jLabel4");
        jPanel1.add(lblCIU, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 170, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        jLabel2.setText("Total Preguntas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        lblTotalP.setFont(new java.awt.Font("Helvetica World", 0, 11)); // NOI18N
        lblTotalP.setText("jLabel3");
        jPanel1.add(lblTotalP, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        f.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout fLayout = new javax.swing.GroupLayout(f);
        f.setLayout(fLayout);
        fLayout.setHorizontalGroup(
            fLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        fLayout.setVerticalGroup(
            fLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 900, 240));

        l.setText("jLabel3");
        jPanel1.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        obo.confirmarCambiosObjeto();
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed
/*
    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RespuestasFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RespuestasFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RespuestasFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RespuestasFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RespuestasFrame().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel f;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l;
    private javax.swing.JLabel lblCIU;
    private javax.swing.JLabel lblDescripcionEncuesta;
    private javax.swing.JLabel lblIDEncuesta;
    private javax.swing.JLabel lblNombreEncuesta;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblTotalP;
    // End of variables declaration//GEN-END:variables
}
