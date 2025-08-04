package org.example;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;

public class Conexao {
    private static final String url = "jdbc:mysql://192.168.18.10:3306/dividas";
    private static final String user = "pc-payer";
    private static final String senha = "Lucas@101";
    private static Connection conexao = null;

    public static void conectar() throws SQLException {
        conexao = DriverManager.getConnection(url, user, senha);
    }

    //Busca todos os clientes
    public static ResultSet buscarTodosCl() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM clientes");
        return stm.executeQuery();
    }

    //Busca os clientes que tem alguma parcela com o status diferente de 'paga'
    public static ResultSet buscarClDevedores() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM view_clientes_devedores");
        return stm.executeQuery();
    }

    //Insere um novo cliente sem telefone
    public static int insereNovoCliente(String nome, String sobrenome, String loja) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO clientes (nome, sobrenome, loja) VALUES (?, ?, ?)");
        stm.setString(1, nome);
        stm.setString(2, sobrenome);
        stm.setString(3, loja);
        return stm.executeUpdate();
    }
    //Insere um novo cliente com telefone
    public static int insereNovoCliente(String nome, String sobrenome, String loja, String telefone) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO clientes (nome, sobrenome, loja, telefone) VALUES (?, ?, ?, ?)");
        stm.setString(1, nome);
        stm.setString(2, sobrenome);
        stm.setString(3, loja);
        stm.setString(4, telefone);
        return stm.executeUpdate();
    }

    //Apaga um cliente

    //Insere um nova divida
    public static int insereDivida(int idCliente, String dataContratacao, float valor, int qtdParcelas) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("CALL insere_dividas(?, ?, ?, ?);");
        stm.setInt(1, idCliente);
        stm.setString(2, dataContratacao);
        stm.setFloat(3, valor);
        stm.setInt(4,qtdParcelas);
        return stm.executeUpdate();
    }

    //Da a baixa em uma parcela
}
