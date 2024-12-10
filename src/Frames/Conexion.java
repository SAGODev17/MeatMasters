/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Conexion {
    public Connection BD;
    public Statement StmBD;
    public ResultSet RstBD;
    public String msgCone;
    private final String user;
    private final String passU;
    private final String urlDataBase;
    
    public Conexion() {
        this.user = "root";
        this.passU = "12345678";
        this.urlDataBase = "jdbc:mysql://localhost:3306/carniceria?autoReconnect=true&useSSL=false";
        this.msgCone = "";
    }

    public void closeConexion_BD() {
        try {
            BD.close();
            System.out.println("Se cerro la conexion");
        } catch (SQLException e) {
        }
    }

    public void openConeccion_BD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            BD = (Connection) DriverManager.getConnection(this.urlDataBase, this.user, this.passU);
            StmBD = (Statement) BD.createStatement();
            this.msgCone = "Conexión exitosa al servidor";
        } catch (SQLException | ClassNotFoundException e1) {
            this.msgCone = "Sin conexión al servidor...";
            JOptionPane.showMessageDialog(null, "No hay conexión con el servidor " + e1);
        }
    }
}
