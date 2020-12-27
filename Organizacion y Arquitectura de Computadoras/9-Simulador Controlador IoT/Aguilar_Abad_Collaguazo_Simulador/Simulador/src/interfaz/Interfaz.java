/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import simulador.Comunicador;

/**
 *
 * @author XaviO_o
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    Comunicador com = new Comunicador();
    private boolean contador = true;

    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        String titulo[] = {"Address", "Content"};
        DefaultTableModel model = new DefaultTableModel(com.getMemoria().getMemoria(), titulo);
        tMemoria.setModel(model);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tMemoria.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tMemoria.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tPC.setEditable(false);
        tMAR.setEditable(false);
        tIR.setEditable(false);
        tMDR.setEditable(false);
        tCU.setEditable(false);
        tAcu.setEditable(false);
        tALU.setEditable(false);
        tSalida.setEditable(false);
        tMemoria.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMemoria = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tMDR = new javax.swing.JTextField();
        tPC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tMAR = new javax.swing.JTextField();
        bSiguiente = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tIR = new javax.swing.JTextField();
        flecha3 = new javax.swing.JLabel();
        flecha2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tCU = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tAcu = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        tALU = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        flecha4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        flecha5 = new javax.swing.JLabel();
        flecha6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tSalida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 200, 81));
        jPanel3.setLayout(null);

        tMemoria.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tMemoria);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 240, 440);

        jLabel35.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Principal Memory");
        jPanel3.add(jLabel35);
        jLabel35.setBounds(0, 10, 280, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(980, 130, 280, 510);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPU (Processor)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Typewriter", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tMDR.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tMDR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tMDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 100, 40));

        tPC.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 100, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel9.setText("MDR");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 40, 40));

        tMAR.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tMAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tMAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 100, 40));

        bSiguiente.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        bSiguiente.setText("Next");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(bSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 100, 40));

        jLabel22.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel22.setText("PC");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 40, 40));

        jLabel23.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel23.setText("IR");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 40, 40));

        tIR.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tIR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 100, 40));

        flecha3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha2.png"))); // NOI18N
        jPanel1.add(flecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha5.png"))); // NOI18N
        jPanel1.add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 60, 110));

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(180, 80));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Control Unit");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        tCU.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tCU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(tCU, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, 35));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 87));

        jPanel9.setBackground(new java.awt.Color(43, 187, 173));
        jPanel9.setPreferredSize(new java.awt.Dimension(180, 80));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Accumulator");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        tAcu.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tAcu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel9.add(tAcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, 35));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 87));

        jPanel10.setBackground(new java.awt.Color(55, 71, 79));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ALU");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        tALU.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        tALU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(tALU, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, 35));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 87));

        jLabel30.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel30.setText("MAR");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 40, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha4.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 10, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha4.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 10, -1));

        flecha4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha6.png"))); // NOI18N
        jPanel1.add(flecha4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 20, 10));

        jPanel11.setBackground(new java.awt.Color(255, 68, 68));
        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 173, 5, 120));

        jPanel13.setBackground(new java.awt.Color(255, 68, 68));
        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 290, 210, 5));

        flecha5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha3.png"))); // NOI18N
        jPanel1.add(flecha5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 40, 40));

        flecha6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha6.png"))); // NOI18N
        jPanel1.add(flecha6, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 287, 20, 10));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 470, 380));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Opcodes");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("0001 - ADD - 1");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("0010 - SUB - 2");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("0011 - LOAD - 3");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("0100 - STORE - 4");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("0101 - JMP- 5");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 30));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("Input/Output");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 30));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel26.setText("Save: pos OPCODE value");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 180, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("Get  : pos OPCODE");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 30));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("Save instruction:");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 30));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setText("pos opcode [posmem]");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 200, 30));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setText("Execute:");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("pos");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 150, 30));

        jButton1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jButton1.setText("Clean");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 100, 40));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 340, 380));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Typewriter", 1, 11))); // NOI18N
        jPanel2.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel10.setText("Output");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(520, 30, 60, 30);

        tSalida.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jPanel2.add(tSalida);
        tSalida.setBounds(590, 30, 210, 40);

        jLabel12.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel12.setText("Input");
        jLabel12.setToolTipText("");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 40, 80, 30);

        bEjecutar.setBackground(new java.awt.Color(255, 255, 255));
        bEjecutar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        bEjecutar.setText("Start");
        bEjecutar.setBorder(null);
        bEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEjecutarActionPerformed(evt);
            }
        });
        jPanel2.add(bEjecutar);
        bEjecutar.setBounds(360, 30, 100, 40);

        tDatos.setColumns(20);
        tDatos.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        tDatos.setRows(5);
        jScrollPane2.setViewportView(tDatos);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(90, 30, 240, 86);

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 820, 130));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha1.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 120, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha1.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, -1, -1));

        jLabel24.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Control Bus");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 110, 20));

        jLabel31.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 10)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Address Bus");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 110, 20));

        jLabel32.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 10)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Data Bus");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 110, 20));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha1.png"))); // NOI18N
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, -1, -1));

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 100, 1340, 690);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png"))); // NOI18N
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1248, 10, 20, 30));

        jLabel29.setBackground(new java.awt.Color(51, 51, 51));
        jLabel29.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Computer Simulator");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 30));

        jPanel6.setBackground(new java.awt.Color(255, 68, 68));

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Arquitectura y Organización de Computadores");
        jPanel6.add(jLabel28);

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 360, -1));

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 1340, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEjecutarActionPerformed

        if (!tDatos.getText().equals("")) {
            String datos[] = tDatos.getText().split("\n");
            for (String dato : datos) {
                com.guardarDato(dato);
                if (!dato.contains(" ")) {
                    tPC.setText(String.valueOf(com.getCpu().getProgramCounter()));
                }

            }
            if (!com.getEntrada().getSalida().equals("")) {
                tSalida.setText(com.getEntrada().getSalida());
                com.getEntrada().setSalida("");
            }
            String titulo[] = {"Address", "Content"};

            DefaultTableModel model = new DefaultTableModel(com.getMemoria().getMemoria(), titulo);
            tMemoria.setModel(model);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            tMemoria.getColumnModel().getColumn(0).setCellRenderer(tcr);
            tMemoria.getColumnModel().getColumn(1).setCellRenderer(tcr);
            
            tDatos.setText("");
        }
        
    }//GEN-LAST:event_bEjecutarActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        if (!com.getMemoria().getMemoria()[com.getCpu().getProgramCounter()][1].equals("0") && contador) {
            com.ejecutarSiguiente(contador);
            tMAR.setText(String.valueOf(com.getCpu().getMAR()));
            tIR.setText(String.valueOf(com.getCpu().getRegistroInstruccion()));
            tMDR.setText(String.valueOf(com.getCpu().getMDR()));
            tPC.setText(String.valueOf(com.getCpu().getProgramCounter()));
            tCU.setText(String.valueOf(com.getCpu().getControlUnit()));
            tAcu.setText(String.valueOf(com.getCpu().getAcumulador()));
            tALU.setText(String.valueOf(com.getCpu().getALU()));
            if (!contador) {
                contador = true;
            } else {
                contador = false;
            }
        } else if (!contador) {
            com.ejecutarSiguiente(contador);
            tMAR.setText(String.valueOf(com.getCpu().getMAR()));
            tIR.setText(String.valueOf(com.getCpu().getRegistroInstruccion()));
            tMDR.setText(String.valueOf(com.getCpu().getMDR()));
            tPC.setText(String.valueOf(com.getCpu().getProgramCounter()));
            tCU.setText(String.valueOf(com.getCpu().getControlUnit()));
            tAcu.setText(String.valueOf(com.getCpu().getAcumulador()));
            tALU.setText(String.valueOf(com.getCpu().getALU()));
            if (!contador) {
                contador = true;
            } else {
                contador = false;
            }
        }
        String titulo[] = {"Address", "Content"};

        DefaultTableModel model = new DefaultTableModel(com.getMemoria().getMemoria(), titulo);
        tMemoria.setModel(model);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tMemoria.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tMemoria.getColumnModel().getColumn(1).setCellRenderer(tcr);
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        try {
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        //this.dispose();
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        com.vaciar();
        String titulo[] = {"Address", "Content"};
        DefaultTableModel model = new DefaultTableModel(com.getMemoria().getMemoria(), titulo);
        tMemoria.setModel(model);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tMemoria.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tMemoria.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tMAR.setText("");
        tIR.setText("");
        tMDR.setText("");
        tPC.setText("");
        tCU.setText("");
        tAcu.setText("");
        tALU.setText("");
        tSalida.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEjecutar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel flecha3;
    private javax.swing.JLabel flecha4;
    private javax.swing.JLabel flecha5;
    private javax.swing.JLabel flecha6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tALU;
    private javax.swing.JTextField tAcu;
    private javax.swing.JTextField tCU;
    private javax.swing.JTextArea tDatos;
    private javax.swing.JTextField tIR;
    private javax.swing.JTextField tMAR;
    private javax.swing.JTextField tMDR;
    private javax.swing.JTable tMemoria;
    private javax.swing.JTextField tPC;
    private javax.swing.JTextField tSalida;
    // End of variables declaration//GEN-END:variables
}