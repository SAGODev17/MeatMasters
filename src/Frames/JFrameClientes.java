/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Animacion.Fade;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sergio
 */
public final class JFrameClientes extends javax.swing.JFrame {

    Conexion ConeBD = new Conexion();
    SoloMayusculas mayus = new SoloMayusculas();
    public int Ingreso = 0;
    public int busqueda = 2;
    public int id_usuario = 0;
    public int id_sqlUsuario = 0;
    public String SqlMostrarT;

    DefaultTableModel DatosCliente;
    Object DatCliente[] = new Object[9];

    public JFrameClientes() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.setUndecorated(true);
            initComponents();
            this.apagar();
            this.setExtendedState(MAXIMIZED_BOTH);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException err) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rSCrear = new rsbuttom.RSButtonMetro();
        rSCrear1 = new rsbuttom.RSButtonMetro();
        rSCrear3 = new rsbuttom.RSButtonMetro();
        rSCrear4 = new rsbuttom.RSButtonMetro();
        rSCrear5 = new rsbuttom.RSButtonMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldBcedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNombreP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextNombreS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldApellidoP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldApellidoS = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldCeluar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBnombre = new javax.swing.JTextField();
        jButtonBusqueda = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel3.setBackground(new java.awt.Color(109, 0, 25));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(255, 255, 255)));

        rSCrear.setText("EDITAR");
        rSCrear.setColorHover(new java.awt.Color(204, 0, 0));
        rSCrear.setColorNormal(new java.awt.Color(255, 204, 204));
        rSCrear.setColorPressed(new java.awt.Color(51, 0, 0));
        rSCrear.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSCrearActionPerformed(evt);
            }
        });

        rSCrear1.setText("NUEVO");
        rSCrear1.setColorHover(new java.awt.Color(204, 0, 0));
        rSCrear1.setColorNormal(new java.awt.Color(255, 204, 204));
        rSCrear1.setColorPressed(new java.awt.Color(51, 0, 0));
        rSCrear1.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSCrear1ActionPerformed(evt);
            }
        });

        rSCrear3.setText("Cerrar");
        rSCrear3.setColorHover(new java.awt.Color(204, 0, 0));
        rSCrear3.setColorNormal(new java.awt.Color(255, 204, 204));
        rSCrear3.setColorPressed(new java.awt.Color(51, 0, 0));
        rSCrear3.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSCrear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSCrear3ActionPerformed(evt);
            }
        });

        rSCrear4.setText("ELIMINAR");
        rSCrear4.setColorHover(new java.awt.Color(204, 0, 0));
        rSCrear4.setColorNormal(new java.awt.Color(255, 204, 204));
        rSCrear4.setColorPressed(new java.awt.Color(51, 0, 0));
        rSCrear4.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSCrear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSCrear4ActionPerformed(evt);
            }
        });

        rSCrear5.setText("GUARDAR");
        rSCrear5.setColorHover(new java.awt.Color(204, 0, 0));
        rSCrear5.setColorNormal(new java.awt.Color(255, 204, 204));
        rSCrear5.setColorPressed(new java.awt.Color(51, 0, 0));
        rSCrear5.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSCrear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSCrear5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rSCrear1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(rSCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSCrear4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSCrear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(rSCrear5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSCrear1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(rSCrear4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSCrear5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSCrear3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaClientes.setOpaque(false);
        TablaClientes.setSelectionBackground(new java.awt.Color(255, 204, 204));
        TablaClientes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaClientes);

        jPanel2.setBackground(new java.awt.Color(109, 0, 25));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("Cliente");

        jTextFieldBcedula.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldBcedula.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldBcedula.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldBcedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBcedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBcedulaKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BUSQUEDA POR CÉDULA");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GESTIÓN DE CLIENTES");
        jLabel12.setToolTipText("");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CÉDULA");

        jTextFieldCC.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCC.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldCC.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCCActionPerformed(evt);
            }
        });
        jTextFieldCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCCKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCCKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRIMER NOMBRE");

        jTextNombreP.setBackground(new java.awt.Color(255, 255, 255));
        jTextNombreP.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextNombreP.setForeground(new java.awt.Color(0, 0, 0));
        jTextNombreP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombrePActionPerformed(evt);
            }
        });
        jTextNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNombrePKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombrePKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SEGUNDO NOMBRE");

        jTextNombreS.setBackground(new java.awt.Color(255, 255, 255));
        jTextNombreS.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextNombreS.setForeground(new java.awt.Color(0, 0, 0));
        jTextNombreS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombreS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreSActionPerformed(evt);
            }
        });
        jTextNombreS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNombreSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreSKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PRIMER APELLIDO");

        jTextFieldApellidoP.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoP.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldApellidoP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPActionPerformed(evt);
            }
        });
        jTextFieldApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPKeyTyped(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SEGUNDO APELLIDO");

        jTextFieldApellidoS.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoS.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldApellidoS.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldApellidoS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldApellidoS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoSKeyTyped(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setToolTipText("Clientes");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CÉLULAR");

        jTextFieldCeluar.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCeluar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldCeluar.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCeluar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCeluarActionPerformed(evt);
            }
        });
        jTextFieldCeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCeluarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCeluarKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("DIRECCIÓN");

        jTextFieldDireccion.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldDireccion.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDireccionActionPerformed(evt);
            }
        });
        jTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDireccionKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BUSQUEDA POR NOMBRE");

        jTextFieldBnombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldBnombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldBnombre.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldBnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBnombreActionPerformed(evt);
            }
        });
        jTextFieldBnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBnombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBnombreKeyTyped(evt);
            }
        });

        jButtonBusqueda.setBackground(new java.awt.Color(109, 0, 25));
        jButtonBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons-search.png"))); // NOI18N
        jButtonBusqueda.setToolTipText("");
        jButtonBusqueda.setBorderPainted(false);
        jButtonBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBusqueda.setFocusPainted(false);
        jButtonBusqueda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldApellidoS, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(jTextFieldBcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCC, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextFieldBnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBusqueda)))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldBcedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTextFieldBnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombreS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldApellidoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldApellidoS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldCeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void rSCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrearActionPerformed
        Ingreso = 2;
        prenderCampos();
        editarcampos();

    }//GEN-LAST:event_rSCrearActionPerformed

    private void rSCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear1ActionPerformed
        Ingreso = 1;
        prenderCampos();
        borraCamposr();
    }//GEN-LAST:event_rSCrear1ActionPerformed

    private void rSCrear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear3ActionPerformed
        ConeBD.closeConexion_BD();
//        Fade.JFrameFadeOut(1f, 0f, 0.1f, 50, this, Fade.DISPOSE);

 
        dispose();
    }//GEN-LAST:event_rSCrear3ActionPerformed

    private void rSCrear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear4ActionPerformed
        eliminarCliente();
    }//GEN-LAST:event_rSCrear4ActionPerformed

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked

        int fila = TablaClientes.getSelectedRow();
        int Columna0 = 0, Columna1 = 1, Columna2 = 2, Columna3 = 3, Columna4 = 4, Columna5 = 5, Columna6 = 6;
        jTextFieldCC.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna0)));
        jTextNombreP.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna1)));
        jTextNombreS.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna2)));
        jTextFieldApellidoP.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna3)));
        jTextFieldApellidoS.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna4)));
        jTextFieldCeluar.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna5)));
        jTextFieldDireccion.setText(String.valueOf(this.TablaClientes.getValueAt(fila, Columna6)));
    }//GEN-LAST:event_TablaClientesMouseClicked

    void mostrarDatosTabla() {
        TablaClientes.clearSelection();
        DatosCliente = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TablaClientes.setModel(DatosCliente);
        DatosCliente.addColumn("Cédula");
        DatosCliente.addColumn("Primer nombre");
        DatosCliente.addColumn("Segundo nombre");
        DatosCliente.addColumn("Primer apellido");
        DatosCliente.addColumn("Segundo apellido");
        DatosCliente.addColumn("Célular");
        DatosCliente.addColumn("Dirección");
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) TablaClientes.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        TablaClientes.setRowHeight(30);
        Font headerFont = headerRenderer.getFont();
        Font newHeaderFont = new Font(headerFont.getName(), Font.BOLD, 14);
        TablaClientes.getTableHeader().setFont(newHeaderFont);
        TablaClientes.getTableHeader().setReorderingAllowed(false);
        TablaClientes.getTableHeader().setResizingAllowed(false);
        switch (busqueda) {
            case 0 -> {
                SqlMostrarT = "SELECT * FROM CLIENTE WHERE  PNOM_CLIENTE  LIKE '%" + jTextFieldBnombre.getText() + "%' ORDER BY PNOM_CLIENTE";
                System.out.println(SqlMostrarT);
            }
            case 1 -> {
                if (jTextFieldBcedula.getText().length() >= 8) {
                    SqlMostrarT = "SELECT * FROM CLIENTE WHERE CC_CLIENTE = " + jTextFieldBcedula.getText() + " ORDER BY PNOM_CLIENTE";
                } else {
                    JOptionPane.showMessageDialog(rootPane, "La cédula, " + jTextFieldBcedula.getText() + ", no existe, por favor ingrese una cédula real");
                    borraCamposr();
                    jTextFieldBcedula.requestFocus();
                    busqueda = 2;
                    mostrarDatosTabla();
                }
            }
            case 2 ->
                SqlMostrarT = "SELECT * FROM CLIENTE ORDER BY PNOM_CLIENTE";
        }
        try {
            ConeBD.RstBD = (ResultSet) ConeBD.StmBD.executeQuery(SqlMostrarT);

            if (ConeBD.RstBD != null && ConeBD.RstBD.next()) {
                do {
                    DatCliente[0] = ConeBD.RstBD.getString("CC_CLIENTE");
                    DatCliente[1] = ConeBD.RstBD.getString("PNOM_CLIENTE");
                    DatCliente[2] = ConeBD.RstBD.getString("SNOM_CLIENTE");
                    DatCliente[3] = ConeBD.RstBD.getString("PAPE__CLIENTE");
                    DatCliente[4] = ConeBD.RstBD.getString("SAPE_CLIENTE");
                    DatCliente[5] = ConeBD.RstBD.getString("CELULAR_CLIENTE");
                    DatCliente[6] = ConeBD.RstBD.getString("DIRECCION_CLIENTE");
                    DatosCliente.addRow(DatCliente);
                } while (ConeBD.RstBD.next());
            } else {
                if (busqueda == 0) {
                    busqueda = 2;
                    JOptionPane.showMessageDialog(rootPane, "No se encontró algún cliente con el nombre, " + jTextFieldBnombre.getText());
                    borraCamposr();
                    mostrarDatosTabla();
                }
                if (busqueda == 1) {
                    busqueda = 2;
                    JOptionPane.showMessageDialog(rootPane, "No se encontró algún cliente con  cédula, " + jTextFieldBcedula.getText());
                    borraCamposr();
                    mostrarDatosTabla();

                }

            }

        } catch (SQLException err) {
            err.printStackTrace();
        } finally {

        }
    }

    public void agregarCliente() {
        switch (Ingreso) {
            case 1 -> {
                if (jTextFieldCC.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar una cédula");
                    break;
                }

                if (jTextFieldApellidoP.getText().isEmpty() || jTextFieldApellidoS.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un apellido");
                    break;
                }

                if (jTextNombreP.getText().isEmpty() || jTextNombreS.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                    break;
                }

                if (jTextFieldDireccion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una dirección...");
                    break;
                }
                if (jTextFieldCeluar.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número célular...");
                    break;
                }
                guardarCliente();
            }

            case 2 -> {
                editarCliente();
            }

            default -> {
            }
        }
    }

    public void guardarCliente() {
        String sqlGuardarCliente;
        try {
            sqlGuardarCliente = "INSERT INTO CLIENTE VALUES (" + jTextFieldCC.getText() + ",'" + jTextNombreP.getText() + "','" + jTextNombreS.getText() + "','" + jTextFieldApellidoP.getText() + "','" + jTextFieldApellidoS.getText() + "'," + jTextFieldCeluar.getText() + ",'" + jTextFieldDireccion.getText() + "')";
            ConeBD.StmBD.executeUpdate(sqlGuardarCliente);
            System.out.println(sqlGuardarCliente);
            busqueda = 2;
            mostrarDatosTabla();
            borraCamposr();
            apagar();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            JOptionPane.showMessageDialog(null, "Usuario y Rol Almacenado ...");
        }
    }

    public void editarCliente() {

        String SqlEditarCliente;
        try {
            SqlEditarCliente = "UPDATE CLIENTE SET PNOM_CLIENTE = '" + jTextNombreP.getText() + "', SNOM_CLIENTE = '" + jTextNombreS.getText() + "',"
                    + " PAPE__CLIENTE = '" + jTextFieldApellidoP.getText() + "', SAPE_CLIENTE = '" + jTextFieldApellidoS.getText() + "', CELULAR_CLIENTE =" + jTextFieldCeluar.getText() + ""
                    + ", DIRECCION_CLIENTE = '" + jTextFieldDireccion.getText() + "' WHERE CC_CLIENTE = " + jTextFieldCC.getText();
            ConeBD.StmBD.executeUpdate(SqlEditarCliente);
            JOptionPane.showMessageDialog(null, "Información Modificada al Usuario : " + jTextNombreP.getText());
            borraCamposr();
            apagar();
            busqueda = 2;
            mostrarDatosTabla();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void editarcampos() {
        jTextFieldCC.setEnabled(false);
    }

    public void eliminarCliente() {
        String sqlEliminarCo;
        try {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de eliminar al cliente?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, "Cliente " + jTextNombreP.getText() + " eliminado exitosamente.");
                sqlEliminarCo = "DELETE FROM CLIENTE WHERE CC_CLIENTE  = " + jTextFieldCC.getText();
                ConeBD.StmBD.executeUpdate(sqlEliminarCo);
                borraCamposr();
                busqueda = 2;
                mostrarDatosTabla();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Eliminación cancelada.");
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void apagar() {
        this.jTextFieldCC.setEnabled(false);
        this.jTextNombreP.setEnabled(false);
        this.jTextNombreS.setEnabled(false);
        this.jTextFieldApellidoS.setEnabled(false);
        this.jTextFieldApellidoP.setEnabled(false);
        this.jTextFieldCeluar.setEnabled(false);
        this.jTextFieldDireccion.setEnabled(false);
    }

    private void prenderCampos() {
        this.jTextFieldCC.requestFocus();
        this.jTextFieldCC.setEnabled(true);
        this.jTextNombreP.setEnabled(true);
        this.jTextNombreS.setEnabled(true);
        this.jTextFieldApellidoS.setEnabled(true);
        this.jTextFieldApellidoP.setEnabled(true);
        this.jTextFieldCeluar.setEnabled(true);
        this.jTextFieldDireccion.setEnabled(true);
    }

    private void borraCamposr() {
        this.jTextFieldCC.setText("");
        this.jTextFieldBnombre.setText("");
        this.jTextFieldCC.setText("");
        this.jTextNombreP.setText("");
        this.jTextNombreS.setText("");
        this.jTextFieldApellidoS.setText("");
        this.jTextFieldApellidoP.setText("");
        this.jTextFieldBcedula.setText("");
        this.jTextFieldBnombre.setText("");
        this.jTextFieldCeluar.setText("");
        this.jTextFieldDireccion.setText("");
    }


    private void jTextFieldBcedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBcedulaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldBcedula.getText().equals(""))) {
                jTextFieldBnombre.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un nombre una cédula");
                jTextFieldBcedula.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldBcedulaKeyPressed

    private void jTextFieldBcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBcedulaKeyTyped
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jTextFieldBcedulaKeyTyped

    private void jTextFieldCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCCActionPerformed

    }//GEN-LAST:event_jTextFieldCCActionPerformed

    private void jTextFieldCCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCCKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldCC.getText().equals(""))) {
                jTextNombreP.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar una cédula");
                jTextFieldCC.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldCCKeyPressed

    private void jTextFieldCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCCKeyTyped
        if (jTextFieldCC.getText().length() >= 10) {
            evt.consume();
        }
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jTextFieldCCKeyTyped

    private void jTextNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombrePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombrePActionPerformed

    private void jTextNombrePKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombrePKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextNombreP.getText().equals(""))) {
                jTextNombreS.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un nombre");
                jTextNombreP.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextNombrePKeyPressed

    private void jTextNombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombrePKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextNombrePKeyTyped

    private void jTextNombreSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreSActionPerformed

    private void jTextNombreSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreSKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextNombreS.getText().equals(""))) {
                jTextFieldApellidoP.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un nombre");
                jTextNombreS.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextNombreSKeyPressed

    private void jTextNombreSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreSKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextNombreSKeyTyped

    private void jTextFieldApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoPActionPerformed

    private void jTextFieldApellidoPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldApellidoP.getText().equals(""))) {
                jTextFieldApellidoS.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un apellido");
                jTextFieldApellidoP.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldApellidoPKeyPressed

    private void jTextFieldApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextFieldApellidoPKeyTyped

    private void jTextFieldApellidoSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoSKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldApellidoS.getText().equals(""))) {
                jTextFieldCeluar.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un apellido");
                jTextFieldApellidoS.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldApellidoSKeyPressed

    private void jTextFieldApellidoSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoSKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextFieldApellidoSKeyTyped

    private void jTextFieldCeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCeluarActionPerformed

    private void jTextFieldCeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCeluarKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldCeluar.getText().equals(""))) {
                jTextFieldDireccion.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un numero célular");
                jTextFieldCeluar.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldCeluarKeyPressed

    private void jTextFieldCeluarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCeluarKeyTyped
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jTextFieldCeluarKeyTyped

    private void jTextFieldDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldDireccion.getText().equals(""))) {
                jTextFieldBcedula.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar una dirección");
                jTextFieldDireccion.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldDireccionKeyPressed

    private void jTextFieldDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
    }//GEN-LAST:event_jTextFieldDireccionKeyTyped

    private void jTextFieldBnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBnombreKeyPressed

    }//GEN-LAST:event_jTextFieldBnombreKeyPressed

    private void jTextFieldBnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBnombreKeyTyped
        char e = evt.getKeyChar();
        mayus.notNum(evt, e);
        mayus.may(evt, e);
    }//GEN-LAST:event_jTextFieldBnombreKeyTyped

    private void jTextFieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDireccionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ConeBD.openConeccion_BD();
        mostrarDatosTabla();

    }//GEN-LAST:event_formWindowOpened

    private void rSCrear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear5ActionPerformed
        agregarCliente();
        apagar();
    }//GEN-LAST:event_rSCrear5ActionPerformed

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        if (!jTextFieldBnombre.getText().equals("")) {
            busqueda = 0;
            mostrarDatosTabla();
        }

        if (!jTextFieldBcedula.getText().equals("")) {
            busqueda = 1;
            mostrarDatosTabla();
        }

        if (jTextFieldBnombre.getText().equals("") && jTextFieldBcedula.getText().equals("")) {
            busqueda = 2;
            mostrarDatosTabla();
        }


    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jTextFieldBnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBnombreActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldApellidoP;
    private javax.swing.JTextField jTextFieldApellidoS;
    private javax.swing.JTextField jTextFieldBcedula;
    private javax.swing.JTextField jTextFieldBnombre;
    private javax.swing.JTextField jTextFieldCC;
    private javax.swing.JTextField jTextFieldCeluar;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextNombreP;
    private javax.swing.JTextField jTextNombreS;
    private rsbuttom.RSButtonMetro rSCrear;
    private rsbuttom.RSButtonMetro rSCrear1;
    private rsbuttom.RSButtonMetro rSCrear3;
    private rsbuttom.RSButtonMetro rSCrear4;
    private rsbuttom.RSButtonMetro rSCrear5;
    // End of variables declaration//GEN-END:variables
}
