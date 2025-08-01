package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Conexao {
    private static String url = "jdbc:mysql://192.168.18.10:3306/dividas";
    private static String user = "pc-payer";
    private static String senha = "Lucas@101";
    private static Connection conexao = null;

    public static void conectar() throws SQLException {
        conexao = DriverManager.getConnection(url, user, senha);
    }

    public static ResultSet buscarClDevedores() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM view_clientes_devedores");
        ResultSet rs = stm.executeQuery();
        return rs;
    }

}
