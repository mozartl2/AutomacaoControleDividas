package org.example;
import java.sql.*;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.print("Hello and welcome!");

        Conexao.conectar();
        ResultSet rs = Conexao.buscarClDevedores();
        while(rs.next()){
            System.out.println("Nome: " + rs.getString("nome") + " Loja: " + rs.getString("loja"));
        }
    }
}