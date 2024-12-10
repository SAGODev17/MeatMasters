/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import java.awt.Font;
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
 * @author nem
 */
public final class JFrameSeguridad extends javax.swing.JFrame {

    Conexion ConeBD = new Conexion();
    SoloMayusculas mayus = new SoloMayusculas();
    int Ingreso = 0;
    int id_usuario = 0;
    int id_sqlUsuario = 0;

    DefaultTableModel DatosSeguridad;
    Object DatSeguridad[] = new Object[9];

    public JFrameSeguridad() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.setUndecorated(true);
            initComponents();
            this.apagar();
            this.setExtendedState(MAXIMIZED_BOTH);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException err) {
        }

    }

    void mostrarDatosTabla() {
        String SqlMostrarT;

        TablaSeguridad.clearSelection();
        DatosSeguridad = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TablaSeguridad.setModel(DatosSeguridad);
        DatosSeguridad.addColumn("Cédula");
        DatosSeguridad.addColumn("Primer nombre");
        DatosSeguridad.addColumn("Segundo nombre");
        DatosSeguridad.addColumn("Primer apellido");
        DatosSeguridad.addColumn("Segundo apellido");
        DatosSeguridad.addColumn("Tipo");
        DatosSeguridad.addColumn("Estado");
        DatosSeguridad.addColumn("Célular");
        DatosSeguridad.addColumn("Dirección");

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) TablaSeguridad.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        TablaSeguridad.setRowHeight(30);
        Font headerFont = headerRenderer.getFont();
        Font newHeaderFont = new Font(headerFont.getName(), Font.BOLD, 14);
        TablaSeguridad.getTableHeader().setFont(newHeaderFont);
        TablaSeguridad.getTableHeader().setReorderingAllowed(false);
        TablaSeguridad.getTableHeader().setResizingAllowed(false);

        try {
            SqlMostrarT = "SELECT E.CC_EMPLEADO,  E.CELULAR_EMPLEADO, E.DIRECCION_EMPLEADO, E.PNOM_EMPLEADO,"
                    + " E.SNOM_EMPLEADO, E.PAPE_EMPLEADO, E.SAPE_EMPLEADO, S.ROLL_SEGURIDAD, S.ESTADO_SEGURIDAD "
                    + "FROM SEGURIDAD S JOIN EMPLEADO E ON S.CC_EMPLEADO_SEGURIDAD = E.CC_EMPLEADO";
            ConeBD.RstBD = (ResultSet) ConeBD.StmBD.executeQuery(SqlMostrarT);

            while (ConeBD.RstBD.next()) {
                DatSeguridad[0] = ConeBD.RstBD.getString("CC_EMPLEADO");
                DatSeguridad[1] = ConeBD.RstBD.getString("PNOM_EMPLEADO");
                DatSeguridad[2] = ConeBD.RstBD.getString("SNOM_EMPLEADO");
                DatSeguridad[3] = ConeBD.RstBD.getString("PAPE_EMPLEADO");
                DatSeguridad[4] = ConeBD.RstBD.getString("SAPE_EMPLEADO");
                int rollSeguridad = ConeBD.RstBD.getInt("ROLL_SEGURIDAD");
                int estadoSeguridad = ConeBD.RstBD.getInt("ESTADO_SEGURIDAD");
                switch (rollSeguridad) {
                    case 1:
                        DatSeguridad[5] = "ADMINISTRADOR";
                        break;
                    case 2:
                        DatSeguridad[5] = "AUXILIAR";
                        break;
                    default:
                        DatSeguridad[5] = "SELECCIONAR";
                }

                switch (estadoSeguridad) {
                    case 1:
                        DatSeguridad[6] = "ACTIVO";
                        break;
                    case 2:
                        DatSeguridad[6] = "INACTIVO";
                        break;
                    default:
                        DatSeguridad[6] = "SELECCIONAR";
                }

                DatSeguridad[7] = ConeBD.RstBD.getString("CELULAR_EMPLEADO");
                DatSeguridad[8] = ConeBD.RstBD.getString("DIRECCION_EMPLEADO");

                DatosSeguridad.addRow(DatSeguridad);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        } finally {
        }
    }

    public void agregarPersona() {

        switch (Ingreso) {
            case 1 -> {
                if (jTextFieldCC.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar una cédula ...");
                    break;
                }

                if (jPasswordFieldContra1.getText().isEmpty() || jPasswordFieldcontra2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña...");
                    break;
                }

                if (!jPasswordFieldContra1.getText().equals(jPasswordFieldcontra2.getText())) {
                    JOptionPane.showMessageDialog(null, "Las Contraseñas no Son Iguales ...");
                    break;
                }

                if (jComboBoxEstado.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar un estado de usuario...");
                    break;
                }

                if (jComboBoxTipo.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar un tipo de usuario...");
                    break;
                }

                if (jTextFieldApellidoP.getText().isEmpty() || jTextFieldApellidoS.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un los apellidos...");
                    break;
                }

                if (jTextFieldUsuario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un usuario...");
                    break;
                }

                if (jTextNombreP.getText().isEmpty() || jTextNombreS.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar un nombre");
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
                guardarEmpleado();
            }

            case 2 -> {
                editarUsuario();
            }

            default -> {
            }
        }

    }

    void apagar() {

        jTextFieldCC.setEnabled(false);
        jTextNombreP.setEnabled(false);
        jTextNombreS.setEnabled(false);
        jTextFieldApellidoS.setEnabled(false);
        jTextFieldApellidoP.setEnabled(false);
        jTextFieldUsuario.setEnabled(false);
        jTextFieldCeluar.setEnabled(false);
        jTextFieldDireccion.setEnabled(false);
        jPasswordFieldContra1.setEnabled(false);
        jPasswordFieldcontra2.setEnabled(false);
        jComboBoxTipo.setEnabled(false);
        jComboBoxEstado.setEnabled(false);

    }

    private void prender() {

        jTextFieldCC.requestFocus();
        jTextFieldCC.setEnabled(true);
        jTextNombreP.setEnabled(true);
        jTextNombreS.setEnabled(true);
        jTextFieldApellidoS.setEnabled(true);
        jTextFieldApellidoP.setEnabled(true);
        jTextFieldUsuario.setEnabled(true);
        jTextFieldCeluar.setEnabled(true);
        jTextFieldDireccion.setEnabled(true);
        jPasswordFieldContra1.setEnabled(true);
        jPasswordFieldcontra2.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jComboBoxEstado.setEnabled(true);
    }

    private void Borrar() {
        jTextFieldCC.setText("");
        jTextNombreP.setText("");
        jTextNombreS.setText("");
        jTextFieldApellidoS.setText("");
        jTextFieldApellidoP.setText("");
        jTextFieldUsuario.setText("");
        jPasswordFieldContra1.setText("");
        jPasswordFieldcontra2.setText("");
        jTextFieldCeluar.setText("");
        jTextFieldDireccion.setText("");
        jComboBoxTipo.setSelectedIndex(0);
        jComboBoxEstado.setSelectedIndex(0);
    }

    public void editarcampos() {
        jTextFieldUsuario.setEnabled(false);
        jPasswordFieldContra1.setEnabled(false);
        jPasswordFieldcontra2.setEnabled(false);
        jTextFieldCC.setEnabled(false);

    }

    public void guardarEmpleado() {
        String sqlGuardarSeguridad, sqlGuardarEmpleado;
        try {
            usuarioid();
            sqlGuardarEmpleado = "INSERT INTO EMPLEADO VALUES (" + jTextFieldCC.getText() + ",'" + jTextNombreP.getText() + "','" + jTextNombreS.getText() + "','" + jTextFieldApellidoP.getText() + "','" + jTextFieldApellidoS.getText() + "'," + jTextFieldCeluar.getText() + ",'" + jTextFieldDireccion.getText() + "')";
            sqlGuardarSeguridad = "INSERT INTO SEGURIDAD VALUES (" + id_usuario + "," + jTextFieldCC.getText() + ","
                    + jComboBoxTipo.getSelectedIndex() + "," + jComboBoxEstado.getSelectedIndex() + ")";
            ConeBD.StmBD.executeUpdate(sqlGuardarEmpleado);
            ConeBD.StmBD.executeUpdate(sqlGuardarSeguridad);
            guardarContra();
            JOptionPane.showMessageDialog(null, "Usuario y Rol Almacenado ...");
            Borrar();
            apagar();
            mostrarDatosTabla();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {

        }
    }

    public void guardarContra() {
        String sqlGuardarCOseguridad;
        try {
            sqlGuardarCOseguridad = "INSERT INTO CO_SEGURIDAD VALUES (" + id_usuario + "," + id_usuario + ",'"
                    + jTextFieldUsuario.getText() + "','" + jPasswordFieldcontra2.getText() + "')";
            ConeBD.StmBD.executeUpdate(sqlGuardarCOseguridad);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int usuarioid() {
        String id_usu;
        try {
            id_usu = "SELECT MAX(id_seguridad)+1 'MAXIMO' FROM SEGURIDAD";
            ConeBD.RstBD = (ResultSet) ConeBD.StmBD.executeQuery(id_usu);
            if (ConeBD.RstBD.next()) {
                id_usuario = Integer.parseInt(ConeBD.RstBD.getString("MAXIMO"));

            }

        } catch (NumberFormatException | SQLException e) {
        }
        return id_usuario;
    }

    public void editarUsuario() {
        String SqlEditarEmpleado, SqlEditarSeguridad;

        try {
            SqlEditarSeguridad = "UPDATE EMPLEADO SET PNOM_EMPLEADO = '" + jTextNombreP.getText() + "', SNOM_EMPLEADO = '" + jTextNombreS.getText() + "',"
                    + " PAPE_EMPLEADO = '" + jTextFieldApellidoP.getText() + "', SAPE_EMPLEADO = '" + jTextFieldApellidoS.getText() + "', CELULAR_EMPLEADO =" + jTextFieldCeluar.getText() + ""
                    + ", DIRECCION_EMPLEADO = '" + jTextFieldDireccion.getText() + "' WHERE CC_EMPLEADO = " + jTextFieldCC.getText();

            SqlEditarEmpleado = "UPDATE SEGURIDAD SET ROLL_SEGURIDAD = '" + jComboBoxTipo.getSelectedIndex() + "', ESTADO_SEGURIDAD = '" + jComboBoxEstado.getSelectedIndex() + "'"
                    + " WHERE CC_EMPLEADO_SEGURIDAD = " + jTextFieldCC.getText();

            System.out.println(SqlEditarEmpleado);
            ConeBD.StmBD.executeUpdate(SqlEditarSeguridad);
            ConeBD.StmBD.executeUpdate(SqlEditarEmpleado);
            JOptionPane.showMessageDialog(null, "Informacion Modificada al Usuario : " + jTextNombreP.getText());
            Borrar();
            apagar();
            mostrarDatosTabla();
        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    public int buscarIdEmpleado() {
        try {
            String sql = "SELECT ID_SEGURIDAD 'ID' FROM SEGURIDAD "
                    + "WHERE CC_EMPLEADO_SEGURIDAD = " + jTextFieldCC.getText();
            ConeBD.RstBD = (ResultSet) ConeBD.StmBD.executeQuery(sql);
            if (ConeBD.RstBD.next()) {
                id_sqlUsuario = Integer.parseInt(ConeBD.RstBD.getString("ID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return id_sqlUsuario;

    }

    void eliminarEmpleado() {
        String sqlEliminarCo;
        try {
            buscarIdEmpleado();
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de eliminar al usuario?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, "Usuario " + jTextNombreP.getText() + " eliminado exitosamente.");
                sqlEliminarCo = "DELETE FROM EMPLEADO WHERE CC_EMPLEADO  = " + jTextFieldCC.getText();
                ConeBD.StmBD.executeUpdate(sqlEliminarCo);
                Borrar();
                mostrarDatosTabla();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Eliminación cancelada.");
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSeguridad = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rSCrear = new rsbuttom.RSButtonMetro();
        rSCrear1 = new rsbuttom.RSButtonMetro();
        rSCrear2 = new rsbuttom.RSButtonMetro();
        rSCrear3 = new rsbuttom.RSButtonMetro();
        rSCrear4 = new rsbuttom.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPasswordFieldContra1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPasswordFieldcontra2 = new javax.swing.JPasswordField();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        TablaSeguridad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaSeguridad.setToolTipText("");
        TablaSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaSeguridad.setOpaque(false);
        TablaSeguridad.setRowHeight(30);
        TablaSeguridad.setSelectionBackground(new java.awt.Color(255, 204, 204));
        TablaSeguridad.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TablaSeguridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSeguridadMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaSeguridad);

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

        rSCrear2.setText("GUARDAR");
        rSCrear2.setColorHover(new java.awt.Color(204, 0, 0));
        rSCrear2.setColorNormal(new java.awt.Color(255, 204, 204));
        rSCrear2.setColorPressed(new java.awt.Color(51, 0, 0));
        rSCrear2.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSCrear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSCrear2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSCrear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSCrear1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSCrear4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(rSCrear2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(rSCrear1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(rSCrear4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSCrear2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSCrear3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(109, 0, 25));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("Seguridad");

        jComboBoxTipo.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxTipo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jComboBoxTipo.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "ADMINISTRADOR", "AUXILIAR" }));
        jComboBoxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        jComboBoxTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxTipoKeyPressed(evt);
            }
        });

        jComboBoxEstado.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEstado.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jComboBoxEstado.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "ACTIVO", "INACTIVO" }));
        jComboBoxEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });
        jComboBoxEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxEstadoKeyPressed(evt);
            }
        });

        jTextFieldUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USUARIO");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ESTADO");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CONTRASEÑA");

        jPasswordFieldContra1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldContra1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jPasswordFieldContra1.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldContra1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldContra1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldContra1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldContra1KeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CONTRASEÑA");

        jPasswordFieldcontra2.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldcontra2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jPasswordFieldcontra2.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldcontra2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldcontra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldcontra2ActionPerformed(evt);
            }
        });
        jPasswordFieldcontra2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldcontra2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldcontra2KeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GESTIÓN DE SEGURIDAD");
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

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("TIPO");

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

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldContra1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldcontra2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCC, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldApellidoS, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldApellidoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldCeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordFieldContra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordFieldcontra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(108, 108, 108)))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
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

    private void TablaSeguridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSeguridadMouseClicked

        int fila = TablaSeguridad.getSelectedRow();
        int Columna0 = 0, Columna1 = 1, Columna2 = 2, Columna3 = 3, Columna4 = 4, Columna5 = 5, Columna6 = 6, Columna7 = 7, Columna8 = 8;
        jTextFieldCC.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna0)));
        jTextNombreP.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna1)));
        jTextNombreS.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna2)));
        jTextFieldApellidoP.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna3)));
        jTextFieldApellidoS.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna4)));
        jComboBoxTipo.setSelectedItem(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna5)));
        jComboBoxEstado.setSelectedItem(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna6)));
        jTextFieldCeluar.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna7)));
        jTextFieldDireccion.setText(String.valueOf(this.TablaSeguridad.getValueAt(fila, Columna8)));

        //Paso del roll
        String i = (String) TablaSeguridad.getValueAt(fila, Columna5);
        if (i.equals("ADMINISTRADOR")) {
            jComboBoxTipo.setSelectedIndex(1);
        }
        if (i.equals("AUXILIAR")) {

            jComboBoxTipo.setSelectedIndex(2);
        }
        String j = (String) TablaSeguridad.getValueAt(fila, Columna6);
        if (j.equals("ACTIVO")) {
            jComboBoxEstado.setSelectedIndex(1);
        }
        if (j.equals("INACTIVO")) {

            jComboBoxEstado.setSelectedIndex(2);
        }
    }//GEN-LAST:event_TablaSeguridadMouseClicked

    private void rSCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrearActionPerformed
        Ingreso = 2;
        prender();
        editarcampos();
    }//GEN-LAST:event_rSCrearActionPerformed

    private void rSCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear1ActionPerformed
        Ingreso = 1;
        prender();
        Borrar();

    }//GEN-LAST:event_rSCrear1ActionPerformed

    private void rSCrear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear2ActionPerformed
        agregarPersona();
        apagar();
    }//GEN-LAST:event_rSCrear2ActionPerformed

    private void rSCrear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear3ActionPerformed
        ConeBD.closeConexion_BD();
        dispose();
    }//GEN-LAST:event_rSCrear3ActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jTextFieldUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextFieldUsuarioKeyTyped

    private void jPasswordFieldContra1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldContra1KeyTyped
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jPasswordFieldContra1KeyTyped

    private void jPasswordFieldcontra2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldcontra2KeyTyped
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jPasswordFieldcontra2KeyTyped

    private void jTextFieldCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCCActionPerformed

    }//GEN-LAST:event_jTextFieldCCActionPerformed

    private void jTextFieldCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCCKeyTyped
        if (jTextFieldCC.getText().length() >= 10) {
            evt.consume();
        }
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jTextFieldCCKeyTyped

    private void jTextNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombrePActionPerformed
    }//GEN-LAST:event_jTextNombrePActionPerformed

    private void jTextNombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombrePKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextNombrePKeyTyped

    private void jTextNombreSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreSKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextNombreSKeyTyped

    private void jTextFieldApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextFieldApellidoPKeyTyped

    private void jTextFieldApellidoSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoSKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
        mayus.notNum(evt, e);
    }//GEN-LAST:event_jTextFieldApellidoSKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ConeBD.openConeccion_BD();
        mostrarDatosTabla();

    }//GEN-LAST:event_formWindowOpened

    private void rSCrear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSCrear4ActionPerformed
        eliminarEmpleado();
    }//GEN-LAST:event_rSCrear4ActionPerformed

    private void jTextFieldCeluarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCeluarKeyTyped
        char e = evt.getKeyChar();
        mayus.num(evt, e);
    }//GEN-LAST:event_jTextFieldCeluarKeyTyped

    private void jTextFieldDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyTyped
        char e = evt.getKeyChar();
        mayus.may(evt, e);
    }//GEN-LAST:event_jTextFieldDireccionKeyTyped

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

    private void jTextNombreSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreSActionPerformed

    private void jTextNombreSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreSKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextNombreS.getText().equals(""))) {
                jComboBoxEstado.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un nombre");
                jTextNombreS.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextNombreSKeyPressed

    private void jComboBoxEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxEstadoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jComboBoxEstado.getSelectedItem().equals("SELECCIONAR"))) {
                jComboBoxTipo.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un estado");
                jComboBoxEstado.requestFocus();
            }
        }
    }//GEN-LAST:event_jComboBoxEstadoKeyPressed

    private void jComboBoxTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jComboBoxTipo.getSelectedItem().equals("SELECCIONAR"))) {
                jTextFieldApellidoP.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario");
                jComboBoxTipo.requestFocus();
            }
        }
    }//GEN-LAST:event_jComboBoxTipoKeyPressed

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

    private void jTextFieldDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldDireccion.getText().equals(""))) {
                jTextFieldUsuario.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar una dirección");
                jTextFieldDireccion.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldDireccionKeyPressed

    private void jTextFieldUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jTextFieldUsuario.getText().equals(""))) {
                jPasswordFieldContra1.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un nombre de usuario");
                jTextFieldUsuario.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldUsuarioKeyPressed

    private void jPasswordFieldContra1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldContra1KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jPasswordFieldContra1.getText().equals(""))) {
                jPasswordFieldcontra2.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar una contraseña");
                jPasswordFieldContra1.requestFocus();
            }
        }
    }//GEN-LAST:event_jPasswordFieldContra1KeyPressed

    private void jPasswordFieldcontra2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldcontra2KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!(jPasswordFieldcontra2.getText().equals(""))) {
                rSCrear2.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar una contraseña");
                jPasswordFieldcontra2.requestFocus();
            }
        }
    }//GEN-LAST:event_jPasswordFieldcontra2KeyPressed

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

    private void jTextFieldCeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCeluarActionPerformed

    private void jTextFieldApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoPActionPerformed

    private void jPasswordFieldcontra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldcontra2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldcontra2ActionPerformed

    private void jTextFieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDireccionActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameSeguridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaSeguridad;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldContra1;
    private javax.swing.JPasswordField jPasswordFieldcontra2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldApellidoP;
    private javax.swing.JTextField jTextFieldApellidoS;
    private javax.swing.JTextField jTextFieldCC;
    private javax.swing.JTextField jTextFieldCeluar;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JTextField jTextNombreP;
    private javax.swing.JTextField jTextNombreS;
    private rsbuttom.RSButtonMetro rSCrear;
    private rsbuttom.RSButtonMetro rSCrear1;
    private rsbuttom.RSButtonMetro rSCrear2;
    private rsbuttom.RSButtonMetro rSCrear3;
    private rsbuttom.RSButtonMetro rSCrear4;
    // End of variables declaration//GEN-END:variables
}
